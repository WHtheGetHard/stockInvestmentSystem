package player;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fieldformat.UserStockInfo;

/**
 * Servlet implementation class RegistUserStockInfo
 */
@WebServlet("/RegistUserStockInfo")
public class RegistUserStockInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistUserStockInfo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		UserStockInfo userStockInfo = new UserStockInfo();

		userStockInfo.setUserId(Integer.parseInt(request.getParameter("userId")));
		userStockInfo.setCompId(Integer.parseInt(request.getParameter("compId")));

		userStockInfo.setNumStock(Integer.parseInt(request.getParameter("numStock")));
		userStockInfo.setBuyingPrice(Integer.parseInt(request.getParameter("buyingPrice")));
		userStockInfo.setSellingPrice(Integer.parseInt(request.getParameter("sellingPrice")));

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
