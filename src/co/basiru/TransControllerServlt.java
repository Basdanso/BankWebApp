package co.basiru;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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


@WebServlet("/transfers")
public class TransControllerServlt extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static PreparedStatement pst = null;
	
	private Transactions trnsdao;
	
	PrintWriter out = null;


	
	public void init(ServletConfig config) throws ServletException {
		
		super.init(config);

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Edureka","root","");
			pst = con.prepareStatement("insert into transactions (Acno, Amount, Balance, Date) values (?, ?, ?, ?)");
			
    		
			Configuration config1 = new Configuration();
	//		config1.configure("basiru/bean.xml");       // for entering acc details
			config1.configure("co/basiru/configs/hibernate.cfg.xml");
			
			SessionFactory sfactory = config1.buildSessionFactory();
			Session session = sfactory.openSession();
			Transaction tx = session.beginTransaction();
			
			Transactions transactions = new Transactions();
			
			
			// Save student with hibernate
			session.save(transactions);
			
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
	  trnsdao =  new Transactions();
	}
	
	
	

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("Transactions.html");
		
	}
	
	private void transfers(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		
		ServletContext context = getServletContext();
		
		DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDateTime now = LocalDateTime.now();
		String date1 = df.format(now);
		
		
		context.setAttribute("Uid", " ");
		
	//	int id = request.getParameter("id");
		String acno = request.getParameter("acno");
		String amount = request.getParameter("amount");
		String balance = request.getParameter("balance");
		String TrnsDate = request.getParameter("TrnsDate");
//		java.util.Date TrnsDate = request.getParameter("TrnsDate");
		System.out.println(acno +"-"+ amount +"-"+ balance +"-"+ date1);
		
		HttpSession session = request.getSession();
	
		
		Transactions transactions = new Transactions();
//		accountDetails.setId(id);
		transactions.setAcno(acno);
		transactions.setAmount(amount);
		transactions.setBalance(balance);
		transactions.setDate(date1);
		transactions.setDate(TrnsDate);
//		pst.setString(4, date1);
		TransactionsDAO.saveTransaction(transactions);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("display");
		dispatcher.forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			transfers(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
/*
		try {
			String result;
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Edureka","root","");
			
			ServletContext context = getServletContext();
			context.setAttribute("acno", " ");
			
			String Uid = request.getParameter("Uid");
			String pwd = request.getParameter("Pwd");
			
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
	*/

		}
		}



