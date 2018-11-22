package poly.service;

import java.util.List;

import poly.dto.NoticeDTO;

public interface INoticeService {

	//공지사항 목록
	public List<NoticeDTO> noticeList() throws Exception;

	//공지사항 등록
	public int insertNotice(NoticeDTO nDTO) throws Exception;

	//ntNo=regNo
	public int updateRegNo(NoticeDTO nDTO2) throws Exception;

}
