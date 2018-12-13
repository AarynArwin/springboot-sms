package com.geekerit.springbootsms.service.impl;

import com.geekerit.springbootsms.domain.SmsData;
import com.geekerit.springbootsms.service.SmsService;
import com.geekerit.springbootsms.utils.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * @ClassName SmsServiceImpl
 * @Description TODO
 * @Author Aaryn
 * @Date 2018/12/13 11:26
 * @Version 1.0
 */
@Service
public class SmsServiceImpl implements SmsService {

    @Autowired
    private SmsUtil smsUtil;

    @Autowired
    private RedisUtil redisUtil;

    @Override
    public void sendMsgForLogin(SmsData smsData) throws Exception {
        String phone = smsData.getPhoneList().get(0);
        // 手机号码非空校验
        if (StringUtils.isEmpty(phone)){
            throw new DisplayableException("手机号码不存在");
        }
        // 手机号码正则校验
        if (!UserUtil.isMobileNum(phone)){
            throw new DisplayableException("手机号码异常");
        }
        // 生成登录随机验证码
        int loginCode = UserUtil.createLoginCode();
        // 调用发送短信工具
        smsUtil.sendSmsForLogin(phone,loginCode);
        // 验证码存储在redis中并设置有效期
        redisUtil.setValue(phone,loginCode);
//        redisUtil.setValueWithExpire(phone,loginCode, SmsConstants.LIMIT_TIME_LOGIN);
    }
}
