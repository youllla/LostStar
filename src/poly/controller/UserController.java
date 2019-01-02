package poly.controller;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import poly.dto.CommDTO;
import poly.dto.NoticeDTO;
import poly.dto.UserDTO;
import poly.service.ICommService;
import poly.service.INoticeService;
import poly.service.IUserService;
import poly.service.impl.UserService;
import poly.util.CmmUtil;
import poly.util.Email;
import poly.util.EmailSender;
import poly.util.TempKey;

@Controller
public class UserController {
	private Logger log = Logger.getLogger(this.getClass());
	
	@Resource(name = "UserService")
	private IUserService userService;
	@Resource(name = "NoticeService")
	private INoticeService noticeService;
	@Resource(name = "CommService")
	private ICommService commService;
	@Autowired
	private EmailSender emailSender;
	
	
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
	
	//아이디 중복확인
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
	@RequestMapping(value="user/userIdFind")
	public String userIdFind() throws Exception {
		return "/user/userIdFind";
	}
	
	//아이디찾기
	@RequestMapping(value="user/userIdFind", method=RequestMethod.POST)
	public @ResponseBody List<UserDTO> userIdFind(HttpServletRequest request, HttpServletResponse response, Model model, HttpSession session) throws Exception {
		log.info("userIdFind Start!!!");
		String name=CmmUtil.nvl(request.getParameter("name"));
		log.info("name : " + name);
		String tel=CmmUtil.nvl(request.getParameter("tel"));
		log.info("tel : " + tel);
		
		UserDTO uDTO = new UserDTO();
		uDTO.setName(name);
		uDTO.setTel(tel);
		
		List<UserDTO> uList = userService.userIdFind(uDTO);
		
		log.info("userIdFind End");
		
		return uList;
	}
	
	//아이디찾기
	/*	@RequestMapping(value="user/userPwFind", method=RequestMethod.POST)
		public @ResponseBody List<UserDTO> userPwFind(HttpServletRequest request, HttpServletResponse response, Model model, HttpSession session) throws Exception {
			log.info("userPwFind Start!!!");
			String name=CmmUtil.nvl(request.getParameter("name"));
			log.info("name : " + name);
			String id=CmmUtil.nvl(request.getParameter("id"));
			log.info("id : " + id);
			
			UserDTO uDTO = new UserDTO();
			uDTO.setName(name);
			uDTO.setTel(id);
			
			List<UserDTO> uList = userService.userPwFind(uDTO);
			
			log.info("userPwFind End");
			
			return uList;
		}*/
	
	//비밀번호찾기 화면
		@RequestMapping(value="user/userPwFind")
		public String userPwFind() throws Exception {
			return "/user/userPwFind";
		}
	
	//비밀번호 찾기
	@RequestMapping(value="user/userPwFindProc", method=RequestMethod.POST)
	public String pwFindProc(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {
		log.info("userPwFind Start!!!!");
		
		String id=CmmUtil.nvl(request.getParameter("id"));
		log.info(this.getClass() + "id : " + id);
		String name=CmmUtil.nvl(request.getParameter("name"));
		log.info(this.getClass() + "name : " + name);
		
		Email sendEmail = new Email();
		UserDTO uDTO = new UserDTO();
		uDTO.setId(id);
		uDTO.setName(name);
		
		HashMap<String, Object> hMap = new HashMap<>();
		hMap.put("uDTO", uDTO);
		hMap = userService.userPwFind(hMap);
		
		int result = (int)hMap.get("result");
		String msg="";
		String url="";
		
		if(result == 0 ) {
			msg= "회원 정보가 일치하지 않습니다.";
			url="/user/userFind.do";
		}else {
			
			TempKey tmpky = new TempKey();
			String tmp = tmpky.getKey(10, false);
			sendEmail.setReciver(id);
			sendEmail.setSubject(name+"님의 임시비밀번호입니다.");
			sendEmail.setContent(sendEmail.setContents(hMap) + tmp);
			
			emailSender.SendEmail(sendEmail);
			
			msg = "가입하신 이메일로 임시비밀번호가 전송되었습니다.";
			url = "/main.do";
		}
		model.addAttribute("url", url);
		model.addAttribute("msg", msg);
		hMap = null;
		uDTO = null;
		
		log.info("userPwFind End!!!!");
		
		return "/alert";
	}
	
	//비밀번호 변경 페이지
	@RequestMapping(value="user/userPwUpdate")
	public String userPwUpdate(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {
		String userNo=CmmUtil.nvl(request.getParameter("userNo"));
		log.info("userNo : " + userNo);
		
		UserDTO uDTO = userService.userDetail(userNo);
		model.addAttribute("uDTO", uDTO);
		
		return "/user/userPwUpdate";
	}
	
	//비밀번호 변경
	@RequestMapping(value="user/userPwUpdateProc")
	public String userPwUpdateProc(HttpServletRequest request, HttpServletResponse response, HttpSession session, Model model) throws Exception {
		String userNo=CmmUtil.nvl(request.getParameter("userNo"));
		log.info("userNo : " + userNo);
		String password=CmmUtil.nvl(request.getParameter("password"));
		log.info("password : " + password);
		
		UserDTO uDTO = new UserDTO();
		uDTO.setUserNo(userNo);
		uDTO.setPassword(password);
		
		int result = userService.userPwUpdateProc(uDTO);
		
		String msg="";
		String url="";
		
		if(result != 0) {
			//수정 성공
			msg = "수정이 완료되었습니다.";
			url = "/main.do";
			session.invalidate();
		} else {
			//수정 실패
			msg = "수정을 실패하였습니다.";
			url = "/user/userPwUpdate.do?userNo=" + userNo;
		}
		
		model.addAttribute("msg", msg);
		model.addAttribute("url", url);
		
		return "/alert";
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
		log.info("UserList Start!!");
		
		List<UserDTO> uList=userService.userList();
		model.addAttribute("uList", uList);
		
		log.info("UserList End!!");
		
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
			msg = "수정을 실패하였습니다.";
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
	
	//내가 쓴 글 보기 페이지
	@RequestMapping(value="/user/userWriteList")
	public String userWriteList(HttpServletRequest request, HttpServletResponse response, HttpSession session, Model model) throws Exception {
		List<NoticeDTO> nList = noticeService.userWriteList();
		List<CommDTO> cList = commService.userWriteList();
		
		model.addAttribute("nList", nList);
		model.addAttribute("cList", cList);
		
		return "/user/userWriteList";
	}
	
	//내가 쓴 글 보기
	@RequestMapping(value="/user/userWriteListAjax")
	public @ResponseBody HashMap<String, Object> userWriteListAjax(HttpServletRequest request, Model model) throws Exception {
		log.info("userWriteListAjax Start!!!");
		
		String userNo=CmmUtil.nvl(request.getParameter("userNo"));
		log.info("userNo : " + userNo);
		String commWriter=CmmUtil.nvl(request.getParameter("commWriter"));
		log.info("commWriter : " + commWriter);
		
		HashMap<String, Object> hMap = new HashMap<>();
		
		if(userNo.equals("1")) {
			List<NoticeDTO> nList = noticeService.userWriteList();
			List<CommDTO> cList = commService.userWriteList();
			hMap.put("nList", nList);
			hMap.put("cList", cList);
		} else {
			List<CommDTO> cList = commService.userWriteList();
			hMap.put("cList", cList);
		}
		
		return hMap;
	}
	
}
