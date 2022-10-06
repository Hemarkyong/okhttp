package com.http.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SessionFilter implements Filter {

    public void init(FilterConfig filterConfig) {
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
            throws IOException, ServletException {
        try {
            // System.out.println(((HttpServletRequest)
            // request).getSession(false) );
            if (request instanceof HttpServletRequest) {
                filterChain.doFilter(request, response);
            } else {
                filterChain.doFilter(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
            if (request instanceof HttpServletRequest) {
                HttpServletRequest req = (HttpServletRequest)request;
                HttpServletResponse resp = (HttpServletResponse)response;
                String path = req.getContextPath();
                String sessionOutUrl = request.getScheme() + "://" + request.getServerName() + ":"
                        + request.getServerPort() + path + "/";
                // sessionOutUrl += "/common/sessionTimeout.jsp";
                // resp.sendRedirect(sessionOutUrl);
            }
        }
    }

    public void destroy() {
        return;
    }
}
