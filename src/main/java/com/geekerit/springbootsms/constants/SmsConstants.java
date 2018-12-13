package com.geekerit.springbootsms.constants;


public class SmsConstants {

    /**
     * 阿里云短信平台的开发者信息
     */
    public static final String ACCESSSKEY_ID = "";
    public static final String ACCESSKEY_SECRET = "";

    /**
     * 产品名称:云通信短信API产品,开发者无需替换
     */
    public static final String PRODUCT = "Dysmsapi";
    /**
     * 产品域名,开发者无需替换
     */
    public static final String DOMAIN = "dysmsapi.aliyuncs.com";
    /**
     * 短信接口连接超时时间
     */
    public static final String TIMEOUT_LIMIT = "10000";
    /**
     * 短信签名
     */
    public static final String SIGN_NAME = "GeekerIT";


    /**
     * 验证码通知短信模板
     */
    public static final String TEMPLATE_YZ_LOGIN = "";

    /**
     * 登录验证码有效时间(毫秒)
     */
    public static final long LIMIT_TIME_LOGIN = 5000L;
}
