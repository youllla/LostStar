package poly.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import poly.dto.UserDTO;
import poly.service.INoticeService;
import poly.service.IUserService;
import poly.service.impl.UserService;
import poly.util.CmmUtil;

@Controller
public class UserController {
	private Logger log = Logger.getLogger(this.getClass());
	
	@Resource(name = "UserService")
	private IUserService userService;
	
	
	//회원가입 페이지
	@RequestMapping(value="user/userReg")
	public String userReg() throws Exception {
	
		return "/user/userReg";
	}
	
	//회원가입
	@RequestMapping(value="user/userRegProc", method=RequestMethod.POST)
	public String userRegProc(HttpServletRequest request, HttpServletResponse response, Model model, HttpSession session) throws Exception {
		log.info("userRegProc Start");
		String userNo=CmmUtil.nvl(request.getParameter("userNo"));
		log.info("userNo : " + userNo);
		String name=CmmUtil.nvl(request.getParameter("name"));
		log.info("name : " + name);
		String tel=CmmUtil.nvl(request.getParameter("tel"));
		log.info("tel : " + tel);
		String id=CmmUtil.nvl(request.getParameter("id"));
		log.info("id : " + id);
		String password=CmmUtil.nvl(request.getParameter("password"));
		log.info("password : " + password);
		String regNo=CmmUtil.nvl(request.getParameter("regNo"));
		log.info("regNo : " + regNo);
		String regDate=CmmUtil.nvl(request.getParameter("regDate"));
		log.info("regDate : " + regDate);
		
		//회원등록
		UserDTO uDTO = new UserDTO();
		uDTO.setName(name);
		uDTO.setTel(tel);
		uDTO.setId(id);
		uDTO.setPassword(password);
		int result = userService.insertUser(uDTO);
		
		//RegNo userNo이랑 같게 insert시키기
		UserDTO uDTO2 = new UserDTO();
		/*uDTO2.setRegNo(regNo);*/
		uDTO2.setRegNo(uDTO.getUserNo());
		log.info("userNo : " + userNo);
		int result2 = userService.updateRegNo(uDTO2);
		log.info("result2 : " + result2);

		String msg="";
		String url="";
		
		if(result != 0) {
			msg="회원가입을 성공하셨습니다.";
			url="/main.do";
		} else {
			msg="회원가입을 실패하셨습니다.";
			url="/user/userReg.do";
		}
		
		model.addAttribute("msg", msg);
		model.addAttribute("url", url);
		
		log.info("userRegProc End");
		
		return "/alert";
	}
	
	//로그인
	@RequestMapping(value="user/userLogin")
	public String userLogin(HttpServletRequest request, HttpServletResponse response, Model model, HttpSession session) throws Exception {
		
		
		
		return "/main";
	}

}
