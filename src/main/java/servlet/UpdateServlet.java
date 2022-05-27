package servlet;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.Product;
import service.ProductService;
import util.Utility;

/**
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateServlet() {
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
		String productName = request.getParameter("productName");
		String price = request.getParameter("price");
		String category_id = request.getParameter("category_id");
		String description = request.getParameter("description");

		HttpSession session = request.getSession();
		Product oldProduct = (Product) session.getAttribute("product");

		Integer productId_int = 0;
		Integer price_int = 0;
		Integer category_id_int = 0;
		boolean error = false;
		
		try {
			productId_int = Integer.parseInt(productId);
			price_int = Integer.parseInt(price);
			category_id_int = Integer.parseInt(category_id);
		} catch(Exception e) {
			error = true;
			session.setAttribute("updateErrMsg", "更新時にエラーが発生しました");
			e.printStackTrace();
		}

		if (Utility.isNullOrEmpty(productId)) {
			request.setAttribute("idErrMsg", "<商品ID>は必須です");
			error = true;
		} 
		
		if(Utility.isNullOrEmpty(productName)){
			request.setAttribute("nameErrMsg", "<商品名>は必須です");
			error = true;
		} 
		
		if(Utility.isNullOrEmpty(price)){
			request.setAttribute("priceErrMsg", "<単価>は必須です");
			error = true;
		} 
		
//		if(Utility.isNullOrEmpty(category)){
//			request.setAttribute("categoryErrMsg", "<カテゴリ>は必須です");
//			error = true;
//		} 
		
		if(error) {
			request.getRequestDispatcher("updateInput.jsp").forward(request, response);
			return;
		} else {
			ProductService pService = new ProductService();
			Date nowDate = new Date();
			Timestamp timestamp = new Timestamp(nowDate.getTime());
			Product p = new Product(productId_int, category_id_int, productName, price_int,  description, timestamp); 
			try {
				pService.update(oldProduct.getProduct_id(), p);
			} catch(Exception e) {
				session.setAttribute("updateErrMsg", "更新時にエラーが発生しました");
			}
			session.setAttribute("productList", pService.find("product_id")); 
			request.getRequestDispatcher("menu.jsp").forward(request, response);
			return;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
