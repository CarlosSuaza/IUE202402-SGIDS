package org.iuedesarrollosoftware.orm.filters;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletRequestWrapper;

import java.io.IOException;

public class MethodOverrideFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;

        String method = req.getParameter("_method");
        if (method != null && ("PUT".equalsIgnoreCase(method) || "DELETE".equalsIgnoreCase(method))) {
            HttpServletRequestWrapper requestWrapper = new HttpServletRequestWrapper(req) {
                @Override
                public String getMethod() {
                    return method.toUpperCase();
                }
            };
            chain.doFilter(requestWrapper, response);
        } else {
            chain.doFilter(request, response);
        }
    }

}
