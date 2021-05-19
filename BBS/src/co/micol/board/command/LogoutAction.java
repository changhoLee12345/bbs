package co.micol.board.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.micol.board.common.Action;

public class LogoutAction implements Action {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// TODO 로그아웃 과정을 처리 한다.
		HttpSession session = request.getSession();
		String name = (String) session.getAttribute("name");
		session.invalidate();
		request.setAttribute("name", name);
		return "jsp/main/logout.jsp";
	}

}
