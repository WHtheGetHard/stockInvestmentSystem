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

		ExecSearchCompanyInfo execSearchCompanyInfo =  new ExecSearchCompanyInfo();
		MessageAreaDisplayContents messageAreaDisplayContents = new MessageAreaDisplayContents();

		HttpSession session = request.getSession(false);
		session.removeAttribute("companyDetailsList");
		session.removeAttribute("companyDetails");


		if ("1".equals(refCompanyInfoCondition.getSelectedSearchType()) || "3".equals(refCompanyInfoCondition.getSelectedSearchType()) ) {
			ArrayList<CompanyStockBaseInfo> companyStockBaseInfoList = new ArrayList<CompanyStockBaseInfo>();
			ArrayList<CompanyDetails> companyDetailsList = new ArrayList<CompanyDetails>();

			if ("1".equals(refCompanyInfoCondition.getSelectedSearchType())) {
				companyStockBaseInfoList = execSearchCompanyInfo.searchFromName(refCompanyInfoCondition.getSearchWord());
			} else if ("3".equals(refCompanyInfoCondition.getSelectedSearchType())) {
				companyStockBaseInfoList = execSearchCompanyInfo.searchFromMarket(refCompanyInfoCondition.getSearchWord());
			}


			if (companyStockBaseInfoList.size() == 0) {
				messageAreaDisplayContents.setError(true);
				messageAreaDisplayContents.setMessage("検索条件に合致するデータは存在しません。");

			} else {

				GatherCompanyDetails gatherCompanyDetailsList = new GatherCompanyDetails();
				companyDetailsList = gatherCompanyDetailsList.execGather(companyStockBaseInfoList);
			}

			session = request.getSession();
			session.setAttribute("companyDetailsList", companyDetailsList);

			request.setAttribute("companyStockBaseInfoList", companyStockBaseInfoList);

		} else if ("2".equals(refCompanyInfoCondition.getSelectedSearchType())) {
			CompanyStockBaseInfo companyStockBaseInfo = new CompanyStockBaseInfo();

			companyStockBaseInfo = execSearchCompanyInfo.searchFromSecuritiesCode(refCompanyInfoCondition.getSearchWord());

			CompanyDetails companyDetails = new CompanyDetails();

			if (companyStockBaseInfo.getCompanyName() == null) {
				messageAreaDisplayContents.setError(true);
				messageAreaDisplayContents.setMessage("検索条件に合致するデータは存在しません。");

			} else {

				GatherCompanyDetails gatherCompanyDetailsUnit = new GatherCompanyDetails();
				companyDetails = gatherCompanyDetailsUnit.execGatherUnit(companyStockBaseInfo);
			}

			session = request.getSession();
			session.setAttribute("companyDetails", companyDetails);

			request.setAttribute("companyStockBaseInfo", companyStockBaseInfo);
		}

		request.setAttribute("refCompanyInfoCondition",refCompanyInfoCondition);
		request.setAttribute("messageAreaDisplayContents", messageAreaDisplayContents);

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
