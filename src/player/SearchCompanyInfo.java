package player;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fieldformat.RefCompanyInfoCondition;

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

		if ("1".equals(refCompanyInfoCondition.getSelectedSearchType())) {

		} else if ("2".equals(refCompanyInfoCondition.getSelectedSearchType())) {

		} else if ("3".equals(refCompanyInfoCondition.getSelectedSearchType())) {

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
