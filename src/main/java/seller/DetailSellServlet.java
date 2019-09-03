package seller;

import car.Car;
import car.CarDB;
import location.*;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




public class DetailSellServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            int seller_id = Integer.parseInt(request.getParameter("id"));
            int car_id = Integer.parseInt(request.getParameter("car_id"));
            int location_id = Integer.parseInt(request.getParameter("location_id"));
            Seller seller = SellerDB.selectOne(seller_id);
            Car car = CarDB.selectOne(car_id);
            Location location = LocationDB.selectOne(location_id);
            if(seller!=null && car!=null && location!=null) {
                request.setAttribute("seller", seller);
                request.setAttribute("car", car);
                request.setAttribute("location", location);
                getServletContext().getRequestDispatcher("/detailsell.jsp").forward(request, response);
            }
            else {
                getServletContext().getRequestDispatcher("/notfound.jsp").forward(request, response);
            }
        }
        catch(Exception ex) {
            getServletContext().getRequestDispatcher("/notfound.jsp").forward(request, response);
        }
    }


}