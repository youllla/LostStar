package poly.dto;

public class CommDTO {
	
	private String No;
	private String commNo; // 게시판번호 (기본키)
	private String commTitle; // 제목
	private String commContent; // 내용
	private String commWriter; // 작성자
	private String commRegDate; // 게시판등록일
	private String commRegNo; // 게시판등록번호
	private String commUpdDate; // 게시판수정일
	private String commUpdNo; // 게시판수정번호
	
	public String getNo() {
		return No;
	}
	public void setNo(String no) {
		No = no;
	}
	public String getCommNo() {
		return commNo;
	}
	public void setCommNo(String commNo) {
		this.commNo = commNo;
	}
	public String getCommTitle() {
		return commTitle;
	}
	public void setCommTitle(String commTitle) {
		this.commTitle = commTitle;
	}
	public String getCommContent() {
		return commContent;
	}
	public void setCommContent(String commContent) {
		this.commContent = commContent;
	}
	public String getCommWriter() {
		return commWriter;
	}
	public void setCommWriter(String commWriter) {
		this.commWriter = commWriter;
	}
	public String getCommRegDate() {
		return commRegDate;
	}
	public void setCommRegDate(String commRegDate) {
		this.commRegDate = commRegDate;
	}
	public String getCommRegNo() {
		return commRegNo;
	}
	public void setCommRegNo(String commRegNo) {
		this.commRegNo = commRegNo;
	}
	public String getCommUpdDate() {
		return commUpdDate;
	}
	public void setCommUpdDate(String commUpdDate) {
		this.commUpdDate = commUpdDate;
	}
	public String getCommUpdNo() {
		return commUpdNo;
	}
	public void setCommUpdNo(String commUpdNo) {
		this.commUpdNo = commUpdNo;
	}
	
}
