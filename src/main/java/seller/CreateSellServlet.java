package seller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class CreateSellServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        getServletContext().getRequestDispatcher("/createsell.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            String name = request.getParameter("name");
            String gender = request.getParameter("gender");
            int age = Integer.parseInt(request.getParameter("age"));
            String email = request.getParameter("email");
            long telnumber = Integer.parseInt(request.getParameter("telnumber"));
            Seller seller = new Seller(name, gender, age, email, telnumber);
            SellerDB.insert(seller);
            response.sendRedirect(request.getContextPath()+"/");
        }
        catch(Exception ex) {

            getServletContext().getRequestDispatcher("/createsell.jsp").forward(request, response);
        }
    }
}