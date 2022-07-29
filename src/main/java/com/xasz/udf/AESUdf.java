package com.xasz.udf;

import com.aliyun.odps.udf.UDF;
import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
import com.xasz.Utils.AESUtils;
//import org.apache.commons.codec.binary.Base64;

public class AESUdf extends UDF {
    public String evaluate(String s) {
        String key = "Sunshicheng";
        if (s == null) {
            return null;
        }
        try {
            byte[] cipherBytes = AESUtils.encrypt(s.getBytes(), key.getBytes());
            byte[] plainBytes = AESUtils.decrypt(cipherBytes, key.getBytes());
            return Base64.encode(cipherBytes);
//            return new String(cipherBytes);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public static void main(String[] args) {
        AESUdf aes = new AESUdf();
        String str = aes.evaluate("Hello world!");
        System.out.printf(str);
    }
}
