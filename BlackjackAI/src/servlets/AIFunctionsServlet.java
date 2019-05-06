package servlets;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import functions.AIFunctions;
import functions.SimulatorFunctions;

/**
 * Servlet implementation class AIFunctionsServlet
 */
@WebServlet("/AIFunctions")
public class AIFunctionsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AIFunctionsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Map<String, String[]> reqParams = request.getParameterMap();
		HttpSession session = request.getSession();
		
		String actionParam = reqParams.get("action")[0];
		SimulatorFunctions functionsObject = (SimulatorFunctions) session.getAttribute("functionsObject");
		System.out.println(new ObjectMapper().writeValueAsString(functionsObject)); // TODO DELETE
		String jsonString;
		
		switch(actionParam)
		{
			case "autoGame" :
				
				// Set all prerequisites
				AIFunctions aiFunct = new AIFunctions();
				aiFunct.setSimFuncts(functionsObject);
				aiFunct.setAmountOfHands(Integer.parseInt(reqParams.get("amountOfHands")[0]));
				
				// Start game
				aiFunct.autoGame();
				
				try
				{
					jsonString = new ObjectMapper().writeValueAsString(aiFunct);
					response.getWriter().write(jsonString);
				} catch(JsonProcessingException e) { e.printStackTrace(); }
				
				break;
				
				default : 
					request.getRequestDispatcher("WEB-INF/aiScreen.jsp").forward(request, response);
					break;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
