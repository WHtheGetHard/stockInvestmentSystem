package player;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fieldformat.CapitalGainsTaxes;
import fieldformat.ConsumptionTaxes;
import fieldformat.DisplayContentsBrokerageCommissions;
import fieldformat.TradingCostTypeSelectCheckResult;
import flayer.DisplayAllRecordBrokerageCommissions;
import flayer.ExecSelectAllCapitalGainsTaxes;
import flayer.ExecSelectAllConsumptionTaxes;

/**
 * Servlet implementation class GetCostTypeList
 */
@WebServlet("/GetCostTypeList")
public class GetCostTypeList extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetCostTypeList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String tradingCostType = request.getParameter("tradingCostType");

		TradingCostTypeSelectCheckResult tradingCostTypeSelectCheckResult = new TradingCostTypeSelectCheckResult();
		tradingCostTypeSelectCheckResult.setTradingCostType(tradingCostType);
		tradingCostTypeSelectCheckResult.setValidValue(true);

		if ("1".equals(tradingCostType)) {
			DisplayAllRecordBrokerageCommissions displayAllRecordBrokerageCommissions = new DisplayAllRecordBrokerageCommissions();

			ArrayList<DisplayContentsBrokerageCommissions> displayContentsBrokerageCommissionsList =
					new ArrayList<DisplayContentsBrokerageCommissions>();

			displayContentsBrokerageCommissionsList = displayAllRecordBrokerageCommissions.exec();

			request.setAttribute("tradingCostTypeSelectCheckResult", tradingCostTypeSelectCheckResult);
			request.setAttribute("displayContentsBrokerageCommissionsList", displayContentsBrokerageCommissionsList);
		} else if ("2".equals(tradingCostType)) {
			ExecSelectAllCapitalGainsTaxes execSelectAllCapitalGainsTaxes = new ExecSelectAllCapitalGainsTaxes();
			ArrayList<CapitalGainsTaxes> capitalGainsTaxesList = new ArrayList<CapitalGainsTaxes>();

			capitalGainsTaxesList = execSelectAllCapitalGainsTaxes.exec();

			request.setAttribute("tradingCostTypeSelectCheckResult", tradingCostTypeSelectCheckResult);
			request.setAttribute("capitalGainsTaxesList", capitalGainsTaxesList);
		} else if ("3".equals(tradingCostType)) {
			ExecSelectAllConsumptionTaxes execSelectAllConsumptionTaxes = new ExecSelectAllConsumptionTaxes();
			ArrayList<ConsumptionTaxes> consumptionTaxesList = new ArrayList<ConsumptionTaxes>();

			consumptionTaxesList = execSelectAllConsumptionTaxes.exec();

			request.setAttribute("tradingCostTypeSelectCheckResult", tradingCostTypeSelectCheckResult);
			request.setAttribute("consumptionTaxesList", consumptionTaxesList);
		}

		RequestDispatcher rd = request.getRequestDispatcher("refTradingCost.jsp");
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
