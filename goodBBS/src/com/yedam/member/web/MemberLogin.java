package com.yedam.member.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yedam.common.DbCommand;
import com.yedam.member.serviceImpl.MemberServiceImpl;
import com.yedam.member.vo.MemberVO;

public class MemberLogin implements DbCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// id, pwd 확인 결과를 return
		// 정상적인 회원이면 이름을 화면으로 보여주도록.
		HttpSession session = request.getSession();

		String id = request.getParameter("memberId");
		String pwd = request.getParameter("memberPwd");

		MemberVO vo = new MemberVO();
		vo.setId(id);
		vo.setPwd(pwd);

		MemberServiceImpl service = new MemberServiceImpl();
		MemberVO rvo = service.loginCheck(vo);
		String path = "";
		if (rvo == null) {
			// 회원존재X -> memberLoginFail.jsp
			path = "member/memberLoginFail.tiles";
		} else {
			// 로그인처리 -> memberLoginSuccess.jsp
			session.setAttribute("id", rvo.getId());
			request.setAttribute("vo", rvo);

			path = "member/memberLoginSuccess.tiles";
		}

		return path;
	}

}
