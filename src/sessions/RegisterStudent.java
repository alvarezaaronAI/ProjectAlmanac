package sessions;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegisterStudent
 */
@WebServlet("/sessions/RegisterStudent")
public class RegisterStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterStudent() {
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
				"                            <small> New Student</small>\r\n" + 
				"                        </h1>\r\n" + 
				"                        <aside title=\"Projects Logo\">\r\n" + 
				"                            <img src=\"/../Images/Logo.png\" alt=\"Logo Picture\">\r\n" + 
				"                        </aside>\r\n" + 
				"\r\n" + 
				"                    </div>\r\n" + 
				"                </div>\r\n" + 
				"                <!-- Content -->\r\n" + 
				"                <forum action \"RegisterStudent\" method \"post\">\r\n" + 
				"                    <div class=\"form-group\">\r\n" + 
				"                        <label class=\"control-label\"> First Name</label>\r\n" + 
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
				"                    <button type=\"submit\" class=\"btn btn-primary\">Register New Student</button>\r\n" + 
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
				"                                        <img src=\"/../Images/Logo.png\" alt=\"Logo Picture \">\r\n" + 
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
