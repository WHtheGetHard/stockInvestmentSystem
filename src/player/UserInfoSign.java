package player;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fieldformat.InputUserInfo;
import fieldformat.UserInfoLoginCheckResult;
import fieldformat.UserInfoRegistCheckResult;
import flayer.ConfirmUserInfo;

/**
 * Servlet implementation class UserInfoSign
 */
@WebServlet("/UserInfoSign")
public class UserInfoSign extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserInfoSign() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String type = request.getParameter("type");

		InputUserInfo inputUserInfo = new InputUserInfo();

		ConfirmUserInfo confirmUserInfo = new ConfirmUserInfo();

		if ("regist".equals(type)) {
			inputUserInfo.setUserName(request.getParameter("user-name"));
			inputUserInfo.setUserPassword(request.getParameter("user-password"));
			inputUserInfo.setUserMail(request.getParameter("user-mail"));

			UserInfoRegistCheckResult userInfoRegistCheckResult = new UserInfoRegistCheckResult();
			userInfoRegistCheckResult = confirmUserInfo.execRegist(inputUserInfo);

			if (userInfoRegistCheckResult.isRegistSuccess()) {
				HttpSession session = request.getSession();
				session.setAttribute("userInformation", userInfoRegistCheckResult.getUserInformation());
				RequestDispatcher rd = request.getRequestDispatcher("userSign.jsp");
				rd.forward(request, response);

			} else {
				request.setAttribute("userInfoRegistCheckResult", userInfoRegistCheckResult);
				RequestDispatcher rd = request.getRequestDispatcher("userSign.jsp");
				rd.forward(request, response);
			}

		} else if ("login".equals(type)) {
			inputUserInfo.setUserName(request.getParameter("user-name"));
			inputUserInfo.setUserPassword(request.getParameter("user-password"));

			UserInfoLoginCheckResult userInfoLoginCheckResult = new UserInfoLoginCheckResult();
			userInfoLoginCheckResult = confirmUserInfo.execLogin(inputUserInfo);

			if (userInfoLoginCheckResult.isLoginSuccess()) {
				HttpSession session = request.getSession();
				session.setAttribute("userInformation", userInfoLoginCheckResult.getUserInformation());
				RequestDispatcher rd = request.getRequestDispatcher("userSign.jsp");
				rd.forward(request, response);
			} else {
				request.setAttribute("userInfoLoginCheckResult", userInfoLoginCheckResult);
				RequestDispatcher rd = request.getRequestDispatcher("userSign.jsp");
				rd.forward(request, response);
			}
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
