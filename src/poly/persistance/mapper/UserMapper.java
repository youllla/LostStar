package poly.persistance.mapper;

import java.util.List;

import config.Mapper;
import poly.dto.UserDTO;

@Mapper("UserMapper")
public interface UserMapper {
	//회원가입
	public int insertUser(UserDTO uDTO) throws Exception;
	
	//등록자번호=사용자번호
	public int updateRegNo(UserDTO uDTO2) throws Exception;

	//아이디 중복확인
	public int getIdCheck(UserDTO uDTO) throws Exception;

	//아이디 찾기
	public List<UserDTO> getIdFind(UserDTO uDTO) throws Exception;

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

	
}
