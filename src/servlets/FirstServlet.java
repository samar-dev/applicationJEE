package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FirstServlet
 */
@WebServlet(urlPatterns = { "/DemandeConnexion"  })
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FirstServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("La méthode Get est invoqué de votre Servlet");
		
		// Récupération des données depuis le formulaire login.html (attribut name)+
		 
		
		// Solution 1 : Réponse depuis la classe Servlet
		/*
		 * if (strlogin.equals("admin")&& strpwd.equals("admin")) {
		 * response.getWriter().append(" Bienvenu"); }else {
		 * response.getWriter().append(" Erreur de login"); }
		 */
		/*
		 * // Solution 2: Réponse : chargement d'une page Web  HTML
		 * if
		 * (strlogin.equals("admin")&& strpwd.equals("admin")) {
		 * request.getRequestDispatcher("bootstrap/index.html").forward(request,
		 * response); }else {
		 * request.getRequestDispatcher("login.html").forward(request, response); }
		 */
				
				// Solution 3: Réponse : chargement d'une page Web JSP (comportement dynamique avec des messages)
		
		
		String vmsg="";	
		
		String path=request.getServletPath() ;
		if (path.equals("/DemandeConnexion")){ 
			String strlogin =request.getParameter("username").toString();
			String strpwd =request.getParameter("password").toString();
		
			if (strlogin.equals("admin")&& strpwd.equals("admin")) {
				vmsg="Bienvenu cher utilisateur";
				// Transemettre la variable / l'objet "vmsg"
				//  -> 1 solution via l'objet request
				request.setAttribute("message", vmsg);
				
				
				request.getRequestDispatcher("bootstrap/index.jsp").forward(request, response);
			}else
			{
				vmsg="Veuillez vérifier votre login et mot de passe";
			//
			//  -> 1 solution via l'objet request
				request.setAttribute("msgErreur", vmsg);
				
				request.getRequestDispatcher("login.jsp").forward(request, response);
				}
			
		} else
			
		if (path.equals("/DemandeDeconnexion")){
			request.getRequestDispatcher("login.jsp").forward(request, response);
			
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
