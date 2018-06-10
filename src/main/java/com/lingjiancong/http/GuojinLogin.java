package com.lingjiancong.http;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @author lingjiancong
 */
public class GuojinLogin {

    public static final String SESSION = "Session";
    public static final String LOGIN_IP = "ClientIP";
    public static final String C_USER = "C_USER";

    public static final String USER_NAME = "username";
    public static final String PASSWORD = "password";
    public static final String CHECK_CODE = "abcdf";
    public static final String ENTERPRISE_CODE = "enterpriseCode";

    public static final String TARGET_URL = "https://www.abscloud.com/xfintech/logAll/login";
  //  public static final String TARGET_URL = "https://www.abscloud.com/logAll/login";
    public static final String ERR_MSG = "errmsg";

    @Test
    public void testLoginResponse() {
        String username = "chentao";
        String password = "12qw34er";
        String checkCode = "12345";
        String cUser = "516a6acca01543059da7d31c550d0835";
        String urlPatameters = String.format("username=%s&password=%s&enterpriseCode=%s",
                username, password, checkCode);
        String cookie = C_USER + "=" + cUser;
        String response = executePost(TARGET_URL, urlPatameters, cookie);

        JSONObject json = JSON.parseObject(response, JSONObject.class);
        if(json.get("error") == null) {
            System.out.println("dada");
            System.out.println(json.toString());
        }
    }

    @Test
    public void testRes() {
        String response = "{\"retMsg\":null,\"error\":null,\"isExit\":0,\"loginUsername\":\"chentao\"," +
                "\"checkCode\":null,\"enterpriseEmail\":null,\"enterpriseAccountName\":null," +
                "\"searchText\":null,\"hasFacPermi\":0,\"jsessionid\":\"46dd9257cc464724b95256ba87ccb" +
                "ddc\",\"category\":0,\"count\":0}";

        JSONObject json = JSON.parseObject(response, JSONObject.class);
        if(json.get("error") == null) {
            System.out.println("dad");
            System.out.println(json.toString());
        }
    }

    public static String executePost(String targetURL, String urlParameters, String cookie) {
        HttpURLConnection connection = null;

        try {
            //Create connection
            URL url = new URL(targetURL);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type",
                    "application/x-www-form-urlencoded");

            connection.setRequestProperty("Content-Length",
                    Integer.toString(urlParameters.getBytes().length));
            connection.addRequestProperty("Cookie", cookie);

            connection.setUseCaches(false);
            connection.setDoOutput(true);

            //Send request
            DataOutputStream wr = new DataOutputStream (
                    connection.getOutputStream());
            wr.writeBytes(urlParameters);
            wr.close();

            //Get Response
            InputStream is = connection.getInputStream();
            BufferedReader rd = new BufferedReader(new InputStreamReader(is));
            StringBuilder response = new StringBuilder(); // or StringBuffer if Java version 5+
            String line;
            while ((line = rd.readLine()) != null) {
                response.append(line);
                response.append('\r');
            }
            rd.close();
            return response.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }
    }
}
