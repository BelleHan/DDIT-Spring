package com.spring.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.spring.dto.MemberVO;
import com.spring.service.MemberServiceImpl;

public class MemberDAOImpl implements MemberDAO {

	Logger logger = LoggerFactory.getLogger(MemberDAOImpl.class);
	
	private DataSource dataSource;

	{
		logger.info("create MemberDAOImpl bean");
	}
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public MemberVO selectMemberById(String id) throws SQLException {
		MemberVO member = null;

		String sql = "select id,pwd,name from member where id=?";

		Connection conn = dataSource.getConnection();
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, id);

		ResultSet rs = null;
		try {
			 rs = pstmt.executeQuery();

			if (rs.next()) {
				member = new MemberVO();
				member.setId(rs.getString("id"));
				member.setPwd(rs.getString("pwd"));
				member.setName(rs.getString("name"));
			}
		} finally {
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
			if(conn!=null)conn.close();
		}

		return member;
	}

}
