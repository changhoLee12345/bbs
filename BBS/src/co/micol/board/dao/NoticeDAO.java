package co.micol.board.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import co.micol.board.vo.NoticeVO;

public class NoticeDAO extends DAO {
	PreparedStatement psmt;
	ResultSet rs;

	private void close() {
		try {
			if (rs != null)
				rs.close();
			if (psmt != null)
				psmt.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public NoticeVO getNotice(String id) {
		String sql = "select * from bbs_notice where ntc_no = ?";
		NoticeVO notice = new NoticeVO();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);

			rs = psmt.executeQuery();
			if (rs.next()) {
				notice.setNtcContent(rs.getString("ntc_content"));
				notice.setNtcFromDate(rs.getDate("ntc_from_date"));
				notice.setNtcNo(rs.getInt("ntc_no"));
				notice.setNtcRegDate(rs.getDate("ntc_reg_date"));
				notice.setNtcTitle(rs.getString("ntc_title"));
				notice.setNtcToDate(rs.getDate("ntc_to_date"));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}

		return notice;
	}

	public void insertNotice(NoticeVO notice) {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		String sql = "INSERT INTO bbs_notice (ntc_no, ntc_title, ntc_from_date, ntc_to_date, ntc_reg_date, ntc_content)\n"
				+ "values((SELECT nvl(max(ntc_no),0)+1 FROM bbs_notice), ?,?,?, sysdate, ?)\n";
		try {
			psmt = conn.prepareStatement(sql);
			String fromDate = sdf.format(notice.getNtcFromDate());
			String toDate = sdf.format(notice.getNtcToDate());
			System.out.println(fromDate);
			psmt.setString(1, notice.getNtcTitle());
			psmt.setString(2, fromDate);
			psmt.setString(3, toDate);
			psmt.setString(4, notice.getNtcContent());
			int r = psmt.executeUpdate();
			System.out.println(r + "건 입력.");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
	}

	public List<NoticeVO> getNoticeList() {
		List<NoticeVO> list = new ArrayList<>();
		String sql = "select ntc_no, ntc_title, ntc_from_date, ntc_to_date, ntc_reg_date, ntc_content from bbs_notice";

		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) {
				NoticeVO notice = new NoticeVO();
				notice.setNtcNo(rs.getInt("ntc_no"));
				notice.setNtcTitle(rs.getString("ntc_title"));
				notice.setNtcFromDate(rs.getDate("ntc_from_date"));
				notice.setNtcToDate(rs.getDate("ntc_to_date"));
				notice.setNtcRegDate(rs.getDate("ntc_reg_date"));
				notice.setNtcContent(rs.getString("ntc_content"));

				list.add(notice);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return list;
	}
}
