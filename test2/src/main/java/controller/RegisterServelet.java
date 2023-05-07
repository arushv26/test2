package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import bean.RegisterBean;
import dao.RegisterDao;

/**
 * Servlet implementation class RegisterServelet
 */
@WebServlet("/RegisterServelet")
public class RegisterServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServelet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String fname = request.getParameter("fname");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		RegisterBean registerbean = new RegisterBean();
		registerbean.setfname(fname);
		registerbean.setusername(username);
		registerbean.setpassword(password);
		
		RegisterDao registerdao = new RegisterDao();
		String userregistered = registerdao.registeruser(registerbean);
		
		if(userregistered.equals("SUCCESS")) {
			request.setAttribute("userName", username);
			request.getRequestDispatcher("/Home.jsp").forward(request, response);;
		}
		else {
			request.setAttribute("errMessage", userregistered);
            request.getRequestDispatcher("/Register.jsp").forward(request, response);
		}
		doGet(request, response);
	}

}
