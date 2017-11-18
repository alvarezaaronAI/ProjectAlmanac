/**
 * This Class Calendar will essentially create 
 */
package main;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Student;

/**
 * Servlet implementation class Calendar
 */
@WebServlet("/main/Calendar")
public class Calendar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Calendar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		Student studentTemp = (Student) request.getAttribute("authenticatedStudent");
		out.println("<doctype html>\r\n" + 
				"    <html lang=\"en\">\r\n" + 
				"\r\n" + 
				"    <head>\r\n" + 
				"        <meta charset=\"UTF-8\">\r\n" + 
				"        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\r\n" + 
				"        <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css\" integrity=\"sha384-rwoIResjU2yc3z8GV/NPeZWAv56rSmLldC3R/AZzGRnGxQQKnKkoFVhFQhNUwEyJ\"\r\n" + 
				"            crossorigin=\"anonymous\">\r\n" + 
				"        <title> Students Name Calendar's </title>\r\n" + 
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
				"        </style>\r\n" + 
				"    </head>\r\n" + 
				"    <body class=\"body-main\">\r\n" + 
				"        <div class=\"container-fluid\">\r\n" + 
				"            <div class=\"container-fluid text-center\">\r\n" + 
				"                <!-- Heading of the Page -->\r\n" + 
				"                <div class=\"jumbotron text-center mini-boxes\">\r\n" + 
				"                    <h1> My Profile: "+ studentTemp.getFirstName() +"</h1>\r\n" + 
				"                    <aside title=\"Projects Logo\">\r\n" + 
				"                        <img width=\"150px\" height=\"150px\" src=\"http://cs3.calstatela.edu:8080/cs3337stu10/Images/Logo.png\" alt=\"Logo Picture\">\r\n" + 
				"                    </aside>\r\n" + 
				"                </div>\r\n" + 
				"                <!-- Content -->\r\n" + 
				"                <div class=\"container\">\r\n" + 
				"\r\n" + 
				"                    <h2>Agenda</h2>\r\n" + 
				"                    <p class=\"lead\">\r\n" + 
				"                        Allows you to see your calendar all cleanly organized!\r\n" + 
				"                    </p>\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"                    <div class=\"agenda\">\r\n" + 
				"                        <div class=\"table-responsive\">\r\n" + 
				"                            <table class=\"table table-condensed table-bordered\">\r\n" + 
				"                                <thead>\r\n" + 
				"                                    <tr>\r\n" + 
				"                                        <th class=\"text-center\">Semester</th>\r\n" + 
				"                                        <th class=\"text-center\">Classes</th>\r\n" + 
				"                                        <th class=\"text-center\">Time</th>\r\n" + 
				"                                    </tr>\r\n" + 
				"                                </thead>\r\n" + 
				"                                <tbody>\r\n" + 
				"                                    <!-- Single event in a single day -->\r\n" + 
				"                                    <tr>\r\n" + 
				"                                        <td class=\"agenda-date\" class=\"active\" rowspan=\"1\">\r\n" + 
				"                                            <!-- <div class=\"dayofmonth\">26</div>\r\n" + 
				"                                        <div class=\"dayofweek\">Saturday</div>\r\n" + 
				"                                        <div class=\"shortdate text-muted\">July, 2014</div> -->\r\n" + 
				"                                            <div>\r\n" + 
				"                                                <p class=\"text-center\">\r\n" + 
				"                                                    Summer/Fall/Spring\r\n" + 
				"                                                </p>\r\n" + 
				"                                            </div>\r\n" + 
				"                                        </td>\r\n" + 
				"                                        <td class=\"course text-center\">\r\n" + 
				"                                            Course Name\r\n" + 
				"                                        </td>\r\n" + 
				"                                        <td class=\"agenda-events\">\r\n" + 
				"                                            <div class=\"agenda-time\">\r\n" + 
				"                                                7:00 - 9:00 PM\r\n" + 
				"                                            </div>\r\n" + 
				"                                        </td>\r\n" + 
				"                                    </tr>\r\n" + 
				"\r\n" + 
				"                                    <!-- Multiple events in a single day (note the rowspan) -->\r\n" + 
				"                                    <tr>\r\n" + 
				"                                        <td class=\"agenda-date\" class=\"active\" rowspan=\"3\">\r\n" + 
				"                                            <!-- <div class=\"dayofmonth\">24</div>\r\n" + 
				"                                        <div class=\"dayofweek\">Thursday</div>\r\n" + 
				"                                        <div class=\"shortdate text-muted\">July, 2014</div> -->\r\n" + 
				"                                            <div>\r\n" + 
				"                                                <p class=\"text-center\">\r\n" + 
				"                                                    Fall\r\n" + 
				"                                                </p>\r\n" + 
				"                                            </div>\r\n" + 
				"                                        </td>\r\n" + 
				"                                        <td class=\"course text-center\">\r\n" + 
				"                                            CS 2013 Data Structures\r\n" + 
				"                                        </td>\r\n" + 
				"                                        <td class=\"agenda-events\">\r\n" + 
				"                                            <div class=\"agenda-time\">\r\n" + 
				"                                                10:15 AM - 12:00 PM\r\n" + 
				"                                            </div>\r\n" + 
				"                                        </td>\r\n" + 
				"                                    </tr>\r\n" + 
				"                                    <tr>\r\n" + 
				"                                        <td class=\"course text-center\">\r\n" + 
				"                                            CS 3112 Web Development\r\n" + 
				"                                        </td>\r\n" + 
				"                                        <td class=\"agenda-events\">\r\n" + 
				"                                            <div class=\"agenda-time\">\r\n" + 
				"                                                10:15 AM - 12:00 PM\r\n" + 
				"                                            </div>\r\n" + 
				"                                        </td>\r\n" + 
				"                                    </tr>\r\n" + 
				"                                    <tr>\r\n" + 
				"                                        <td class=\"course text-center\">\r\n" + 
				"                                            CS 3337 Software Engineer\r\n" + 
				"                                        </td>\r\n" + 
				"                                        <td class=\"agenda-events\">\r\n" + 
				"                                            <div class=\"agenda-time\">\r\n" + 
				"                                                7:00 - 9:00 PM\r\n" + 
				"                                            </div>\r\n" + 
				"                                        </td>\r\n" + 
				"                                    </tr>\r\n" + 
				"                                </tbody>\r\n" + 
				"                            </table>\r\n" + 
				"                        </div>\r\n" + 
				"                    </div>\r\n" + 
				"                </div>\r\n" + 
				"                <!-- Log Out Button -->\r\n" + 
				"                <div class=\"text-center\">\r\n" + 
				"                    <form action=\"LogoutSessions\" method=\"get\">\r\n" + 
				"                        <a class=\"btn btn-primary\" href=\"../sessions/Logout\">Log Out</a>\r\n" + 
				"                    </form>\r\n" + 
				"                </div>\r\n" + 
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
				"                                    <li class=\"nav-item\">\r\n" + 
				"                                        <a class=\"nav-link\" href=\"../Info/Help\">Help</a>\r\n" + 
				"                                    </li>\r\n" + 
				"                                    <li class=\"nav-item\">\r\n" + 
				"                                        <a class=\"nav-link\" href=\"../Info/ContactAlmanac\">Contact and Suggestions </a>\r\n" + 
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
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
