package com.uwjx.aliyunpushservice;

/**
 * {"identityName":"张三", "identityNumber":"123455", "clientId":"1","submitId":"123"}
 */
public class MsgBean {

    private String identityName;
    private String identityNumber;
    private String clientId;
    private String submitId;

    public String getIdentityName() {
        return identityName;
    }

    public void setIdentityName(String identityName) {
        this.identityName = identityName;
    }

    public String getIdentityNumber() {
        return identityNumber;
    }

    public void setIdentityNumber(String identityNumber) {
        this.identityNumber = identityNumber;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getSubmitId() {
        return submitId;
    }

    public void setSubmitId(String submitId) {
        this.submitId = submitId;
    }
}
