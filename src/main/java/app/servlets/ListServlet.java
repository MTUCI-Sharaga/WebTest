package app.servlets;

import app.dbConnector.UserService;
import app.entities.User;
import app.model.Model;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class ListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

//        UserService service = new UserService();
//        List<User> users = service.findAllUsers();
//        req.setAttribute("users", users);


        Model model = Model.getInstance();
        List<String> names = model.listNames();
        List<String> sexes = model.listSexes();
        List<Integer> ages = model.listAges();
        req.setAttribute("userNames", names);
        req.setAttribute("userSexes", sexes);
        req.setAttribute("userAges", ages);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/list.jsp");
        requestDispatcher.forward(req, resp);
    }
}
