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
	
	//회원가입
	public void insert(GymDTO gdto){
		dao.uinsert("uinsert",gdto);
	}
	
	//로그인
	public String uLogin(String email){
		return dao.uLogin("uLogin",email);
	}
	
	//로그인 넘버값 들고오기
	public int uLoginnum(String email){
		return dao.uLoginnum("uLoginnum",email);
	}
	
	//게시판 글스기
	public void fbinsert(FreeBoardDTO fdto){
		dao.fbinsert("fbinsert",fdto);
	}
}
