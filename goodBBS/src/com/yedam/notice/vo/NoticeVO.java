package com.yedam.notice.vo;

import java.util.Date;

public class NoticeVO {
	private int id;
	private String title;
	private String content;
	private Date regDate; // 2021/05/04
	private int hit;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public int getHit() {
		return hit;
	}

	public void setHit(int hit) {
		this.hit = hit;
	}

	@Override
	public String toString() {
		return "NoticeVO [id=" + id + ", title=" + title + ", content=" + content + ", regDate=" + regDate + ", hit="
				+ hit + "]";
	}

}
