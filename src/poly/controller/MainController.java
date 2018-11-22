package poly.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import poly.dto.NoticeDTO;
import poly.service.INoticeService;
import poly.util.CmmUtil;

/*
 * Controller 선언해야만 Spring 프레임워크에서 Controller인지 인식 가능
 * 자바 서블릿 역할 수행
 * */
@Controller
public class MainController {
	private Logger log = Logger.getLogger(this.getClass());
	
	
	//메인화면
	@RequestMapping(value="main")
	public String main(HttpServletRequest request, HttpServletResponse response, Model model, HttpSession session) throws Exception{
		
		log.info("main");
		return "/main";
	}
	
	@RequestMapping(value="portfolio")
	public String portfolio(HttpServletRequest request, HttpServletResponse response, Model model, HttpSession session) throws Exception {
		log.info("portfolio");
		return "/portfolio";
	}
	
	@RequestMapping(value="blog_home")
	public String bloghome(HttpServletRequest request, HttpServletResponse response, Model model, HttpSession session) throws Exception {
		log.info("blog_home");
		return "/blog_home";
	}
	
	@RequestMapping(value="blog_single")
	public String blogsingle(HttpServletRequest request, HttpServletResponse response, Model model, HttpSession session) throws Exception {
		log.info("blog_single");
		return "/blog_single";
	}
	
	@RequestMapping(value="contact")
	public String contact(HttpServletRequest request, HttpServletResponse response, Model model, HttpSession session) throws Exception {
		log.info("contact");
		return "/contact";
	}
	
	@RequestMapping(value="portfolio_detail")
	public String portfolio_detail(HttpServletRequest request, HttpServletResponse response, Model model, HttpSession session) throws Exception {
		log.info("portfolio_detail");
		return "/portfolio_detail";
	}
	
	@RequestMapping(value="elements")
	public String elements(HttpServletRequest request, HttpServletResponse response, Model model, HttpSession session) throws Exception {
		log.info("elements");
		return "/elements";
	}
	
}
