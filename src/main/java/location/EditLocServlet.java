package location;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/editloc")
public class EditLocServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            int location_id = Integer.parseInt(request.getParameter("id"));
            Location location = LocationDB.selectOne(location_id);
            if(location!=null) {
                request.setAttribute("location", location);
                getServletContext().getRequestDispatcher("/editloc.jsp").forward(request, response);
            }
            else {
                getServletContext().getRequestDispatcher("/notfound.jsp").forward(request, response);
            }
        }
        catch(Exception ex) {
            getServletContext().getRequestDispatcher("/notfound.jsp").forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            int location_id = Integer.parseInt(request.getParameter("id"));
            String name = request.getParameter("name");
            Location location = new Location(location_id, name);
            LocationDB.update(location);
            response.sendRedirect(request.getContextPath() + "/loc");
        }
        catch(Exception ex) {

            getServletContext().getRequestDispatcher("/notfound.jsp").forward(request, response);
        }
    }
}