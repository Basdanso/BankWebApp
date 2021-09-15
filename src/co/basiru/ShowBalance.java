package co.basiru;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/balance")
public class ShowBalance extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		Bank AccountDetails = Bank.getAccountDetails(request.getParameter("acno"));
		if (AccountDetails == null) {
			out.println("Unknown account"); // I can create a error page for this and direst response.
		} else if (Bank.getBalance() > 0) {
			out.println("Known account");
		}
		else {
			out.println("Account exist");
			RequestDispatcher dispatcher = request.getRequestDispatcher("Transactions");
			dispatcher.forward(request, response);
		}
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
