package com.ldsw.dcc192.controllers;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;

public class PagesFilter implements Filter {

    private FilterConfig filterConfig;

    /**
     * @param filterConfig a <code>FilterConfig</code> object containing the filter's configuration and initialization
     *                     parameters
     * @throws ServletException
     */
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
        if (this.filterConfig != null) {
            filterConfig.getServletContext().log("controlsession:Initializing filter");
        }
    }

    /**
     * @param request  the <code>ServletRequest</code> object contains the client's request
     * @param response the <code>ServletResponse</code> object contains the filter's response
     * @param chain    the <code>FilterChain</code> for invoking the next filter or the resource
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        var session = ((HttpServletRequest) request).getSession(true);
        var loggedIn = (String) session.getAttribute("logged");
        var path = ((HttpServletRequest) request).getRequestURI();
        RequestDispatcher rd;
        if (loggedIn == null || !loggedIn.equals("true")) {
            if (path.contains("index.jsp")) {
                chain.doFilter(request, response);
            } else {
                session.setAttribute("error", "Você precisa estar logado para acessar esta página");
                rd = request.getRequestDispatcher("index.jsp");
                rd.forward(request, response);
            }
        } else {
            chain.doFilter(request, response);
        }

    }

    /**
     *
     */
    @Override
    public void destroy() {
        jakarta.servlet.Filter.super.destroy();
    }
}