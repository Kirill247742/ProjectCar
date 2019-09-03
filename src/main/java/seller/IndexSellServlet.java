package seller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class IndexSellServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


        final HttpSession session = request.getSession();
        String role = (String) session.getAttribute("role");

        if (role.equals("ADMIN")) {

            ArrayList<Seller> sellers = SellerDB.select();
            request.setAttribute("sellers", sellers);

            getServletContext().getRequestDispatcher("/indexsell.jsp").forward(request, response);

        } else if (role.equals("USER")) {

            ArrayList<Seller> sellers = SellerDB.select();
            request.setAttribute("sellers", sellers);

            getServletContext().getRequestDispatcher("/indexsellUSER.jsp").forward(request, response);
        }

    }
}