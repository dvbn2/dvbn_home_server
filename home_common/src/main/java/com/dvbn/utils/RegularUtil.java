package com.dvbn.utils;

/**
 * @author dvbn
 * @title: RegularUtil
 * @createDate 2023/11/8 12:50
 */
public class RegularUtil {

    /**
     * 手机号匹配
     */
    public static boolean phoneNumberMatch(String phoneNumber) {
        return phoneNumber.matches("^(13[0-9]|14[01456879]|15[0-35-9]|16[2567]|17[0-8]|18[0-9]|19[0-35-9])\\d{8}$");
    }
}
