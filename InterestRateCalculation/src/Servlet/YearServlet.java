package Servlet;

import Model.Interest;
import Service.I_InterestService;
import Service.OrInterestService;
import Service.YearService;

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
public class YearServlet extends HttpServlet {

    private Interest interest = new Interest();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        interest.setPrincipal(Integer.parseInt(request.getParameter("principal")));
        interest.setInterest(Double.parseDouble(request.getParameter("interestRate")));
        interest.setAmount(Integer.parseInt(request.getParameter("amount")));

        I_InterestService yearService = new YearService();
        String compound = yearService.calculate(interest);
        if(compound != null ){
            request.getSession().setAttribute("compound",compound);
            request.getSession().setAttribute("change" , "年限");
            RequestDispatcher rd = request.getRequestDispatcher("/Jsp/successInterest.jsp");
            rd.forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
