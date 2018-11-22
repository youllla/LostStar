package poly.persistance.mapper;

import java.util.List;

import config.Mapper;
import poly.dto.NoticeDTO;

@Mapper("NoticeMapper")
public interface NoticeMapper {

	//공지사항 목록
	public List<NoticeDTO> noticeList() throws Exception;

	//공지사항 등록
	public int insertNotice(NoticeDTO nDTO) throws Exception;

	//ntNo=regNo
	public int updateRegNo(NoticeDTO nDTO2) throws Exception;
	
}