package Servlet;

import Model.Interest;

import Service.OrInterestService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by pc on 2016/3/11.
 */
public class InterestRateServlet extends HttpServlet {
    /*
    * 创建 interest
    *  ：本金 利率 年份
    * */
    private Interest interest = new Interest();

    /*
    * post 方法
    * */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        interest.setPrincipal(Integer.parseInt(request.getParameter("principal")));
        interest.setInterest(Double.parseDouble(request.getParameter("interestRate")));
        interest.setYear(Integer.parseInt(request.getParameter("year")));

        OrInterestService orInterestService = new OrInterestService();

//        I_InterestService compoundInterestService = new SingleInterestService();
//        System.out.println(compoundInterestService.calculate(interest));

        String compound = orInterestService.orInterest(request.getParameter("interest"),interest);
        if(compound != null ){
            request.getSession().setAttribute("compound",compound);
            RequestDispatcher rd = request.getRequestDispatcher("/Jsp/successInterest.jsp");
            rd.forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
