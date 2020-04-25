package com.dtxw.model;

public class InMessage {

    private String uid; //用户ID 哈希生成
    private String name; //聊天室名称
    private String path; //聊天室路径
    private String content;//消息内容
    private String time;//时间
    private int id;//聊天室ID
    private String mac;//用户当前WiFi MAC
    private String mid;
    public InMessage(){}

    public InMessage(String uid, String path, String content) {
        this.uid = uid;
        this.path = path;
        this.content = content;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid;
    }

    @Override
    public String toString() {
        return "uid = '" + "["+uid +"]"+
                "   name ='" + "["+name +"]"+
                "   path ='" + "["+path +"]"+
                "   time ='" + "["+time +"]"+
                "   id =" + "["+id +"]"+
                "   mac ='" +"["+ mac +"]"+
                "   content ='" + "["+content +"]"+
                "   mid ='" + "["+mid+"]"
                ;
    }


}
