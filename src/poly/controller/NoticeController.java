package poly.controller;

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

import poly.dto.NoticeDTO;
import poly.service.INoticeService;
import poly.util.CmmUtil;

@Controller
public class NoticeController {
	private Logger log = Logger.getLogger(this.getClass());
	
	@Resource(name = "NoticeService")
	private INoticeService noticeService;
	
	
	//공지사항 목록
	@RequestMapping(value="notice/noticeList")
	public String noticeList(HttpServletRequest request, HttpServletResponse response, Model model, HttpSession session) throws Exception {
		log.info("NoticeList Start!!");
		
		List<NoticeDTO> nList = noticeService.noticeList();
		
		model.addAttribute("nList", nList);
		
		log.info("NoticeList End!!");
		return "/notice/noticeList";
	}
	
	//공지사항 등록 페이지
	@RequestMapping(value="notice/noticeWriteView")
	public String noticeWriteView() throws Exception {
		return "/notice/noticeWriteView";
	}
	
	//공지사항 등록
	@RequestMapping(value="notice/noticeWrite")
	public String noticeWrite(HttpServletRequest request, HttpServletResponse response, HttpSession session, Model model) throws Exception {
		log.info("noticeWrite Start!!");
		
		String ntNo=CmmUtil.nvl(request.getParameter("ntNo"));
		log.info("ntNo : " + ntNo);
		String ntTitle=CmmUtil.nvl(request.getParameter("ntTitle"));
		log.info("ntTitle : " + ntTitle);
		String ntContent=CmmUtil.nvl(request.getParameter("ntContent"));
		log.info("ntContent : " + ntContent);
		String ntWriter=CmmUtil.nvl(request.getParameter("ntWriter"));
		log.info("ntWriter : " + ntWriter);
		String ntRegdate=CmmUtil.nvl(request.getParameter("ntRegdate"));
		log.info("ntRegdate : " + ntRegdate);
		String ntRegNo=CmmUtil.nvl(request.getParameter("ntRegNo"));
		log.info("ntRegNo : " + ntRegNo);
		
		NoticeDTO nDTO = new NoticeDTO();
		nDTO.setNtNo(ntNo);
		nDTO.setNtTitle(ntTitle);
		nDTO.setNtContent(ntContent);
		nDTO.setNtWriter(ntWriter);
		nDTO.setNtRegDate(ntRegdate);
		nDTO.setNtRegNo(ntRegNo);
		
		int result = noticeService.insertNotice(nDTO);
		
		NoticeDTO nDTO2 = new NoticeDTO();
		nDTO2.setNtRegNo(nDTO.getNtRegNo());
		log.info("ntNo : " + ntNo);
		int result2 = noticeService.updateRegNo(nDTO2);
		log.info("result2 : " + result2);
		
		String msg="";
		String url="";
		
		if(result != 0) {
			msg="글이 성공적으로 등록되었습니다.";
			url="/notice/noticeList.do";
		} else {
			msg="글 등록을 실패하였습니다.";
			url="/notice/noticeWriteView.do";
		}
		
		model.addAttribute("msg", msg);
		model.addAttribute("url", url);
		
		log.info("noticeWrite End!!");
		
		return "/alert";
	}
	
	@RequestMapping(value="notice/noticeDetail")
	public String noticeDetail(HttpServletRequest request, HttpServletResponse response, HttpSession session, Model model) throws Exception {
		String ntNo=CmmUtil.nvl(request.getParameter("ntNo"));
		log.info("ntNo : " + ntNo);
		
		NoticeDTO nDTO = new NoticeDTO();
		nDTO.setNtNo(ntNo);
		
		return "/notice/noticeDetail";
	}
}
