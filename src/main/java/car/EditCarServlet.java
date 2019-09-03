package car;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EditCarServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            int car_id = Integer.parseInt(request.getParameter("id"));
            Car car = CarDB.selectOne(car_id);
            if(car!=null) {
                request.setAttribute("car", car);
                getServletContext().getRequestDispatcher("/editcar.jsp").forward(request, response);
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
            int car_id = Integer.parseInt(request.getParameter("id"));
            int seller_id = Integer.parseInt(request.getParameter("seller_id"));
            int location_id = Integer.parseInt(request.getParameter("location_id"));
            String model = request.getParameter("model");
            String brand = request.getParameter("brand");
            int age = Integer.parseInt(request.getParameter("age"));
            int mileage = Integer.parseInt(request.getParameter("mileage"));
            int price = Integer.parseInt(request.getParameter("price"));
            String colour = request.getParameter("colour");

            Car car = new Car(car_id, seller_id, location_id, model, brand, age, mileage, price, colour);
            CarDB.update(car);
            response.sendRedirect(request.getContextPath() + "/car");
        }
        catch(Exception ex) {

            getServletContext().getRequestDispatcher("/notfound.jsp").forward(request, response);
        }
    }
}