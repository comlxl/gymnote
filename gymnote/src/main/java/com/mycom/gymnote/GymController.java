package com.mycom.gymnote;

import java.util.HashMap;

import javax.annotation.Resource;

import org.junit.runner.Request;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mycom.gymnote.dao.GymService;
import com.mycom.gymnote.dto.FreeBoardDTO;
import com.mycom.gymnote.dto.GymDTO;

@Controller
public class GymController {
	
	@Resource(name="uservice")
	private GymService uservice;
	
	//index 페이지에서 로그인 페이지로 이동
	@RequestMapping("login_page")
	public String log(){	
		return "login";
	}
	
	//회원가입
	@RequestMapping(value="userInsert")
	public String insert(GymDTO gdto){
		uservice.insert(gdto);
		return "login";
	}
	
	
	//로그인
	@RequestMapping(value="userLogin")
	@ResponseBody
	public String uLogin(Model model,String email,String password){
		String pwd=uservice.uLogin(email);
		
		String flag="false";
		
		if(password.equals(pwd)){
			flag="true";
		}
		return flag;
	}
	
	//홈
	@RequestMapping("index")
	public void index(Model model,String email){
		int num=uservice.uLoginnum(email);
		
		model.addAttribute("num",num);
		
	}
	
	//운동차트
	@RequestMapping("chart")
	public void chart(){		
	}
	
	//게시판 이동
	@RequestMapping("board")
	public void board(){		
	}
	
	//코치소개
	@RequestMapping("coach")
	public void coach(){		
	}
	
	//운동일지
	@RequestMapping("record")
	public void record(){		
	}
	
	//게시판 글쓰기이동
	@RequestMapping("boardInsert")
	public void boardInsert(){		
	}
	
	//프로필
	@RequestMapping("profile")
	public void profile(int num,Model model){
		GymDTO userProfile=uservice.uProfile(num);
		model.addAttribute("userProfile", userProfile);
	}
	
	//게시판 글쓰기
	@RequestMapping(value="insert_freeboard", method=RequestMethod.POST)
	public String fbinsert(FreeBoardDTO fdto){
		uservice.fbinsert(fdto);		
		return "board";
	}
}
