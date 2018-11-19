package poly.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
	
	/*//아이디 중복확인
	@RequestMapping(value="user/idCheck")
	@ResponseBody
	public void idCheck(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id=CmmUtil.nvl(request.getParameter("id"));
		
		int count=0;
		count = userService.idCheck(id);
		log.info(count);
		System.out.println("카운트 : " + count);
		
		response.getWriter().println(count);
	}*/
	
	//아이디 중복확인 해야됨 !!!!!!!!!!!!!!!!!!!!!!
	@RequestMapping(value="user/idCheck")
	public @ResponseBody int idCheck(@RequestParam(value="id") String id) throws Exception{
		System.out.println(id);

		UserDTO uDTO = new UserDTO();
		uDTO.setId(id);
		log.info("uDTO id : " + uDTO.getId());

		int idCheck = userService.getIdCheck(uDTO);

		System.out.println(idCheck);
		
		return idCheck;
	}
	
	//아이디찾기 화면
	@RequestMapping(value="user/userFind")
	public String userFind() throws Exception {
		return "/user/userFind";
	}
	
	//아이디찾기
	@RequestMapping(value="user/idFind", method=RequestMethod.POST)
	public @ResponseBody List<UserDTO> idFind(HttpServletRequest request, HttpServletResponse response, Model model, HttpSession session) throws Exception {
		log.info("idFind Start");
		String name=CmmUtil.nvl(request.getParameter("name"));
		log.info("name : " + name);
		String tel=CmmUtil.nvl(request.getParameter("tel"));
		log.info("tel : " + tel);
		
		UserDTO uDTO = new UserDTO();
		uDTO.setName(name);
		uDTO.setTel(tel);
		
		List<UserDTO> uList = userService.getIdFind(uDTO);
		
		log.info("idFind End");
		
		return uList;
	}
	
	//로그인
	@RequestMapping(value="user/loginProc", method=RequestMethod.POST)
	public String loginProc(HttpServletRequest request, HttpServletResponse response, Model model, HttpSession session) throws Exception {
		String id=CmmUtil.nvl(request.getParameter("id"));
		log.info("id : " + id);
		String password=CmmUtil.nvl(request.getParameter("password"));
		log.info("password : " + password);
		
		UserDTO uDTO = new UserDTO();
		uDTO.setId(id);
		uDTO.setPassword(password);
		
		uDTO=userService.userLogin(uDTO);
		
		String msg = "";
		String url = "";
		
		if(uDTO == null) {
			//로그인 실패
			msg = "로그인이 실패하셨습니다.";
			url = "/main.do";
			model.addAttribute("msg", msg);
			model.addAttribute("url", url);
			return "/alert";
		} else {
			//로그인 성공
			session.setAttribute("userNo", uDTO.getUserNo()); //관리자만 상단메뉴 달라지기 때문에 userNo 받아야함.
			session.setAttribute("id", uDTO.getId());
			session.setAttribute("name", uDTO.getName());
			session.setAttribute("PASSWORD", password);
		}
		
		return "/main";
	}
	
	//로그아웃
	@RequestMapping(value="user/logout")
	public String logout(HttpSession session) throws Exception {
		//세션을 초기화 시키는 함수
		session.invalidate();
		//로그아웃 끝
	
		return "/main";
	}
	
	//회원목록
	@RequestMapping(value="user/userList")
	public String userList(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {
		List<UserDTO> uList=userService.userList();
		
		model.addAttribute("uList", uList);
		
		return "/user/userList";
	}
	
	//회원 상세 정보
	@RequestMapping(value="user/userDetail")
	public String userDetail(HttpServletRequest request, HttpServletResponse response, HttpSession sesstion, Model model) throws Exception {
		String userNo=CmmUtil.nvl(request.getParameter("userNo"));
		log.info("userNo : " + userNo);
		
		UserDTO uDTO = userService.userDetail(userNo);
		model.addAttribute("uDTO", uDTO);
		
		return "/user/userDetail";
	}
	
	//회원 정보 변경 화면
	@RequestMapping(value="user/userUpdateView")
	public String userUpdateView(HttpServletRequest request, HttpServletResponse response, HttpSession session, Model model) throws Exception {
		String userNo=CmmUtil.nvl(request.getParameter("userNo"));
		log.info("userNo : " + userNo);
		
		UserDTO uDTO = userService.userDetail(userNo);
		model.addAttribute("uDTO", uDTO);
		
		return "/user/userUpdateView";
	}
	
	//회원 정보 변경
	@RequestMapping(value="user/userUpdate")
	public String userUpdate(HttpServletRequest request, HttpServletResponse response, HttpSession session, Model model) throws Exception {
		String userNo=CmmUtil.nvl(request.getParameter("userNo"));
		log.info("userNo : " + userNo);
		String id=CmmUtil.nvl(request.getParameter("id"));
		log.info("id : " + id);
		String name=CmmUtil.nvl(request.getParameter("name"));
		log.info("name : " + name);
		String tel=CmmUtil.nvl(request.getParameter("tel"));
		log.info("tel : " + tel);
		
		UserDTO uDTO = new UserDTO();
		uDTO.setUserNo(userNo);
		uDTO.setId(id);
		uDTO.setName(name);
		uDTO.setTel(tel);
		
		int result = userService.userUpdate(uDTO);
		
		String msg="";
		String url="";
		
		if(result != 0) {
			//수정 성공
			msg = "수정이 완료되었습니다.";
			url = "/user/userDetail.do?userNo=" + userNo;
		} else {
			//수정 실패
			msg = "수정을 실패하셨습니다.";
			url = "/user/userUpdateView.do?userNo=" + userNo;
		}
		
		model.addAttribute("msg", msg);
		model.addAttribute("url", url);
		
		return "/alert";
	}
	
	//회원 탈퇴
	@RequestMapping(value="user/userDelete")
	public String userDelete(HttpServletRequest request, HttpServletResponse response, HttpSession session, Model model) throws Exception {
		String userNo=CmmUtil.nvl(request.getParameter("userNo"));
		log.info("탈퇴 userNo : " + userNo);
		
		int result = userService.userDelete(userNo);
		String msg="";
		String url="";
		
		if(result != 0) {
			//회원탈퇴 성공
			msg="회원이 탈퇴되었습니다.";
			session.invalidate();
			url="/main.do";
		} else {
			//회원탈퇴 실패
			msg="회원탈퇴를 실패하였습니다.";
			url="/user/userDetail.do?userNo=" + userNo;
		}
		
		model.addAttribute("msg", msg);
		model.addAttribute("url", url);
		
		return "/alert";
	}

}
