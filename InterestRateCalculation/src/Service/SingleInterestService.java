package Service;

import Model.Interest;

import java.text.DecimalFormat;

/**
 * Created by pc on 2016/3/12.
 */
public class SingleInterestService implements I_InterestService{
    @Override
    public String calculate(Interest interest) {
        DecimalFormat df   = new DecimalFormat("######0.00");
        return df.format(interest.getPrincipal()*(interest.getInterest()+1)*interest.getYear());
    }
}
