package com.sxw.learn.auth;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.HmacAlgorithms;
import org.apache.commons.codec.digest.HmacUtils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.*;

import static java.time.temporal.ChronoUnit.SECONDS;

/**
 * https://nullpointer.pw/interface-authentication.html
 */
@Slf4j
public class AuthUtils {

    private AuthUtils() {
    }

    // 生成 app_secret 密钥
    private final static String SERVER_NAME = "xingluo_dw";
    private final static String[] chars = new String[]{"a", "b", "c", "d", "e", "f",
            "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s",
            "t", "u", "v", "w", "x", "y", "z", "0", "1", "2", "3", "4", "5",
            "6", "7", "8", "9", "A", "B", "C", "D", "E", "F", "G", "H", "I",
            "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V",
            "W", "X", "Y", "Z"};

    public static ApiResult checkSign(Map<String, String> params){
        if (Objects.isNull(params) || params.size() <= 2 || !params.containsKey("sign") || !params.containsKey("app_id")){
            return ApiResult.failure(ResultCode.PARAMS_ERROR);
        }
        log.info("********************************* 验签开始 *********************************");
        // 获取appId
        String appId = params.get("app_id");
        String appSecret = AuthAppKeyAndSecretEnum.getAppSecret(appId);
        // 验证appKey是否合法
        if (Objects.isNull(appSecret)){
            log.info("获取appSecret失败,appKey:[{}]", appId);
            return ApiResult.failure(ResultCode.NO_UNAUTHORIZED_FROM);
        }
        // 获取sign参数
        String sign = params.get("sign");
        log.info("sign:[{}]", sign);
        // 校验请求是否过期
        String inTimeStamp = params.getOrDefault("timestamp", "0");
        LocalDateTime inTime = LocalDateTime.ofInstant(Instant.ofEpochMilli(Long.parseLong(inTimeStamp)), ZoneOffset.ofHours(8));
        Duration duration = Duration.between(inTime, LocalDateTime.now());
        long seconds = duration.get(SECONDS);
        log.info("seconds: " + seconds);
        if (seconds > 10 * 60) {
            log.info("请求超时");
            return ApiResult.failure(ResultCode.REQUEST_TIMED_OUT);
        }
        String inSignData = getSignData(params);
        log.info("inSignData: " + inSignData);
        byte[] inHmac = new HmacUtils(HmacAlgorithms.HMAC_SHA_1, appSecret).hmac(inSignData);
        String mySign = new String(Base64.encodeBase64(inHmac));
        log.info("mySign:[{}], 验签结果:[{}]", mySign, sign.equals(mySign));
        log.info("********************************* 验签结束 *********************************");
        if (sign.equals(mySign)){
            return ApiResult.success(mySign);
        }
        return ApiResult.failure(ResultCode.NO_UNAUTHORIZED);
    }

    public static String getSignData(Map<String, String> params) {
        StringBuilder content = new StringBuilder();
        // key 自然排序
        List<String> keys = new ArrayList<>(params.keySet());
        Collections.sort(keys);

        for (int i = 0; i < keys.size(); i++) {
            String key = keys.get(i);
            if ("sign".equals(key)) {
                continue;
            }
            String value = params.get(key);
            if (value != null) {
                content.append(i == 0 ? "" : "&").append(key).append("=").append(value);
            } else {
                content.append(i == 0 ? "" : "&").append(key).append("=");
            }
        }

        return content.toString();
    }

    /**
     * @Description: <p>
     * 短8位UUID思想其实借鉴微博短域名的生成方式，但是其重复概率过高，而且每次生成4个，需要随即选取一个。
     * 本算法利用62个可打印字符，通过随机生成32位UUID，由于UUID都为十六进制，所以将UUID分成8组，每4个为一组，然后通过模62操作，结果作为索引取出字符，
     * 这样重复率大大降低。
     * 经测试，在生成一千万个数据也没有出现重复，完全满足大部分需求。
     * </p>
     */
    public static String getAppId() {
        StringBuffer shortBuffer = new StringBuffer();
        String uuid = UUID.randomUUID().toString().replace("-", "");
        for (int i = 0; i < 8; i++) {
            String str = uuid.substring(i * 4, i * 4 + 4);
            int x = Integer.parseInt(str, 16);
            shortBuffer.append(chars[x % 0x3E]);
        }
        return shortBuffer.toString();

    }

    /**
     * <p>
     * 通过appId和内置关键词生成APP Secret
     * </P>
     */
    public static String getAppSecret(String appId) {
        try {
            String[] array = new String[]{appId, SERVER_NAME};
            StringBuffer sb = new StringBuffer();
            // 字符串排序
            Arrays.sort(array);
            for (int i = 0; i < array.length; i++) {
                sb.append(array[i]);
            }
            String str = sb.toString();
            MessageDigest md = MessageDigest.getInstance("SHA-1");
            md.update(str.getBytes());
            byte[] digest = md.digest();

            StringBuffer hexstr = new StringBuffer();
            String shaHex = "";
            for (int i = 0; i < digest.length; i++) {
                shaHex = Integer.toHexString(digest[i] & 0xFF);
                if (shaHex.length() < 2) {
                    hexstr.append(0);
                }
                hexstr.append(shaHex);
            }
            return hexstr.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    public static void main(String[] args) {
        long timestamp = System.currentTimeMillis();
        System.out.println(timestamp);
//        long timestamp = 1670305211565L;
        Map<String, String> params = new HashMap<>();
        params.put("app_id", AuthAppKeyAndSecretEnum.TKT_API.getAppId());
        params.put("type", "1");
        params.put("timestamp", String.valueOf(timestamp));

        StringBuilder content = new StringBuilder();
        // key 自然排序
        List<String> keys = new ArrayList<>(params.keySet());
        Collections.sort(keys);

        for (int i = 0; i < keys.size(); i++) {
            String key = keys.get(i);
            if ("sign".equals(key)) {
                continue;
            }
            String value = params.get(key);
            if (value != null) {
                content.append(i == 0 ? "" : "&").append(key).append("=").append(value);
            } else {
                content.append(i == 0 ? "" : "&").append(key).append("=");
            }
        }

        byte[] hmac = new HmacUtils(HmacAlgorithms.HMAC_SHA_1, AuthAppKeyAndSecretEnum.TKT_API.getAppSecret()).hmac(content.toString());
        String sign = new String(Base64.encodeBase64(hmac));
        System.out.println(sign);
        params.put("sign", sign);
        ApiResult apiResult = checkSign(params);
        System.out.println(apiResult);
    }
}
