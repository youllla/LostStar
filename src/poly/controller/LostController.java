package poly.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import poly.util.CmmUtil;
import poly.util.HttpUtil;
import poly.util.StringUtil;

@Controller
public class LostController {
	private Logger log = Logger.getLogger(this.getClass());
	
	// 분실물 검색 창
	@RequestMapping(value="lost/lostItemSearch")
	public String lostItemSearch(HttpServletRequest request, Model model) throws Exception{
		return "/lost/lostItemSearch";
	}
	
	// 분실물 검색 ajax
	@RequestMapping(value="lost/lostItemFind")
	public @ResponseBody List<Object> lostItemFind(HttpServletRequest request, HttpSession session, Model model) throws Exception {
		log.info("lostItemSearch Start!!!");
		
		String key = "7244534e51756c6134366370414b47";
		String startNum = "1";
		String endNum = "10";
		String itemCategory = CmmUtil.nvl(request.getParameter("itemCategory"));
		log.info(this.getClass() + "itemCategory : " + itemCategory);
		String itemCode = CmmUtil.nvl(request.getParameter("itemCode"));
		log.info(this.getClass() + "itemCode : " + itemCode);
		String lostId = CmmUtil.nvl(request.getParameter("id"));
		log.info(this.getClass() + "lostId : " + lostId);
		
		String urlstr = "http://openapi.seoul.go.kr:8088/"+ key + "/json/SearchLostArticleService/" +
						startNum + "/" + endNum + "/" + itemCategory +"/" + itemCode+"/"+lostId;
		log.info(this.getClass() + "urlstr : " + urlstr);
		
		List<Object> lList=new ArrayList<>();
		HashMap<String, Object> hashmapRes = new HashMap<String, Object>();
		
		try {
			String charset = "UTF-8";
			HashMap<String, String> hashmapResponse = (HashMap<String, String>)HttpUtil.callURLGet(urlstr, charset);
			
			if("200".equals(hashmapResponse.get("httpStatus"))) {
				String responseBody = String.valueOf(hashmapResponse.get("responseBody"));
				hashmapRes = StringUtil.JsonStringToObject(responseBody);
				String bodyJSON = StringUtil.ObjectToJsonString(hashmapRes.get("SearchLostArticleService"));
				JSONParser parser = new JSONParser();
				Object obj = parser.parse(bodyJSON);
				JSONObject jsonObj = (JSONObject) obj;
				JSONArray bodyJSONArray = (JSONArray) jsonObj.get("row");
				
				for(int i=0; i<bodyJSONArray.size(); i++) {
					lList.add(bodyJSONArray.get(i));
				}
			} else {
				hashmapRes.put("REP_CODE", "9999");
				hashmapRes.put("REP_MSG", "오류가 발생했습니다.");
			}
		} catch(Exception e) {
			hashmapRes.put("REP_CODE", "9999");
			hashmapRes.put("REP_MSG", "오류가 발생했습니다.");
		}
		
		session.setAttribute("lostId", lostId);
		model.addAttribute("lostId", lostId);
		log.info(this.getClass() + "lostId : " + lostId);
		
		log.info("lostItemSearch End!!!");
		
		return lList;
	}
	
	// 분실물 상세 페이지
	@RequestMapping(value="lost/lostItemDetail")
	public String lostItemDetail(HttpServletRequest request, HttpServletResponse response, HttpSession session, Model model) throws Exception{
		String lostId = CmmUtil.nvl(request.getParameter("id"));
		log.info("lostId : " + lostId);
		
		model.addAttribute("lostId", lostId);
		
		return "/lost/lostItemDetail";
	}
	
