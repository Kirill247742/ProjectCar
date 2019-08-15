package seller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/sell")
public class IndexSellServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ArrayList<Seller> sellers = SellerDB.select();
        request.setAttribute("sellers", sellers);

        getServletContext().getRequestDispatcher("/indexsell.jsp").forward(request, response);
    }
}