package com.xasz.udf;

//继承UDF类。
import com.aliyun.odps.udf.UDF;
//自定义Java类。
public final class Lower extends UDF {
    //evaluate方法。其中：String标识输入参数的数据类型，return标识返回值。
    public String evaluate(String s) {
        if (s == null) {
            return null;
        }
        return s.toLowerCase();
    }

    public static void main(String[] args) {
        Lower low = new Lower();
        String str = low.evaluate("HELLO");
        System.out.printf(str);
    }
}