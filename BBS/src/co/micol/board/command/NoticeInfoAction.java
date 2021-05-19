package co.micol.board.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.board.common.Action;
import co.micol.board.dao.NoticeDAO;
import co.micol.board.vo.NoticeVO;

public class NoticeInfoAction implements Action {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {

		String id = request.getParameter("id");

		NoticeDAO dao = new NoticeDAO();
		NoticeVO notice = dao.getNotice(id);

		request.setAttribute("notice", notice);

		return "jsp/notice/noticeInfo.jsp";
	}

}
