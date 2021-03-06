package sessions;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.Faculty;
import models.Global;
import models.Student;
import models.User;

/**
 * Servlet implementation class LoginSessions
 */
@WebServlet("/sessions/Login")
public class LoginSessions extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		// ---------------------------------------------------------------------
		// Create a few students
		Global mainDB;
		try {
			mainDB = new Global();
			ArrayList<User> students = new ArrayList<User>(); // -- harry -joe
			String[] info1 = new String[3];
			info1[0] = "CSULA";
			info1[1] = "Engr";
			info1[2] = "Computer Science";
			String[] info2 = new String[3];
			info2[0] = "CSULA";
			info2[1] = "Engr";
			info2[2] = "Computer Science";
			students.add(new Student("Joe", "Bob", "j@b.com", "asdf", info1));
			students.add(new Student("joe", "low", "j@l.com", "ghjk", info2));
			for (int i = 0; i < students.size(); i++) {
				System.out.println("Student " + i + " is -" + students.get(i).getFirstName());
			}
			// Add the students to the application scope (Servlet Context)
				mainDB.setUsers(students);
				getServletContext().setAttribute("mainDB",mainDB);
				getServletContext().setAttribute("students", students);
				
			
		} catch (FileNotFoundException e1) {
			
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		// ---------------------------------------------------------------------
		// Create a few faculties
		ArrayList<Faculty> faculties = new ArrayList<Faculty>();
		// faculties.add(new Faculty("Pamula", "Pamula", "p@p.com", "asdf"));
		// faculties.add(new Faculty("Jose", "Richard", "j@r.com", "ghjk"));
		// // Add the students to the application scope (Servlet Context)
		getServletContext().setAttribute("faculties", faculties);
		//Create a global database from where I can access every thing
		

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ---------------------------------------------------------------------
		// Checking cookies first to see if a student wanted to stay logged in.
		ArrayList<Student> students = (ArrayList<Student>) getServletContext().getAttribute("students");
		Global mainDB = (Global) getServletContext().getAttribute("mainDB");
		Cookie[] cookies = request.getCookies();
		// For every cookie that it was requested we must athenticate the student log in
		// and by pass the password.
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				for (Student student : students) {
					String uniqID = "" + student.getIdentity();
					Cookie studentUniqueID = new Cookie("student", uniqID);
					// Comparing the cookie in the array vs the cookie in the student
					// This allows us to make sure that the student is who it is.
					if (cookie.getValue().equals(studentUniqueID.getValue())) {
						HttpSession session = request.getSession();
						session.setAttribute("authenticatedStudent", student);
						response.sendRedirect("../main/MyProfile");

					}
				}

			}
			// Onced checked every student, for those students not
		}
		// ---------------------------------------------------------------------
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		// ---------------------------------------------------------------------
		out.println("<doctype html>\r\n" + 
				"    <html lang=\"en\">\r\n" + 
				"\r\n" + 
				"    <head>\r\n" + 
				"        <meta charset=\"UTF-8\">\r\n" + 
				"        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\r\n" + 
				"        <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css\" integrity=\"sha384-rwoIResjU2yc3z8GV/NPeZWAv56rSmLldC3R/AZzGRnGxQQKnKkoFVhFQhNUwEyJ\"\r\n" + 
				"            crossorigin=\"anonymous\">\r\n" + 
				"        <title> Login Page </title>\r\n" + 
				"        <style type=\"text/css\">\r\n" + 
				"            .control-label{\r\n" + 
				"                font-weight: bold;\r\n" + 
				"            }\r\n" + 
				"            .legend-text{\r\n" + 
				"                font-weight: bold;\r\n" + 
				"            }\r\n" + 
				"            .body-main{\r\n" + 
				"                background-color: beige;\r\n" + 
				"            }\r\n" + 
				"            .mini-boxes{\r\n" + 
				"                background-color: darkcyan;\r\n" + 
				"            }\r\n" + 
				"            .nav-link{\r\n" + 
				"                font-weight: bold;\r\n" + 
				"            }\r\n" + 
				"            body{\r\n" + 
				"                zoom: 80%;\r\n" + 
				"            }\r\n" + 
				"        </style>\r\n" + 
				"    </head>");
				out.println(" <!-- Body of the page -->\r\n" + 
						"\r\n" + 
						"    <body class=\"body-main\">\r\n" + 
						"        <!-- Heading of the page -->\r\n" + 
						"        <div class=\"container-fluid\">\r\n" + 
						"            <div class=\"container-fluid text-center\">\r\n" + 
						"                <!-- Header -->\r\n" + 
						"                <div class=\"jumbotron mini-boxes\">\r\n" + 
						"                    <!-- Logo -->\r\n" + 
						"                    <div class=\"navbar-brand\">\r\n" + 
						"                        <h1> Login </h1>\r\n" + 
						"                        <aside title=\"Projects Logo\">\r\n" + 
						"                            <img width=\"150px\" height=\"150px\" src=\"http://cs3.calstatela.edu:8080/cs3337stu10/Images/Logo.png\" alt=\"Logo Picture\">\r\n" + 
						"                        </aside>\r\n" + 
						"\r\n" + 
						"                    </div>\r\n" + 
						"                </div>\r\n" + 
						"                <!-- Content -->\r\n" );
				//out.println("File outOut: " + mainDB.getDefaultFile().getAbsolutePath());
						out.println("                <div class=\"container-fluid text-center\">\r\n" + 
						"                    <span>\r\n" + 
						"                        <ul style=\"list-style-type: none; display: inline-block;\">\r\n" + 
						"                            <li>\r\n" + 
						"                                <form action=\"Register\" method=\"get\">\r\n" + 
						"                                    <button type=\"submit\" class=\"btn btn-primary\">Register For Student</button>\r\n" + 
						"                                </form>\r\n" + 
						"                            </li>\r\n" + 
						"                        </ul>\r\n" + 
						"\r\n" + 
						"                        <ul style=\"list-style-type: none; display: inline-block;\">\r\n" + 
						"                            <li>\r\n" + 
						"                                <form action=\"RegisterFaculty\" method=\"get\">\r\n" + 
						"                                    <button type=\"submit\" class=\"btn btn-primary\">Register For Faculty</button>\r\n" + 
						"                                </form>\r\n" + 
						"                            </li>\r\n" + 
						"                        </ul>\r\n" + 
						"                        <ul style=\"list-style-type: none; display: inline-block;\">\r\n" + 
						"                            <li>\r\n" + 
						"                                <form action=\"GuestProfile\" method=\"get\">\r\n" + 
						"                                    <a class=\"btn btn-primary\" href=\"../main/GuestProfile\">Guest Profile</a>\r\n" + 
						"                                </form>\r\n" + 
						"                            </li>\r\n" + 
						"                        </ul>\r\n" + 
						"                    </span>\r\n" + 
						"                    <form action=\"Login\" method=\"post\">\r\n" + 
						"                        <div>\r\n" + 
						"                            <label>\r\n" + 
						"                                Username(Email Address)\r\n" + 
						"                            </label>\r\n" + 
						"                            <input class=\"form-control\" type=\"text\" name=\"username\" placeholder=\"Email\">\r\n" + 
						"                        </div>\r\n" + 
						"                        <div class=\"form-group\">\r\n" + 
						"                            <label>\r\n" + 
						"                                Password\r\n" + 
						"                            </label>\r\n" + 
						"                            <input class=\"form-control\" type=\"password\" name=\"password\" placeholder=\"Password\">\r\n" + 
						"                        </div>\r\n" + 
						"                        <div class=\"checkbox\">\r\n" + 
						"                            <label>\r\n" + 
						"                                <input type=\"checkbox\" name=\"rememberMe\"> Remember Username\r\n" + 
						"                            </label>\r\n" + 
						"                        </div>\r\n" + 
						"                        <button type=\"submit\" class=\"btn btn-primary\">Login</button>\r\n" + 
						"                    </form>\r\n" + 
						"                </div>\r\n" + 
						"                <hr>\r\n" + 
						"            </div>\r\n" + 
						"\r\n" + 
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
						"                                        <a class=\"nav-link\" href=\"Login\">Login\r\n" + 
						"                                            <span class=\"sr-only\">(current)</span>\r\n" + 
						"                                        </a>\r\n" + 
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
						"                crossorigin=\"anonymous\"></script>\r\n" + 
						"            <script src=\"https://cdnjs.cloudflare.com/ajax/libs/tether/1.4.0/js/tether.min.js\" integrity=\"sha384-DztdAPBWPRXSA/3eYEEUWrWCy7G5KFbe8fFjk5JAIxUYHKkDx6Qin1DkWx51bBrb\"\r\n" + 
						"                crossorigin=\"anonymous\"></script>\r\n" + 
						"            <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/js/bootstrap.min.js\" integrity=\"sha384-vBWWzlZJ8ea9aCX4pEW3rVHjgjt7zpkNpZk+02D9phzyeVkE+jo0ieGizqPLForn\"\r\n" + 
						"                crossorigin=\"anonymous\"></script>\r\n" + 
						"            </footer>\r\n" + 
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
		// Get the credentials from the request object
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String rememberMe = request.getParameter("rememberMe");
		// ---------------------------------------------------------------------
		// If the user submitted bad input, just redisplay the form
		if (username == null || username.trim().length() == 0 || password == null || password.trim().length() == 0) {
			// Refresh the page
			doGet(request, response);
			return;
		}
		// ---------------------------------------------------------------------
		// Here we going to check for students
		ArrayList<Student> students = (ArrayList<Student>) getServletContext().getAttribute("students");
		// Login and Check and make cookie given students login info
		for (Student student : students) {
			if (student.getEmail().toLowerCase().equals(username.trim().toLowerCase())
					&& student.getPassword().equals(password)) {
				// Creating a Cookie that allows us to keep track of the user save username
				if (rememberMe == null) {

				} else {
					String uniqID = "" + student.getIdentity();
					Cookie cookie = new Cookie("student", uniqID);
					response.addCookie(cookie);
				}
				// If it matches we create session and log that student in into that session.
				HttpSession session = request.getSession();
				session.setAttribute("authenticatedStudent", student);

				// Now that we've set an attribute in the session scope, let's
				// redirect the Student to the "Student's Profile" area.
				response.sendRedirect("../main/MyProfile");
				return;
			}

		}
		// ---------------------------------------------------------------------
		// Here we going to check for faculties.
		ArrayList<Faculty> faculties = (ArrayList<Faculty>) getServletContext().getAttribute("facutlies");
		// Login and Check and make cookie given faculties login info
		// ---------------------------------------------------------------------
		// Got through all those students and check if the password matches with each
		// username
		request.setAttribute("error", "Invalid username and/or password");
		// ---------------------------------------------------------------------
		doGet(request, response);
	}
}