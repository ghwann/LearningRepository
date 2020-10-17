package com.ssafy.car;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ssafy.dto.Car;
import com.ssafy.svc.CarService;
import com.ssafy.svc.CarServiceImpl;

@WebServlet("/main.do")
public class MainServlet extends HttpServlet {
	private CarService svc=CarServiceImpl.getInstance();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}
	protected void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String action=request.getParameter("action");
		System.out.println("action=["+action+"]");
		if(action==null) {
			response.sendRedirect("index.jsp");
			//request.getRequestDispatcher("index.jsp").forward(request, response);
			return;
		}
		if(action.equals("login")) {
			login(request, response);
		}else if(action.equals("logout")) {
			logout(request, response);
		}else if(action.equals("regi")) {
			regi(request, response);
		}else if(action.equals("save")) {
			save(request, response);
		}else if(action.equals("list")) {
			list(request, response);
		}else if(action.equals("view")) {
			view(request, response);
		}else if(action.equals("dele")) {
			dele(request, response);
		}else{
			response.sendRedirect("index.jsp");
			//request.getRequestDispatcher("index.jsp").forward(request, response);
		}
	}
	protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String next="Error.jsp";
		String id=request.getParameter("id");
		String pw=request.getParameter("pw");
		try {
			String user=svc.login(id,pw);
			if(user!=null) {
				HttpSession hs=request.getSession();
				hs.setAttribute("user", user);
			}else{
				request.setAttribute("msg", "아이디, 패스워드를 확인하세요");
			}
			next="index.jsp";
		} catch (SQLException e) {
			request.setAttribute("msg", "로그인 중 오류가 발생했습니다");
		}
		request.getRequestDispatcher(next).forward(request, response);
	}
	protected void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession hs=request.getSession(false);
		if(hs!=null) hs.invalidate();
		response.sendRedirect("index.jsp");
		//request.getRequestDispatcher("index.jsp").forward(request, response);
	}
	protected void regi(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String next="car/CarRegi.jsp";
		request.getRequestDispatcher(next).forward(request, response);
	}
	protected void save(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String next="Error.jsp";
		String num=request.getParameter("num");
		String model=request.getParameter("model");
		int price=Integer.parseInt(request.getParameter("price"));
		String vcode=request.getParameter("vcode");
		try {
			svc.insert(new Car(num,model,price,vcode,""));
			request.setAttribute("msg", "정상적으로 등록 되었습니다");
			next="Result.jsp";
		} catch (SQLException e) {
			request.setAttribute("msg", "등록 중 오류가 발생했습니다");
		}
		request.getRequestDispatcher(next).forward(request, response);
	}
	protected void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String next="Error.jsp";
		try {
			List<Car> cars=svc.search();
			request.setAttribute("cars", cars);
			next="car/CarList.jsp";
		} catch (SQLException e) {
			request.setAttribute("msg", "목록 중 오류가 발생했습니다");
		}
		request.getRequestDispatcher(next).forward(request, response);
	}
	protected void view(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String next="Error.jsp";
		String num=request.getParameter("num");
		try {
			Car car=svc.search(num);
			request.setAttribute("car", car);
			next="car/CarView.jsp";
		} catch (SQLException e) {
			request.setAttribute("msg", "조회 중 오류가 발생했습니다");
		}
		request.getRequestDispatcher(next).forward(request, response);
	}
	protected void dele(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String next="Error.jsp";
		String[] num=request.getParameterValues("num");
		try {
			svc.delete(num);
			if(num.length==1) {
				request.setAttribute("msg", "정상적으로 삭제 되었습니다");
				next="Result.jsp";
			}else{
				next="main.do?action=list";
			}
		} catch (SQLException e) {
			request.setAttribute("msg", "삭제 중 오류가 발생했습니다");
		}
		request.getRequestDispatcher(next).forward(request, response);
	}
}




























