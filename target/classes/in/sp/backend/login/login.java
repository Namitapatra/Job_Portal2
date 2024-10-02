package in.sp.backend.login;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

// Define the servlet mapping (URL pattern for accessing this servlet)
@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    // Simulated credentials (In a real scenario, credentials would be fetched from a database)
    private final String VALID_USERNAME = "root";
    private final String VALID_PASSWORD = "Namita220301120155";

    // Handles POST requests, such as the form submission from login page
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        // Get the username and password from the login form submission
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Validate the username and password
        if (VALID_USERNAME.equals(username) && VALID_PASSWORD.equals(password)) {
            // If credentials are valid, create an HTTP session for the user
            HttpSession session = request.getSession();
            session.setAttribute("username", username);

            // Redirect the user to the welcome page (after successful login)
            response.sendRedirect("welcome.jsp");
        } else {
            // If credentials are invalid, redirect back to login page with an error message
            response.sendRedirect("login.jsp?error=true");
        }
    }

    // Optional: Handles GET requests (if you want to support GET for login)
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        // Simply forward the request to the login page (or handle GET logic)
        response.sendRedirect("login.jsp");
    }
}
