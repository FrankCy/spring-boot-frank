package com.frank.excerpt;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/**
 *
 *
 * @author cy
 * @version ExcerptStartApplication.java, v 0.1 2021年01月05日 1:55 下午 cy Exp $
 */
public class ExcerptStartApplication {

    public static void main(String[] args) {
        String sourceStr = "http://192.168.2.183:19000/hfm%2FDocMgr%2FOpenItem%2Easp%3FDocMgr%3D%26Name%3Dbigdata%26Path%3D%26DocumentType%3D3%26DocumentFileType%3D3%26iscontained%3DYes%26Caller%26cluster%3DHFM%2DAPP%2DPROD%26workspace%3Dtrue%26reopen%3Dtrue%26themes%5Ftadpole%3DBpmTadpole";
        try {
            String str = URLDecoder.decode(sourceStr,"UTF-8");
            System.out.println(str);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

    }


}
