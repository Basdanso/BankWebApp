package co.basiru;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/admin")
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		response.setContentType("text/html");
		
		HttpSession session = request.getSession();
		
		PrintWriter out = response.getWriter();
		out.println("<html><body style=background-color:teal;text-align:center>");
		out.println("<h2>Banking System</h2>");
		out.println("<hr>");
		out.println("Hello "+request.getParameter("Uid"));
		out.println(("<a href = account_creation.html><h3 style=text-align:left>Create Account</h3></a>"));
		out.println(("<a href = Transactions.html><h3 style=text-align:left>Transactions</h3></a>"));
		out.println(("<a href = Display_statement.html><h3 style=text-align:left>Display bank statement</h3></a>"));
		out.println(("<a href = Authorize_creditcard_amount.html><h3 style=text-align:left>Authorize credit card amount</h3></a>"));
		out.println("</body></html>");

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
