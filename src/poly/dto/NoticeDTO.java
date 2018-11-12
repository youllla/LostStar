package poly.dto;

public class NoticeDTO {

	private String ntNo; // 공지사항번호 (기본키)
	private String ntTitle; // 제목
	private String ntContent; // 내용
	private String ntWriter; // 작성자
	private String ntRegDate; // 공지사항등록일
	private String ntRegNo; // 공지사항등록번호
	private String ntUpdDate; // 공지사항수정일
	private String ntUpdNo; // 공지사항수정번호
	
	public String getNtNo() {
		return ntNo;
	}
	public void setNtNo(String ntNo) {
		this.ntNo = ntNo;
	}
	public String getNtTitle() {
		return ntTitle;
	}
	public void setNtTitle(String ntTitle) {
		this.ntTitle = ntTitle;
	}
	public String getNtContent() {
		return ntContent;
	}
	public void setNtContent(String ntContent) {
		this.ntContent = ntContent;
	}
	public String getNtWriter() {
		return ntWriter;
	}
	public void setNtWriter(String ntWriter) {
		this.ntWriter = ntWriter;
	}
	public String getNtRegDate() {
		return ntRegDate;
	}
	public void setNtRegDate(String ntRegDate) {
		this.ntRegDate = ntRegDate;
	}
	public String getNtRegNo() {
		return ntRegNo;
	}
	public void setNtRegNo(String ntRegNo) {
		this.ntRegNo = ntRegNo;
	}
	public String getNtUpdDate() {
		return ntUpdDate;
	}
	public void setNtUpdDate(String ntUpdDate) {
		this.ntUpdDate = ntUpdDate;
	}
	public String getNtUpdNo() {
		return ntUpdNo;
	}
	public void setNtUpdNo(String ntUpdNo) {
		this.ntUpdNo = ntUpdNo;
	}

	

}
