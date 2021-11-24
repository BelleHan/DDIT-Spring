package com.spring.service;

import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.dao.MemberDAO;
import com.spring.dto.MemberVO;


public class MemberServiceImpl implements MemberService {

	Logger logger = LoggerFactory.getLogger(MemberServiceImpl.class);
		
	
	private MemberDAO memberDAO;
	public void setMemberDAO(MemberDAO memberDAO){
		this.memberDAO = memberDAO;
	}
	
	{
		logger.info("create MemberService bean");
	}
	
	@Override
	public MemberVO getMember(String id) throws SQLException {
		MemberVO member = memberDAO.selectMemberById(id);
		return member;
	}

}
