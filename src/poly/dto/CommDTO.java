package poly.dto;

public class CommDTO {
	
	private String comNo; // 공지사항번호 (기본키)
	private String comTitle; // 제목
	private String comContent; // 내용
	private String comWriter; // 작성자
	private String comRegDate; // 공지사항등록일
	private String comRegNo; // 공지사항등록번호
	private String comUpdDate; // 공지사항수정일
	private String comUpdNo; // 공지사항수정번호
	
	public String getComNo() {
		return comNo;
	}
	public void setComNo(String comNo) {
		this.comNo = comNo;
	}
	public String getComTitle() {
		return comTitle;
	}
	public void setComTitle(String comTitle) {
		this.comTitle = comTitle;
	}
	public String getComContent() {
		return comContent;
	}
	public void setComContent(String comContent) {
		this.comContent = comContent;
	}
	public String getComWriter() {
		return comWriter;
	}
	public void setComWriter(String comWriter) {
		this.comWriter = comWriter;
	}
	public String getComRegDate() {
		return comRegDate;
	}
	public void setComRegDate(String comRegDate) {
		this.comRegDate = comRegDate;
	}
	public String getComRegNo() {
		return comRegNo;
	}
	public void setComRegNo(String comRegNo) {
		this.comRegNo = comRegNo;
	}
	public String getComUpdDate() {
		return comUpdDate;
	}
	public void setComUpdDate(String comUpdDate) {
		this.comUpdDate = comUpdDate;
	}
	public String getComUpdNo() {
		return comUpdNo;
	}
	public void setComUpdNo(String comUpdNo) {
		this.comUpdNo = comUpdNo;
	}
	
}
