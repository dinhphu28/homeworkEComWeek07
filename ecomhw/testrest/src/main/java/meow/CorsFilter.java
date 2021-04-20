package meow;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author anthony
 */
public class CorsFilter implements Filter {
    /**
     * Destroy method for this filter
     */
    public void destroy() {
    }

    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {

                HttpServletResponse resp = (HttpServletResponse) response;
                // HttpServletRequest req = (HttpServletRequest) request;

                resp.addHeader("Access-Control-Allow-Origin", "*");
                resp.addHeader("Access-Control-Allow-Headers", "*");
                resp.addHeader("Access-Control-Allow-Methods", "*");
                resp.addHeader("Access-Control-Expose-Headers", "*");
                // resp.addHeader("Accept-Charset", "*");
                // resp.setCharacterEncoding("UTF-8");

                // req.setCharacterEncoding("UTF-8");
                response.setCharacterEncoding("UTF-8");
                request.setCharacterEncoding("UTF-8");

                chain.doFilter(request, response);
    }

    public void init(FilterConfig filterConfig) {

    }

}
