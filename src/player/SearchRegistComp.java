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
import fieldformat.MessageAreaDisplayContents;
import flayer.ExecSearchCompanyInfo;

/**
 * Servlet implementation class SearchRegistComp
 */
@WebServlet("/SearchRegistComp")
public class SearchRegistComp extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchRegistComp() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		String searchCompName = request.getParameter("searchCompName");

		ArrayList<CompanyStockBaseInfo> companyStockBaseInfoList = new ArrayList<CompanyStockBaseInfo>();
		ExecSearchCompanyInfo execSearchCompanyInfo = new ExecSearchCompanyInfo();

		companyStockBaseInfoList = execSearchCompanyInfo.searchFromName(searchCompName);

		MessageAreaDisplayContents messageAreaDisplayContents = new MessageAreaDisplayContents();

		if (companyStockBaseInfoList.size() == 0) {
			messageAreaDisplayContents.setError(true);
			messageAreaDisplayContents.setMessage("検索条件に一致する企業は登録されていません。");

		} else {
			messageAreaDisplayContents.setError(false);

		}

		request.setAttribute("companyStockBaseInfoList", companyStockBaseInfoList);
		request.setAttribute("messageAreaDisplayContents", messageAreaDisplayContents);


		RequestDispatcher rd = request.getRequestDispatcher("userStockInfoRegist.jsp");
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
