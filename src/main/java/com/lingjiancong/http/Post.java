package com.lingjiancong.http;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.CookiePolicy;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.UUID;

/**
 * @author lingjiancong
 */
public class Post {

    @Test
    public void doPost() {

        String urlParameters = "username=lingjiancong&password=16qu53ars&enterpriseCode=uri8";
        String targetUrl = "https://www.abscloud.com/logAll/login";

        System.out.println(executePost(targetUrl, urlParameters));
    }

    @Test
    public void doXfintechCheckCode() {

        //String targetUrl = "https://www.abscloud.com/enterprUser/getCheckImage?1479714862041";
        String targetUrl = "http://localhost:8080/xfintech/enterprUser/getCheckImage?1479714447552";
        executeGet(targetUrl);

    }

    public static String executePost(String targetURL, String urlParameters) {
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
            connection.setRequestProperty("Content-Language", "en-US");

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


    public static String executeGet(String targetURL) {
        HttpURLConnection connection = null;

        try {
            //Create connection
            CookieHandler.setDefault(new CookieManager(null, CookiePolicy.ACCEPT_ALL));
            URL url = new URL(targetURL);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            String authToken = UUID.randomUUID().toString().replace("-","");
            String cUser = "C_USER=" + authToken;
            System.out.println(authToken);
            connection.addRequestProperty("Cookie", cUser);

            connection.setUseCaches(false);

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

    @Test
    public void testStringFormat() {
        String username = null, password = "2", checkCode = "";
        String urlPatameters = String.format("username=%s&password=%s&enterpriseCode=%s",
                username, password, checkCode);
        System.out.println(urlPatameters);

    }
}
