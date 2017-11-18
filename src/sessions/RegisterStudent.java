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

import models.Global;
import models.Student;
import structure.Department;
import structure.Major;

/**
 * Servlet implementation class RegisterStudent
 */
@WebServlet("/sessions/Register")
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ---------------------------------------------------------------------
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		// ---------------------------------------------------------------------
		out.println("<doctype html>\r\n" + "    <html lang=\"en\">\r\n" + "\r\n" + "    <head>\r\n"
				+ "        <meta charset=\"UTF-8\">\r\n"
				+ "        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\r\n"
				+ "        <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css\" integrity=\"sha384-rwoIResjU2yc3z8GV/NPeZWAv56rSmLldC3R/AZzGRnGxQQKnKkoFVhFQhNUwEyJ\"\r\n"
				+ "            crossorigin=\"anonymous\">\r\n" + "        <title> Register </title>\r\n"
				+ "        <style type=\"text/css\">\r\n" + "            .control-label{\r\n"
				+ "                font-weight: bold;\r\n" + "            }\r\n" + "            .legend-text{\r\n"
				+ "                font-weight: bold;\r\n" + "            }\r\n" + "            .body-main{\r\n"
				+ "                background-color: beige;\r\n" + "            }\r\n" + "            .mini-boxes{\r\n"
				+ "                background-color: darkcyan;\r\n" + "            }\r\n" + "            .nav-link{\r\n"
				+ "                font-weight: bold;\r\n" + "            }\r\n" + "            body{\r\n"
				+ "                zoom: 80%;\r\n" + "            }\r\n" + "        </style>\r\n" + "    </head>\r\n"
				+ "    <!-- Body of the page -->\r\n" + "\r\n"  + "    <body class=\"body-main\">\r\n"
				+ "        <!-- Heading of the page -->\r\n" + "        <div class=\"container-fluid\">\r\n"
				+ "            <div class=\"container-fluid text-center\">\r\n" + "                <!-- Header -->\r\n"
				+ "                <div class=\"jumbotron mini-boxes\">\r\n" + "                    <!-- Logo -->\r\n"
				+ "                    <div class=\"navbar-brand\">\r\n" + "                        <h1> Register,\r\n"
				+ "                            <small> New Student</small>\r\n" + "                        </h1>\r\n"
				+ "                        <aside title=\"Projects Logo\">\r\n"
				+ "                            <img width=\"150px\" height=\"150px\" src=\"http://cs3.calstatela.edu:8080/cs3337stu10/Images/Logo.png\" alt=\"Logo Picture\">\r\n"
				+ "                        </aside>\r\n"
				+ "                        <p> Welcome to the Student Registration, Please provide some info about your Self</p>\r\n"
				+ "                    </div>\r\n" + "                </div>\r\n"
				+ "                <!-- Content -->\r\n"
				+ "                <form action=\"Register\" method=\"post\">");
	
		
			
		out.println("<div class=\"form-group\">");
		String firstName = request.getParameter("fName");
		String lastName = request.getParameter("lName");
		firstName = firstName == null ? "" : firstName;
		lastName = lastName == null ? "" : lastName;
		String fError = (String) request.getAttribute("fError");
		String lError=(String) request.getAttribute("lError");
		//System.out.println(nameError);
		if (fError != null) {
			out.println("                        <label class=\"control-label text-danger\"> First Name</label>\r\n"
					+"<p class =\"text-danger\">"+fError +" </p>");
		} else{
		out.println("                        <label class=\"control-label\"> First Name</label>\r\n");
		}
		out.println("<input class=\"form-control\" type=\"text\" value=\"" + firstName
				+ "\" name=\"fName\" placeholder=\"Enter First Name\">\r\n"+"</div>\r\n" );
		
		
		out.println("<div class=\"form-group\">");
		if(lError !=null){
			out.println(" <label class=\"control-label text-danger\"> Last Name</label>\r\n"
					+"<p class =\"text-danger\">"+lError +" </p>"); 
		}else{
			out.println("                        <label class=\"control-label\"> Last Name</label>\r\n");
		}	
			out.println("       <input class=\"form-control\" type=\"text\" value=\"" + lastName  
					+   "\" name=\"lName\" placeholder=\"Enter Last Name\">\r\n" +"</div>\r\n");
			
			
		out.println("<div class=\"form-group\">");	
		String email = request.getParameter("username");
		String emailError = (String) request.getAttribute("emailError");
		 
		if (emailError != null) {
			out.println(
					    "<label class=\"control-label text-danger\"> Email</label>\r\n"
							+"<p class =\"text-danger\">"+emailError +" </p>");
		}
		else{
			out.println("<label class=\"control-label\"> Email</label>\r\n");
	    }
	    
		email = email == null ? "" : email;
		out.println( "                        <input class=\"form-control\" type=\"text\" value=\"" + email
				+ "\" name=\"username\" placeholder=\"Enter New Email\">\r\n" + "</div>\r\n");
		
		
		
		out.println("<div class=\"form-group\">");
		String passwordError = (String) request.getAttribute("passwordError");
		if (passwordError != null) {
			out.println(
					"<label class=\"control-label text-danger\"> Password</label>\r\n"
							+"<p class =\"text-danger\">"+passwordError +" </p>");
		} else {
				out.println("<label class=\"control-label\"> Password</label>\r\n");
		}
			String password1 = request.getParameter("password1");
			String password2 = request.getParameter("password2");
			password1 = password1 == null ? "" : password1;
			password2 = password2 == null ? "" : password2;
			out.println(
					    "                        <input class=\"form-control\" type=\"text\" value=\"" + password1
					+ "\" name=\"password1\" placeholder=\"Enter New Password\">\r\n" + "  </div>\r\n"
					+ "                    <div class=\"form-group\">\r\n"
					+ "                        <label class=\"control-label\"> Retype Password </label>\r\n"
					+ "                        <input class=\"form-control\" type=\"text\" value=\"" + password2
					+ "\" name=\"password2\" placeholder=\"Enter New Password Again\">\r\n"
					+ "                    </div>\r\n");
			
		Global mainDB = (Global) getServletContext().getAttribute("mainDB");
		//An ArrayList of Schools
			//mainDB ArrayList
		out.println(" <fieldset class=\"form-group\">\r\n"
				+ "                        <div class=\"container-fluid \">\r\n"
				+ "                            <div class=\"row\">\r\n"
				+ "                                <div class=\"col-sm-4\">\r\n"
				+ "                                    <legend class=\"legend-text\">School Selection</legend>\r\n"
				+ "                                    <div class=\"form-check\">\r\n"
				);
		//do a for loop that goes through the arraylost of Databases and prints out the schools
		
		//Here print just one school for demo
			out.println("                                      <label class=\"form-check-label\">\r\n"
				+ "                                            <input type=\"radio\" class=\"form-check-input\" value=\"\" + " + mainDB.defaultSchool().getName() + " name=\"schoolOption\" id=\"schoolOption\" checked> "+ mainDB.defaultSchool().getName()+"l\r\n"
				+ "                                        </label>\r\n"
				);
		//For loop that goes through the the list of departments
			out.println("                                    	</div>\r\n"
				+ "                                    <div class=\"form-check\">\r\n"
				+ "                                        <label class=\"form-check-label\">\r\n"
				+ "                                            <input type=\"radio\" class=\"form-check-input\" value=\"\" + schoolOption2 + name=\"schoolOption\" id=\"schoolOption\"> Second School\r\n"
				+ "                                        </label>\r\n"
				+ "                                    </div>\r\n"
				+ "                                    <div class=\"form-check disabled\">\r\n"
				+ "                                        <label class=\"form-check-label\">\r\n"
				+ "                                            <input type=\"radio\" class=\"form-check-input\" value=\"\" + schoolOption3 + name=\"schoolOption\" id=\"schoolOption\" disabled> Not an Option School\r\n"
				+ "                                        </label>\r\n"
				+ "                                    </div>\r\n" + "                                </div>\r\n"
				+ "                                <div class=\"col-sm-4\">\r\n"
				+ "                                    <legend class=\"legend-text\">Department Selection</legend>\r\n");
		/*	csulaDepts gets an arraylist of departments for me to transverse
			departmentOptions is what i am saving in order to retrieve it in Post method*/
			ArrayList<Department> csulaDepts = mainDB.defaultSchool().getDepts();
			ArrayList<String> departmentOptions = new ArrayList<>();
			for (int i = 0; i < csulaDepts.size(); i++) {
				String tempDeptSetUp = csulaDepts.get(i).getName(); 
				departmentOptions.add(tempDeptSetUp);
				out.println("                          <div class=\"form-check\">\r\n" 
				
				+ "                                    <label class=\"form-check-label\">\r\n"
				+ "                                            <input type=\"radio\" class=\"form-check-input\" value=\"\" + "+ tempDeptSetUp + " + name=\"deptOption\" id=\"deptOption\" checked>"+ tempDeptSetUp + "\r\n"
				+ "                                        </label>\r\n"
				+ "                                    </div>\r\n");
			}
			//Send to the server the Arraylist of departementOptions for me to read in the post method
			getServletContext().setAttribute("deptOptions", departmentOptions);
				out.println( "                                    <div class=\"form-check\">\r\n"
				+ "                                        <label class=\"form-check-label\">\r\n"
				+ "                                            <input type=\"radio\" class=\"form-check-input\" value=\"\" + deptOption2 + name=\"deptOption\" id=\"deptOption2\"> Second Department\r\n"
				+ "                                        </label>\r\n"
				+ "                                    </div>\r\n"
				+ "                                    <div class=\"form-check disabled\">\r\n"
				+ "                                        <label class=\"form-check-label\">\r\n"
				+ "                                            <input type=\"radio\" class=\"form-check-input\" value=\"\" + deptOption3 + name=\"deptOption\" id=\"deptOption3\" disabled> Not an Option Department\r\n"
				+ "                                        </label>\r\n"
				+ "                                    </div>\r\n" + "                                </div>\r\n");
		/*	Make an arraylist of majors to get all the majors listed in each dept.
			Store a list of majors, from each dept.*/
			ArrayList<String> majorOptions = new ArrayList<>();
			for (int i = 0; i < csulaDepts.size(); i++) {
				ArrayList<Major> tempMajors = csulaDepts.get(i).getMajors();
				out.println("                       <div class=\"col-sm-4\">\r\n"
				+ "                                    <legend class=\"legend-text\">Major Selection for " + departmentOptions.get(i) +"</legend>\r\n"
				+ "                                    <div class=\"form-check\">\r\n");
				//for loop that goes through every department and prints out each major in that department
				for (int j = 0; j < tempMajors.size(); j++) {
					String tempOneMajor = tempMajors.get(j).getName();
					majorOptions.add(tempOneMajor);
					out.println("                                        <label class=\"form-check-label\">\r\n"
					+ "                                            <input type=\"radio\" class=\"form-check-input\" value=\"\" + "+ tempOneMajor + " + name=\"majOption\" id=\"majOption\" checked>" + tempOneMajor +"\r\n"
					+ "                                        </label>\r\n" );
					}
				out.println("                                    </div>\r\n"                             
				+ "                                 </div>\r\n"
				);
			}
			getServletContext().setAttribute("majorOptions", majorOptions);
				out.println( "                            </div>\r\n" + "                        </div>\r\n"
				+ "                    </fieldset>");
		
		out.println("<button type=\"submit\" class=\"btn btn-primary\">Register</button>\r\n"
				+ "                </form>\r\n" + "\r\n" + "                <!-- Footer of the page -->\r\n"
				+ "                <div>\r\n" + "                    <footer class=\"footer\">\r\n"
				+ "                        <!-- Mini Naviation-->\r\n"
				+ "                        <div class=\"container text-center\">\r\n"
				+ "                            <nav class=\"navbar navbar-toggleable-md navbar-light bg-faded  mini-boxes\">\r\n"
				+ "                                <button class=\"navbar-toggler navbar-toggler-right\" type=\"button\" data-toggle=\"collapse\" data-target=\"#navbarSupportedContent\"\r\n"
				+ "                                    aria-controls=\"navbarSupportedContent\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\r\n"
				+ "                                    <span class=\"navbar-toggler-icon\"></span>\r\n"
				+ "                                </button>\r\n" + "                                <!-- Logo -->\r\n"
				+ "                                <div class=\"navbar-brand\">\r\n"
				+ "                                    <aside title=\"Projects Logo\">\r\n"
				+ "                                        <img width=\"150px\" height=\"150px\" src=\"http://cs3.calstatela.edu:8080/cs3337stu10/Images/Logo.png\" alt=\"Logo Picture\">\r\n"
				+ "                                    </aside>\r\n" + "                                </div>\r\n"
				+ "                                <div class=\"collapse navbar-collapse\" id=\"navbarSupportedContent\">\r\n"
				+ "                                    <ul class=\"navbar-nav mr-auto\">\r\n"
				+ "                                        <li class=\"nav-item active\">\r\n"
				+ "                                            <a class=\"nav-link\" href=\"../sessions/Login\">Login\r\n"
				+ "                                                <span class=\"sr-only\">(current)</span>\r\n"
				+ "                                            </a>\r\n"
				+ "                                        </li>\r\n"
				+ "                                        <li class=\"nav-item\">\r\n"
				+ "                                            <a class=\"nav-link\" href=\"../Info/Help\">Help</a>\r\n"
				+ "                                        </li>\r\n"
				+ "                                        <li class=\"nav-item\">\r\n"
				+ "                                            <a class=\"nav-link\" href=\"../Info/ContactAlmanac\">Contact and Suggestions </a>\r\n"
				+ "                                        </li>\r\n"
				+ "                                        <li class=\"nav-item\">\r\n"
				+ "                                            <a class=\"nav-link disabled\">Forum</a>\r\n"
				+ "                                        </li>\r\n"
				+ "                                        <li class=\"nav-item\">\r\n"
				+ "                                            <a class=\"nav-link disabled\">Recomendations and Modifications</a>\r\n"
				+ "                                        </li>\r\n"
				+ "                                        <li class=\"nav-item\">\r\n"
				+ "                                            <a class=\"nav-link disabled\">Calendar</a>\r\n"
				+ "                                        </li>\r\n" + "                                    </ul>\r\n"
				+ "                                </div>\r\n" + "                            </nav>\r\n"
				+ "                            <p class=\"p1\">&copy;2017 Almanac, All Rights Reserve.</p>\r\n"
				+ "                        </div>\r\n" + "                </div>\r\n"
				+ "                <!-- Other Resources Needed By Bootstrap -->\r\n"
				+ "                <script src=\"https://code.jquery.com/jquery-3.1.1.slim.min.js\" integrity=\"sha384-A7FZj7v+d/sdmMqp/nOQwliLvUsJfDHW+k9Omg/a/EheAdgtzNs3hpfag6Ed950n\"\r\n"
				+ "                    crossorigin=\"anonymous\"></script>\r\n"
				+ "                <script src=\"https://cdnjs.cloudflare.com/ajax/libs/tether/1.4.0/js/tether.min.js\" integrity=\"sha384-DztdAPBWPRXSA/3eYEEUWrWCy7G5KFbe8fFjk5JAIxUYHKkDx6Qin1DkWx51bBrb\"\r\n"
				+ "                    crossorigin=\"anonymous\"></script>\r\n"
				+ "                <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/js/bootstrap.min.js\" integrity=\"sha384-vBWWzlZJ8ea9aCX4pEW3rVHjgjt7zpkNpZk+02D9phzyeVkE+jo0ieGizqPLForn\"\r\n"
				+ "                    crossorigin=\"anonymous\"></script>\r\n" + "                </footer>\r\n"
				+ "            </div>\r\n" + "    </body>\r\n" + "\r\n" + "    </html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
    boolean emailInUse(String email) {
		ArrayList<Student> students = (ArrayList<Student>) getServletContext().getAttribute("students");
		if(students == null) {
			System.out.println("Theres nothing in students");
		}
		for (int i = 0; i < students.size(); i++) {
			System.out.println("Student " + i + " is -" + students.get(i));
		}
		for (Student student : students) {
			if (student.getEmail().toLowerCase().matches(email.toLowerCase()))
				return true;
		}
		return false;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String firstName = request.getParameter("fName");
		String lastName = request.getParameter("lName");
		
		String email = request.getParameter("username");
		System.out.println("This is an email" + email);
		
		String password1 = request.getParameter("password1");
		String password2 = request.getParameter("password2");
		//With the arraylist of majorOptions and DeptOptions, check what dept they choose and add it in the New Student
		ArrayList<String> deptOptions = (ArrayList<String>) getServletContext().getAttribute("deptOption");
		ArrayList<String> majorOption = (ArrayList<String>) getServletContext().getAttribute("majorOptions");
		
		boolean hasError = false;
		if (firstName.isEmpty() || firstName.matches("[A-Za-z]")) {
			request.setAttribute("fError", "You must enter a first name");
			hasError = true;
		}
		if (lastName.isEmpty() || lastName.matches("[A-Za-z]")) {
			request.setAttribute("lError", "You must enter a last name");
			hasError = true;
		}
		if (email==null || email.trim().length() == 0) {
			request.setAttribute("emailError", "You must enter an email");
			hasError = true;
		} else if (emailInUse(email)) {
			request.setAttribute("emailError", "This email is already registered");
			hasError = true;
		}
		if (password1.isEmpty() || password1.trim().length() == 0) {
			request.setAttribute("passwordError", "You must enter a password");
			hasError = true;
		} else if (password2.isEmpty() || !password1.equals(password2)) {
			request.setAttribute("passwordError", "Passwords don't match");
			hasError = true;
		}
		if (hasError) {
			doGet(request, response);
			return;
		} else {
			ArrayList<Student> students = (ArrayList<Student>) getServletContext().getAttribute("students");
			Global mainDB = (Global) getServletContext().getAttribute("mainDB");
			//Student newStudent = new Student(firstName, lastName, email, password1,info[]);
			//students.add(newStudent);
			HttpSession session = request.getSession();
			//session.setAttribute("authenticatedStudent", newStudent);
			response.sendRedirect("sessions/Login");
			return;

		}
	}

}