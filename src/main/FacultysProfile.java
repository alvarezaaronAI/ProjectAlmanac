package main;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FacultysProfile
 */
@WebServlet("/main/FacultysProfile")
public class FacultysProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FacultysProfile() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//---------------------------------------------------------------------
		// Set the content type
		response.setContentType("text/html");
		// Get a reference to the PrintWriter that lets us talk to the client
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
				"        <title> Faculty's Profile </title>\r\n" + 
				"        <style>\r\n" + 
				"\r\n" + 
				"        </style>\r\n" + 
				"    </head>\r\n" + 
				"\r\n" + 
				"    <body>\r\n" + 
				"        <div>\r\n" + 
				"            <!-- Heading of the Page -->\r\n" + 
				"            <div class=\"jumbotron text-center\">\r\n" + 
				"                <h1> My Profile: Name of the Faculty</h1>\r\n" + 
				"                <aside title=\"Projects Logo\">\r\n" + 
				"                    <img src=\"../Images/Logo.png\" alt=\"Logo Picture\">\r\n" + 
				"                </aside>\r\n" + 
				"            </div>\r\n" + 
				"            <!-- Content -->\r\n" + 
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
				"                        <nav class=\"navbar navbar-toggleable-md navbar-light bg-faded\">\r\n" + 
				"                            <button class=\"navbar-toggler navbar-toggler-right\" type=\"button\" data-toggle=\"collapse\" data-target=\"#navbarSupportedContent\"\r\n" + 
				"                                aria-controls=\"navbarSupportedContent\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\r\n" + 
				"                                <span class=\"navbar-toggler-icon\"></span>\r\n" + 
				"                            </button>\r\n" + 
				"                            <!-- Logo -->\r\n" + 
				"                            <div class=\"navbar-brand\">\r\n" + 
				"                                <aside title=\"Projects Logo\">\r\n" + 
				"                                    <img src=\"../Images/Logo.png\" alt=\"Logo Picture \">\r\n" + 
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
				"                                    <li class=\"nav-item\">\r\n" + 
				"                                        <a class=\"nav-link\" href=\"../Info/Help\">Help</a>\r\n" + 
				"                                    </li>\r\n" + 
				"                                    <li class=\"nav-item\">\r\n" + 
				"                                        <a class=\"nav-link\" href=\"../Info/ContactAlmanac\">Contact and Suggestions </a>\r\n" + 
				"                                    </li>\r\n" + 
				"                                    <li class=\"nav-item\">\r\n" + 
				"                                        <a class=\"nav-link disabled\">Forum</a>\r\n" + 
				"                                    </li>\r\n" + 
				"                                    <li class=\"nav-item\">\r\n" + 
				"                                        <a class=\"nav-link disabled\">Recomendations and Modifications</a>\r\n" + 
				"                                    </li>\r\n" + 
				"                                    <li class=\"nav-item\">\r\n" + 
				"                                        <a class=\"nav-link disabled\">Calendar</a>\r\n" + 
				"                                    </li>\r\n" + 
				"                                </ul>\r\n" + 
				"                            </div>\r\n" + 
				"                        </nav>\r\n" + 
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
				"    </html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
