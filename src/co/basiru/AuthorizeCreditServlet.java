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

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


@WebServlet("/authorizeCredits")
public class AuthorizeCreditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static PreparedStatement pst = null;


	public void init(ServletConfig config) throws ServletException {
		
		super.init(config);
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Edureka","root","");
			pst = con.prepareStatement("insert into authorize_credit ( name, cardNumber, cvv, amount) values (?, ?, ?, ?)");
/*			
			Configuration config1 = new Configuration();
		//	config1.configure("basiru/bean.xml");       // for entering acc details
			config1.configure("co/basiru/configs/hibernate.cfg.xml");
			
			SessionFactory sfactory = config1.buildSessionFactory();
			Session session = sfactory.openSession();
			Transaction tx = session.beginTransaction();
			
			AuthorizeCredit authorizeCredit = new AuthorizeCredit();
			
			// Save student with hibernate
			session.save(authorizeCredit);
			
			System.out.println("------------------------------------------");
			
			tx.commit();
			
			session.close();
			sfactory.close();
	*/		
		}
		catch (Exception ex) {
			System.out.println(ex.toString());
		}
		
	
	}
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String cardNumber = request.getParameter("cardNumber");
		String cvv = request.getParameter("cvv");
		String amount = request.getParameter("amount");
		
		HttpSession session = request.getSession();
		session.setAttribute("name", name);
		session.setAttribute("cardNumber", cardNumber);
		session.setAttribute("cvv", cvv);
		session.setAttribute("amount", amount);
		
		try {
			pst.setString(1, name);
			pst.setString(2, cardNumber);
			pst.setString(3, cvv);
			pst.setString(4, amount);
			ResultSet rs = pst.executeQuery();
			
			if(rs.next()) {
				RequestDispatcher rd = request.getRequestDispatcher("authorize");
				rd.forward(request, response);
			}
			else {
				PrintWriter out = response.getWriter();
				
				out.println("<h2>"+session.getId()+" "+ session.isNew()+"</h2>");
				
				out.println("<p style = text-align:center; font-size:50px; font-color:red>Not Persisted</p>");
				RequestDispatcher rd = request.getRequestDispatcher("Authorize_creditcard_amount.html");
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
