package player;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fieldformat.InputUserInfo;

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

		if ("regist".equals(type)) {
			inputUserInfo.setUserName(request.getParameter("user-name"));
			inputUserInfo.setUserPassword(request.getParameter("user-password"));
			inputUserInfo.setUserMail(request.getParameter("user-mail"));


		} else if ("login".equals(type)) {
			inputUserInfo.setUserName(request.getParameter("user-name"));
			inputUserInfo.setUserPassword(request.getParameter("user-password"));


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
