package com.uwjx.aliyunpushservice;

import com.alibaba.fastjson.JSON;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.push.model.v20160801.PushRequest;
import com.aliyuncs.push.model.v20160801.PushResponse;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
@Slf4j
public class PushService implements InitializingBean {

    private static String regionId = "cn-hangzhou";
    @Value("${accessKey}")
    private String accessKey;
    @Value("${accessSecret}")
    private String accessSecret;

    @Override
    public void afterPropertiesSet() throws Exception {
        log.warn("执行启动");
        log.warn("accessKey -> {}" , accessKey);
        log.warn("accessSecret -> {}" , accessSecret);

        DefaultProfile profile = DefaultProfile.getProfile(regionId, accessKey, accessSecret);
        IAcsClient client = new DefaultAcsClient(profile);
        PushRequest request = new PushRequest();
//        request.setRegionId("cn-hangzhou");

        Random random = new Random();
        MsgBean msgBean = new MsgBean();
        msgBean.setClientId("clientId");
        msgBean.setIdentityName("身份证号码");
        msgBean.setIdentityName("王欢");
        msgBean.setSubmitId("12");

        request.setAppKey(30256251L);
        request.setPushType("MESSAGE");
        request.setDeviceType("ALL");
        request.setTarget("DEVICE");
        request.setTargetValue("406646fd4f6343089d8e7ab1e9773fef");
        request.setBody("测试推送消息Body —> " + random.nextLong());
        request.setTitle("测试推送消息Title —> " + random.nextLong());

        request.setAndroidNotifyType("BOTH");
        request.setAndroidOpenType("APPLICATION");
        request.setAndroidPopupActivity("com.jiafinance.mlj.DetailPageActivity");

        request.setStoreOffline(true);

        request.setAndroidRemind(true);
        request.setAndroidPopupTitle("离线推送title");
        request.setAndroidPopupBody("离线推送 body");



        request.setAndroidExtParameters(JSON.toJSONString(msgBean));

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
