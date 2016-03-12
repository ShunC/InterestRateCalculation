package Service;

import Model.Interest;

import java.text.DecimalFormat;

/**
 * Created by pc on 2016/3/11.
 */
public class CompoundInterestService implements I_InterestService {

    /*
    * 复利 计算
    *  ：本金 * （1 + 利率 ）^ 年份
    * 输出 字符串 （保存 2 位有效数字）
    * */
    @Override
    public String calculate(Interest interest) {
        DecimalFormat df   = new DecimalFormat("######0.00");
        return df.format(interest.getPrincipal()*Math.pow(interest.getInterest()+1,interest.getYear()));
    }
}
