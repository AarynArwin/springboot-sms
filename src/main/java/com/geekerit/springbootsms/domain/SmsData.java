package com.geekerit.springbootsms.domain;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * 发送短信所需实体类
 * @author Aaryn
 */
@Data
public class SmsData {

    /** 发送的手机号码的集合 */
    private List<String> phoneList = new ArrayList<>();

}
