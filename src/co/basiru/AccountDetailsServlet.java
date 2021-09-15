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

import org.springframework.orm.hibernate5.HibernateTemplate;


@WebServlet("/accountDetails")
public class AccountDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static PreparedStatement pst = null;

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Edureka","root","");
			pst = con.prepareStatement("select * from accountdetails where accno = ?, name = ?, dob = ?, address= ?, email= ?, accType = ?");
			
			
		} catch(Exception ex) {
			System.out.println(ex.toString());	
			
		}
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//get form data
		String acno = request.getParameter("acno");
		String name = request.getParameter("name");
		String dob = request.getParameter("dob");
		String address = request.getParameter("address");
		String email = request.getParameter("email");
		String accType = request.getParameter("accType");
		
		HttpSession session = request.getSession();
		session.setAttribute("acno", acno);
		session.setAttribute("name", name);
		session.setAttribute("dob", dob);
		session.setAttribute("address", address);
		session.setAttribute("email", email);
		session.setAttribute("accType", accType);
		
		try {
			pst.setString(1, acno);
			pst.setString(2, name);
			pst.setString(3, dob);
			pst.setString(4, address);
			pst.setString(5, email);
			pst.setString(5, accType);
			ResultSet rs = pst.executeQuery();
			
			if(rs.next()) {
				RequestDispatcher rd = request.getRequestDispatcher("register");
				rd.forward(request, response);
			}
			else {
				PrintWriter out = response.getWriter();
				
				out.println("<h2>"+session.getId()+" "+ session.isNew()+"</h2>");
				
				out.println("<p style = text-align:center; font-size:50px; font-color:red>Invalid Username/Password</p>");
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

