package com.yedam.bulletin.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.bulletin.service.BulletinService;
import com.yedam.bulletin.serviceImpl.BulletinServiceImpl;
import com.yedam.bulletin.vo.BulletinVO;

@WebServlet("/ajaxBulletinUpdate")
public class AjaxBulletinUpdate extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		String content = request.getParameter("content");
		String title = request.getParameter("title");
		System.out.println("content: \n" + content);

		BulletinVO vo = new BulletinVO();
		vo.setId(Integer.parseInt(id));
		vo.setTitle(title);
		vo.setContent(content);

		BulletinService service = new BulletinServiceImpl();
		int rcnt = service.updateBulletin(vo);

		response.getWriter().print(rcnt);
	}
}
