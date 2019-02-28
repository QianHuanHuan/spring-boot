package com.example.retailers.result;

public class BaseResult {

    private String resCode = "";
    private String resMsg = "";

    public BaseResult(){

    }

    /**
     * 成功
     * @return
     */
    public static BaseResult success(){
        return findBaseResult(1);
    }

    /**
     * 失败
     * @return
     */
    public static BaseResult error(){
        return findBaseResult(0);
    }

    public static BaseResult findBaseResult(boolean flag){
        return flag?findBaseResult(1):findBaseResult(0);
    }
    public static BaseResult findBaseResult(int i){
        BaseResult baseResult = new BaseResult();
        if(i>=1){
            baseResult.setResMsg("操作成功");
            baseResult.setResCode("ok");
        }else {
            baseResult.setResMsg("操作失败");
            baseResult.setResCode("error");
        }
        return baseResult;
    }

    public BaseResult(String code,String msg){
        this.resCode = code;
        this.resMsg = msg;
    }

    public  String getResCode() {
        return resCode;
    }

    public  void setResCode(String resCode) {
        this.resCode = resCode;
    }

    public  String getResMsg() {
        return resMsg;
    }

    public  void setResMsg(String resMsg) {
        this.resMsg = resMsg;
    }
}
