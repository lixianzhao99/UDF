package com.xasz.udf;

import com.aliyun.odps.udf.UDF;
import com.xasz.Utils.AESUtils;

public class AESUdf extends UDF {
    public String evaluate(String s) {
        String key = "Sunshicheng";
        if (s == null) {
            return null;
        }
        try {
            byte[] cipherBytes = AESUtils.encrypt(s.getBytes(), key.getBytes());
            byte[] plainBytes = AESUtils.decrypt(cipherBytes, key.getBytes());
            return new String(cipherBytes);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public static void main(String[] args) {
        AESUdf aes = new AESUdf();
        String str = aes.evaluate("Hello world!");
        System.out.printf(str);
        System.out.printf("\n你好\n");
        System.out.println(System.getProperty("file.encoding"));
    }
}
