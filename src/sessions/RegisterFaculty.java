package sessions;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.Faculty;
import models.Student;

/**
 * Servlet implementation class RegisterFaculty
 */
@WebServlet("/sessions/RegisterFaculty")
public class RegisterFaculty extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterFaculty() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//---------------------------------------------------------------------
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String firstName=request.getParameter("firstName");
		String lastName=request.getParameter("lastName");
		String email=request.getParameter("email");
		String password1=request.getParameter("password1");
		String password2=request.getParameter("password2");
		String passwordByDeveloper=request.getParameter("passwordByDeveloper");
		String nameError=(String) request.getAttribute("nameError");
		String emailError=(String) request.getAttribute("emailError");
		String passwordError=(String) request.getAttribute("passwordError");
		
		//---------------------------------------------------------------------
		out.println("<doctype html>\r\n" + 
				"    <html lang=\"en\">\r\n" + 
				"\r\n" + 
				"    <head>\r\n" + 
				"        <meta charset=\"UTF-8\">\r\n" + 
				"        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\r\n" + 
				"        <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css\" integrity=\"sha384-rwoIResjU2yc3z8GV/NPeZWAv56rSmLldC3R/AZzGRnGxQQKnKkoFVhFQhNUwEyJ\"\r\n" + 
				"            crossorigin=\"anonymous\">\r\n" + 
				"        <title> Register </title>\r\n" + 
				"    </head>\r\n" + 
				"    <!-- Body of the page -->\r\n" + 
				"\r\n" + 
				"    <body>\r\n" + 
				"        <!-- Heading of the page -->\r\n" + 
				"        <div class=\"container-fluid\">\r\n" + 
				"            <div class=\"container-fluid text-center\">\r\n" + 
				"                <!-- Header -->\r\n" + 
				"                <div class=\"jumbotron\">\r\n" + 
				"                    <!-- Logo -->\r\n" + 
				"                    <div class=\"navbar-brand\">\r\n" + 
				"                        <h1> Register,\r\n" + 
				"                            <small> New Faculty </small>\r\n" + 
				"                        </h1>\r\n" + 
				"                        <aside title=\"Projects Logo\">\r\n" + 
				"                            <img src=\"/../Images/Logo.png\" alt=\"Logo Picture\">\r\n" + 
				"                        </aside>\r\n" + 
				"\r\n" + 
				"                    </div>\r\n" + 
				"                </div>\r\n" + 
				"                <!-- Content -->\r\n" + 
				"                <forum action \"RegisterFaculty\" method \"post\">\r\n" );
		
		if(nameError!=null){
		out.println(		"                    <div class=\"form-group has-error\">"+"<span class=\"help-block\">"+nameError+"</span>");
		
		out.println(		"                        <label class=\"control-label\"> First Name</label>\r\n" + 
				"                        <input class=\"form-control\" type=\"text\" value=\"\" + firstName + \"\" name=\"fName\" placeholder=\"Enter First Name\">\r\n" + 
				"                    </div>\r\n" + 
				"                    <div class=\"form-group\">\r\n" + 
				"                        <label class=\"control-label\"> Last Name</label>\r\n" + 
				"                        <input class=\"form-control\" type=\"text\" value=\"\" + lastName + \"\" name=\"lName\" placeholder=\" Enter Last Name\">\r\n" + 
				"                    </div>\r\n" + 
				"                    <div class=\"form-group\">\r\n" + 
				"                        <label class=\"control-label\"> Your Email Adress </label>\r\n" + 
				"                        <input class=\"form-control\" type=\"text\" value=\"\" + email + \"\" name=\"username\" placeholder=\"Enter New Email\">\r\n" + 
				"                    </div>\r\n" + 
				"                    <div class=\"form-group\">\r\n" + 
				"                        <label class=\"control-label\"> Password </label>\r\n" + 
				"                        <input class=\"form-control\" type=\"text\" value=\"\" + password1 + \"\" name=\"password1\" placeholder=\"Enter New Password\">\r\n" + 
				"                    </div>\r\n" + 
				"                    <div class=\"form-group\">\r\n" + 
				"                        <label class=\"control-label\"> Retype Password </label>\r\n" + 
				"                        <input class=\"form-control\" type=\"text\" value=\"\" + password2 + \"\" name=\"password2\" placeholder=\"Enter New Password Again\">\r\n" + 
				"                    </div>\r\n" + 
				"                    <div class=\"form-group\">\r\n" + 
				"                        <label class=\"control-label\"> Unique Faculty Password </label>\r\n" + 
				"                        <input class=\"form-control\" type=\"text\" value=\"\" + uniqueFPass + \"\" name=\"uniqueFPass\" placeholder=\"Enter the Password Given By Developer\">\r\n" + 
				"                    </div>\r\n" + 
				"                    <button type=\"submit\" class=\"btn btn-primary\">Register New Faculty</button>\r\n" + 
				"                </forum>\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"                <!-- Footer of the page -->\r\n" + 
				"                <div>\r\n" + 
				"                    <footer class=\"footer \">\r\n" + 
				"                        <!-- Mini Naviation-->\r\n" + 
				"                        <div class=\"container text-center\">\r\n" + 
				"                            <nav class=\"navbar navbar-toggleable-md navbar-light bg-faded\">\r\n" + 
				"                                <button class=\"navbar-toggler navbar-toggler-right\" type=\"button\" data-toggle=\"collapse\" data-target=\"#navbarSupportedContent\"\r\n" + 
				"                                    aria-controls=\"navbarSupportedContent\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\r\n" + 
				"                                    <span class=\"navbar-toggler-icon\"></span>\r\n" + 
				"                                </button>\r\n" + 
				"                                <!-- Logo -->\r\n" + 
				"                                <div class=\"navbar-brand\">\r\n" + 
				"                                    <aside title=\"Projects Logo\">\r\n" + 
				"                                        <img src=\"/../Images/Logo.png\" alt=\"Logo Picture\">\r\n" + 
				"                                    </aside>\r\n" + 
				"                                </div>\r\n" + 
				"                                <div class=\"collapse navbar-collapse\" id=\"navbarSupportedContent\">\r\n" + 
				"                                    <ul class=\"navbar-nav mr-auto\">\r\n" + 
				"                                        <li class=\"nav-item active\">\r\n" + 
				"                                            <a class=\"nav-link\" href=\"Login\">Login\r\n" + 
				"                                                <span class=\"sr-only\">(current)</span>\r\n" + 
				"                                            </a>\r\n" + 
				"                                        </li>\r\n" + 
				"                                        <li class=\"nav-item\">\r\n" + 
				"                                            <a class=\"nav-link\" href=\"/Almanac/Info/Help\">Help</a>\r\n" + 
				"                                        </li>\r\n" + 
				"                                        <li class=\"nav-item\">\r\n" + 
				"                                            <a class=\"nav-link\" href=\"/Almanac/Info/ContactAlmanac\">Contact and Suggestions </a>\r\n" + 
				"                                        </li>\r\n" + 
				"                                        <li class=\"nav-item\">\r\n" + 
				"                                            <a class=\"nav-link disabled\">Forum</a>\r\n" + 
				"                                        </li>\r\n" + 
				"                                        <li class=\"nav-item\">\r\n" + 
				"                                            <a class=\"nav-link disabled\">Recomendations and Modifications</a>\r\n" + 
				"                                        </li>\r\n" + 
				"                                        <li class=\"nav-item\">\r\n" + 
				"                                            <a class=\"nav-link disabled\">Calendar</a>\r\n" + 
				"                                        </li>\r\n" + 
				"                                    </ul>\r\n" + 
				"                                </div>\r\n" + 
				"                            </nav>\r\n" + 
				"                            <p class=\"p1\">&copy;2017 Almanac, All Rights Reserve.</p>\r\n" + 
				"                        </div>\r\n" + 
				"                </div>\r\n" + 
				"                <!-- Other Resources Needed By Bootstrap -->\r\n" + 
				"                <script src=\"https://code.jquery.com/jquery-3.1.1.slim.min.js\" integrity=\"sha384-A7FZj7v+d/sdmMqp/nOQwliLvUsJfDHW+k9Omg/a/EheAdgtzNs3hpfag6Ed950n\"\r\n" + 
				"                    crossorigin=\"anonymous\"></script>\r\n" + 
				"                <script src=\"https://cdnjs.cloudflare.com/ajax/libs/tether/1.4.0/js/tether.min.js\" integrity=\"sha384-DztdAPBWPRXSA/3eYEEUWrWCy7G5KFbe8fFjk5JAIxUYHKkDx6Qin1DkWx51bBrb\"\r\n" + 
				"                    crossorigin=\"anonymous\"></script>\r\n" + 
				"                <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/js/bootstrap.min.js\" integrity=\"sha384-vBWWzlZJ8ea9aCX4pEW3rVHjgjt7zpkNpZk+02D9phzyeVkE+jo0ieGizqPLForn\"\r\n" + 
				"                    crossorigin=\"anonymous\"></script>\r\n" + 
				"                </footer>\r\n" + 
				"            </div>\r\n" + 
				"    </body>\r\n" + 
				"\r\n" + 
				"    </html>");
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	boolean emailInUse(String email){
		ArrayList<Student>students=(ArrayList<Student>) getServletContext().getAttribute("students");
		for (Student student: students){
			if (student.getEmail().toLowerCase().matches(email.toLowerCase()))
				return true;
		}
		return false;
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String firstName=request.getParameter("firstName");
		String lastName=request.getParameter("lastName");
		String email=request.getParameter("email");
		String password1=request.getParameter("password1");
		String password2=request.getParameter("password2");
		String passwordByDeveloper=request.getParameter("passwordByDeveloper");
		
		boolean hasError=false;
		if (firstName==null||firstName.matches("[a-zA-Z]{2,} [a-zA-Z]{2,}")){
			request.setAttribute("nameError","You must enter a first name");
			hasError=true;
		}
		if (lastName==null||lastName.matches("[a-zA-Z]{2,} [a-zA-Z]{2,}")){
			request.setAttribute("nameError","You must enter a last name");
			hasError=true;
		}
		if (email==null||email.trim().length()==0){
			request.setAttribute("emailError", "You must enter an email");
			hasError=true;
		}
		else if(emailInUse(email)){
			request.setAttribute("emailError", "This email is already registered");
			hasError=true;
		}
		if (password1==null||password1.trim().length()==0){
			request.setAttribute("passwordError", "You must enter a password");
            hasError=true;
		}
		else if (password2==null||!password1.equals(password2)){
			request.setAttribute("passwordError", "Passwords don't match");
			hasError=true;
		}
		if(passwordByDeveloper==null||passwordByDeveloper.trim().length()==0){
			request.setAttribute("passwordError", "Password you enter does not match any password provided by developer");
		    hasError=true;
		}
		if (hasError){
			doGet(request, response);
			return;
			}
		else{
			ArrayList<Faculty> faculties=(ArrayList<Faculty>) getServletContext().getAttribute("faculties");
			Faculty newFaculty=new Faculty(firstName, lastName, email, password1, passwordByDeveloper);
			faculties.add(newFaculty);
			HttpSession session=request.getSession();
			session.setAttribute("authenticatedFaculty", newFaculty);
			response.sendRedirect("LoginSession");
			return;
		}
		
	}

}
