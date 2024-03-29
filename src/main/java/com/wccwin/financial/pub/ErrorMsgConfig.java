package com.wccwin.financial.pub;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Properties;

/**
 * 异常消息
 */
public class ErrorMsgConfig {

    /**
     * 异常对照表
     */
    private final static HashMap<Integer, String> errMsg = new HashMap<>();

    private final static String FILE_PATH = "/exception.properties";

    static {//静态读取异常消息 classpath:exception.properties
        Properties pro = new Properties();
        InputStream in = null;
        try{
            in = ErrorMsgConfig.class.getResourceAsStream(FILE_PATH);
            pro.load(new InputStreamReader(in, "utf-8"));

            Iterator<String> it= pro.stringPropertyNames().iterator();
            while(it.hasNext()){
                String key=it.next();
                String msg = pro.getProperty(key);
                errMsg.put(Integer.parseInt(key), msg);
            }
        } catch (Exception e){
            //e.printStackTrace();
        } finally {
            if(in != null){
                try{
                    in.close();
                } catch (Exception e){
                    //e.printStackTrace();
                }
            }
        }
    }

    /**
     * 获取异常message
     * @param code
     * @return
     */
    public static String getErrorMsg(Integer code){
        return errMsg.get(code);
    }


}
