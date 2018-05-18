package com.real.logicserver.price.config;

import com.github.wxpay.sdk.WXPayConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import java.io.*;

/**
 * @author 15988440973
 */
@Configuration
public class WxPayConfig implements WXPayConfig {
    @Value("${wx.pay.app-id}")
    private String appId;
    @Value("${wx.pay.mch-id}")
    private String mchId;

    @Value("${wx.pay.key}")
    private String key;
    @Value("${wx.pay.cert-path}")
    private String certPath;
    private byte[] certData;
    public WxPayConfig() throws IOException {

    }

    @Override
    public String getAppID() {
        return appId;
    }

    @Override
    public String getMchID() {
        return mchId;
    }

    @Override
    public String getKey() {
        return key;
    }

    @Override
    public InputStream getCertStream() {
        if (this.certData==null) {
            File file = new File(certPath);
            InputStream certStream = null;
            try {
                certStream = new FileInputStream(file);
                this.certData = new byte[(int) file.length()];
                certStream.read(this.certData);
                certStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return new ByteArrayInputStream(this.certData);
    }

    @Override
    public int getHttpConnectTimeoutMs() {
        return 8000;
    }

    @Override
    public int getHttpReadTimeoutMs() {
        return 10000;
    }
}
