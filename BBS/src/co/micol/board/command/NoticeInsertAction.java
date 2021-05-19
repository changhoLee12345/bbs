package co.micol.board.command;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.board.common.Action;
import co.micol.board.dao.NoticeDAO;
import co.micol.board.vo.NoticeVO;

public class NoticeInsertAction implements Action {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {

		System.out.println(request.getMethod());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		String title = request.getParameter("ntcTitle");
		String fromDate = request.getParameter("ntcFromDate");
		String toDate = request.getParameter("ntcToDate");
		String content = request.getParameter("ntcContent");

		NoticeDAO dao = new NoticeDAO();
		NoticeVO notice = new NoticeVO();
		notice.setNtcTitle(title);
		notice.setNtcContent(content);
		try {
			notice.setNtcFromDate(sdf.parse(fromDate));
			notice.setNtcToDate(sdf.parse(toDate));

		} catch (ParseException e) {
			e.printStackTrace();
		}

		dao.insertNotice(notice);

		return "noticeList.do";
//		return "jsp/notice/noticeList.jsp";
	}

}
