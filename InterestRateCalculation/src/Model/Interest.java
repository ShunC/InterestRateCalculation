package Model;

/**
 * Created by pc on 2016/3/11.
 */
public class Interest {

    private int principal;
    private double interest;
    private int year;
    private int amount;

    public int getPrincipal() {
        return principal;
    }

    public void setPrincipal(int principal) {
        this.principal = principal;
    }

    public double getInterest() {
        return interest;
    }

    public void setInterest(double interest) {
        this.interest = interest;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Interest() {
    }

    public Interest(double interest, int principal, int year) {
        this.interest = interest;
        this.principal = principal;
        this.year = year;
    }


}
