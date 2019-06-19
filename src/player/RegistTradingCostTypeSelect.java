package player;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fieldformat.RegistTradingCostTypeSelectCheckResult;
import flayer.RegistTradingCostTypeSelectCheck;

/**
 * Servlet implementation class RegistTradingCostTypeSelect
 */
@WebServlet("/RegistTradingCostTypeSelect")
public class RegistTradingCostTypeSelect extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistTradingCostTypeSelect() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String tradingCostType = request.getParameter("tradingCostType");

		RegistTradingCostTypeSelectCheck registTradingCostTypeSelectCheck
			= new RegistTradingCostTypeSelectCheck();

		RegistTradingCostTypeSelectCheckResult registTradingCostTypeSelectCheckResult
			= new RegistTradingCostTypeSelectCheckResult();

		registTradingCostTypeSelectCheckResult = registTradingCostTypeSelectCheck.selectedValueCheck(tradingCostType);

		request.setAttribute("registTradingCostTypeSelectCheckResult", registTradingCostTypeSelectCheckResult);

		RequestDispatcher rd = request.getRequestDispatcher("tradingCost.jsp");
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
