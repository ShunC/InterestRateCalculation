package Service;

import Model.Interest;

import java.text.DecimalFormat;

/**
 * Created by pc on 2016/3/17.
 */
public class InterestService implements I_InterestService {
    @Override
    public String calculate(Interest interest) {
        DecimalFormat df   = new DecimalFormat("######0.00");
        return df.format(Math.pow(interest.getAmount()/interest.getPrincipal(),1/interest.getYear())-1);
    }
}
