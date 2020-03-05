package com.lingjiancong.sdk.alipay;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import org.junit.Test;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;

/**
 * @author lingjiancong
 * @since 2019-11-01
 */
public class AlipayTest {

    @Test
    public void payPost(HttpServletRequest httpRequest, HttpServletResponse httpResponse) throws ServletException, IOException {
        // 获得初始化的 AlipayClient
        AlipayClient alipayClient = new DefaultAlipayClient("https://openapi.alipay.com/gateway.do", "appId", "appPrivateKey", "format", "charset", "alipayPublicKey", "signType");
        // 创建API对应的 request
        AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
        alipayRequest.setReturnUrl("http://domain.com/CallBack/return_url.jsp");
        // 在公共参数中设置回跳和通知地址
        alipayRequest.setNotifyUrl("http://domain.com/CallBack/notify_url.jsp");
        alipayRequest.setBizContent("{" +
                "    \"out_trade_no\":\"20150320010101001\"," +
                "    \"product_code\":\"FAST_INSTANT_TRADE_PAY\"," +
                "    \"total_amount\":88.88," +
                "    \"subject\":\"Iphone6 16G\"," +
                "    \"body\":\"Iphone6 16G\"," +
                "    \"passback_params\":\"merchantBizType%3d3C%26merchantBizNo%3d2016010101111\"," +
                "    \"extend_params\":{" +
                "    \"sys_service_provider_id\":\"2088511833207846\"" +
                "    }"+
                "  }");
        // 填充业务参数
        String form="";
        try {
            // 调用SDK生成表单
            form = alipayClient.pageExecute(alipayRequest).getBody();
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        httpResponse.setContentType("text/html;charset=" + "charset");
        // 直接将完整的表单html输出到页面
        httpResponse.getWriter().write(form);
        httpResponse.getWriter().flush();
        httpResponse.getWriter().close();
    }
}
