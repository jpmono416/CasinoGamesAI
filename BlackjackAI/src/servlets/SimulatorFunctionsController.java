package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import functions.SimulatorFunctions;
import models.Customer;
import models.Dealer;

/**
 * Servlet implementation class SimulatorFunctions
 */
@WebServlet("/SimulatorFunctions")
public class SimulatorFunctionsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SimulatorFunctionsController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String actionParam = request.getParameter("action");
		SimulatorFunctions functionsObject = (SimulatorFunctions) request.getSession().getAttribute("functionsObject");
		
		
		switch(actionParam)
		{
		// No bets taken into account so far, just draw new card
		case "double" :	
		case "drawCard" :
			functionsObject.drawExtraCustomerCards();
				
		case "split" :
			
		case "stay" :
			functionsObject.drawAllDealerCards();
		}
		request.getSession().setAttribute("functionsObject", functionsObject);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}