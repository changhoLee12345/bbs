package com.yedam.notice.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.DbCommand;
import com.yedam.notice.service.NoticeService;
import com.yedam.notice.serviceImpl.NoticeServiceImpl;
import com.yedam.notice.vo.NoticeVO;

public class NoticeUpdate implements DbCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// 파라미터 (id, title, content)
		// serviceImpl -> update기능작성.
		// 공지사항 리스트로 페이지 호출.

//		NoticeList commad = new NoticeList();
//		commad.execute(request, response);

//		NoticeService service = new NoticeServiceImpl();
//		List<NoticeVO> list = service.noticeSelectList();
//
//		request.setAttribute("noticeList", list);

		return "/noticeList.do";
	}

}
