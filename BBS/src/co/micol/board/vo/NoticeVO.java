package co.micol.board.vo;

import java.util.Date;

public class NoticeVO {
	private int ntcNo;
	private String ntcTitle;
	private Date ntcFromDate;
	private Date ntcToDate;
	private Date ntcRegDate;
	private String ntcContent;

	public int getNtcNo() {
		return ntcNo;
	}

	public void setNtcNo(int ntcNo) {
		this.ntcNo = ntcNo;
	}

	public String getNtcTitle() {
		return ntcTitle;
	}

	public void setNtcTitle(String ntcTitle) {
		this.ntcTitle = ntcTitle;
	}

	public Date getNtcFromDate() {
		return ntcFromDate;
	}

	public void setNtcFromDate(Date ntcFromDate) {
		this.ntcFromDate = ntcFromDate;
	}

	public Date getNtcToDate() {
		return ntcToDate;
	}

	public void setNtcToDate(Date ntcToDate) {
		this.ntcToDate = ntcToDate;
	}

	public Date getNtcRegDate() {
		return ntcRegDate;
	}

	public void setNtcRegDate(Date ntcRegDate) {
		this.ntcRegDate = ntcRegDate;
	}

	public String getNtcContent() {
		return ntcContent;
	}

	public void setNtcContent(String ntcContent) {
		this.ntcContent = ntcContent;
	}

}
