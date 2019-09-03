package car;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class IndexCarServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        final HttpSession session = request.getSession();
        String role = (String) session.getAttribute("role");
        if (role.equals("ADMIN")) {

            String login = request.getParameter("login");
            ArrayList<Car> cars = CarDB.select();
            ArrayList<AmountBrand> amount = CarDB.selectamount();
            request.setAttribute("cars", cars);
            request.setAttribute("amount", amount);
            request.setAttribute("login", login);

            getServletContext().getRequestDispatcher("/indexcar.jsp").forward(request, response);

        } else if (role.equals("USER")) {

            ArrayList<Car> cars = CarDB.select();
            request.setAttribute("cars", cars);

            getServletContext().getRequestDispatcher("/indexcarUSER.jsp").forward(request, response);
        }

    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {

            final HttpSession session = request.getSession();
            String role = (String) session.getAttribute("role");
            ArrayList<Car> cars = new ArrayList<>();

            if (role.equals("ADMIN")) {
            String login = request.getParameter("login");
            String search = request.getParameter("search");
            String type = request.getParameter("typefilter");

            if(type.equals("brand")){cars = CarDB.selectfilterbrand(search);}
            if(type.equals("mileage")){int i = Integer.parseInt(search);
                                       cars = CarDB.selectfiltermileage(i);}
            if(type.equals("price")){int i = Integer.parseInt(search);
                                     cars = CarDB.selectfilterprice(i);}

            request.setAttribute("cars", cars);

            ArrayList<AmountBrand> amount = CarDB.selectamount();
            request.setAttribute("amount", amount);
            request.setAttribute("login", login);
            getServletContext().getRequestDispatcher("/indexcar.jsp").forward(request, response);}

            else if (role.equals("USER")) {
                String search = request.getParameter("search");
                cars = CarDB.selectfilterbrand(search);
                request.setAttribute("cars", cars);
                getServletContext().getRequestDispatcher("/indexcarUSER.jsp").forward(request, response);
            }


        }
        catch(Exception ex) {

            getServletContext().getRequestDispatcher("/notfound.jsp").forward(request, response);
        }
    }
}