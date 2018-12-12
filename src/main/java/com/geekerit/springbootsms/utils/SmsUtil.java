package com.geekerit.springbootsms.utils;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import org.springframework.stereotype.Component;

/**
 * 阿里云短信发送工具类
 */
@Component
public class SmsUtil {


    /**
     * @Classname: SmsService
     * @Description: 短信发送的公共部分封装
     * @Author: Aaryn
     * @Date: 2018/8/25 10:36
     * @Version: 1.0
     */
    public IAcsClient sendMsgCommon() throws ClientException {
        //HttpURLConnection是基于HTTP协议的，其底层通过socket通信实现。
        // 如果不设置超时（timeout），在网络异常的情况下，可能会导致程序僵死而不继续往下执行。可以通过以下两个语句来设置相应的超时：
        //可自助调整超时时间
        System.setProperty("sun.net.client.defaultConnectTimeout", SmsConstants.TIMEOUT_LIMIT);
        System.setProperty("sun.net.client.defaultReadTimeout", SmsConstants.TIMEOUT_LIMIT);

        //初始化acsClient,暂不支持region化
        IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", SmsConstants.ACCESSSKEY_ID, SmsConstants.ACCESSKEY_SECRET);
        DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", SmsConstants.PRODUCT, SmsConstants.DOMAIN);
        IAcsClient acsClient = new DefaultAcsClient(profile);

        return acsClient;
    }

    /**
     * @Classname: SmsService
     * @Description: 发送验证码服务，支持对单个手机号码
     * @Author: Aaryn
     * @Date: 2018/8/25 10:37
     * @Version: 1.0
     */
    public void sendSmsForLogin(String phone) throws ClientException {
        // 手机号码的非空判断
        if (phone == null || phone == "") {
            throw new DisplayableException("手机号码不可为空!");
        }
        IAcsClient iAcsClient = sendMsgCommon();
        //组装请求对象-具体描述见控制台-文档部分内容
        SendSmsRequest request = new SendSmsRequest();
        //必填:待发送手机号
        request.setPhoneNumbers(phone);
        //必填:短信签名-可在短信控制台中找到
        request.setSignName(SmsConstants.SIGN_NAME);
        // 根据短信类型选择不同的参数
        request.setTemplateCode(SmsConstants.TEMPLATE_YZ_LOGIN);

        int code = (int) ((Math.random() * 9 + 1) * 1000);
        request.setTemplateParam("{\"code\":" + code + "}");
        //选填-上行短信扩展码(无特殊需求用户请忽略此字段)
        //request.setSmsUpExtendCode("90997");
        // 可选:outId为提供给业务方扩展字段,最终在短信回执消息中将此值带回给调用者
        request.setOutId("yourOutId");

        //hint 此处可能会抛出异常，注意catch
        SendSmsResponse sendSmsResponse = iAcsClient.getAcsResponse(request);
    }

}
