package com.twc.mydemo;

public class CodesInfo {
    private String codeMsg;
    private String codeId;
    private int isSelect;


    public CodesInfo(String codeMsg, String codeId, int isSelect) {
        this.codeMsg = codeMsg;
        this.codeId = codeId;
        this.isSelect = isSelect;
    }

    public int getIsSelect() {
        return isSelect;
    }

    public void setIsSelect(int isSelect) {
        this.isSelect = isSelect;
    }

    public String getCodeMsg() {
        return codeMsg;
    }

    public void setCodeMsg(String codeMsg) {
        this.codeMsg = codeMsg;
    }

    public String getCodeId() {
        return codeId;
    }

    public void setCodeId(String codeId) {
        this.codeId = codeId;
    }

    public CodesInfo(int isSelect) {
        this.isSelect = isSelect;

    }
}
