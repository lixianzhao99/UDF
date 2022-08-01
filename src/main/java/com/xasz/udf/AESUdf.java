package com.xasz.udf;

import com.aliyun.odps.udf.UDF;
import com.xasz.Utils.AESUtils;

import java.util.Base64;


public class AESUdf extends UDF {
    public String evaluate(String s) {
        String key = "Sunshicheng";
        if (s == null) {
            return null;
        }
        try {
            byte[] cipherBytes = AESUtils.encrypt(s.getBytes(), key.getBytes());
            byte[] plainBytes = AESUtils.decrypt(Base64.getDecoder().decode(s), key.getBytes());
//            return Base64.getEncoder().encodeToString(cipherBytes);
            return new String(plainBytes);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public static void main(String[] args) {
        AESUdf aes = new AESUdf();
//        String str = aes.evaluate("Hello world!");
        String str = aes.evaluate("tZVE51rBjIMdSwpMgzyz1Q==");
        System.out.printf(str);
        System.out.printf("\n你好\n");
        System.out.println(System.getProperty("file.encoding"));
    }
}
