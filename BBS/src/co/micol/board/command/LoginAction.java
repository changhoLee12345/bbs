package co.micol.board.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.micol.board.common.Action;
import co.micol.board.dao.MemberDao;
import co.micol.board.vo.MemberVO;

public class LoginAction implements Action {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// TODO 로그인 인증과정을 처리한다.
		MemberDao dao = new MemberDao();
		MemberVO vo = new MemberVO();
		HttpSession session = request.getSession(false);
		String msq;
		vo.setId(request.getParameter("id"));
//		vo.setPassword(request.getParameter("password"));
		
		vo = dao.select(vo);  //MemberDao 를 실행시킨다.
		
		if(vo.getPassword().equals(request.getParameter("password"))) {;
			session.setAttribute("id", vo.getId());  //session에 id 담음
			session.setAttribute("author", vo.getAuthor());  //session 권한담음
			session.setAttribute("name", vo.getName());
			msq = "정상적인 로그인";
			request.setAttribute("msg", msq);
			request.setAttribute("vo", vo);	//멤버를 싫어 보냄
		}
		else {
			msq = "패스워드가 틀렸다.";
			request.setAttribute("msg", msq);
		}
		
		return "jsp/main/loginResult.jsp";
	}

}
