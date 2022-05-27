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
 * Servlet implementation class UpdateInputServlet
 */
@WebServlet("/UpdateInputServlet")
public class UpdateInputServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateInputServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		request.setCharacterEncoding("UTF-8");
		String productId = request.getParameter("productId");
		
		HttpSession session = request.getSession();

		Integer productId_int = 0;
		try {
			productId_int = Integer.parseInt(productId);
		} catch(Exception e) {
			e.printStackTrace();
		}

		ProductService pService = new ProductService();

		session.setAttribute("product", pService.findById(productId_int));
		session.removeAttribute("updateErrMsg");
		request.getRequestDispatcher("updateInput.jsp").forward(request, response);
		return;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);
	}

}
