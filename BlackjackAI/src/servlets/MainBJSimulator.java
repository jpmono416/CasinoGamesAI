package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		HttpSession session = request.getSession();
		session.setAttribute("functionsObject", functs);
		
		if(session.getAttribute("handsPlayed") == null)
		{
			session.setAttribute("handsPlayed", 0);

		}
		if(session.getAttribute("handsWon") == null)
		{
			session.setAttribute("handsWon", 0);

		}
		if(session.getAttribute("handsLost") == null)
		{
			session.setAttribute("handsLost", 0);

		}
		if(session.getAttribute("WLRatio") == null)
		{
			session.setAttribute("WLRatio", 0);

		}
		
		request.getRequestDispatcher("WEB-INF/mainBJScreen.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
