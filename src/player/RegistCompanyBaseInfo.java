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

import fieldformat.CompanyStockBaseInfo;
import fieldformat.CompanyStockBaseInfoWithDistance;
import fieldformat.MessageAreaDisplayContents;
import flayer.ConfirmCompaniesRegistered;
import flayer.RegistStcokBaseInfo;

/**
 * Servlet implementation class RegistCompanyBaseInfo
 */
@WebServlet("/RegistCompanyBaseInfo")
public class RegistCompanyBaseInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistCompanyBaseInfo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		HttpSession session = request.getSession();

		ArrayList<CompanyStockBaseInfoWithDistance> companyStockBaseInfoWithDistanceList = new ArrayList<CompanyStockBaseInfoWithDistance>();
		companyStockBaseInfoWithDistanceList = (ArrayList<CompanyStockBaseInfoWithDistance>) session.getAttribute("companyStockBaseInfoWithDistanceList");

		int listNumber = Integer.parseInt(request.getParameter("listNumber"));

		CompanyStockBaseInfo companyStockBaseInfo = new CompanyStockBaseInfo();

		companyStockBaseInfo.setCompanyName(companyStockBaseInfoWithDistanceList.get(listNumber).getCompanyName());
		companyStockBaseInfo.setMarket(companyStockBaseInfoWithDistanceList.get(listNumber).getMarket());
		companyStockBaseInfo.setSecuritiesCode(companyStockBaseInfoWithDistanceList.get(listNumber).getSecuritiesCode());

		ConfirmCompaniesRegistered confirmCompaniesRegistered = new ConfirmCompaniesRegistered();
		boolean isRegistered = false;

		isRegistered = confirmCompaniesRegistered.isRegistered(companyStockBaseInfo.getCompanyName());

		MessageAreaDisplayContents messageAreaDisplayContents = new MessageAreaDisplayContents();
		String message = "" + companyStockBaseInfo.getCompanyName() + "";
		if (isRegistered) {
			message += "は既に登録済みです。";
			messageAreaDisplayContents.setError(true);
			messageAreaDisplayContents.setMessage(message);
		} else {
			RegistStcokBaseInfo registStcokBaseInfo = new RegistStcokBaseInfo();
			registStcokBaseInfo.execRegistration(companyStockBaseInfo);

			message += "を登録しました。";
			messageAreaDisplayContents.setError(false);
			messageAreaDisplayContents.setMessage(message);
		}

		session.removeAttribute("companyStockBaseInfoWithDistanceList");

		request.setAttribute("messageAreaDisplayContents", messageAreaDisplayContents);

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
