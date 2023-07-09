package com.yemeksepeti.util;

import java.util.UUID;

public class codeGenerator {

    public static String genCode(){
        String code= UUID.randomUUID().toString();
        String[] brack=code.split("-");
        String finalCode="";
        for (String string: brack) {
            finalCode +=string.charAt(0);
        }
        return finalCode;
    }
}
