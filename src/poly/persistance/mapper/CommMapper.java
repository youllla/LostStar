package poly.persistance.mapper;

import java.util.List;

import config.Mapper;
import poly.dto.CommDTO;

@Mapper("CommMapper")
public interface CommMapper {

	//자유게시판 목록
	public List<CommDTO> commList() throws Exception;

	//자유게시판 등록
	public int insertComm(CommDTO cDTO) throws Exception;

	//자유게시판 상세
	public CommDTO commDetail(String commNo) throws Exception;

	//자유게시판 수정
	public int commUpdate(CommDTO cDTO) throws Exception;

	//자유게시판 삭제
	public int commDelete(String commNo) throws Exception;

	//내가 쓴 글 보기 페이지
	public List<CommDTO> userWriteList() throws Exception;

}
