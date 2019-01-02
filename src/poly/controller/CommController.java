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

import com.fasterxml.jackson.annotation.JsonCreator.Mode;

import poly.dto.CommDTO;
import poly.dto.NoticeDTO;
import poly.service.ICommService;
import poly.util.CmmUtil;

@Controller
public class CommController {
	private Logger log = Logger.getLogger(this.getClass());
	
	@Resource(name = "CommService")
	private ICommService commService;
	
	//자유게시판 목록
	@RequestMapping(value="community/commList")
	public String commList(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {
		log.info("commList Start!!!");
		
		List<CommDTO> cList = commService.commList();
		
		model.addAttribute("cList", cList);
		log.info(cList.get(0).getCommNo());
		log.info("commList End!!!");
		return "/community/commList";
	}
	
	//자유게시판 등록 페이지
	@RequestMapping(value="community/commWriteView")
	public String commWriteView() throws Exception {
		return "/community/commWriteView";
	}
	
	//자유게시판 등록
	@RequestMapping(value="community/commWrite")
	public String commWrite(HttpServletRequest request, HttpServletResponse response, HttpSession session, Model model) throws Exception {
		log.info("commWrite Start!!!");
		
		String commNo=CmmUtil.nvl(request.getParameter("commNo"));
		log.info("commNo : " + commNo);
		String commTitle=CmmUtil.nvl(request.getParameter("commTitle"));
		log.info("commTitle : " + commTitle);
		String commContent=CmmUtil.nvl(request.getParameter("commContent"));
		log.info("commContent : " + commContent);
		String commWriter=CmmUtil.nvl(request.getParameter("commWriter"));
		log.info("commWriter : " + commWriter);
		String commRegDate=CmmUtil.nvl(request.getParameter("commRegDate"));
		log.info("commRegDate : " + commRegDate);
		String commRegNo=CmmUtil.nvl(request.getParameter("commRegNo"));
		log.info("commRegNo : " + commRegNo);
		
		CommDTO cDTO = new CommDTO();
		cDTO.setCommNo(commNo);
		cDTO.setCommTitle(commTitle);
		cDTO.setCommContent(commContent);
		cDTO.setCommWriter(commWriter);
		cDTO.setCommRegDate(commRegDate);
		cDTO.setCommRegNo(commRegNo);
		
		int result = commService.insertComm(cDTO);
		
		CommDTO cDTO2 = new CommDTO();
		cDTO2.setCommRegNo(cDTO.getCommRegNo());
		log.info("commNo : " + commNo);
		/*int result2 = commService.updateRegNo(cDTO2);
		log.info("result2 : " + result2);*/
		
		String msg="";
		String url="";
		
		if(result != 0) {
			msg="글이 성공적으로 등록되었습니다.";
			url="/community/commList.do";
		} else {
			msg="글 등록을 실패하였습니다.";
			url="/community/commWriteView.do";
		}
		
		model.addAttribute("msg", msg);
		model.addAttribute("url", url);
		
		log.info("commWrite End!!!");
		return "/alert";
	}
	
	//자유게시판 상세
	@RequestMapping(value="community/commDetail")
	public String commDetail(HttpServletRequest request, HttpServletResponse response, HttpSession session, Model model) throws Exception {
		String commNo=CmmUtil.nvl(request.getParameter("commNo"));
		log.info("commNo : " + commNo);
		
		CommDTO cDTO = commService.commDetail(commNo);
		model.addAttribute("cDTO", cDTO);
		
		return "/community/commDetail";
	}
	
	//자유게시판 수정 페이지
	@RequestMapping(value="community/commUpdateView")
	public String commUpdateView(HttpServletRequest request, HttpServletResponse response, HttpSession session, Model model) throws Exception {
		String commNo=CmmUtil.nvl(request.getParameter("commNo"));
		log.info("commNo : " + commNo);
		
		CommDTO cDTO = commService.commDetail(commNo);
		model.addAttribute("cDTO", cDTO);
		
		return "/community/commUpdateView";
	}
	
	//자유게시판 수정
	@RequestMapping(value="community/commUpdate")
	public String commUpdate(HttpServletRequest request, HttpServletResponse response, HttpSession session, Model model) throws Exception {
		log.info("commUpdate Start!!!!!");
		
		String commNo=CmmUtil.nvl(request.getParameter("commNo"));
		log.info("commNo : " + commNo);
		String commTitle=CmmUtil.nvl(request.getParameter("commTitle"));
		log.info("commTitle : " + commTitle);
		String commContent=CmmUtil.nvl(request.getParameter("commContent"));
		log.info("commContent : " + commContent);
		
		CommDTO cDTO = new CommDTO();
		cDTO.setCommNo(commNo);
		cDTO.setCommTitle(commTitle);
		cDTO.setCommContent(commContent);
		
		int result = commService.commUpdate(cDTO);
		
		String msg="";
		String url="";
		
		if(result != 0) {
			//수정 성공
			msg = "수정이 완료되었습니다.";
			url = "/community/commDetail.do?commNo=" + commNo;
		} else {
			//수정 실패
			msg = "수정을 실패하였습니다.";
			url = "/community/commUpdateView.do?commNo=" + commNo;
		}
		
		model.addAttribute("msg", msg);
		model.addAttribute("url", url);
		
		log.info("commUpdate End!!!!!");
		
		return "/alert";
	}
	
	@RequestMapping(value="community/commDelete")
	public String commDelete(HttpServletRequest request, HttpServletResponse response, HttpSession session, Model model) throws Exception {
		log.info("commDelete Start!!!!");
		
		String commNo=CmmUtil.nvl(request.getParameter("commNo"));
		log.info("commNo : " + commNo);
		
		int result = commService.commDelete(commNo);
		
		String msg="";
		String url="";
		
		if(result != 0) {
			//삭제 성공
			msg = "게시글이 성공적으로 삭제되었습니다.";
			url = "/community/commList.do";
		} else {
			//삭제 실패
			msg = "삭제를 실패하였습니다.";
			url = "/community/commDetail.do?commNo=" + commNo;
		}
		
		model.addAttribute("msg", msg);
		model.addAttribute("url", url);
		
		log.info("commDelete End!!!!");
		
		return "/alert";
	}

}
