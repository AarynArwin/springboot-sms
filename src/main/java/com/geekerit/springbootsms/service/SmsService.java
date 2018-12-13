package com.geekerit.springbootsms.service;

import com.geekerit.springbootsms.domain.SmsData;

/**
 * @ClassName SmsService
 * @Description TODO
 * @Author Aaryn
 * @Date 2018/12/13 11:24
 * @Version 1.0
 */
public interface SmsService {
    /**
     * 登录验证码
     * @param smsData
     * @exception 
     */
    void sendMsgForLogin(SmsData smsData) throws Exception;
}
