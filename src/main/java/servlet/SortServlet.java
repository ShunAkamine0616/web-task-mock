//package servlet;
//
//import java.io.IOException;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import service.ProductService;
//
///**
// * Servlet implementation class SortServlet
// */
//@WebServlet("/SortServlet")
//public class SortServlet extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//       
//    /**
//     * @see HttpServlet#HttpServlet()
//     */
//    public SortServlet() {
//        super();
//        // TODO Auto-generated constructor stub
//    }
//
//	/**
//	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		//response.getWriter().append("Served at: ").append(request.getContextPath());
//		
//		String sort = request.getParameter("sort");
//		
//		ProductService pService = new ProductService();
//		
//		pService.sort(sort);
////		if(sort.equals("")) {
////			
////		} else if (sort.equals("")) {
////			
////		}else if (sort.equals("")) {
////			
////		}else if (sort.equals("")) {
////			
////		}else if (sort.equals("")) {
////			
////		}else if (sort.equals("")) {
////			
////		}else if (sort.equals("")) {
////			
////		} else {
////			
////		}
//	}
//
//	/**
//	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		doGet(request, response);
//	}
//
//}
