package model.controller;

import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gdu.mskim.MskimRequestMapping;
import gdu.mskim.RequestMapping;
import model.board.BoardDao;

@WebServlet(urlPatterns= {"/board/*"},
initParams= {@WebInitParam(name="view",value="/view/board/")})
public class BoardController extends MskimRequestMapping{
	private BoardDao boardDao = new BoardDao();

	public String noticecheck(HttpServletRequest request, HttpServletResponse response ) {
		return null;
	}
	
	
}
