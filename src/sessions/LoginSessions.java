package sessions;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.Student;

/**
 * Servlet implementation class LoginSessions
 */
@WebServlet(urlPatterns = "/sessions/Login", loadOnStartup = 3)
public class LoginSessions extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		// Create a few students
		ArrayList<Student> students = new ArrayList<Student>();
		students.add(new Student("harry", "potter", "h@p.com", "asdf"));
		students.add(new Student("joe", "low", "j@l.com", "ghjk"));
		// Add the students to the application scope (Servlet Context)
		getServletContext().setAttribute("students", students);

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ArrayList<Student> students = (ArrayList<Student>) getServletContext().getAttribute("students");
		//Checking cookies first to see if a student wanted to stay logged in.
		Cookie[] cookies = request.getCookies();
		//For every cookie that it was requested we must athenticate the student log in and by pass the password.
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				for (Student student : students) {
					String uniqID = "" + student.getIdenty(); 
					Cookie studentUniqueID = new Cookie("student", uniqID);
					//Comparing the cookie in the array vs the cookie in the student
					//This allows us to make sure that the student is who it is.
					if (cookie.getValue().equals(studentUniqueID.getValue())) {
						HttpSession session = request.getSession();
						session.setAttribute("authenticatedStudent", student);
						response.sendRedirect("MyProfile");

					}
				}

			}
			//Onced checked every student, for those students not 
		}
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		out.println("<doctype html>");
		out.println("<html lang=\"en\">");

		out.println("<head>");
		out.println("<meta charset=\"UTF-8\">");
		out.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">");
		out.println(
				"<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css\" integrity=\"sha384-rwoIResjU2yc3z8GV/NPeZWAv56rSmLldC3R/AZzGRnGxQQKnKkoFVhFQhNUwEyJ\"");
		out.println("crossorigin=\"anonymous\">");
		out.println("<title> Login Page </title>");
		out.println("<style>");

		out.println("</style>");
		out.println("</head>");
		out.println("<!-- Body of the page -->");

		out.println("<body>");
		out.println("<!-- Heading of the page -->");
		out.println("<div class=\"container-fluid\">");
		out.println("<div class=\"container-fluid text-center\">");
		out.println("<!-- Header -->");
		out.println("<div class=\"jumbotron\">");
		out.println("<!-- Logo -->");
		out.println("<div class=\"navbar-brand\">");
		out.println("<h1> Login </h1>");
		out.println("<aside title=\"Projects Logo\">");
		out.println("<img src=\"Logo.png\" alt=\"Logo Picture.png\">");
		out.println("</aside>");

		out.println("</div>");
		out.println("</div>");
		out.println("<!-- Content -->");
		out.println("<div class=\"container-fluid text-center\">");
		out.println("<form action=\"Login\" method=\"post\">");
		out.println("<div>");
		out.println("<label>");
		out.println("Username(Email Adress)");
		out.println("</label>");
		out.println("<input class=\"form-control\" type=\"text\" name=\"username\" placeholder=\"Email\">");
		out.println("</div>");
		out.println("<div class=\"form-group\">");
		out.println("<label>");
		out.println("Password");
		out.println("</label>");
		out.println("<input class=\"form-control\" type=\"password\" name=\"password\" placeholder=\"Password\">");
		out.println("</div>");
		out.println("<div class=\"checkbox\">");
		out.println("<label>");
		out.println("<input type=\"checkbox\" name=\"rememberMe\"> Remember Username");
		out.println("</label>");
		out.println("</div>");
		out.println("<button type=\"submit\" class=\"btn btn-primary\">Login</button>");
		out.println("</form>");
		out.println("<form action=\"Register\" method=\"post\">");
		out.println("<button type=\"submit\" class=\"btn btn-primary\">Register</button>");
		out.println("</form>");
		out.println("</div>");
		out.println("<hr>");
		out.println("</div>");
		out.println("<!-- Footer of the page -->");
		out.println("<div>");
		out.println("<footer class=\"footer \">");
		out.println("<!-- Mini Naviation-->");
		out.println("<div class=\"container text-center\">");
		out.println("<nav class=\"navbar navbar-toggleable-md navbar-light bg-faded\">");
		out.println(
				"<button class=\"navbar-toggler navbar-toggler-right\" type=\"button\" data-toggle=\"collapse\" data-target=\"#navbarSupportedContent\"");
		out.println(
				"aria-controls=\"navbarSupportedContent\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">");
		out.println("<span class=\"navbar-toggler-icon\"></span>");
		out.println("</button>");
		out.println("<!-- Logo -->");
		out.println("<div class=\"navbar-brand\">");
		out.println("<aside title=\"Projects Logo\">");
		out.println("<img src=\"Logo.png\" alt=\"Logo Picture.png\">");
		out.println("</aside>");
		out.println("</div>");

		out.println("<div class=\"collapse navbar-collapse\" id=\"navbarSupportedContent\">");
		out.println("<ul class=\"navbar-nav mr-auto\">");
		out.println("<li class=\"nav-item active\">");
		out.println("<a class=\"nav-link\" href=\"Login\">Login <span class=\"sr-only\">(current)</span></a>");
		out.println("</li>");
		out.println("<li class=\"nav-item\">");
		out.println("<a class=\"nav-link\" href=\"Help\">Help</a>");
		out.println("</li>");
		out.println("<li class=\"nav-item\">");
		out.println("<a class=\"nav-link\" href=\"ContactAlmanac\">Contact and Suggestions </a>");
		out.println("</li>");
		out.println("<li class=\"nav-item\">");
		out.println("<a class=\"nav-link disabled\" href=\"Forum\">Forum</a>");
		out.println("</li>");
		out.println("<li class=\"nav-item\">");
		out.println(
				"<a class=\"nav-link disabled\" href=\"RecomendationsAndModifications\">Recomendations and Modifications</a>");
		out.println("</li>");
		out.println("<li class=\"nav-item\">");
		out.println("<a class=\"nav-link disabled\" href=\"Calendar\">Calendar</a>");
		out.println("</li>");
		out.println("<li class=\"nav-item\">");
		out.println("<a class=\"nav-link disabled\" href=\"Login\">Logout</a>");
		out.println("</li>");
		out.println("</ul>");
		out.println("</div>");
		out.println("</nav>");
		out.println("<p class=\"p1\">&copy;2017 Almanac, All Rights Reserve.</p>");
		out.println("</div>");
		out.println("</div>");
		out.println("<!-- Other Resources Needed By Bootstrap -->");
		out.println(
				" <script src=\"https://code.jquery.com/jquery-3.1.1.slim.min.js\" integrity=\"sha384-A7FZj7v+d/sdmMqp/nOQwliLvUsJfDHW+k9Omg/a/EheAdgtzNs3hpfag6Ed950n\"");
		out.println("crossorigin=\"anonymous\"></script>");
		out.println(
				"  <script src=\"https://cdnjs.cloudflare.com/ajax/libs/tether/1.4.0/js/tether.min.js\" integrity=\"sha384-DztdAPBWPRXSA/3eYEEUWrWCy7G5KFbe8fFjk5JAIxUYHKkDx6Qin1DkWx51bBrb\"");
		out.println("crossorigin=\"anonymous\"></script>");
		out.println(
				"  <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/js/bootstrap.min.js\" integrity=\"sha384-vBWWzlZJ8ea9aCX4pEW3rVHjgjt7zpkNpZk+02D9phzyeVkE+jo0ieGizqPLForn\"");
		out.println("crossorigin=\"anonymous\"></script>");
		out.println("</footer>");
		out.println("</div>");
		out.println("</body>");

		out.println("</html>");
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
		
		// If the user submitted bad input, just redisplay the form
		if (username == null || username.trim().length() == 0 || password == null || password.trim().length() == 0) {
			//Refresh the page
			doGet(request, response);
			return;
		}
		//Get an array of students so we can check stuff.
		ArrayList<Student> students = (ArrayList<Student>) getServletContext().getAttribute("students");
		//Got through all those students and check if the password matches with each username
		for (Student student : students) {
			if (student.getEmail().toLowerCase().equals(username.trim().toLowerCase())
					&& student.getPassword().equals(password)) {
				//Creating a Cookie that allows us to keep track of the user save username
				if (rememberMe == null) {

				} else {
					String uniqID = "" + student.getIdenty(); 
					Cookie cookie = new Cookie("student",uniqID);
					response.addCookie(cookie);
				}
				//If it matches we create session and log that student in into that session.
				HttpSession session = request.getSession();
				session.setAttribute("authenticatedStudent", student);

				// Now that we've set an attribute in the session scope, let's
				// redirect the Student to the "Student's Profile" area.
				response.sendRedirect("MyProfile");
				return;
			}

		}
		request.setAttribute("error", "Invalid username and/or password");
		doGet(request, response);
	}
}
