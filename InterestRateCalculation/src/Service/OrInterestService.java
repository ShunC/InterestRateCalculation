package Service;

import Model.Interest;

/**
 * Created by pc on 2016/3/11.
 */
public class OrInterestService {
    public String orInterest(String or, Interest interest){
        String orit = null;
        if(or.equals("compound")){
            System.out.println("compound");
            I_InterestService compound = new CompoundInterestService();
            orit =  compound.calculate(interest);
        }else if(or.equals("single")){
            System.out.println("compound");
            I_InterestService compound = new SingleInterestService();
            orit =  compound.calculate(interest);
        }
        return orit;
    }
}
