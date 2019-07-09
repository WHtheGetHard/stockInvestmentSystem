package player;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fieldformat.DisplayContentsBrokerageCommissions;
import fieldformat.DisplayContentsCapitalGainsTaxes;
import fieldformat.DisplayContentsConsumptionTaxes;
import flayer.RegistBrokerageCommissions;
import flayer.RegistCapitalGainsTaxes;
import flayer.RegistConsumptionTaxes;

/**
 * Servlet implementation class RegistContentsExec
 */
@WebServlet("/RegistContentsExec")
public class RegistContentsExec extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistContentsExec() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String tradingCostType = request.getParameter("tradingCostType");

		if ("1".equals(tradingCostType)) {
			DisplayContentsBrokerageCommissions displayContentsBrokerageCommissions = new DisplayContentsBrokerageCommissions();

			displayContentsBrokerageCommissions.setCompanyName(request.getParameter("companyName"));
			displayContentsBrokerageCommissions.setBraokerageCommission(request.getParameter("braokerageCommission"));
			displayContentsBrokerageCommissions.setStartDate(request.getParameter("startDate"));
			displayContentsBrokerageCommissions.setEndDate(request.getParameter("endDate"));

			RegistBrokerageCommissions registBrokerageCommissions = new RegistBrokerageCommissions();
			registBrokerageCommissions.execRegistration(displayContentsBrokerageCommissions);

		} else if ("2".equals(tradingCostType)) {
			DisplayContentsCapitalGainsTaxes displayContentsCapitalGainsTaxes = new DisplayContentsCapitalGainsTaxes();

			displayContentsCapitalGainsTaxes.setCapitalGainsTax(request.getParameter("capitalGainsTax"));
			displayContentsCapitalGainsTaxes.setStartDate(request.getParameter("startDate"));
			displayContentsCapitalGainsTaxes.setEndDate(request.getParameter("endDate"));

			RegistCapitalGainsTaxes registCapitalGainsTaxes = new RegistCapitalGainsTaxes();
			registCapitalGainsTaxes.execRegistration(displayContentsCapitalGainsTaxes);

		} else if ("3".equals(tradingCostType)) {
			DisplayContentsConsumptionTaxes displayContentsConsumptionTaxes = new DisplayContentsConsumptionTaxes();

			displayContentsConsumptionTaxes.setComsumptionTax(request.getParameter("comsumptionTax"));
			displayContentsConsumptionTaxes.setStartDate(request.getParameter("startDate"));
			displayContentsConsumptionTaxes.setEndDate(request.getParameter("endDate"));

			RegistConsumptionTaxes registConsumptionTaxes = new RegistConsumptionTaxes();
			registConsumptionTaxes.execRegistration(displayContentsConsumptionTaxes);
		}

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
