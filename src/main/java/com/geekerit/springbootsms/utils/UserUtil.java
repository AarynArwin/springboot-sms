package com.geekerit.springbootsms.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @ClassName UserUtil
 * @Description TODO
 * @Author Aaryn
 * @Date 2018/12/13 11:33
 * @Version 1.0
 */
public class UserUtil {

    /**
     * 使用正则表达式校验手机号码
     * @param telNum
     * @return true即为通过检测
     */
    public static boolean isMobileNum(String telNum){
        String regex = "^((13[0-9])|(14[5,7,9])|(15([0-3]|[5-9]))|(166)|(17[0,1,3,5,6,7,8])|(18[0-9])|(19[8|9]))\\d{8}$";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(telNum);
        return m.matches();
    }


    /**
     * 生成四位登录随机验证码
     * @return
     */
    public static int createLoginCode(){
        int code = (int) ((Math.random() * 9 + 1) * 1000);
        return code;
    }

}
