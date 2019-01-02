package poly.service;

import java.util.HashMap;
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
	public List<UserDTO> userIdFind(UserDTO uDTO) throws Exception;

	//비밀번호 찾기
	public HashMap<String, Object> userPwFind(HashMap<String, Object> hMap) throws Exception;
	
	//로그인
	public UserDTO userLogin(UserDTO uDTO) throws Exception;
	
	//회원목록
	public List<UserDTO> userList() throws Exception;

	//회원상세정보
	public UserDTO userDetail(String userNo) throws Exception;

	//회원정보변경
	public int userUpdate(UserDTO uDTO) throws Exception;

	//회원탈퇴
	public int userDelete(String userNo) throws Exception;

	//비밀번호 변경
	public int userPwUpdateProc(UserDTO uDTO) throws Exception;


}
