package poly.service;

import java.util.List;

import poly.dto.UserDTO;

public interface IUserService {
	
	//회원등록
	public int insertUser(UserDTO uDTO) throws Exception;
	
	//등록자번호=사용자번호
	public int updateRegNo(UserDTO uDTO2) throws Exception;

	//아이디 중복확인
	public int getIdCheck(UserDTO uDTO) throws Exception;

	//아이디 찾기
	public List<UserDTO> getIdFind(UserDTO uDTO) throws Exception;

	//로그인
	public UserDTO userLogin(UserDTO uDTO) throws Exception;

	//회원상세정보
	public UserDTO userDetail(String userNo) throws Exception;

	//회원저보변경
	public int userUpdate(UserDTO uDTO) throws Exception;
}
