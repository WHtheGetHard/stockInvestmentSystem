package player;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fieldformat.CompanyStockBaseInfo;
import flayer.SecuritiesCode;

/**
 * Servlet implementation class SearchCompanyName
 */
@WebServlet("/SearchCompanyName")
public class SearchCompanyName extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchCompanyName() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");


		String companyName = request.getParameter("companyName");

		SecuritiesCode securitiesCode = new SecuritiesCode();
		String article = securitiesCode.accessTargetPage(companyName);

		ArrayList<CompanyStockBaseInfo> companyStockBaseInfoList = new ArrayList<CompanyStockBaseInfo>();
		companyStockBaseInfoList = securitiesCode.getResults(article);

		request.setAttribute("companyStockBaseInfoList", companyStockBaseInfoList);

		RequestDispatcher rd = request.getRequestDispatcher("companyInfoRegist.jsp");

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
