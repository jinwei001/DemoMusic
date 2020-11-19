package com.ys.music.common;

public enum InterfaceError {
    SERVICE_SYS_ERROR(500,"E000001","系统异常")
    ,SERVICE_SYS_PARAMERROR(500,"E000002","参数异常")
    ,SERVICE_HTTPINFO_ERROR(401,"E100001","http返回信息异常")
    ,SERVICE_ACCOUNT_NOT_EXISTED(500,"E040102","账户不存在")
    ,SERVICE_TAG_ERROR(500,"E000004","tag异常")
    ,SERVICE_PROCESS_ERROR(500,"E200001","工序操作错误")
    ;

    private int code;
    private String errorCode;
    private String errormsg;
    private InterfaceError(int code,String errorCode,String errormsg)
    {
        this.code=code;
        this.errormsg=errormsg;
        this.errorCode=errorCode;
    }
    public ResponseBean  getErrorInfo()
    {
        ResponseBean responseBean=new ResponseBean();
        responseBean.setCode(this.code);
        responseBean.setErrorCode(errorCode);

        return new ResponseBean(this.code,this.errorCode,this.errormsg,null);
    }
}
