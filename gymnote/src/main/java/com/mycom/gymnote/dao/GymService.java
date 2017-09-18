package com.mycom.gymnote.dao;

import java.util.HashMap;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.mycom.gymnote.dto.FreeBoardDTO;
import com.mycom.gymnote.dto.GymDTO;

@Service("uservice")
public class GymService {
	@Resource(name="dao")
	private GymDAO dao;
	
	public void insert(GymDTO gdto){
		dao.uinsert("uinsert",gdto);
	}
	
	//·Î±×ÀÎ
	public String uLogin(String email){
		return dao.uLogin("uLogin",email);
	}
	
	public void fbinsert(FreeBoardDTO fdto){
		dao.fbinsert("fbinsert",fdto);
	}
}
