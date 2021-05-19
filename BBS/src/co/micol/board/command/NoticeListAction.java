package co.micol.board.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.board.common.Action;
import co.micol.board.dao.NoticeDAO;
import co.micol.board.vo.NoticeVO;

public class NoticeListAction implements Action {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// 공지사항 리스트 조회 후 notice/noticeList.jsp 파일 이동.
		NoticeDAO dao = new NoticeDAO();
		List<NoticeVO> list = dao.getNoticeList();
		request.setAttribute("list", list);

		return "jsp/notice/noticeList.jsp";
	}

}
