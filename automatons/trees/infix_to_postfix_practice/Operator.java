public class Operator{

    public String operator;
    public int precedence;
    public boolean isLeftToRight;

    public Operator(String operator, int precedence, boolean isLeftToRight){
        this.operator = operator;
        this.precedence = precedence;
        this.isLeftToRight = isLeftToRight;
    }
}
