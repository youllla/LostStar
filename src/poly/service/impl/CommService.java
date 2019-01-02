package poly.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import poly.dto.CommDTO;
import poly.persistance.mapper.CommMapper;
import poly.service.ICommService;

@Service("CommService")
public class CommService implements ICommService {
	
	@Resource(name="CommMapper")
	private CommMapper commMapper;

	//자유게시판 목록
	@Override
	public List<CommDTO> commList() throws Exception {
		return commMapper.commList();
	}

	//자유게시판 등록
	@Override
	public int insertComm(CommDTO cDTO) throws Exception {
		return commMapper.insertComm(cDTO);
	}

	//자유게시판 상세
	@Override
	public CommDTO commDetail(String commNo) throws Exception {
		return commMapper.commDetail(commNo);
	}

	//자유게시판 수정
	@Override
	public int commUpdate(CommDTO cDTO) throws Exception {
		return commMapper.commUpdate(cDTO);
	}

	//자유게시판 삭제
	@Override
	public int commDelete(String commNo) throws Exception {
		return commMapper.commDelete(commNo);
	}

	//내가 쓴 글 보기 페이지
	@Override
	public List<CommDTO> userWriteList() throws Exception {
		return commMapper.userWriteList();
	}
	
}
