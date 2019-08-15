package seller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/editsell")
public class EditSellServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            int seller_id = Integer.parseInt(request.getParameter("id"));
            Seller seller = SellerDB.selectOne(seller_id);
            if(seller!=null) {
                request.setAttribute("seller", seller);
                getServletContext().getRequestDispatcher("/editsell.jsp").forward(request, response);
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
            int seller_id = Integer.parseInt(request.getParameter("id"));
            String name = request.getParameter("name");
            String gender = request.getParameter("gender");
            int age = Integer.parseInt(request.getParameter("age"));
            String email = request.getParameter("email");
            long telnumber = Integer.parseInt(request.getParameter("telnumber"));
            Seller seller = new Seller(seller_id, name, gender, age, email, telnumber);
            SellerDB.update(seller);
            response.sendRedirect(request.getContextPath() + "/sell");
        }
        catch(Exception ex) {

            getServletContext().getRequestDispatcher("/notfound.jsp").forward(request, response);
        }
    }
}