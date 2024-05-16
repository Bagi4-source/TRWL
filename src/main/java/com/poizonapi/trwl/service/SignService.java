package com.poizonapi.trwl.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.github.unidbg.AndroidEmulator;
import com.github.unidbg.linux.android.AndroidEmulatorBuilder;
import com.github.unidbg.linux.android.AndroidResolver;
import com.github.unidbg.linux.android.dvm.DalvikModule;
import com.github.unidbg.linux.android.dvm.DvmClass;
import com.github.unidbg.linux.android.dvm.StringObject;
import com.github.unidbg.linux.android.dvm.VM;
import com.github.unidbg.linux.android.dvm.jni.ProxyClassFactory;
import com.github.unidbg.memory.Memory;
import com.poizonapi.trwl.dto.SignObject;
import lombok.Synchronized;
import org.springframework.stereotype.Service;

import java.io.File;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class SignService {

    private final AndroidEmulator emulator;

    private final DvmClass cSignUtil;
    private final VM vm;

    public SignService() {
        emulator = AndroidEmulatorBuilder.for64Bit()
                .setProcessName("com.anjuke.android.app")
                .build();
        Memory memory = emulator.getMemory();
        memory.setLibraryResolver(new AndroidResolver(23));
        vm = emulator.createDalvikVM();
        vm.setDvmClassFactory(new ProxyClassFactory());
        vm.setVerbose(false);
        URL url = getClass().getResource("/libs/libJNIEncrypt.so");
        assert url != null;
        DalvikModule dm = vm.loadLibrary(new File(url.getPath()), false);
        cSignUtil = vm.resolveClass("com/duapp/aesjni/AESEncrypt");
        dm.callJNI_OnLoad(emulator);
    }

    @Synchronized
    public SignObject getNewSign(Map<String, Object> objectMap) {
        objectMap.remove("newSign");
        String data = stringifyObject(objectMap);
        String methodSign = "encode(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/String;";
        StringObject obj = cSignUtil.callStaticJniMethodObject(emulator, methodSign, data, data);
        String aesString = obj.getValue();
        String newSign = md5(aesString);
        objectMap.put("newSign", newSign);
        return new SignObject(objectMap, aesString, newSign);
    }

    public String md5(String data) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(data.getBytes());
            byte[] digest = messageDigest.digest();
            StringBuilder sb3 = new StringBuilder();
            for (byte b : digest) {
                StringBuilder hexString = new StringBuilder(Integer.toHexString(b & 255));
                while (hexString.length() < 2) {
                    hexString.insert(0, "0");
                }
                sb3.append(hexString);
            }
            return sb3.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return "";
        }
    }

    public String stringifyObject(Map<String, Object> objectMap) {
        StringBuilder sb3 = new StringBuilder();
        List<Map.Entry<String, Object>> arrayList = new ArrayList<>(objectMap.entrySet());
        arrayList.sort((a, b) -> a.getKey().compareTo(b.getKey()));
        for (Map.Entry<String, Object> entry : arrayList) {
            sb3.append(entry.getKey());
            if (entry.getValue() instanceof String) {
                sb3.append(entry.getValue());
            } else {
                Object json = JSON.toJSON(entry.getValue());
                if (json instanceof JSONArray) {
                    JSONArray jSONArray = (JSONArray) json;
                    for (int i = 0; i < jSONArray.size(); i++) {
                        if (jSONArray.get(i) instanceof String) {
                            sb3.append(jSONArray.get(i));
                        } else {
                            sb3.append(JSON.toJSONString(jSONArray.get(i)));
                        }
                        if (i != jSONArray.size() - 1) {
                            sb3.append(",");
                        }
                    }
                } else {
                    sb3.append(JSON.toJSONString(json));
                }
            }
        }
        return sb3.toString();
    }
}
