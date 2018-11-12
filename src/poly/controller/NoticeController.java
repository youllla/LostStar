package poly.controller;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import poly.service.INoticeService;

@Controller
public class NoticeController {
	private Logger log = Logger.getLogger(this.getClass());
	
	@Resource(name = "NoticeService")
	private INoticeService noticeService;
	
	
}
