package car;

import location.Location;
import location.LocationDB;
import seller.*;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/createcar")
public class CreateCarServlet extends HttpServlet {





    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                getServletContext().getRequestDispatcher("/createcar.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            int seller_id = Integer.parseInt(request.getParameter("seller_id"));
            int location_id = Integer.parseInt(request.getParameter("location_id"));
            String model = request.getParameter("model");
            String brand = request.getParameter("brand");
            int age = Integer.parseInt(request.getParameter("age"));
            int mileage = Integer.parseInt(request.getParameter("mileage"));
            int price = Integer.parseInt(request.getParameter("price"));
            String colour = request.getParameter("colour");

            ArrayList<Seller> sellers = SellerDB.select();
            Seller[] sellarray = sellers.toArray(new Seller[sellers.size()]);
            int sid[] = new int[sellers.size()];
            for(int i=0; i<sellarray.length;i++) sid[i]=sellarray[i].getId();

            ArrayList<Location> locations = LocationDB.select();
            Location[] locarray = locations.toArray(new Location[locations.size()]);
            int lid[] = new int[locations.size()];
            for(int i=0; i<locarray.length;i++) lid[i]=locarray[i].getId();

            boolean a=true;
            for(int i=0;i<sid.length;i++){
                if(sid[i]==seller_id){
                    for(int j=0;j<lid.length;j++){
                        if(lid[j]==location_id){
            Car car = new Car(seller_id, location_id, model, brand, age, mileage, price, colour);
            CarDB.insert(car);
            response.sendRedirect(request.getContextPath()+"/");a=false; break;}}}}
            if(a) getServletContext().getRequestDispatcher("/invalidId.jsp").forward(request, response);
        }
        catch(Exception ex) {

            getServletContext().getRequestDispatcher("/createcar.jsp").forward(request, response);
        }
    }
}