package com.geekerit.springbootsms.controller;

import com.geekerit.springbootsms.domain.SmsData;
import com.geekerit.springbootsms.utils.SmsUtil;
import com.geekerit.springbootsms.vo.JSONResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/sms")
public class SendMsgController {

    @Autowired
    private SmsUtil smsUtil;

    @PostMapping
    public JSONResultVo sendMsg(@RequestBody SmsData smsData){
        JSONResultVo jsonResultVo = new JSONResultVo();
        try {
            smsUtil.sendSmsForLogin(smsData.getPhoneList().get(0));
        }catch (Exception e){
            e.printStackTrace();
            jsonResultVo.setErrorMsg("发送验证码失败");
        }

        return jsonResultVo;
    }

}
