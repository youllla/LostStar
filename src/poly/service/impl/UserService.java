package poly.service.impl;

import java.util.List;

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
	
	//등록자번호=사용자번호
	@Override
	public int updateRegNo(UserDTO uDTO2) throws Exception {
		return userMapper.updateRegNo(uDTO2);
	}

	//아이디 중복확인
	@Override
	public int getIdCheck(UserDTO uDTO) throws Exception {
		return userMapper.getIdCheck(uDTO);
	}

	//아이디 찾기
	@Override
	public List<UserDTO> getIdFind(UserDTO uDTO) throws Exception {
		return userMapper.getIdFind(uDTO);
	}

	//로그인
	@Override
	public UserDTO userLogin(UserDTO uDTO) throws Exception {
		return userMapper.userLogin(uDTO);
	}

	//회원상세정보
	@Override
	public UserDTO userDetail(String userNo) throws Exception {
		return userMapper.userDetail(userNo);
	}

	//회원정보변경
	@Override
	public int userUpdate(UserDTO uDTO) throws Exception {
		return userMapper.userUpdate(uDTO);
	}
}
