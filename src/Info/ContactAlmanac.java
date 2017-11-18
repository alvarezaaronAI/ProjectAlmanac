package Info;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ContactAlmanac
 */
@WebServlet("/Info/ContactAlmanac")
public class ContactAlmanac extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ContactAlmanac() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//---------------------------------------------------------------------
				// Set the content type
				response.setContentType("text/html");
				// Get a reference to the PrintWriter that lets us talk to the client
				PrintWriter out = response.getWriter();
				out.println("<doctype html>\r\n" + 
						"    <html lang=\"en\">\r\n" + 
						"\r\n" + 
						"    <head>\r\n" + 
						"        <meta charset=\"UTF-8\">\r\n" + 
						"        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\r\n" + 
						"        <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css\" integrity=\"sha384-rwoIResjU2yc3z8GV/NPeZWAv56rSmLldC3R/AZzGRnGxQQKnKkoFVhFQhNUwEyJ\"\r\n" + 
						"            crossorigin=\"anonymous\">\r\n" + 
						"        <title> Contact And Suggestions </title>\r\n" + 
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
						"			    display: block;\r\n" + 
						"	float: left;\r\n" + 
						"	width: 60%;\r\n" + 
						"	margin-top: 5px;\r\n" + 
						"	margin-bottom: 5px;	\r\n" + 
						"	margin-left: 300px;\r\n" + 
						"	margin-right: 250px;\r\n" + 
						"	height: 100px;\r\n" + 
						"			}\r\n" + 
						"			\r\n" + 
						"        </style>\r\n" + 
						"    </head>\r\n" + 
						"	\r\n" + 
						"    <body class=\"body-main\">\r\n" + 
						"        <div class=\"container-fluid\">\r\n" + 
						"            <!-- Heading of the Page -->\r\n" + 
						"            <div class=\"jumbotron text-center mini-boxes\">\r\n" + 
						"                <h1> Contact and Suggestions</h1>\r\n" + 
						"                <aside title=\"Projects Logo\">\r\n" + 
						"                    <img width=\"150px\" height=\"150px\" src=\"http://cs3.calstatela.edu:8080/cs3337stu10/Images/Logo.png\" alt=\"Logo Picture\">\r\n" + 
						"                </aside>\r\n" + 
						"            </div>\r\n" + 
						"            <!-- Content -->\r\n" + 
						"			\r\n" + 
						"			\r\n" + 
						"			<table align=\"center\" cellpadding=\"5\" class=\"dept_contact\" style=\"width: 429px;\">\r\n" + 
						"			    <tbody>\r\n" + 
						"				 \r\n" + 
						"				 <tr>\r\n" + 
						"				  <th style=\"width: 68px;\"><font size=\"5\">Office</font></th>\r\n" + 
						"				  <td style=\"width: 317px;\"><font size=\"5\">E&amp;T 322</font></td>\r\n" + 
						"				 </tr>\r\n" + 
						"				 <tr>\r\n" + 
						"				  <th style=\"width: 68px;\"><font size=\"5\">Phone</font></th>\r\n" + 
						"				  <td style=\"width: 317px;\"><font size=\"5\">(323) 343-6690</font></td>\r\n" + 
						"				 </tr>\r\n" + 
						"				 <tr><th style=\"width: 68px;\"><font size=\"5\">Fax</font></th>\r\n" + 
						"				 <td style=\"width: 317px;\"><font size=\"5\">(323) 343-6672</font></td>\r\n" + 
						"				 </tr>\r\n" + 
						"				 <tr><th style=\"width: 68px;\"><font size=\"5\">Email</font></th>\r\n" + 
						"				 <td style=\"width: 317px;\"><a href=\"mailto:cs@calstatela.edu\"><font size=\"5\">cs@calstatela.edu</font></a></td>\r\n" + 
						"				 </tr>\r\n" + 
						"				 <tr><th style=\"width: 68px;\"><font size=\"5\">Address</font></th><td style=\"width: 317px;\"><font size=\"5\">5151 State University Drive, Los Angeles, CA 90032</font></td>\r\n" + 
						"				 </tr>\r\n" + 
						"				 <tr><th style=\"width: 68px;\"><font size=\"5\">Web</th>\r\n" + 
						"				 <td style=\"width: 317px;\"><a href=\"http://cs.calstatela.edu\" title=\"Computer Science Department\"><font size=\"5\">cs.calstatela.edu</font></a><font size=\"5\">  or</font>  <a href=\"http://www.calstatela.edu/cs\" title=\"Computer Science Department\"><font size=\"5\">www.calstatela.edu/cs</font></a></td>\r\n" + 
						"				 </tr>\r\n" + 
						"				</tbody>\r\n" + 
						"				</font>\r\n" + 
						"			  </table>\r\n" + 
						"			  </br>\r\n" + 
						"			<textarea></textarea></br>\r\n" + 
						"\r\n" + 
						"			<div class=\"text-center\">\r\n" + 
						"            <div class=\"col-md-6 col-md-offset-0 col-sm-6 col-sm-offset-0\">\r\n" + 
						"			<form action=\"myform.cgi\">\r\n" + 
						"			 <!--<input style=\"height:200px;font-size:14pt\" type=\"suggestions\" align=\"center\" class=\"form-control\" aria-describedby=\"sizing-addon1\">-->\r\n" + 
						"			 \r\n" + 
						"			 \r\n" + 
						"			 \r\n" + 
						"			 </div>\r\n" + 
						"			 <label for=\"suggestion\">Enter Your Suggestions Here</label>\r\n" + 
						"			 <br><input type=\"submit\" value=\"Submit\">\r\n" + 
						"			 </form>\r\n" + 
						"			 </div>\r\n" + 
						"\r\n" + 
						"             </br>\r\n" + 
						"			 <!-- Log Out Button -->\r\n" + 
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
