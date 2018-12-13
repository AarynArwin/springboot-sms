package com.geekerit.springbootsms.controller;

import com.geekerit.springbootsms.domain.SmsData;
import com.geekerit.springbootsms.service.SmsService;
import com.geekerit.springbootsms.vo.ResultVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

/**
 * @author Aaryn
 */
@RestController
@RequestMapping(value = "/sms")
@Api(description = "短信发送服务")
public class SendMsgController {

    @Autowired
    private SmsService smsService;

    @PostMapping(value = "/v1")
    @ApiOperation(value = "初始短信服务")
    public ResultVO sendMsg(@RequestBody SmsData smsData,HttpServletResponse response){
        ResultVO resultVO = new ResultVO();
        try {
            smsService.sendMsgForLogin(smsData);
        }catch (Exception e){
            e.printStackTrace();
            resultVO.setErrorMsg(e.getMessage());
            resultVO.setResponseCode(HttpServletResponse.SC_BAD_REQUEST);
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
        return resultVO;
    }



}
