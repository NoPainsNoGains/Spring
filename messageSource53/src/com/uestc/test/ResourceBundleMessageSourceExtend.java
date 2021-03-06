package com.uestc.test;

import java.io.UnsupportedEncodingException;
import java.text.MessageFormat;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.context.support.ResourceBundleMessageSource;
/** 
 *  
 * 扩展Spring的resourceBundleMessageSource 
 * 使其支持中文，因为properties文件天生不支持中文，如果要其支持，需要转码，麻烦! 
 * 于是扩展一下，实现自动转码 
 */  
public class ResourceBundleMessageSourceExtend extends ResourceBundleMessageSource{
	private static final String ENCODING = "GBK";// 注意属性文件使用GBK编码  
    private static final String NULL = "null";  
    
    Map<String, String> encodingCache = new ConcurrentHashMap<String, String>(20);
    
    protected String resolveCodeWithoutArguments(String code, Locale locale) {  
        String message = super.resolveCodeWithoutArguments(code, locale);  
        return decodeString(message, ENCODING);  
  
    }  
    
    protected MessageFormat createMessageFormat(String msg, Locale locale) {  
        if (logger.isDebugEnabled()) {  
            logger.debug("Creating MessageFormat for pattern [" + msg  
                    + "] and locale '" + locale + "'");  
        }  
        msg = decodeString(msg, ENCODING);  
        return new MessageFormat((msg != null ? msg : ""), locale);  
    }  
    
    private String decodeString(String message, String encode) {  
        String encodMessage = encodingCache.get(message);  
        if (encodMessage == null) {  
            try {  
                encodMessage = new String(message.getBytes("ISO8859-1"), encode);  
                if (message != null) {  
                    encodingCache.put(message, encodMessage);  
                } else {  
                    encodingCache.put(message, NULL);  
                    // log the code is not exist in properties  
                }  
            } catch (UnsupportedEncodingException e) {  
                e.printStackTrace();  
            }  
        }  
        return encodMessage;  
    }  
}
