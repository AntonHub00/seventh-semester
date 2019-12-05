public class Operator{

    public String operator;
    public int precedence;
    public boolean isLeft;

    public Operator(String operator, int precedence, boolean isLeft){
        this.operator = operator;
        this.precedence = precedence;
        this.isLeft = isLeft;
    }
}
