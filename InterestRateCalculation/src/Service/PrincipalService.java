package Service;

import Model.Interest;

import java.text.DecimalFormat;

/**
 * Created by pc on 2016/3/17.
 */
public class PrincipalService implements I_InterestService {
    @Override
    public String calculate(Interest interest) {
        DecimalFormat df   = new DecimalFormat("######0.00");
        return df.format(interest.getAmount()/Math.pow(interest.getInterest()+1,interest.getYear()));
    }
}
