package Filter;


import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by pc on 2016/3/12.
 */
public class ChangeFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;

        String servletPath = httpServletRequest.getServletPath();
        HttpSession httpSession = httpServletRequest.getSession();
        String change = (String) httpSession.getAttribute("change");

        if (servletPath != null) {
            filterChain.doFilter(servletRequest,servletResponse);
        }else {
            if(change !=null && change.equals("single")){
                httpServletRequest.setAttribute("change","single");
                System.out.println("single");
            }else if(change !=null && change.equals("principal")){
                httpServletRequest.setAttribute("change","principal");
                System.out.println("principal");
            }else {
                httpServletRequest.setAttribute("change","compound");
                System.out.println("compound");
            }
            RequestDispatcher rd = httpServletRequest.getRequestDispatcher("/index.jsp");
            rd.forward(httpServletRequest,httpServletResponse);
        }


    }

    @Override
    public void destroy() {

    }
}
