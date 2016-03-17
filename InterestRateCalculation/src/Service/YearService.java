package Service;

import Model.Interest;

import java.text.DecimalFormat;

/**
 * Created by pc on 2016/3/17.
 */
public class YearService implements I_InterestService{

    @Override
    public String calculate(Interest interest) {
        DecimalFormat df   = new DecimalFormat("######0.00");
        return df.format(Math.log10(interest.getAmount()/interest.getPrincipal())/Math.log10(interest.getInterest()+1));
    }
}
