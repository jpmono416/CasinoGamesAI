package servlets;

import java.io.IOException;
import java.util.List;
import java.util.Map;

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
		Map<String, String[]> reqParams = request.getParameterMap();
		
		
		String actionParam = reqParams.get("action")[0];
		SimulatorFunctions functionsObject = (SimulatorFunctions) request.getSession().getAttribute("functionsObject");
		String jsonString;
		
		switch(actionParam)
		{
		// No bets taken into account so far, just draw new card
		case "double" :	
		case "drawCard" :
			functionsObject.drawExtraCustomerCards();
			jsonString = functionsObject.generateJSON(functionsObject.getCustomer());
			response.getWriter().write(jsonString);
			
			break;
		case "split" :
			
		case "stay" :
			functionsObject.drawAllDealerCards();
			jsonString = functionsObject.generateJSON(functionsObject.getDealer());
			response.getWriter().write(jsonString);
			break;
		case "updateStats" :
			HttpSession session = request.getSession();
			
			System.out.println("P: " + reqParams.get("played")[0] + "/ W: " + reqParams.get("won")[0] 
					+ "/ L: " + reqParams.get("lost")[0] + "/ wl: " + reqParams.get("wl")[0]);
			
			session.setAttribute("handsPlayed", reqParams.get("played")[0]);
			session.setAttribute("handsWon", reqParams.get("won")[0]);
			session.setAttribute("handsLost", reqParams.get("lost")[0]);
			session.setAttribute("WLRatio", reqParams.get("wl")[0]);
			System.out.println("All updated"); 
			break;
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
