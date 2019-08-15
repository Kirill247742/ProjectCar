package location;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/createloc")
public class CreateLocServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        getServletContext().getRequestDispatcher("/createloc.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            String name = request.getParameter("name");
            Location location = new Location(name);
            LocationDB.insert(location);
            response.sendRedirect(request.getContextPath()+"/");
        }
        catch(Exception ex) {

            getServletContext().getRequestDispatcher("/createloc.jsp").forward(request, response);
        }
    }
}