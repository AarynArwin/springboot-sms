package com.geekerit.springbootsms.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * 发送短信所需实体类
 * @author Aaryn
 */
@Data
@ApiModel(value = "短信发送所需参数")
public class SmsData {

    /** 发送的手机号码的集合 */
    @ApiModelProperty(value = "手机号码集合")
    private List<String> phoneList = new ArrayList<>();

}
