package location;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


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