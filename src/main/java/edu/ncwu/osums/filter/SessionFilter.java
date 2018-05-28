package edu.ncwu.osums.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.ncwu.osums.entity.Position;
import edu.ncwu.osums.entity.User;

@WebFilter(urlPatterns = "/*")
public class SessionFilter implements Filter {
    @Override
    public void init(FilterConfig arg0) throws ServletException {}

    @Override
    public void doFilter(ServletRequest servletRequest , ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        HttpServletResponse response = (HttpServletResponse)servletResponse;
        request.setCharacterEncoding("UTF-8");
        String requestedUri = request.getRequestURI().substring(request.getContextPath().length());
        String[] noNeedLoginUris = {"/index/rjxy", "/index/findById", "/login", "/recruitment/signedUp", "/recruitment/create", "/recruitment/upload", "/feedback/create"};
        boolean isAllow = false;

        for (String uri : noNeedLoginUris) {
            if (uri.equals(requestedUri) || requestedUri.endsWith(".js") || requestedUri.endsWith(".css") || requestedUri.endsWith(".jpg") || requestedUri.endsWith(".png") || requestedUri.endsWith(".ico")) {
                isAllow = true;
                break;
            }
        }

        if (isAllow) {
            filterChain.doFilter(request, response);
        } else {
            HttpSession session = request.getSession();
            User user = (User)session.getAttribute("user");
            Position position = (Position)session.getAttribute("position");

            if (user == null) {
                PrintWriter printWriter = response.getWriter();
                printWriter.println("<html>");
                printWriter.println("<script>");
                printWriter.println("window.close()");
                printWriter.println("window.open('" + request.getContextPath() + "/index/rjxy')");
                printWriter.println("</script>");
                printWriter.println("</html>");
            } else {
                if ("/index/findAll".equals(requestedUri)) {
                    if (position.getPermission_id() <= 2 || "新媒体宣传部".equals(user.getDepartment_name())) {
                        filterChain.doFilter(request, response);
                    } else {
                        PrintWriter printWriter = response.getWriter();
                        printWriter.println("<html>");
                        printWriter.println("<script>");
                        printWriter.println("alert('You do not have permission!')");
                        printWriter.println("window.location.href='/index/rjxy'");
                        printWriter.println("</script>");
                        printWriter.println("</html>");
                    }
                } else if ("/feedback/findAll".equals(requestedUri)) {
                    if (position.getPermission_id() <= 2 || "提案调研部".equals(user.getDepartment_name())) {
                        filterChain.doFilter(request, response);
                    } else {
                        PrintWriter printWriter = response.getWriter();
                        printWriter.println("<html>");
                        printWriter.println("<script>");
                        printWriter.println("alert('You do not have permission!')");
                        printWriter.println("window.location.href='/index/rjxy'");
                        printWriter.println("</script>");
                        printWriter.println("</html>");
                    }
                } else {
                    filterChain.doFilter(request, response);
                }
            }
        }
    }

    @Override
    public void destroy() {}
}
