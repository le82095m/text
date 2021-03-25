package org.example.util;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;

public class JsonUtil {

    private static final ObjectMapper MAPPER = new ObjectMapper();
    /**
     * JSON序列化：将java对象序列化为json字符串
     * @param o java对象
     * @return json字符串
     */
    public static String serialize(Object o){
        try {
            return MAPPER.writeValueAsString(o);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new RuntimeException("JSON序列化失败："+o);
        }
    }
    /**
     * JSON反序列化：将输入流反序列化为java对象
     * @param is 输入流
     * @param tClass 指定要反序列化的对象
     * @return 反序列化对象
     */

    public static <T> T deserialize(InputStream is, Class<T> tClass){
        try {
            return MAPPER.readValue(is,tClass);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("JSON反序列化失败"+tClass.getName());
        }
    }
}
