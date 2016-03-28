package Test;

import Model.Interest;
import Service.CompoundInterestService;
import Service.OrInterestService;
import Service.PrincipalService;
import Service.SingleInterestService;
import org.junit.Test;

/**
 * Created by pc on 2016/3/28.
 */
public class TestInterest {
    @Test
    public void testInterest(){
        Interest interest = new Interest(0.5,1000,10);
        System.out.println(interest.getInterest() +" "+ interest.getPrincipal() +" "+ interest.getYear());
    }

    @Test
    public void testOrInterest(){
        Interest interest = new Interest(0.5,1000,10);
        System.out.println(new OrInterestService().orInterest("compound" , interest));
        System.out.println(new OrInterestService().orInterest("single" , interest));
    }

    @Test
    public void testCompoundInterest(){
        Interest interest = new Interest(0.5,1000,10);
        System.out.println(new CompoundInterestService().calculate(interest));
    }

    @Test
    public void testSingleInterest(){
        Interest interest = new Interest(0.5,1000,10);
        System.out.println(new SingleInterestService().calculate(interest));
    }

    @Test
    public void testPrincipal(){
        Interest interest = new Interest();
        interest.setAmount(1000);
        interest.setYear(10);
        interest.setInterest(0.5);
        System.out.println(new PrincipalService().calculate(interest));
    }

    @Test
    public void testYear(){
        Interest interest = new Interest();
        interest.setAmount(1000);
        interest.setPrincipal(10000);
        interest.setInterest(0.5);
        System.out.println(new PrincipalService().calculate(interest));
    }

    @Test
    public void testLong(){
        Interest interest = new Interest();
        interest.setAmount(1000000000);
        interest.setPrincipal(1000000000);
        interest.setInterest(0.000000000001);
        System.out.println(new PrincipalService().calculate(interest));
    }

    @Test
    public void test_01(){
        Interest interest = new Interest();
        interest.setAmount(1);
        interest.setPrincipal(1);
        interest.setInterest(1);
        System.out.println(new PrincipalService().calculate(interest));
    }

}
