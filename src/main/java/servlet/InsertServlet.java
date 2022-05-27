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
import service.CategoryService;
import service.ProductService;
import util.Utility;

/**
 * Servlet implementation class InsertServlet
 */
@WebServlet("/InsertServlet")
public class InsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertServlet() {
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
		String category = request.getParameter("category");
		String description = request.getParameter("description");
		
		Integer productId_int = 0;
		Integer price_int = 0;
		Integer category_int = 0;
		
		HttpSession session = request.getSession();
		
		try {
			productId_int = Integer.parseInt(productId);
			price_int = Integer.parseInt(price);
			category_int = Integer.parseInt(category);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		request.setAttribute("productId", productId);
		request.setAttribute("productName", productName);
		request.setAttribute("price", price);
//		request.setAttribute("category", category);
		
		boolean error = false;
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
		
		if(Utility.isNullOrEmpty(category)){
			request.setAttribute("categoryErrMsg", "<カテゴリ>は必須です");
			error = true;
		} 
		
		ProductService pService = new ProductService();
		CategoryService cService= new CategoryService();
		session.setAttribute("categoryList", cService.find());
//		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date nowDate = new Date();
		Timestamp timestamp = new Timestamp(nowDate.getTime());
		Product p = new Product(productId_int, category_int, productName, price_int,  description, timestamp); 
		if(pService.findById(productId_int) != null) {
			error = true;
			session.setAttribute("insertErrMsg", "商品IDが重複しています");
		}
		
//		pService.register(null);
		if(error) {
			request.getRequestDispatcher("insert.jsp").forward(request, response);
			return;
		} else {
			pService.register(p);
			session.setAttribute("productList", pService.find("product_id")); 
			session.setAttribute("successMsg", "登録が完了しました");
			request.getRequestDispatcher("menu.jsp").forward(request, response);
			return;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
	}

}
