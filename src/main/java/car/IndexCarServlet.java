package car;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/car")
public class IndexCarServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ArrayList<Car> cars = CarDB.select();
        request.setAttribute("cars", cars);

        getServletContext().getRequestDispatcher("/indexcar.jsp").forward(request, response);
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {

            String searchbrand = request.getParameter("brand");
            ArrayList<Car> cars = CarDB.selectfiltr(searchbrand);
            request.setAttribute("cars", cars);
            getServletContext().getRequestDispatcher("/indexcar.jsp").forward(request, response);
        }
        catch(Exception ex) {

            getServletContext().getRequestDispatcher("/notfound.jsp").forward(request, response);
        }
    }
}