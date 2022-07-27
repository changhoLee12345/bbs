package com.yedam.bulletin.serviceImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yedam.bulletin.service.BulletinService;
import com.yedam.bulletin.vo.BulletinVO;
import com.yedam.common.DAO;


public class BulletinServiceImpl extends DAO implements BulletinService {

	PreparedStatement psmt;
	ResultSet rs;
	String sql;

	// 전체조회
	@Override
	public List<BulletinVO> bulletinSelectList() {
		List<BulletinVO> list = new ArrayList<>();

		sql = "select * from bulletin order by 1";
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) {
				BulletinVO vo = new BulletinVO();
				vo.setContent(rs.getString("content"));
				vo.setHit(rs.getInt("hit"));
				vo.setId(rs.getInt("id"));
				vo.setRegDate(rs.getDate("reg_date"));
				vo.setTitle(rs.getString("title"));
				vo.setWriter(rs.getString("writer"));
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return list;
	} // 전체조회 끝부분.

	@Override
	public BulletinVO bulletinSelect(BulletinVO vo) {
		sql = "select * from bulletin where id=?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, vo.getId());

			rs = psmt.executeQuery();
			if (rs.next()) {
				vo.setContent(rs.getString("content"));
				vo.setHit(rs.getInt("hit"));
				vo.setRegDate(rs.getDate("reg_date"));
				vo.setTitle(rs.getString("title"));
				vo.setWriter(rs.getString("writer"));

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return vo;
	}

	@Override
	public int insertBulletin(BulletinVO vo) {
		// 입력기능 구현하세요...
		sql = "insert into bulletin values(bulletin_seq.nextval,?,?,?,sysdate,0)";
		int r = 0;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getTitle());
			psmt.setString(2, vo.getContent());
			psmt.setString(3, vo.getWriter());
			r = psmt.executeUpdate();
			System.out.println(r + "건 입력.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return r;
	}

	@Override
	public int updateBulletin(BulletinVO vo) {
		sql = "update bulletin set content=? , title=? where id=?";
		int r = 0;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getContent());
			psmt.setString(2, vo.getTitle());
			psmt.setInt(3, vo.getId());
			r = psmt.executeUpdate();
			System.out.println("수정: " + r);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return r;
	}

	@Override
	public int deleteBulletin(BulletinVO vo) {
		return 0;
	}

	private void close() {
		if (rs != null)
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		if (psmt != null)
			try {
				psmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		if (conn != null)
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
}
