package com.dtxw.model;


public class OutMessage {

    private String uid;//用户ID
    private String name;//聊天室名称
    private String path;//聊天室路径
    private String content;//消息内容
    private String time;//时间
    private int id;//聊天室ID
    private String mid;

    public OutMessage(InMessage inMessage) {
        this.content=inMessage.getContent();
        this.id=inMessage.getId();
        this.name=inMessage.getName();
        this.path=inMessage.getPath();
        this.time=inMessage.getTime();
        this.uid=inMessage.getUid();
        this.mid=inMessage.getMid();
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
                "   content ='" + "["+content +"]"+
                "   mid ='" + "["+mid+"]"
                ;
    }
}
