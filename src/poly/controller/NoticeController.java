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
	
	//데이터테이블
	@RequestMapping(value="/index")
	public String index() throws Exception {
		return "/index.do";
	}
	
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
	
	//공지사항 상세
	@RequestMapping(value="notice/noticeDetail")
	public String noticeDetail(HttpServletRequest request, HttpServletResponse response, HttpSession session, Model model) throws Exception {
		String ntNo=CmmUtil.nvl(request.getParameter("ntNo"));
		log.info("ntNo : " + ntNo);
		
		NoticeDTO nDTO = noticeService.noticeDetail(ntNo);
		model.addAttribute("nDTO", nDTO);
		
		return "/notice/noticeDetail";
	}
	
	//공지사항 수정 페이지
	@RequestMapping(value="notice/noticeUpdateView")
	public String noticeUpdateView(HttpServletRequest request, HttpServletResponse response, HttpSession session, Model model) throws Exception {
		String ntNo=CmmUtil.nvl(request.getParameter("ntNo"));
		log.info("ntNo : " + ntNo);
		
		NoticeDTO nDTO = noticeService.noticeDetail(ntNo);
		model.addAttribute("nDTO",nDTO);
	
		return "/notice/noticeUpdateView";
	}
	
	//공지사항 수정
	@RequestMapping(value="notice/noticeUpdate")
	public String noticeUpdate(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {
		log.info("noticeUpdate Start!!!");
		
		String ntNo=CmmUtil.nvl(request.getParameter("ntNo"));
		log.info("ntNo : " + ntNo);
		String ntTitle=CmmUtil.nvl(request.getParameter("ntTitle"));
		log.info("ntTitle : " + ntTitle);
		String ntContent=CmmUtil.nvl(request.getParameter("ntContent"));
		log.info("ntContent : " + ntContent);
		
		NoticeDTO nDTO = new NoticeDTO();
		nDTO.setNtNo(ntNo);
		nDTO.setNtTitle(ntTitle);
		nDTO.setNtContent(ntContent);
		
		int result = noticeService.noticeUpdate(nDTO);
		
		String msg="";
		String url="";
		
		if(result != 0) {
			//수정 성공
			msg = "수정이 완료되었습니다.";
			url = "/notice/noticeDetail.do?ntNo=" + ntNo;
		} else {
			//수정 실패
			msg = "수정을 실패하였습니다.";
			url = "/notice/noticeUpdateView.do?ntNo=" + ntNo;
		}
		
		model.addAttribute("msg", msg);
		model.addAttribute("url", url);
		
		log.info("noticeUpdate End!!!");
		
		return "/alert";
	}
	
	//공지사항 삭제
	@RequestMapping(value="notice/noticeDelete")
	public String noticeDelete(HttpServletRequest request, HttpServletResponse response, HttpSession session, Model model) throws Exception {
		log.info("noticeDelete Start!!!");
		
		String ntNo=CmmUtil.nvl(request.getParameter("ntNo"));
		log.info("ntNo : " + ntNo);
		
		int result = noticeService.noticeDelete(ntNo);
		
		String msg="";
		String url="";
		
		if(result != 0) {
			//삭제 성공
			msg = "공지사항이 삭제되었습니다.";
			url = "/notice/noticeList.do";
		} else {
			//삭제 실패
			msg = "삭제를 실패하였습니다.";
			url = "/notice/noticeDetail.do?ntNo=" + ntNo;
		}
		
		model.addAttribute("msg", msg);
		model.addAttribute("url", url);
		
		log.info("noticeDelete End!!!");
		
		return "/alert";
	}
}
