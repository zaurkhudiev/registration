package controller;

import dao.UserDao;
import model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
/** UserServlet
 * @author zaur
 * This class helps user to register and it sends information to regUser method in UserDao before the send, this class sends passwords to Hash class for the hashing process   */

@WebServlet("/register") //it defines webservlet
public class UserServlet extends HttpServlet {
    private UserDao userDao =  new UserDao();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().append("Server at: ").append(req.getContextPath());
        RequestDispatcher dispatcher = req.getRequestDispatcher("/login.jsp");
        dispatcher.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        User user = new User();
        password=Hash.hashh(password);
        user.setEmail(email);
        user.setPassword(password);
        try {
            userDao.regUser(user);
        } catch (ClassNotFoundException | SQLException e) {

        }
        RequestDispatcher dispatcher = req.getRequestDispatcher("/");
        dispatcher.forward(req,resp);
    }

    @Override
    public void destroy() {
        super.destroy();
    }

    @Override
    public void init() throws ServletException {
        super.init();
    }
}
