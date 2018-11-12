package poly.service;

import poly.dto.UserDTO;

public interface IUserService {
	
	//회원등록
	public int insertUser(UserDTO uDTO) throws Exception;
	
	//RegNo
	public int updateRegNo(UserDTO uDTO2) throws Exception;
}
