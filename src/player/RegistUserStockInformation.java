package player;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fieldformat.MessageAreaDisplayContents;
import fieldformat.UserStockInfo;
import flayer.RegistUserStockInfo;

/**
 * Servlet implementation class RegistUserStockInformation
 */
@WebServlet("/RegistUserStockInformation")
public class RegistUserStockInformation extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistUserStockInformation() {
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

		String buyingPrice = request.getParameter("buyingPrice");

		if ("".equals(buyingPrice)) {
			userStockInfo.setBuyingPrice(0);
		} else {
			userStockInfo.setBuyingPrice(Integer.parseInt(buyingPrice));
		}


		String sellingPrice = request.getParameter("sellingPrice");

		if ("".equals(sellingPrice)) {
			userStockInfo.setSellingPrice(0);
		} else {
			userStockInfo.setSellingPrice(Integer.parseInt(sellingPrice));
		}

		RegistUserStockInfo registUserStockInfo = new RegistUserStockInfo();

		MessageAreaDisplayContents messageAreaDisplayContents = new MessageAreaDisplayContents();

		messageAreaDisplayContents = registUserStockInfo.execRegist(userStockInfo);

		request.setAttribute("messageAreaDisplayContents", messageAreaDisplayContents);

		RequestDispatcher rd = request.getRequestDispatcher("inputUserStockInfo.jsp");

		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
