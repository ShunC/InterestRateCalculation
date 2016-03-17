package Servlet;

import Model.Interest;
import Service.I_InterestService;
import Service.OrInterestService;
import Service.PrincipalService;

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
public class PrincipalServlet extends HttpServlet {

    private Interest interest = new Interest();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        interest.setAmount(Integer.parseInt(request.getParameter("amount")));
        interest.setInterest(Double.parseDouble(request.getParameter("interest")));
        interest.setYear(Integer.parseInt(request.getParameter("year")));

        I_InterestService principalService = new PrincipalService();
        String compound = principalService.calculate(interest);
        if(compound != null ){
            request.getSession().setAttribute("compound",compound);
            request.getSession().setAttribute("change" , "本金");
            RequestDispatcher rd = request.getRequestDispatcher("/Jsp/successInterest.jsp");
            rd.forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
