package Servlet;

import Model.Interest;
import Service.I_InterestService;
import Service.InterestService;
import Service.OrInterestService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by pc on 2016/3/17.
 */
public class InterestServlet extends HttpServlet {

    private Interest interest = new Interest();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        interest.setPrincipal(Integer.parseInt(request.getParameter("principal")));
        interest.setAmount(Integer.parseInt(request.getParameter("amount")));
        interest.setYear(Integer.parseInt(request.getParameter("year")));

        I_InterestService interestService = new InterestService();
        String  compound = interestService.calculate(interest);
        if(compound != null ){
            request.getSession().setAttribute("compound",compound);
            request.getSession().setAttribute("change" , "利率");
            RequestDispatcher rd = request.getRequestDispatcher("/Jsp/successInterest.jsp");
            rd.forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
