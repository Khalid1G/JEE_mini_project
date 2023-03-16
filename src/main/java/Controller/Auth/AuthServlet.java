package Controller.Auth;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/auth")
public class AuthServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// http://example.com/auth?action=login

		String action = request.getParameter("action");

		PrintWriter out = response.getWriter();
		out.print(request.getContextPath());
		response.sendRedirect("view/");
        if ("login".equals(action)) {
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            
            if (authenticate(email, password)) {
                HttpSession session = request.getSession(true);
                session.setAttribute("email", email);
                response.sendRedirect("/");
            } else {
                response.sendRedirect("/login.jsp?error=Invalid credentials");
            }
        } else if ("logout".equals(action)) {
            HttpSession session = request.getSession(false);
            if (session != null) {
                session.invalidate();
            }
            response.sendRedirect(request.getContextPath() + "/login.jsp");
        }
	}

	private boolean authenticate(String username, String password) {
		return true;
	}
}
