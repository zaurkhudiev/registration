package controller;

import dao.UserDao;
import dao.UserInfoDao;
import model.User;
import model.UserInfo;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
/** DashboardControllerServlet
 * @author zaur
 * This class takes the personal information about the user    */
@WebServlet("/dash")   //defines the servlet
public class DashboardControllerServlet extends HttpServlet {

    private UserInfoDao userInfoDao= new UserInfoDao();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().append("Server at: ").append(req.getContextPath());
        RequestDispatcher dispatcher = req.getRequestDispatcher("/login.jsp");
        dispatcher.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firstname = req.getParameter("firstname");
        String lastname = req.getParameter("lastname");
        String city = req.getParameter("city");
        String country = req.getParameter("country");
        String gender = req.getParameter("gender");                   //sets the information after them taking
        UserInfo userInfo = new UserInfo();
        userInfo.setFirstname(firstname);
        userInfo.setLastname(lastname);
        userInfo.setCity(city);
        userInfo.setCountry(country);
        userInfo.setGender(gender);
        try {
            userInfoDao.regUser1(userInfo);
        } catch (ClassNotFoundException | SQLException e) {      /** DashboardControllerServlet
                                                                 * @author zaur
                                                                  * catch the exceptions if there is   */
            //We should not show exception to the client
        }
        RequestDispatcher dispatcher = req.getRequestDispatcher("/index.jsp");
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