package co.micol.board.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.board.command.LoginAction;
import co.micol.board.command.LoginForm;
import co.micol.board.command.LogoutAction;
import co.micol.board.command.MainAction;
import co.micol.board.command.MemberForm;
import co.micol.board.command.MemberInsertAction;
import co.micol.board.command.MemberListAction;
import co.micol.board.command.NoticeListAction;
import co.micol.board.common.Action;

@WebServlet("/FrontController")
public class FrontController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private HashMap<String, Action> map = new HashMap<String, Action>();

	public FrontController() {
		super();
	}

	public void init(ServletConfig config) throws ServletException {
		// 요청들을 정의함
		map.put("/main.do", new MainAction()); // 처음 들어오는 페이지 처리 index.jsp
		map.put("/login.do", new LoginAction()); // 로그인 메뉴를 처리하는것
		map.put("/loginForm.do", new LoginForm()); // 로그인 폼 호출
		map.put("/memberList.do", new MemberListAction()); // 회원전체리스트 보기
		map.put("/memberForm.do", new MemberForm()); // 회원가입화면 호출
		map.put("/memberInsert.do", new MemberInsertAction()); // 회원입력
		map.put("/logout.do", new LogoutAction()); // 로그아웃
		map.put("/noticeList.do", new NoticeListAction()); // 게시판 리스트
//		map.put("/loginForm.do", new LoginForm());
//		map.put("/loginForm.do", new LoginForm());

	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 수행할 명령을 정리
		request.setCharacterEncoding("utf-8"); // 한글깨짐 방지를 위해

		String uri = request.getRequestURI();
		System.out.println("uri : " + uri);
		String contextPath = request.getContextPath();
		System.out.println("context: " + contextPath);
		String path = uri.substring(contextPath.length()); // 실제들어 오는 요청 페이지를 찾음
		System.out.println("path: " + path);

		Action command = map.get(path);
		String viewPage = command.exec(request, response); // 명령이 수행되고 나서 보여줄 페이지선택

		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage); // 선택한 페이지로 가기
		dispatcher.forward(request, response);
	}

}
