package co.micol.board.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.board.common.Action;
import co.micol.board.dao.MemberDao;
import co.micol.board.vo.MemberVO;

public class MemberListJsonAction implements Action {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		MemberDao dao = new MemberDao();
		List<MemberVO> list = dao.selectAll();
		int rowCnt = 0;

		String json = "[";
		for (MemberVO vo : list) {
			json += "{" + //
					"\"id\":\"" + vo.getId() + "\"" + //
					",\"name\":\"" + vo.getName() + "\"" + //
					",\"author\":\"" + vo.getAuthor() + "\"" + //
					",\"tel\":\"" + vo.getTel() + "\"" + //
					"}";
			if (++rowCnt != list.size()) {
				json += ",";
			}
		}
		json += "]";

		return json;
	}

}
