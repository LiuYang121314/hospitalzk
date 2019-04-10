package com.litbo.hospitalzj.supplier.util;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.springframework.web.context.request.WebRequest;
;

public class Message {
   public static void sendMessage(){
        String info = null;
        try {
            HttpClient httpclient = new HttpClient();//方法调用
            PostMethod post = new PostMethod("http://192.168.1.56/Server/SMS_Send.aspx");//接口地址
            post.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET, "gb2312");//格式转换
            post.addParameter("sn", "SDK-NFY-020-00088");//接口数据
            post.addParameter("pwd", "xxxxxx");//接口密码
            post.addParameter("mobile", "17630215746");//要发送短信的手机号，可多个手机号，用逗号隔开。
            post.addParameter("content", "18616330318南方医院");//短信内容
            post.addParameter("ext", "1");
            System.out.println(post.getResponseBody());
            httpclient.executeMethod(post);
            /*info = new String(post.getResponseBody(), "gb2312");
            System.out.println(info);*/
            //最后得到结果后，是一个字符长串，截取有用的信息，可判断短信是否发送成功
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
