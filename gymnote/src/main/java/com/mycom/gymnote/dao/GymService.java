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
	
	//ȸ������
	public void insert(GymDTO gdto){
		dao.uinsert("uinsert",gdto);
	}
	
	//�α���
	public String uLogin(String email){
		return dao.uLogin("uLogin",email);
	}
	
	//�α��� �ѹ��� ������
	public int uLoginnum(String email){
		return dao.uLoginnum("uLoginnum",email);
	}
	
	//�Խ��� �۽���
	public void fbinsert(FreeBoardDTO fdto){
		dao.fbinsert("fbinsert",fdto);
	}
}
