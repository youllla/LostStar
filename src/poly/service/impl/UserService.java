package poly.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import poly.dto.UserDTO;
import poly.persistance.mapper.UserMapper;
import poly.service.IUserService;

@Service("UserService")
public class UserService implements IUserService {

	@Resource(name="UserMapper")
	private UserMapper userMapper;
	
	//회원등록
	@Override
	public int insertUser(UserDTO uDTO) throws Exception {
		return userMapper.insertUser(uDTO);
	}
	
	//RegNo
	@Override
	public int updateRegNo(UserDTO uDTO2) throws Exception {
		return userMapper.updateRegNo(uDTO2);
	}
}
