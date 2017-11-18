package Info;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Help
 */
@WebServlet("/Info/Help")
public class Help extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Help() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//---------------------------------------------------------------------
				// Set the content type
				response.setContentType("text/html");
				// Get a reference to the PrintWriter that lets us talk to the client
				PrintWriter out = response.getWriter();
				//---------------------------------------------------------------------
				// Set the content type	
				out.println("<doctype html>\r\n" + 
						"    <html lang=\"en\">\r\n" + 
						"\r\n" + 
						"    <head>\r\n" + 
						"        <meta charset=\"UTF-8\">\r\n" + 
						"        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\r\n" + 
						"        <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css\" integrity=\"sha384-rwoIResjU2yc3z8GV/NPeZWAv56rSmLldC3R/AZzGRnGxQQKnKkoFVhFQhNUwEyJ\"\r\n" + 
						"            crossorigin=\"anonymous\">\r\n" + 
						"        <title> Help </title>\r\n" + 
						"        <style type=\"text/css\">\r\n" + 
						"            .control-label {\r\n" + 
						"                font-weight: bold;\r\n" + 
						"            }\r\n" + 
						"\r\n" + 
						"            .legend-text {\r\n" + 
						"                font-weight: bold;\r\n" + 
						"            }\r\n" + 
						"\r\n" + 
						"            .body-main {\r\n" + 
						"                background-color: beige;\r\n" + 
						"            }\r\n" + 
						"\r\n" + 
						"            .mini-boxes {\r\n" + 
						"                background-color: darkcyan;\r\n" + 
						"            }\r\n" + 
						"\r\n" + 
						"            .nav-link {\r\n" + 
						"                font-weight: bold;\r\n" + 
						"            }\r\n" + 
						"\r\n" + 
						"            body {\r\n" + 
						"                zoom: 80%;\r\n" + 
						"            }\r\n" + 
						"			\r\n" + 
						"			textarea {\r\n" + 
						"			 \r\n" + 
						"	\r\n" + 
						"	width: 50%;\r\n" + 
						"	margin-top: 5px;\r\n" + 
						"	margin-bottom: 5px;	\r\n" + 
						"	\r\n" + 
						"	height: 60px;\r\n" + 
						"			}\r\n" + 
						"        </style>\r\n" + 
						"    </head>\r\n" + 
						"\r\n" + 
						"    <body class=\"body-main\">\r\n" + 
						"        <div class=\"container-fluid\">\r\n" + 
						"            <!-- Heading of the Page -->\r\n" + 
						"            <div class=\"jumbotron text-center mini-boxes\">\r\n" + 
						"                <h1> Help</h1>\r\n" + 
						"                <aside title=\"Projects Logo\">\r\n" + 
						"                    <img width=\"150px\" height=\"150px\" src=\"http://cs3.calstatela.edu:8080/cs3337stu10/Images/Logo.png\" alt=\"Logo Picture\">\r\n" + 
						"                </aside>\r\n" + 
						"            </div>\r\n" + 
						"            <!-- Content -->\r\n" + 
						"			<h2>Most Popular Questions</h2>\r\n" + 
						"			\r\n" + 
						"			<div id=\"accordion\" role=\"tablist\" aria-multiselectable=\"true\">\r\n" + 
						"  <div class=\"card\">\r\n" + 
						"    <div class=\"card-header\" role=\"tab\" id=\"headingOne\">\r\n" + 
						"      <h5 class=\"mb-0\">\r\n" + 
						"        <a data-toggle=\"collapse\" data-parent=\"#accordion\" href=\"#collapseOne\" aria-expanded=\"true\" aria-controls=\"collapseOne\">\r\n" + 
						"          Register Questions\r\n" + 
						"        </a>\r\n" + 
						"      </h5>\r\n" + 
						"    </div>\r\n" + 
						"	\r\n" + 
						"\r\n" + 
						"    <div id=\"collapseOne\" class=\"collapse show\" role=\"tabpanel\" aria-labelledby=\"headingOne\">\r\n" + 
						"      <div class=\"card-block\">\r\n" + 
						"        <p>If you register as a student, please enter your first name, last name, email address, set a password and retype that password.</p>\r\n" + 
						"		<p>If you register as a faculty, besides everything mentioned above, please also enter the password provided by developer. Ask developers for more details.</p>\r\n" + 
						"      </div>\r\n" + 
						"    </div>\r\n" + 
						"  </div>\r\n" + 
						"  <div class=\"card\">\r\n" + 
						"    <div class=\"card-header\" role=\"tab\" id=\"headingTwo\">\r\n" + 
						"      <h5 class=\"mb-0\">\r\n" + 
						"        <a class=\"collapsed\" data-toggle=\"collapse\" data-parent=\"#accordion\" href=\"#collapseTwo\" aria-expanded=\"false\" aria-controls=\"collapseTwo\">\r\n" + 
						"          Login Questions\r\n" + 
						"        </a>\r\n" + 
						"      </h5>\r\n" + 
						"    </div>\r\n" + 
						"    <div id=\"collapseTwo\" class=\"collapse\" role=\"tabpanel\" aria-labelledby=\"headingTwo\">\r\n" + 
						"      <div class=\"card-block\">\r\n" + 
						"        <p>Please enter the email and password you used to register. Note that the password here is not the password provided by developer.</p>\r\n" + 
						"      </div>\r\n" + 
						"    </div>\r\n" + 
						"  </div>\r\n" + 
						"  <div class=\"card\">\r\n" + 
						"    <div class=\"card-header\" role=\"tab\" id=\"headingThree\">\r\n" + 
						"      <h5 class=\"mb-0\">\r\n" + 
						"        <a class=\"collapsed\" data-toggle=\"collapse\" data-parent=\"#accordion\" href=\"#collapseThree\" aria-expanded=\"false\" aria-controls=\"collapseThree\">\r\n" + 
						"          Other Questions\r\n" + 
						"        </a>\r\n" + 
						"      </h5>\r\n" + 
						"    </div>\r\n" + 
						"    <div id=\"collapseThree\" class=\"collapse\" role=\"tabpanel\" aria-labelledby=\"headingThree\">\r\n" + 
						"      <div class=\"card-block\">\r\n" + 
						"       <p>If you have any other questions, feel free to leave a message and your contact information here, we will reply to you as soon as possible.</p>\r\n" + 
						"	   <form action=\"myform.cgi\">\r\n" + 
						"			 \r\n" + 
						"			 <!--<input type=\"questions\" name=\"questions\" id=\"questions\" maxlength=\"200\">-->\r\n" + 
						"			 <label for=\"questions\">Enter Your Questions Here</label></br>\r\n" + 
						"			 \r\n" + 
						"			 <textarea></textarea></br>\r\n" + 
						"			 <input type=\"submit\" value=\"Submit\">\r\n" + 
						"			 \r\n" + 
						"			 </form>\r\n" + 
						"			 \r\n" + 
						"			 \r\n" + 
						"      </div>\r\n" + 
						"    </div>\r\n" + 
						"  </div>\r\n" + 
						"</div>\r\n" + 
						"			\r\n" + 
						"            <!-- Log Out Button -->\r\n" + 
						"            <div class=\"text-center\">\r\n" + 
						"                <form action=\"LogoutSessions\" method=\"get\">\r\n" + 
						"                    <a class=\"btn btn-primary\" href=\"../sessions/Logout\">Log Out</a>\r\n" + 
						"                </form>\r\n" + 
						"            </div>\r\n" + 
						"            <!-- Footer of the page -->\r\n" + 
						"            <div>\r\n" + 
						"                <footer class=\"footer \">\r\n" + 
						"                    <!-- Mini Naviation-->\r\n" + 
						"                    <div class=\"container text-center\">\r\n" + 
						"                        <nav class=\"navbar navbar-toggleable-md navbar-light bg-faded mini-boxes\">\r\n" + 
						"                            <button class=\"navbar-toggler navbar-toggler-right\" type=\"button\" data-toggle=\"collapse\" data-target=\"#navbarSupportedContent\"\r\n" + 
						"                                aria-controls=\"navbarSupportedContent\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\r\n" + 
						"                                <span class=\"navbar-toggler-icon\"></span>\r\n" + 
						"                            </button>\r\n" + 
						"                            <!-- Logo -->\r\n" + 
						"                            <div class=\"navbar-brand\">\r\n" + 
						"                                <aside title=\"Projects Logo\">\r\n" + 
						"                                    <img width=\"150px\" height=\"150px\" src=\"http://cs3.calstatela.edu:8080/cs3337stu10/Images/Logo.png\" alt=\"Logo Picture\">\r\n" + 
						"                                </aside>\r\n" + 
						"                            </div>\r\n" + 
						"                            <div class=\"collapse navbar-collapse\" id=\"navbarSupportedContent\">\r\n" + 
						"                                <ul class=\"navbar-nav mr-auto\">\r\n" + 
						"                                    <li class=\"nav-item active\">\r\n" + 
						"                                        <a class=\"nav-link\" href=\"../sessions/Login\">Login\r\n" + 
						"                                            <span class=\"sr-only\">(current)</span>\r\n" + 
						"                                        </a>\r\n" + 
						"                                    </li>\r\n" + 
						"                                    <li class=\"nav-item\">\r\n" + 
						"                                        <form action=\"LogoutSessions\" method=\"get\">\r\n" + 
						"                                            <a class=\"nav-link\" href=\"../sessions/Logout\">Log Out</a>\r\n" + 
						"                                        </form>\r\n" + 
						"                                    </li>\r\n" + 
						"                                    <li class=\"nav-item active\">\r\n" + 
						"                                        <a class=\"nav-link\" href=\"Help.html\">Help\r\n" + 
						"										<span class=\"sr-only\">(current)</span>\r\n" + 
						"										</a>\r\n" + 
						"                                    </li>\r\n" + 
						"                                    <li class=\"nav-item active\">\r\n" + 
						"                                        <a class=\"nav-link\" href=\"ContactAndSuggestions.html\">Contact and Suggestions \r\n" + 
						"										<span class=\"sr-only\">(current)</span>\r\n" + 
						"										</a>\r\n" + 
						"                                    </li>\r\n" + 
						"                                    <li class=\"nav-item\">\r\n" + 
						"                                        <a class=\"nav-link\" href=\"Forum\">Forum</a>\r\n" + 
						"                                    </li>\r\n" + 
						"                                    <li class=\"nav-item\">\r\n" + 
						"                                        <a class=\"nav-link\" href=\"RAndMod\">Recomendations and Modifications</a>\r\n" + 
						"                                    </li>\r\n" + 
						"                                    <li class=\"nav-item\">\r\n" + 
						"                                        <a class=\"nav-link\" href=\"Calendar\">Calendar</a>\r\n" + 
						"                                    </li>\r\n" + 
						"                                </ul>\r\n" + 
						"                            </div>\r\n" + 
						"                        </nav>\r\n" + 
						"					\r\n" + 
						"                        <p class=\"p1\">&copy;2017 Almanac, All Rights Reserve.</p>\r\n" + 
						"                    </div>\r\n" + 
						"            </div>\r\n" + 
						"            <!-- Other Resources Needed By Bootstrap -->\r\n" + 
						"            <script src=\"https://code.jquery.com/jquery-3.1.1.slim.min.js\" integrity=\"sha384-A7FZj7v+d/sdmMqp/nOQwliLvUsJfDHW+k9Omg/a/EheAdgtzNs3hpfag6Ed950n\"\r\n" + 
						"                crossorigin=\"anonymous\">\r\n" + 
						"            </script>\r\n" + 
						"            <script src=\"https://cdnjs.cloudflare.com/ajax/libs/tether/1.4.0/js/tether.min.js\" integrity=\"sha384-DztdAPBWPRXSA/3eYEEUWrWCy7G5KFbe8fFjk5JAIxUYHKkDx6Qin1DkWx51bBrb\"\r\n" + 
						"                crossorigin=\"anonymous\">\r\n" + 
						"            </script>\r\n" + 
						"            <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/js/bootstrap.min.js\" integrity=\"sha384-vBWWzlZJ8ea9aCX4pEW3rVHjgjt7zpkNpZk+02D9phzyeVkE+jo0ieGizqPLForn\"\r\n" + 
						"                crossorigin=\"anonymous\">\r\n" + 
						"            </script>\r\n" + 
						"        </div>\r\n" + 
						"    </body>\r\n" + 
						"\r\n" + 
						"    </html>\r\n" + 
						"	");
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
