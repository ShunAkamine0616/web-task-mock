package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ProductDao;
import entity.Category;
import entity.Product;
import service.CategoryService;
import service.ProductService;
import util.Utility;
/**
 * Servlet implementation class SearchResult
 */
@WebServlet("/SearchResult")
public class SearchResult extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection connection;
	private ProductDao productDao;
	/**
	 * Default constructor. 
	 */
	public SearchResult() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		request.setCharacterEncoding("UTF-8");

		String keyword = request.getParameter("keyword");

		String sort = request.getParameter("sort");
		

		HttpSession session = request.getSession();
		
		session.setAttribute("keyword", keyword);
		session.setAttribute("sort", sort);
		
		ProductService pService = new ProductService();
		CategoryService cService = new CategoryService();
		List<Product> productList = null;
		List<Category> categoryList = null;
		
		if (Utility.isNullOrEmpty(keyword)) {
			productList = pService.find(sort);
			session.setAttribute("productList", productList);
			if(productList.size() == 0) {
				session.setAttribute("successMsg", "検索条件と十分に一致する結果が見つかりません");
			} else {
				session.removeAttribute("successMsg");
			}
		} else {
			productList = pService.findByKeyword(keyword, sort);
//			categoryList = cService.findByKeyword(keyword);
			if(productList.size() == 0) {
				session.setAttribute("successMsg", "検索条件と十分に一致する結果が見つかりません");
			} else {
				session.removeAttribute("successMsg");
			}
			session.setAttribute("productList", productList);
//			session.setAttribute("categoryList", categoryList);
		} 
		request.getRequestDispatcher("menu.jsp").forward(request, response);
		return;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response)
		
	}
}
