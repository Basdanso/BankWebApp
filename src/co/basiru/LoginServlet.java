package co.basiru;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/Login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static PreparedStatement pst = null;

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Edureka","root","");
			pst = con.prepareStatement("select * from user_pass where username = ? and password = ?");
			
		}
		catch (Exception ex) {
			System.out.println(ex.toString());
		}
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Get form data
		String Uid = request.getParameter("Uid");
		String Pwd = request.getParameter("Pwd");
		
		HttpSession session = request.getSession();
		session.setAttribute("Uid", Uid);
		
		try {
			pst.setString(1, Uid);
			pst.setString(2, Pwd);
			ResultSet rs = pst.executeQuery();
			
			if(rs.next()) {
				RequestDispatcher rd = request.getRequestDispatcher("admin");
				rd.forward(request, response);
			}
			else {
				PrintWriter out = response.getWriter();
				
				out.println("<p style = text-align:center; font-size:50px; font-color:red>Invalid Username/Password</p>");
				out.println("<h2>"+session.getId()+" "+ session.isNew()+"</h2>");
				
				RequestDispatcher rd = request.getRequestDispatcher("Login.html");
				rd.include(request, response);
			}
		}
		catch (Exception ex) {
			System.out.println(ex.toString());
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		
	}

}
