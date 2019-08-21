package player;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fieldformat.CompanyDetails;
import fieldformat.CompanyStockBaseInfo;
import fieldformat.MessageAreaDisplayContents;
import fieldformat.RefCompanyInfoCondition;
import flayer.ExecSearchCompanyInfo;
import flayer.GatherCompanyDetails;

/**
 * Servlet implementation class SearchCompanyInfo
 */
@WebServlet("/SearchCompanyInfo")
public class SearchCompanyInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchCompanyInfo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		RefCompanyInfoCondition refCompanyInfoCondition = new RefCompanyInfoCondition();

		refCompanyInfoCondition.setSelectedSearchType(request.getParameter("selectedSearchType"));
		refCompanyInfoCondition.setSearchWord(request.getParameter("searchWord"));

		ArrayList<CompanyStockBaseInfo> companyStockBaseInfoList = new ArrayList<CompanyStockBaseInfo>();
		CompanyStockBaseInfo companyStockBaseInfo = new CompanyStockBaseInfo();

		ExecSearchCompanyInfo execSearchCompanyInfo =  new ExecSearchCompanyInfo();

		if ("1".equals(refCompanyInfoCondition.getSelectedSearchType())) {

			companyStockBaseInfoList = execSearchCompanyInfo.searchFromName(refCompanyInfoCondition.getSearchWord());

		} else if ("2".equals(refCompanyInfoCondition.getSelectedSearchType())) {

			companyStockBaseInfo = execSearchCompanyInfo.searchFromSecuritiesCode(refCompanyInfoCondition.getSearchWord());

		} else if ("3".equals(refCompanyInfoCondition.getSelectedSearchType())) {

			companyStockBaseInfoList = execSearchCompanyInfo.searchFromMarket(refCompanyInfoCondition.getSearchWord());

		}

		MessageAreaDisplayContents messageAreaDisplayContents = new MessageAreaDisplayContents();

		if ("1".equals(refCompanyInfoCondition.getSelectedSearchType()) || "3".equals(refCompanyInfoCondition.getSelectedSearchType())) {
			if (companyStockBaseInfoList.size() == 0) {
				messageAreaDisplayContents.setError(true);
				messageAreaDisplayContents.setMessage("検索条件に合致するデータは存在しません。");
			}
		} else if ("2".equals(refCompanyInfoCondition.getSelectedSearchType())) {
			if (companyStockBaseInfo.getCompanyName() == null) {
				messageAreaDisplayContents.setError(true);
				messageAreaDisplayContents.setMessage("検索条件に合致するデータは存在しません。");
			}
		}

		ArrayList<CompanyDetails> companyDetailsList = new ArrayList<CompanyDetails>();
		GatherCompanyDetails gatherCompanyDetails = new GatherCompanyDetails();
		companyDetailsList = gatherCompanyDetails.execGather(companyStockBaseInfoList);

		HttpSession session = request.getSession();
		session.setAttribute("companyDetailsList", companyDetailsList);

		request.setAttribute("refCompanyInfoCondition",refCompanyInfoCondition);
		request.setAttribute("messageAreaDisplayContents", messageAreaDisplayContents);
		request.setAttribute("companyStockBaseInfoList", companyStockBaseInfoList);
		request.setAttribute("companyStockBaseInfo", companyStockBaseInfo);

		RequestDispatcher rd = request.getRequestDispatcher("refCompanyInfo.jsp");

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
