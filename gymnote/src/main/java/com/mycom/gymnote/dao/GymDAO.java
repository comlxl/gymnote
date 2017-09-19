package com.mycom.gymnote.dao;

import java.util.HashMap;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mycom.gymnote.dto.FreeBoardDTO;
import com.mycom.gymnote.dto.GymDTO;

@Repository("dao")
public class GymDAO {
	
	@Autowired 
	private SqlSessionFactory sqlMapper;
	
	//회원가입
	public void uinsert(String sqlid, GymDTO gdto){
		SqlSession session=sqlMapper.openSession(ExecutorType.REUSE);
		session.insert(sqlid, gdto);
	}
	
	public void fbinsert(String sqlid, FreeBoardDTO fdto){
		SqlSession session=sqlMapper.openSession(ExecutorType.REUSE);
		session.insert(sqlid, fdto);
	}
	
	//로그인
	public String uLogin(String sqlid,String email){
		SqlSession session=sqlMapper.openSession(ExecutorType.REUSE);
		return session.selectOne(sqlid, email);
	}
	
	//로그인 너버값들고오기
	public int uLoginnum(String sqlid,String email){
		SqlSession session=sqlMapper.openSession(ExecutorType.REUSE);
		return session.selectOne(sqlid, email);
	}
	
	//유저 프로필정보 뿌리기
	public GymDTO uProfile(String sqlid,int num){
		SqlSession session=sqlMapper.openSession(ExecutorType.REUSE);		
		return session.selectOne(sqlid, num);
	}
}
