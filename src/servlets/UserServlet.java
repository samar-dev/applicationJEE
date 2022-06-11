package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.plaf.synth.SynthOptionPaneUI;

import org.json.simple.JSONObject;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;

import dao.Userdao;
import domaine.User;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet( name="UserServlet",  urlPatterns = { "/Authentifier", "/Consulter" , "/Ajouter"  , "/Users"  ,"/Lister","/Deconnecter"})
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static int  userCountConnected=0;
	Userdao dao;
	private static JSONObject simpleJo;  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @throws IOException 
	 * @throws ServletException 
	 * @see Servlet#init(ServletConfig)
	 */
    
    @SuppressWarnings("unused")
	private void demandeListeUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	 String nextJSP = "/jsp/listuser.jsp";
    	 RequestDispatcher pageWeb= null;
    	 request.setAttribute("usersList", dao.getAll());
    	 System.out.println("Avant Page :"+nextJSP+" ; nbre :"+dao.getAll().size());
      	try {
      		 pageWeb  =request.getRequestDispatcher(nextJSP);
        	   
      		pageWeb.forward(request, response); 
      	}catch(Exception ex) {
      		
      		System.out.println("Erreur : "+ex.getMessage());
      	}
      
      	 System.out.println("Apres Page :"+nextJSP+" ; nbre :"+dao.getAll().size());
      	
    	
    	 
    }
    
    
    private void demandeListeUser2(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
   	 String nextJSP = "/listuser2.jsp";
   	 RequestDispatcher pageWeb= null;
   	 HttpSession session = request.getSession();
   	  System.out.println("Avant Page :"+nextJSP+" ; nbre :"+dao.getAll().size());
     	try {
     		
     		 
     		ArrayList<User> users=new ArrayList<User>();
     		users= (ArrayList<User>) dao.getAll();
     		 
     		session.setAttribute("users", users);
     		
     		
     		 pageWeb  =request.getRequestDispatcher(nextJSP);
       	   
     		pageWeb.forward(request, response); 
     	}catch(Exception ex) {
     		
     		System.out.println("Erreur : "+ex.getMessage());
     	}
     
     	 System.out.println("Apres Page :"+nextJSP+" ; nbre :"+dao.getAll().size());
     	
   	
   	 
   }
    
    private void demandeData(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	simpleJo=new JSONObject();
    	Gson gson= new Gson();
    	String actString =request.getParameter("act");
    	ArrayList<User> list =new ArrayList<>();
    	if (actString.equals("show")){
    		list=(ArrayList<User>) dao.getAll();
    		JsonElement element =gson.toJsonTree(list, new TypeToken<List<User>>(){
    		}.getType());
    		JsonArray ja = element.getAsJsonArray();
    		response.setContentType("application/json");
    		simpleJo.put("status",true);
    		simpleJo.put("result",ja);
    		response.getWriter().print(simpleJo);
    		}
   	
   	 
   }
    private void demandeLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String msg="";
    	HttpSession session= request.getSession();
    	 String strlogin =request.getParameter("username").toString();
    	 String strpwd =request.getParameter("password").toString();
    		 
    	 User u=dao.verifierLogin(strlogin,strpwd);
    	 if (u!=null) {
    		 //Utilisateur trouvé
    		 msg ="Bienvenu cher utilisateur";
    			 
    			request.setAttribute("message", msg );
    			session.setAttribute("user", u);
    			
    			request.getRequestDispatcher("jsp/listuser.jsp").forward(request, response);
    	
    	 }else {
    		 //Utilisateur erroné
    		 
    			 msg="Veuillez vérifier votre login et mot de passe";
    			 	request.setAttribute("msgErreur",  msg);
    				
    				request.getRequestDispatcher("login.jsp").forward(request, response);
    			
    	 }
    }
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		userCountConnected=0;
	 	dao=new Userdao();
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	 

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
	
String path=request.getServletPath() ;
	
 
		String modeEnvoie =request.getMethod();
		System.out.println("chemin "+ path + "Mode : "+modeEnvoie);
String msg="test";
if (path.equals("/Authentifier"))
	msg ="Page Login";
 
if (path.equals("/Ajouter")) {
	 msg ="Page Nouveau Utilisateur" ;
	 
}
//Cas d'authentification
 if (path.equals("/Authentifier")&& modeEnvoie.equals("POST") ) 
 {
	 demandeLogin(request,response);
	 
	}
 
 if (path.equals("/Users")&& modeEnvoie.equals("GET") ) 
 {
	 demandeData(request,response);
	 
	}
 
 
 if (path.equals("/Consulter")&& modeEnvoie.equals("GET") ) 
 {
	 
	 demandeListeUser(request,response);
	 
	}
 
 if (path.equals("/Lister")&& modeEnvoie.equals("GET") ) 
 {
	 
	 demandeListeUser2(request,response);
	 
	}
	
	
	
	
	}
	
	

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
	 
	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
