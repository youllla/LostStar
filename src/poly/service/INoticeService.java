package poly.service;

import java.util.List;

import poly.dto.NoticeDTO;

public interface INoticeService {

	//공지사항 목록
	public List<NoticeDTO> noticeList() throws Exception;

	//공지사항 등록
	public int insertNotice(NoticeDTO nDTO) throws Exception;

	//공지사항 상세
	public NoticeDTO noticeDetail(String ntNo) throws Exception;

	//공지사항 수정
	public int noticeUpdate(NoticeDTO nDTO) throws Exception;

	//공지사항 삭제
	public int noticeDelete(String ntNo) throws Exception;

	//내가 쓴 글 보기 페이지
	public List<NoticeDTO> userWriteList() throws Exception;

}
