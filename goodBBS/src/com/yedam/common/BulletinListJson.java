package com.yedam.common;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yedam.bulletin.service.BulletinService;
import com.yedam.bulletin.serviceImpl.BulletinServiceImpl;
import com.yedam.bulletin.vo.BulletinVO;

public class BulletinListJson implements DbCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		BulletinService service = new BulletinServiceImpl();
		List<BulletinVO> list = service.bulletinSelectList();
		Gson gson = new GsonBuilder().create();
		return gson.toJson(list);
	}

}
