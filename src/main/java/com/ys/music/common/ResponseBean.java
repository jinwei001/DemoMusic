package com.ys.music.common;


import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 *
 * @ClassName:  ResponseBean
 * @Description:返回类
 */
@Data
@ApiModel("返回类")
public class ResponseBean {

    private int code;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String errorCode;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String errorMsg;
    //返回信息
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String msg;
    //返回的数据
    private Object data;
    public ResponseBean(int code,String errorCode,  String errorMsg ,Object data) {
        this.code = code;
        this.errorCode=errorCode;
        this.errorMsg=errorMsg;

    }


    public ResponseBean(int code, String msg ,Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;

    }
    public ResponseBean() {


    }
    public static ResponseBean ofSuccess(int i, Object data) {
        return new ResponseBean(200, "操作成功", data);
    }


    public static ResponseBean ofSuccess(String message,Object data) {
        return new ResponseBean(200, message, data);
    }
    public static ResponseBean ofMessage(int code, String message) {
        return new ResponseBean(code, message, null);
    }

    public static ResponseBean ofError(InterfaceError interfaceError,String message ) {

        ResponseBean responseBean =interfaceError.getErrorInfo();
        responseBean.setMsg(message);
        return responseBean;
    }
}
