package all.ecommerce.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import all.ecommerce.connection.DbCon;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import all.ecommerce.dao.UserDao;
import all.ecommerce.model.User;

@WebServlet("/user-register")
public class RegisterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Retrieve user registration details from the form
        String name = request.getParameter("login-name");
        String email = request.getParameter("login-email");
        String password = request.getParameter("login-password");

        // Create a User object with the registration details
        User newUser = new User();
        newUser.setName(name);
        newUser.setEmail(email);
        newUser.setPassword(password);

        // Use UserDao to register the user
        UserDao userDao = null;
        try {
            userDao = new UserDao(DbCon.getConnection());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        boolean registrationStatus = userDao.registerUser(newUser);

        // Display registration status
        if (registrationStatus) {
            response.sendRedirect("login.jsp");
        } else {
            response.sendRedirect("register.jsp");
        }

        out.close();
    }
}
