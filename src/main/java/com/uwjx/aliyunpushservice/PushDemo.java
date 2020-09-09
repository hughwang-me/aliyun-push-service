package com.uwjx.aliyunpushservice;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.push.model.v20160801.PushRequest;
import com.aliyuncs.push.model.v20160801.PushResponse;
import com.google.gson.Gson;

public class PushDemo {

    private static String regionId = "cn-hangzhou";


    public static void main(String[] args) {
        DefaultProfile profile = DefaultProfile.getProfile(regionId, accessKey, accessSecret);
        IAcsClient client = new DefaultAcsClient(profile);
        PushRequest request = new PushRequest();
//        request.setRegionId("cn-hangzhou");

        request.setAppKey(30256251L);
        request.setPushType("MESSAGE");
        request.setDeviceType("ALL");
        request.setTarget("ALL");
        request.setTargetValue("ALL");
        request.setBody("ALi Push Title");
        request.setTitle("Ali Push Body");

        request.setAndroidNotifyType("BOTH");
        request.setAndroidOpenType("APPLICATION");
        request.setAndroidPopupActivity("com.jiafinance.mlj.DetailPageActivity");

        request.setAndroidRemind(true);
        request.setAndroidPopupTitle("离线推送title");
        request.setAndroidPopupBody("离线推送 body");

        request.setAndroidNotificationChannel("1");

        try {
            PushResponse response = client.getAcsResponse(request);
            System.out.println(new Gson().toJson(response));
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            System.out.println("ErrCode:" + e.getErrCode());
            System.out.println("ErrMsg:" + e.getErrMsg());
            System.out.println("RequestId:" + e.getRequestId());
        }
    }
}
