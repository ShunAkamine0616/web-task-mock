package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.ProductService;

/**
 * Servlet implementation class DeleteServlet
 */
@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeleteServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		request.setCharacterEncoding("UTF-8");
		String productId = request.getParameter("productId");
		
//		HttpSession session = request.getSession();
		HttpSession session = request.getSession();
		Integer productId_int = 0;
		try {
			productId_int = Integer.parseInt(productId);
		} catch(Exception e) {
			session.setAttribute("deleteErrMsg", "削除に失敗しました");
			e.printStackTrace();
			request.getRequestDispatcher("detail.jsp").forward(request, response);
			return;
		}

		ProductService pService = new ProductService();
		
		if(pService.delete(productId_int) == 0) {
			session.setAttribute("deleteErrMsg", "削除に失敗しました。");
			request.getRequestDispatcher("detail.jsp").forward(request, response);
			return;
		} else {
			session.setAttribute("successMsg", "削除に成功しました");
		}
		
		session.setAttribute("productList", pService.find("product_id")); 
		request.getRequestDispatcher("menu.jsp").forward(request, response);
		return;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
