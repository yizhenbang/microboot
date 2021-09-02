package com.yzb.filter;

import org.springframework.boot.web.servlet.ServletComponentScan;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import java.io.IOException;

/**
 * ClassName: MFilter
 * Description:
 * date: 2021/9/2 16:14
 *
 * @author ZhenBang-Yi
 * @version 1.0
 * @since JDK 1.8
 */
@WebFilter("/*")
public class MFilter extends HttpFilter {
    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        System.out.println("【MFilter】=================");
        chain.doFilter(req, res);
    }
}
