package player;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fieldformat.TradingCostTransition;
import fieldformat.TradingCostTypeSelectCheckResult;
import flayer.TradingCostTypeSelectCheck;

/**
 * Servlet implementation class TradingCostTypeSelect
 */
@WebServlet("/TradingCostTypeSelect")
public class TradingCostTypeSelect extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public TradingCostTypeSelect() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String tradingCostType = request.getParameter("tradingCostType");
		String caller = request.getParameter("caller");

		TradingCostTransition tradingCostTransition = new TradingCostTransition();
		tradingCostTransition.setTradingCostType(tradingCostType);
		tradingCostTransition.setCaller(caller);

		TradingCostTypeSelectCheck tradingCostTypeSelectCheck = new TradingCostTypeSelectCheck();

		TradingCostTypeSelectCheckResult tradingCostTypeSelectCheckResult = new TradingCostTypeSelectCheckResult();

		tradingCostTypeSelectCheckResult = tradingCostTypeSelectCheck.selectedValueCheck(tradingCostTransition);

		request.setAttribute("tradingCostTypeSelectCheckResult", tradingCostTypeSelectCheckResult);

		if ("regist".equals(caller)) {
			RequestDispatcher rd = request.getRequestDispatcher("tradingCost.jsp");
			rd.forward(request, response);

		} else if ("ref".equals(caller)) {
			RequestDispatcher rd = request.getRequestDispatcher("refTradingCost.jsp");
			rd.forward(request, response);

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
