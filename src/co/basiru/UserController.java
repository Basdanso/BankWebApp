package co.basiru;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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
import org.springframework.orm.hibernate5.HibernateTemplate;



@WebServlet("/register")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static PreparedStatement pst = null;
	
	private AccountDetails accountDetailsDao;
	
	PrintWriter out = null;
	
//	private static PreparedStatement pst = null;

	public void init(ServletConfig config) throws ServletException {
		
		super.init(config);
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Edureka","root","");
			pst = con.prepareStatement("insert into accountdetails (Acno, Name, DOB, Address, Email, AccType, Id) values (?, ?, ?, ?, ?, ?, ?)");
			
			Configuration config1 = new Configuration();
	//		config1.configure("basiru/bean.xml");       // for entering acc details
	//		config1.configure("co/basiru/configs/hibernate.cfg.xml");
			
			SessionFactory sfactory = config1.buildSessionFactory();
			Session session = sfactory.openSession();
			Transaction tx = session.beginTransaction();
			
			AccountDetails accountDetails = new AccountDetails();
			
			// Save student with hibernate
			session.save(accountDetails);
			
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
	  accountDetailsDao =  new AccountDetails();
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.sendRedirect("account_creation.html");
	}
	
	private void register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ServletContext context = getServletContext();
		context.setAttribute("Uid", " ");
		
	//	int id = request.getParameter("id");
		String acno = request.getParameter("acno");
		String name = request.getParameter("name");
		String dob = request.getParameter("DOB");
		String address = request.getParameter("address");
		String email = request.getParameter("email");
		String accType = request.getParameter("accounts");
		
		HttpSession session = request.getSession();
		session.setAttribute("acno", acno);
		session.setAttribute("name", name);
		session.setAttribute("DOB", dob);
		session.setAttribute("address", address);
		session.setAttribute("email", email);
		session.setAttribute("accType", accType);
		
		AccountDetails accountDetails = new AccountDetails();
//		accountDetails.setId(id);
		accountDetails.setAcno(acno);
		accountDetails.setName(name);
		accountDetails.setDob(dob);
		accountDetails.setAddress(address);
		accountDetails.setEmail(email);
		accountDetails.setAccType(accType);
		AccountDetailsDAO.saveAccountDetails(accountDetails);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("display");
		dispatcher.forward(request, response);
		
	}


	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		register(request, response);
		
		try {
			String result;
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Edureka","root","");
			
			ServletContext context = getServletContext();
			context.setAttribute("acno", " ");
			
			String Uid = request.getParameter("Uid");
			String pwd = request.getParameter("Pwd");
			
			HttpSession session = request.getSession();
			
			pst = con.prepareStatement("select * from user_pass where username = ? and password = ?");
			pst.setString(1, Uid);
			pst.setString(2, pwd);
			ResultSet rs = pst.executeQuery();
			
			boolean row = false;
			
			row = rs.next();
			
			if (row == true) {
				
				result = rs.getString(2);
				context.setAttribute("acno", result);
				
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/secondservlet");
				
				if(dispatcher == null) {
					
				}
				dispatcher.forward(request, response);
				con.close();
			}
			else {
				out = response.getWriter();
				response.setContentType("text/html");
				out.println("<html>");
				out.println("<body bgcolor=pink>");
				out.println("Please check the Accno and Balance");
				out.println("</body>");
				out.println("</html>");
				out.close();
			}
			
		} catch (Exception ex) {
			
			
		}
	}
	


}

	
