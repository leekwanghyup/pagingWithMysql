package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.service.BoarServiceList;
import board.service.BoardService;

@WebServlet("/board/*")
public class BoardController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private final String MAPPING = "/board/";
	private final String PREFIX = "/WEB-INF/views/board/";
	private final String SUFFIX = ".jsp";
       
    public BoardController() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String contextPath = request.getContextPath(); 
		String requestURI = request.getRequestURI();
		String cmdURI = requestURI.substring(contextPath.length() + MAPPING.length());
		String viewPage = null; 
		
		BoardService service = null; 

		if(cmdURI.equals("list")) {
			service = new BoarServiceList();
			service.execute(request, response);
			viewPage = "list";
			forward(viewPage, request, response);
			return; 
		} 
		
		if(cmdURI.equals("get")) {
			viewPage = "get";
			forward(viewPage,request,response);
			return; 
		}
		
		if(cmdURI.equals("register")) {
			viewPage = "register";
			forward(viewPage,request,response);
			return; 
		}
		
		if(cmdURI.equals("modify")) {
			viewPage = "modify";
			forward(viewPage,request,response);
			return; 
		}	
	}

    private void forward(String viewPage, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	RequestDispatcher rd = request.getRequestDispatcher(PREFIX + viewPage + SUFFIX);
		rd.forward(request, response);
    }

}
