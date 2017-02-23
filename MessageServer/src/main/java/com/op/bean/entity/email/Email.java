package com.op.bean.entity.email;

import java.io.File;
import java.util.List;

import com.google.gson.annotations.SerializedName;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/1/7.
 ****************************************/
public class Email {
    private String sender;
    private List<String> accepter;
    private String title;
    private String content;
    private String remark;
    @SerializedName("date_time")
    private String dateTime;
    private String size;
    @SerializedName("bcc_accepter")
    private List<String> bccAccepter;
    @SerializedName("attachment_file")
    private List<File> attachmentFile;
    @SerializedName("attachment_path")
    private List<String> attachmentPath;
    private List<String> recipienters;

    public Email() {
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public List<String> getAccepter() {
        return accepter;
    }

    public void setAccepter(List<String> accepter) {
        this.accepter = accepter;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public List<File> getAttachmentFile() {
        return attachmentFile;
    }

    public void setAttachmentFile(List<File> attachmentFile) {
        this.attachmentFile = attachmentFile;
    }

    public List<String> getRecipienters() {
        return recipienters;
    }

    public void setRecipienters(List<String> recipienters) {
        this.recipienters = recipienters;
    }

    public List<String> getBccAccepter() {
        return bccAccepter;
    }

    public void setBccAccepter(List<String> bccAccepter) {
        this.bccAccepter = bccAccepter;
    }

    public List<String> getAttachmentPath() {
        return attachmentPath;
    }

    public void setAttachmentPath(List<String> attachmentPath) {
        this.attachmentPath = attachmentPath;
    }
}
