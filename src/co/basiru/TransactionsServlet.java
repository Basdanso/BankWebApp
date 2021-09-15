package co.basiru;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Set;

import javax.persistence.TypedQuery;
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

import co.basiru.configs.HibernateUtils;


@WebServlet("/Transactions")
public class TransactionsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static PreparedStatement pst = null;
	
	public void init(ServletConfig config) throws ServletException {
		
		super.init(config);
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Edureka","root","");
			pst = con.prepareStatement("insert into transactions (Acno, Amount, Balance, Date) values (?, ?, ?, ?)");
		} catch(Exception ex) {
			System.out.println(ex.toString());
		}
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
			
			ServletContext context = getServletContext();
			DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			LocalDateTime now = LocalDateTime.now();
			String date = df.format(now);
			context.setAttribute("Uid", " ");
			
		//	int id = request.getParameter("id");
			String acno = request.getParameter("acno");
			String amount = request.getParameter("amount");
			String balance = request.getParameter("balance");
			String TrnsDate = request.getParameter("TrnsDate");
			System.out.println(acno +"-"+ amount +"-"+ balance +"-"+ date);
			
			HttpSession session = request.getSession();   // to create session
			session.setAttribute("acno", acno);
			session.setAttribute("amount", amount);
			session.setAttribute("balance", balance);
			session.setAttribute("TrnsDate", date);
			
			out.println("<body bgcolor=cyan>");
			out.println("<h2>"+session.getId()+" "+ session.isNew()+"</h2>");
			out.println("</body>");
		
			
			Transactions transactions = new Transactions();
//			accountDetails.setId(id);
			transactions.setAcno(acno);
			transactions.setAmount(amount);
			transactions.setBalance(balance);
			transactions.setDate(TrnsDate);
		//	pst.setString(4, date);
			TransactionsDAO.saveTransaction(transactions);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("transfers");
			dispatcher.forward(request, response);
		
		
		
	
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		SessionFactory sf = HibernateUtils.getSessionFactory();
		Session session = sf.openSession();
		
		PrintWriter out = response.getWriter();

  //      Bank bank = new Bank();
        
		BankAccount account = new BankAccount();
	int amount = 0;
		//	account.withdraw(300);
		account.transferFunds(account, amount);
	
		Bank AccountDetails = Bank.getAccountDetails(request.getParameter("id"));
		if (AccountDetails == null) {
			out.println("Unknown account"); // I can create a error page for this and direst response.
		}
		else {
			out.println("Account exist");
			RequestDispatcher dispatcher = request.getRequestDispatcher("transfers");
			dispatcher.forward(request, response);
		}

	//	bank.deposit();
	//	bank.withdraw();
	//	Bank.transfer();
	
		
		
		String hql = "from co.basiru.Transactions";
		TypedQuery<Transactions> query = session.createQuery(hql);
		
		List<Transactions> transactions = query.getResultList();
		
		for(Transactions tx : transactions) {
			System.out.println(tx);
		}
	}

}
