package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import functions.SimulatorFunctions;
import models.Card;
import models.Customer;
import models.Dealer;
/**
 * Servlet implementation class MainBJFunctions
 */
@WebServlet("/MainBJSimulator")
public class MainBJSimulator extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainBJSimulator() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		SimulatorFunctions functs = new SimulatorFunctions();
		Customer customer = functs.getCustomer();
		Dealer dealer = functs.getDealer();
		Card cCard1 = customer.getCards().get(0);
		Card cCard2 = customer.getCards().get(1);
		Card dCard = dealer.getCards().get(0);
		
		System.out.println("Player cards: " + cCard1.getSuit() +cCard1.getValue() + ", "+ cCard2.getSuit() + cCard2.getValue()
				+ " Dealers cards: " + dCard.getSuit() + dCard.getValue());
		request.getSession().setAttribute("functionsObject", functs);
		request.getRequestDispatcher("WEB-INF/mainBJScreen.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
