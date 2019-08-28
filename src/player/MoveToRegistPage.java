package player;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fieldformat.Companies;
import fieldformat.CompanyStockBaseInfo;
import flayer.ExecSearchCompanyInfo;

/**
 * Servlet implementation class MoveToRegistPage
 */
@WebServlet("/MoveToRegistPage")
public class MoveToRegistPage extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public MoveToRegistPage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		String targetSecuritiesCode = request.getParameter("targetSecuritiesCode");

		CompanyStockBaseInfo companyStockBaseInfo = new CompanyStockBaseInfo();
		ExecSearchCompanyInfo execSearchCompanyInfo = new ExecSearchCompanyInfo();

		companyStockBaseInfo = execSearchCompanyInfo.searchFromSecuritiesCode(targetSecuritiesCode);

		Companies companies = new Companies();
		companies.setId(execSearchCompanyInfo.getIdFromSecuritiesCode(companyStockBaseInfo.getSecuritiesCode()));
		companies.setName(companyStockBaseInfo.getCompanyName());

		request.setAttribute("companyStockBaseInfo", companyStockBaseInfo);
		request.setAttribute("companies", companies);

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
