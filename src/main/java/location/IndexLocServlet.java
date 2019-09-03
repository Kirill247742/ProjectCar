package location;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;


public class IndexLocServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        final HttpSession session = request.getSession();
        String role = (String) session.getAttribute("role");

        if (role.equals("ADMIN")) {
        ArrayList<Location> locations = LocationDB.select();
        request.setAttribute("locations", locations);
        getServletContext().getRequestDispatcher("/indexloc.jsp").forward(request, response);}

        else if (role.equals("USER")) {
            ArrayList<Location> locations = LocationDB.select();
            request.setAttribute("locations", locations);
            getServletContext().getRequestDispatcher("/indexlocUSER.jsp").forward(request, response);
        }
    }


}