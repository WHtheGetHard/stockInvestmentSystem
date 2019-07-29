package player;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fieldformat.CompanyStockBaseInfo;
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

		ArrayList<CompanyStockBaseInfo> companyStockBaseInfoList = new ArrayList<CompanyStockBaseInfo>();
		companyStockBaseInfoList = (ArrayList<CompanyStockBaseInfo>) session.getAttribute("companyStockBaseInfoList");

		int listNumber = Integer.parseInt(request.getParameter("listNumber"));

		CompanyStockBaseInfo companyStockBaseInfo = new CompanyStockBaseInfo();

		companyStockBaseInfo = companyStockBaseInfoList.get(listNumber);

		ConfirmCompaniesRegistered confirmCompaniesRegistered = new ConfirmCompaniesRegistered();
		boolean isRegistered = false;

		isRegistered = confirmCompaniesRegistered.isRegistered(companyStockBaseInfo.getCompanyName());

		if (isRegistered) {
			// TODO : 登録済みの場合の処理
		} else {
			RegistStcokBaseInfo registStcokBaseInfo = new RegistStcokBaseInfo();
			registStcokBaseInfo.execRegistration(companyStockBaseInfo);
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
