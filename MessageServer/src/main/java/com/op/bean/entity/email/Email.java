package com.op.bean.entity.email;

import java.io.File;
import java.util.List;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/1/7.
 ****************************************/
public class Email{
	private String sender;
	private List<String> accepter;
	private String title;
	private String content;
	private String remark;
	private String dateTime;
	private String size;
	private List<String> bccAccepter;
	private List<File> attachmentList;
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

	public List<File> getAttachmentList() {
		return attachmentList;
	}

	public void setAttachmentList(List<File> attachmentList) {
		this.attachmentList = attachmentList;
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
}
