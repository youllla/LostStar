package poly.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import poly.dto.NoticeDTO;
import poly.persistance.mapper.NoticeMapper;
import poly.service.INoticeService;

@Service("NoticeService")
public class NoticeService implements INoticeService{
	
	@Resource(name="NoticeMapper")
	private NoticeMapper noticeMapper;

	
	//공지사항 목록
	@Override
	public List<NoticeDTO> noticeList() throws Exception {
		return noticeMapper.noticeList();
	}

	//공지사항 등록
	@Override
	public int insertNotice(NoticeDTO nDTO) throws Exception {
		return noticeMapper.insertNotice(nDTO);
	}

	//ntNo=regNo
	@Override
	public int updateRegNo(NoticeDTO nDTO2) throws Exception {
		return noticeMapper.updateRegNo(nDTO2);
	}
	
}
