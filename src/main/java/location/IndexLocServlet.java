package location;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;


@WebServlet("/loc")
public class IndexLocServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ArrayList<Location> locations = LocationDB.select();
        request.setAttribute("locations", locations);

        getServletContext().getRequestDispatcher("/indexloc.jsp").forward(request, response);
    }
}