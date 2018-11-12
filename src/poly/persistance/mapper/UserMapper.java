package poly.persistance.mapper;

import config.Mapper;
import poly.dto.UserDTO;

@Mapper("UserMapper")
public interface UserMapper {
	//회원가입
	public int insertUser(UserDTO uDTO) throws Exception;
	
	//RegNo
	public int updateRegNo(UserDTO uDTO2) throws Exception;
	

}
