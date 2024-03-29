package com.yedam.bulletin.vo;

import java.util.Date;

public class BulletinVO {
	private int id;// 키
	private String title; // 제목
	private String content; // 내용
	private String writer; // 작성자
	private Date regDate;// 등록일자
	private int hit;// 클릭수

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

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
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
		return "BulletinVO [id=" + id + ", title=" + title + ", content=" + content + ", writer=" + writer
				+ ", regDate=" + regDate + ", hit=" + hit + "]";
	}

}
