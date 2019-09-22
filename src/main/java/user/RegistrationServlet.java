package user;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static java.util.Objects.nonNull;


@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet {


    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        final HttpSession session = request.getSession();

        if (nonNull(session) &&
                nonNull(session.getAttribute("login")) &&
                nonNull(session.getAttribute("password"))){
            getServletContext().getRequestDispatcher("/requesttologout2.jsp").forward(request, response);
        }
        else getServletContext().getRequestDispatcher("/registration.jsp").forward(request, response);
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            String login = request.getParameter("login");
            String password = request.getParameter("password");
            User user = new User(login,password);
            UserDB.insert(user);
            response.sendRedirect(request.getContextPath()+"/login");
        }
        catch(Exception ex) {

            getServletContext().getRequestDispatcher("/registration.jsp").forward(request, response);
        }
    }
}