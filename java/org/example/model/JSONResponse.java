package org.example.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * HTTP响应json数据，前后端统一约定的json格式
 * 响应状态码都是200
 *
 * */
@Getter
@Setter
@ToString
public class JSONResponse {
    //业务是否成功
    private boolean success;
    //业务操作消息码，一般来说，只有错误情况才有意义
    private String code;
    //业务操作错误信息，给用户看
    private String massage;
    //业务操作成功时，给前端ajax success方法使用，解析数据
    private Object data;
}
