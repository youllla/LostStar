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

	//공지사항 상세
	@Override
	public NoticeDTO noticeDetail(String ntNo) throws Exception {
		return noticeMapper.noticeDetail(ntNo);
	}

	//공지사항 수정
	@Override
	public int noticeUpdate(NoticeDTO nDTO) throws Exception {
		return noticeMapper.noticeUpdate(nDTO);
	}

	//공지사항 삭제
	@Override
	public int noticeDelete(String ntNo) throws Exception {
		return noticeMapper.noticeDelete(ntNo);
	}

	//내가 쓴 글 보기 페이지
	@Override
	public List<NoticeDTO> userWriteList() throws Exception {
		return noticeMapper.userWriteList();
	}
	
}
