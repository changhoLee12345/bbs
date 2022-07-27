package com.yedam.notice.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.DbCommand;
import com.yedam.common.Paging;
import com.yedam.notice.serviceImpl.NoticeServiceImpl;
import com.yedam.notice.vo.NoticeVO;

public class NoticeListPaging implements DbCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String page = request.getParameter("page"); // 페이지번호.
		if (page == null)
			page = "1";
		int pageCnt = Integer.parseInt(page);

		// 전체건수를 위해 실행.
		NoticeServiceImpl service = new NoticeServiceImpl();
		List<NoticeVO> total = service.noticeSelectList(); // 전체카운트

		// 현재 페이지 리스트를 위해 실행.
		service = new NoticeServiceImpl();
		List<NoticeVO> list = service.noticeListPaging(pageCnt);

		Paging paging = new Paging();
		paging.setPageNo(pageCnt);
		paging.setPageSize(10);
		paging.setTotalCount(total.size());

		request.setAttribute("noticeList", list);
		request.setAttribute("paging", paging);

		return "notice/noticeListPaging.tiles";
	}

}
