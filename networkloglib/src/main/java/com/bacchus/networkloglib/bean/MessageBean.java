package com.bacchus.networkloglib.bean;

public class MessageBean {

    public static final String DATA_FLAG = "data";
    public static final String ACTION_FLAG = "action";
    public static final String TARRGET_FLAG = "targetTag";
    public static final String SELF_FLAG = "selfTag";

    public static final String TARRGET_ALL = "allTarget";

    public static final String TARRGET_SERVER = "serverTarget";

    // 表示弹出一个信息的确定框
    public static final String ACTON_MSGBOX = "msgbox";
    public static final String ACTON_ADD_DEVICE = "addDeviceTag";

    // 表示其他端发送给哪一端
    private String targetTag;
    // 表示自身的tag
    private String selfTag;

    // 表示需要支持的操作
    private String action;

    // 真正发送出去的数据,最终会转化成 json 数据传出去
    private Object data;

    public MessageBean() {
    }

    public MessageBean(String action) {
        this.action = action;
    }

    public MessageBean(String targetTag, String selfTag, String action, Object data) {
        this.targetTag = targetTag;
        this.selfTag = selfTag;
        this.action = action;
        this.data = data;
    }

    public String getTargetTag() {
        return targetTag;
    }

    public void setTargetTag(String targetTag) {
        this.targetTag = targetTag;
    }

    public String getSelfTag() {
        return selfTag;
    }

    public void setSelfTag(String selfTag) {
        this.selfTag = selfTag;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }




}