	// 분실물 상세 Ajax
	@RequestMapping(value="/lost/lostItemInfo")
	public @ResponseBody List<Object> lostItemInfo(HttpServletRequest request, HttpSession session, Model model) throws Exception {
		log.info("lostItemInfo start!!!");
		
		String key = "7244534e51756c6134366370414b47";
		String startNum = "1";
		String endNum = "10";
		String lostId = CmmUtil.nvl(request.getParameter("id"));
		log.info(this.getClass() + "lostId : " + lostId);
		String urlstr = "http://openapi.seoul.go.kr:8088/"+ key + "/json/SearchLostArticleInfoService/" +
				startNum + "/" + endNum + "/" + lostId;
		log.info(this.getClass() + "urlstr : " + urlstr);
		
		List<Object> dList=new ArrayList<>();

		HashMap<String, Object> hashmapRes = new HashMap<String, Object>();
		
		try {
			String charset = "UTF-8";
			HashMap<String, String> hashmapResponse = (HashMap<String, String>)HttpUtil.callURLGet(urlstr, charset);
			
			if("200".equals(hashmapResponse.get("httpStatus"))) {
				String responseBody = String.valueOf(hashmapResponse.get("responseBody"));
				hashmapRes = StringUtil.JsonStringToObject(responseBody);
				String bodyJSON = StringUtil.ObjectToJsonString(hashmapRes.get("SearchLostArticleInfoService"));
				JSONParser parser = new JSONParser();
				Object obj = parser.parse(bodyJSON);
				JSONObject jsonObj = (JSONObject) obj;
				JSONArray bodyJSONArray = (JSONArray) jsonObj.get("row");
				
				for(int i=0; i<bodyJSONArray.size(); i++) {
					dList.add(bodyJSONArray.get(i));
				}
			} else {
				hashmapRes.put("REP_CODE", "9999");
				hashmapRes.put("REP_MSG", "오류가 발생했습니다.");
			}
		} catch(Exception e) {
			hashmapRes.put("REP_CODE", "9999");
			hashmapRes.put("REP_MSG", "오류가 발생했습니다.");
		}
		
		session.setAttribute("lostId", lostId);
		model.addAttribute("lostId", lostId);
		log.info(this.getClass() + "lostId : " + lostId);
		
		log.info("lostItemSearch End!!!");
		
		return dList;
	}
	
	//분실물 이미지
	@RequestMapping(value="/lost/lostItemImage")
	public @ResponseBody List<Object> lostItemImage(HttpServletRequest request, HttpSession session, Model model) throws Exception {
		log.info("lostItemImage start!!!");
		
		String key = "7244534e51756c6134366370414b47";
		String startNum = "1";
		String endNum = "10";
		String lostId = CmmUtil.nvl(request.getParameter("id"));
		log.info("lostId : " + lostId);
		String urlstr = "http://openapi.seoul.go.kr:8088/"+ key + "/json/SearchLostArticleImageService/" +
				startNum + "/" + endNum + "/" + lostId;
		log.info("urlstr : " + urlstr);
		
		List<Object> iList=new ArrayList<>();
		HashMap<String, Object> hashmapRes = new HashMap<String, Object>();
		
		try {
			String charset = "UTF-8";
			HashMap<String, String> hashmapResponse = (HashMap<String, String>)HttpUtil.callURLGet(urlstr, charset);
			
			if("200".equals(hashmapResponse.get("httpStatus"))) {
				String responseBody = String.valueOf(hashmapResponse.get("responseBody"));
				hashmapRes = StringUtil.JsonStringToObject(responseBody);
				String bodyJSON = StringUtil.ObjectToJsonString(hashmapRes.get("SearchLostArticleImageService"));
				JSONParser parser = new JSONParser();
				Object obj = parser.parse(bodyJSON);
				JSONObject jsonObj = (JSONObject) obj;
				JSONArray bodyJSONArray = (JSONArray) jsonObj.get("row");
				
				for(int i=0; i<bodyJSONArray.size(); i++) {
					iList.add(bodyJSONArray.get(i));
				}
			} else {
				hashmapRes.put("REP_CODE", "9999");
				hashmapRes.put("REP_MSG", "오류가 발생했습니다.");
			}
		} catch(Exception e) {
			hashmapRes.put("REP_CODE", "9999");
			hashmapRes.put("REP_MSG", "오류가 발생했습니다.");
		}
		
		session.setAttribute("lostId", lostId);
		model.addAttribute("lostId", lostId);
		log.info(this.getClass() + "lostId : " + lostId);
		
		log.info("lostItemImage end!!!");
		
		return iList;
	}
	
}
