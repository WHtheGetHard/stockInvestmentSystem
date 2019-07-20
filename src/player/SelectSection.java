package player;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fieldformat.StockGlossary;
import flayer.ExecSelectStockGlossary;

/**
 * Servlet implementation class SelectSection
 */
@WebServlet("/SelectSection")
public class SelectSection extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectSection() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String selectedSection = request.getParameter("selectedSection");

		ExecSelectStockGlossary execSelectStockGlossary = new ExecSelectStockGlossary();

		ArrayList<StockGlossary> stockGlossaryList = new ArrayList<StockGlossary>();

		stockGlossaryList = execSelectStockGlossary.execSelectFromsection(selectedSection);

		request.setAttribute("stockGlossaryList", stockGlossaryList);

		RequestDispatcher rd = request.getRequestDispatcher("aboutStock.jsp");

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
