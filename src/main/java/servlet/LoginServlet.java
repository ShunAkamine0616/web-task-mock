package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.User;
import service.UserService;
import util.Utility;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);
		request.setCharacterEncoding("UTF-8");
		String loginId = request.getParameter("loginId");
		String pass = request.getParameter("pass");

		if (Utility.isNullOrEmpty(loginId) && Utility.isNullOrEmpty(pass)) {
			request.setAttribute("idErrMsg", "IDは必須です");
			request.setAttribute("passErrMsg", "PASSは必須です");

			request.getRequestDispatcher("index.jsp").forward(request, response);
			return;
		} else if(!Utility.isNullOrEmpty(loginId) && Utility.isNullOrEmpty(pass)){
			request.setAttribute("passErrMsg", "PASSは必須です");

			request.getRequestDispatcher("index.jsp").forward(request, response);
			return;
		} else if(Utility.isNullOrEmpty(loginId) && !Utility.isNullOrEmpty(pass)){
			request.setAttribute("idErrMsg", "IDは必須です");

			request.getRequestDispatcher("index.jsp").forward(request, response);
			return;
		} 
		Integer loginIdInt;

		try {
			loginIdInt = Integer.parseInt(loginId);
		} catch (NumberFormatException e) {
			loginIdInt = null;
		}


		HttpSession session = request.getSession();

		UserService uService = new UserService();
		//		List<User> productList = null;
		User u = uService.findByUserIdAndPass(loginId, pass);
		

		if(u == null) {
			session.setAttribute("loginErrMsg", "IDまたはパスワードが不正です");
			request.getRequestDispatcher("index.jsp").forward(request, response);
			return;
		} else {
			session.setAttribute("name", u.getName());
			request.getRequestDispatcher("menu.jsp").forward(request, response);
			return;
		}
	}

}
