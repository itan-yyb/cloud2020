package com.itan.config;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.itan.utils.Base64Util;
import com.itan.utils.FileUtil;
import com.itan.utils.GsonUtils;
import com.itan.utils.HttpUtil;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.net.URL;
import java.net.HttpURLConnection;
import java.util.Map;

/**
 * @Author: yeyanbin
 * @Date: 2020/11/3
 */
@Slf4j
public class AuthConfig {
    /**
     * 获取权限token
     * @return 返回示例：
     * {
     * "access_token": "24.460da4889caad24cccdb1fea17221975.2592000.1491995545.282335-1234567",
     * "expires_in": 2592000
     * }
     */
    public static String getAuth() {
        // 官网获取的 API Key 更新为你注册的
        String clientId = "7srGyTv7n2qvv9dwOomGQk76";
        // 官网获取的 Secret Key 更新为你注册的
        String clientSecret = "QtNctKiWCZ5f0KbGIvFnSx2pCOYpI7Ar";
        return getAuth(clientId, clientSecret);
    }

    /**
     * 获取API访问token
     * 该token有一定的有效期，需要自行管理，当失效时需重新获取.
     * @param ak - 百度云官网获取的 API Key
     * @param sk - 百度云官网获取的 Securet Key
     * @return assess_token 示例：
     * "24.460da4889caad24cccdb1fea17221975.2592000.1491995545.282335-1234567"
     */
    public static String getAuth(String ak, String sk) {
        // 获取token地址
        String authHost = "https://aip.baidubce.com/oauth/2.0/token?";
        String getAccessTokenUrl = authHost
                // 1. grant_type为固定参数
                + "grant_type=client_credentials"
                // 2. 官网获取的 API Key
                + "&client_id=" + ak
                // 3. 官网获取的 Secret Key
                + "&client_secret=" + sk;
        try {
            URL realUrl = new URL(getAccessTokenUrl);
            // 打开和URL之间的连接
            HttpURLConnection connection = (HttpURLConnection) realUrl.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();
            // 获取所有响应头字段
            Map<String, List<String>> map = connection.getHeaderFields();
            // 遍历所有的响应头字段
            for (String key : map.keySet()) {
                log.info(key + "--->" + map.get(key));
            }
            // 定义 BufferedReader输入流来读取URL的响应
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String result = "";
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
            /**
             * 返回结果示例
             */
            log.info("result:" + result);
            JSONObject jsonObject = new JSONObject(result);
            String access_token = jsonObject.getString("access_token");
            return access_token;
        } catch (Exception e) {
            log.info("获取token失败！");
            e.printStackTrace(System.err);
        }
        return null;
    }

    // 公安验证
    public static String personverify(String accessToken,String fileUrl,String id_card_number,String name) {
        // 请求url
        String url = "https://aip.baidubce.com/rest/2.0/face/v3/person/verify";
        String message = "";
        try {
            byte[] imgData = FileUtil.readFileByBytes(fileUrl);
            String imgStr = Base64Util.encode(imgData);
            Map<String, Object> map = new HashMap<>();
            map.put("image", imgStr);
            map.put("image_type", "BASE64");
            map.put("id_card_number", id_card_number);
            /*
                活体检测控制
                NONE: 不进行控制
                LOW:较低的活体要求(高通过率 低攻击拒绝率)
                NORMAL: 一般的活体要求(平衡的攻击拒绝率, 通过率)
                HIGH: 较高的活体要求(高攻击拒绝率 低通过率)
                默认NONE
            */
            map.put("liveness_control", "NONE");
            map.put("name", name);
            /*
                图片质量控制
                NONE: 不进行控制
                LOW:较低的质量要求
                NORMAL: 一般的质量要求
                HIGH: 较高的质量要求
                默认 NONE
            */
            map.put("quality_control", "NONE");

            String param = GsonUtils.toJson(map);

            // 注意这里仅为了简化编码每一次请求都去获取access_token，线上环境access_token有过期时间， 客户端可自行缓存，过期后重新获取。
            // String accessToken = "【调用鉴权接口获取的token】";

            String result = HttpUtil.post(url, accessToken, "application/json", param);
            // score	与公安小图相似度可能性，用于验证生活照与公安小图是否为同一人，有正常分数时为[0~100]，推荐阈值80，超过即判断为同一人
            System.out.println(result);
            JsonObject jObject =new JsonParser().parse(result).getAsJsonObject();
            String errorCode = jObject.get("error_code").getAsString();
            if("0".equals(errorCode)) {
                JsonObject resultObject = jObject.getAsJsonObject("result");
                String score = resultObject.get("score").getAsString();
                if(Integer.parseInt(score)>=80) {
                    message = "是同一个人";
                }else {
                    message = "不是同一个人，请重新上传";
                }
            }else if("222350".equals(errorCode)) {
                message = "公安网图片不存在或质量过低，请重新上传";
            }else if("222351".equals(errorCode)) {
                message = "身份证号与姓名不匹配或该身份证号不存在，请重新上传";
            }else if("222352".equals(errorCode)) {
                message = "身份证名字格式错误，请重新上传";
            }else if("222353".equals(errorCode)) {
                message = "身份证号码格式错误，请重新上传";
            }else if("222354".equals(errorCode)) {
                message = "公安库里不存在此身份证号，请重新上传";
            }else if("222355".equals(errorCode)) {
                message = "身份证号码正确，公安库里没有对应的照片，请重新上传";
            }else if("222356".equals(errorCode)) {
                message = "验证的人脸图片质量不符合要求，请重新上传";
            }else if("222360".equals(errorCode)) {
                message = "身份证号码或名字非法（公安网校验不通过），请重新上传";
            }else if("222361".equals(errorCode)) {
                message = "公安服务连接失败，请重新上传";
            }else if("216600".equals(errorCode)) {
                message = "输入身份证格式错误，请重新上传";
            }else if("216601".equals(errorCode)) {
                message = "身份证号和名字匹配失败，请重新上传";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return message;
    }

    public static void main(String[] args) {
        //获取token
        String access_token = getAuth();
        System.out.println(access_token);
        //公安验证
        String wangUrl = "E:/renxiang.jpg";
        String id_card_number = "";
        String name = "叶彦斌";
        personverify(access_token,wangUrl,id_card_number,name);
    }
}
