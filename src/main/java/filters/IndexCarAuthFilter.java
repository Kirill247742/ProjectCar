package filters;

import user.UserDB;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


import static java.util.Objects.nonNull;


public class IndexCarAuthFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(final ServletRequest request,
                         final ServletResponse response,
                         final FilterChain filterChain)

            throws IOException, ServletException {

        final HttpServletRequest req = (HttpServletRequest) request;
        final HttpServletResponse res = (HttpServletResponse) response;

        String login = req.getParameter("login");
        String password = req.getParameter("password");

        final HttpSession session = req.getSession();

        if (nonNull(session) &&
                nonNull(session.getAttribute("login")) &&
                nonNull(session.getAttribute("password"))) {

            final String role = (String) session.getAttribute("role");

            if (role.equals("ADMIN")) {

                filterChain.doFilter(req, res);

            } else if (role.equals("USER")) {

                filterChain.doFilter(req, res);

            }


        } else if (UserDB.userIsExist(login, password)) {

            final String role = UserDB.selectRoleByLoginPassword(login, password);

            req.getSession().setAttribute("password", password);
            req.getSession().setAttribute("login", login);
            req.getSession().setAttribute("role", role);

            if (role.equals("ADMIN")) {

                req.getRequestDispatcher("/index.jsp").forward(req, res);

            } else if (role.equals("USER")) {

                req.getRequestDispatcher("/index.jsp").forward(req, res);

            }

        } else if(nonNull(login) &&
                nonNull(password)){

            req.getRequestDispatcher("/loginerr.jsp").forward(req, res);

        } else {req.getRequestDispatcher("/login.jsp").forward(req, res);}
    }


    @Override
    public void destroy() {
    }

}
