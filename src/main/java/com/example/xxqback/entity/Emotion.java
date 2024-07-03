package com.example.xxqback.entity;

import java.util.Date;

public class Emotion {
    private int eid;
    private String type;
    private Date emotionDate;

    // Getters and Setters
    public int getEid() {
        return eid;
    }

    public void setEid(int eid) {
        this.eid = eid;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getEmotionDate() {
        return emotionDate;
    }

    public void setEmotionDate(Date emotionDate) {
        this.emotionDate = emotionDate;
    }
}
