package kr.or.ddit.security;

import java.sql.SQLException;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;

import kr.or.ddit.dao.MemberDAO;
import kr.or.ddit.dto.MemberVO;

public class CustomAuthenticationProvider implements AuthenticationProvider {

	private MemberDAO memberDAO;
	public void setMemberDAO(MemberDAO memberDAO) {
		this.memberDAO = memberDAO;
	}
	
	@Override
	public Authentication authenticate(Authentication auth) throws AuthenticationException {
		String login_id = (String) auth.getPrincipal(); // 로그인 시도한 ID를 가져온다
 		String login_pwd = (String) auth.getCredentials(); //로그인 시도한 Password 를 가져온다.
 		
 		MemberVO member = null;
 		try {
			 member = memberDAO.selectMemberById(login_id);			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new AuthenticationServiceException("Internal server error!");
		}
 		
 		if(member != null) {
 			if(login_pwd.equals(member.getPwd())) {
 				UserDetails authUser = new User(member);
 				boolean invalidCheck = authUser.isAccountNonExpired()
 						  	   && authUser.isAccountNonLocked()
 						  	   && authUser.isCredentialsNonExpired()
 						  	   && authUser.isEnabled();
 				if(invalidCheck) {
					// 스프링 시큐리티 내부 클래스로 인증 토큰 생성한다.
					UsernamePasswordAuthenticationToken result =
							new UsernamePasswordAuthenticationToken(authUser.getUsername(),
																 	authUser.getPassword(),
																	authUser.getAuthorities());
			 		// 전달할 내용을 설정한 후 
			         result.setDetails(authUser);
			         // 리턴한다. successHandler로 전송된다.   
			         return result;
 				}else {
 					throw new BadCredentialsException("로그인이 거부되었습니다."); 					
 				}
 				
 			}else {
 				throw new BadCredentialsException("패스워드가 일치하지 않습니다.");
 			}
 		}else {
 			throw new BadCredentialsException("존재하지 않는 아이디입니다.");
 		}
 		
 		
		
	}

	@Override
	public boolean supports(Class<?> auth) {
		return auth.equals(UsernamePasswordAuthenticationToken.class);
	}

}
