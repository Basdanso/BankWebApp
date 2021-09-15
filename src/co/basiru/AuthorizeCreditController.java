package co.basiru;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
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

/**
 * Servlet implementation class AuthorizeCreditController
 */
@WebServlet("/authorize")
public class AuthorizeCreditController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static PreparedStatement pst = null;
	
	
	private AuthorizeCredit authorizeCreditDao;
	
	PrintWriter out = null;
       

	
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Edureka","root","");
			pst = con.prepareStatement("insert into authorize_credit ( name, cardNumber, cvv, amount) values (?, ?, ?, ?)");
			
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
			
		}
		catch (Exception ex) {
			System.out.println(ex.toString());
		}
		
	}
	
	public void init() {
		  authorizeCreditDao =  new AuthorizeCredit();
		}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("Authorize_creditcard_amount.html");

	}
	
	private void authorize(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ServletContext context = getServletContext();
		context.setAttribute("Uid", " ");
		
		String name = request.getParameter("name");
		String cardNumber = request.getParameter("cardNumber");
		String cvv = request.getParameter("cvv");
		String amount = request.getParameter("amount");
		
		HttpSession session = request.getSession();
		session.setAttribute("name", name);
		session.setAttribute("cardNumber", cardNumber);
		session.setAttribute("cvv", cvv);
		session.setAttribute("amount", amount);
		
		AuthorizeCredit authorizeCredit = new AuthorizeCredit();
//		accountDetails.setId(id);
		authorizeCredit.setName(name);
		authorizeCredit.setCardNumber(cardNumber);
		authorizeCredit.setCvv(cvv);
		authorizeCredit.setAmount(amount);
		AuthorizeCreditDAO.saveCredit(authorizeCredit);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("display");
		dispatcher.forward(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
