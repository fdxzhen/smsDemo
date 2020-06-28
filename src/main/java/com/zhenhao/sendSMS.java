package com.zhenhao;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

/**
 * Created by zhenhao on 2020/6/28 17:58
 * Content: 发送短信
 */
@RestController
public class sendSMS {
    /**
     * 随机生成6位验证码
     * @return
     */
    public static String getRandomCode(){
        Random random = new Random();
        String result="";
        for (int i=0;i<6;i++){
            result+=random.nextInt(10);
        }
        return result;
    }

    /**
     * @author：lvfang
     * @mathName： testSendMessage
     * @parameter： 无
     * @return value：
     * @throws null
     * @date 2018/8/11
     * @desc SMS短信测试
     */
    @RequestMapping("/sendSMS")
    public String  testSendMessage(){
//        SendMessageUtil.send("SMS账户","接口秘钥","目标号码","发送内容");
        int resultCode = SendMessageUtil.send("xx","xx","xx","您好，欢迎登录本网站，你的验证码为:"+getRandomCode());
        System.out.println(SendMessageUtil.getMessage(resultCode));
        return SendMessageUtil.getMessage(resultCode);
    }
}
