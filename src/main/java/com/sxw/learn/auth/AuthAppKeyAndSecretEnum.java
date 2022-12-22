package com.sxw.learn.auth;

import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;

public enum AuthAppKeyAndSecretEnum {
    /**
     * 用于MRP服务端发起的接口服务的校验授权
     */
    MRP_API("P7UKMGiN", "6607df5c734e0d779c24717c0c56f61851d15cc9"),
    TKT_API("Q7bsIiMA", "4c5afbd9d101fd0fd481589f486fd055ce9fb6c3");

    /**
     * 备用appid
     * appId:jTnxiZUV
     * appSecret:30ac6e41034f0eef3aa661df4576a986d23d7050
     */
    AuthAppKeyAndSecretEnum(String appId, String appSecret) {
        this.appId = appId;
        this.appSecret = appSecret;
    }

    private String appId;
    private String appSecret;

    public String getAppId() {
        return appId;
    }

    public String getAppSecret() {
        return appSecret;
    }

    public static boolean checkAppKeyExist(String appKey){
        return Arrays.stream(AuthAppKeyAndSecretEnum.values()).map(AuthAppKeyAndSecretEnum::getAppId)
                .collect(Collectors.toSet()).contains(appKey);
    }

    public static String getAppSecret(String appKey){
        if (Objects.isNull(appKey)){
            return null;
        }
        return Arrays.stream(AuthAppKeyAndSecretEnum.values())
                .collect(Collectors.toMap(AuthAppKeyAndSecretEnum::getAppId, AuthAppKeyAndSecretEnum::getAppSecret))
                .get(appKey);
    }

    public static void main(String[] args) {
        String appId = AuthUtils.getAppId();
        String appSecret = AuthUtils.getAppSecret(appId);

        System.out.println("appId:" + appId);
        System.out.println("appSecret:" + appSecret);
    }
}
