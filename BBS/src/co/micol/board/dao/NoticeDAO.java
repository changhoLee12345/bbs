package co.micol.board.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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

	public List<NoticeVO> getNoticeList() {
		List<NoticeVO> list = new ArrayList<>();
		String sql = "select ntc_no, ntc_title, ntc_from_date, ntc_to_date, ntc_content from bbs_notice";

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
