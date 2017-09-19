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
	
	//index ���������� �α��� �������� �̵�
	@RequestMapping("login_page")
	public String log(){	
		return "login";
	}
	
	//ȸ������
	@RequestMapping(value="userInsert")
	public String insert(GymDTO gdto){
		uservice.insert(gdto);
		return "login";
	}
	
	
	//�α���
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
	
	//Ȩ
	@RequestMapping("index")
	public void index(Model model,String email){
		int num=uservice.uLoginnum(email);
		
		model.addAttribute("num",num);
		
	}
	
	//���Ʈ
	@RequestMapping("chart")
	public void chart(){		
	}
	
	//�Խ��� �̵�
	@RequestMapping("board")
	public void board(){		
	}
	
	//��ġ�Ұ�
	@RequestMapping("coach")
	public void coach(){		
	}
	
	//�����
	@RequestMapping("record")
	public void record(){		
	}
	
	//�Խ��� �۾����̵�
	@RequestMapping("boardInsert")
	public void boardInsert(){		
	}
	
	//������
	@RequestMapping("profile")
	public void profile(int num,Model model){
		GymDTO userProfile=uservice.uProfile(num);
		model.addAttribute("userProfile", userProfile);
	}
	
	//�Խ��� �۾���
	@RequestMapping(value="insert_freeboard", method=RequestMethod.POST)
	public String fbinsert(FreeBoardDTO fdto){
		uservice.fbinsert(fdto);		
		return "board";
	}
}
