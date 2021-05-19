package co.micol.board.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.micol.board.vo.MemberVO;

public class MemberDao extends DAO {
	private PreparedStatement psmt; // sql 명령문 실행
	private ResultSet rs; // select 후 결과셋 받기
	private MemberVO vo;

	private final String SELECT_ALL = "SELECT * FROM BBS_MEMBER WHERE NVL(AUTHOR, 'user') <> 'admin'";
	private final String SELECT = "SELECT * FROM BBS_MEMBER WHERE ID = ? ";
	private final String INSERT = "INSERT INTO BBS_MEMBER(ID,NAME,PASSWORD,ADDRESS,TEL,ENTERDATE) VALUES(?,?,?,?,?,?)";
	private final String UPDATE = "UPDATE BBS_MEMBER SET NAME = ?, PASSWORD = ?, ADDRESS = ?, TEL = ? WHERE ID = ?";
	private final String DELETE = "DELETE FROM BBS_MEMBER WHERE ID = ?";

	public List<MemberVO> selectAll() { // 멤버리스트 전체를 가져오는 메소드
		List<MemberVO> list = new ArrayList<MemberVO>();
		try {
			psmt = conn.prepareStatement(SELECT_ALL);
			rs = psmt.executeQuery();
			while (rs.next()) {
				vo = new MemberVO();
				vo.setId(rs.getString("id"));
				vo.setName(rs.getString("name"));
				vo.setPassword(rs.getString("password"));
				vo.setAddress(rs.getString("address"));
				vo.setTel(rs.getString("tel"));
				vo.setEnterdate(rs.getDate("enterdate"));
				vo.setAuthor(rs.getString("author"));
				list.add(vo);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();// db 연결을 끊어준다.
		}
		return list;
	}

	public MemberVO select(MemberVO vo) { // 한행을 검색할때
		try {
			psmt = conn.prepareStatement(SELECT);
			psmt.setString(1, vo.getId());
//			psmt.setString(2, vo.getPassword());
			rs = psmt.executeQuery();
			if (rs.next()) {
				vo.setPassword(rs.getString("password"));
				vo.setName(rs.getString("name"));
				vo.setAddress(rs.getString("address"));
				vo.setTel(rs.getString("tel"));
				vo.setEnterdate(rs.getDate("enterdate"));
				vo.setAuthor(rs.getString("author"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return vo;
	}

	public int insert(MemberVO vo) { // 추가하기
		int n = 0;
		try {
			psmt = conn.prepareStatement(INSERT);
			psmt.setString(1, vo.getId());
			psmt.setString(2, vo.getName());
			psmt.setString(3, vo.getPassword());
			psmt.setString(4, vo.getAddress());
			psmt.setString(5, vo.getTel());
			psmt.setDate(6, vo.getEnterdate());
			n = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return n;
	}

	public int update(MemberVO vo) { // 수정하기
		int n = 0;
		try {
			psmt = conn.prepareStatement(UPDATE);
			psmt.setString(1, vo.getName());
			psmt.setString(2, vo.getPassword());
			psmt.setString(3, vo.getAddress());
			psmt.setString(4, vo.getTel());
			psmt.setString(5, vo.getId());
			n = psmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return n;
	}

	public int delete(MemberVO vo) { // 삭제하기
		int n = 0;
		try {
			psmt = conn.prepareStatement(DELETE);
			psmt.setString(1, vo.getId());
			n = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return n;
	}

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
}
