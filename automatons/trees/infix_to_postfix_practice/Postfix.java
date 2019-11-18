import java.util.ArrayList;
import java.util.Stack;
import java.util.Hashtable;

public class Postfix{
    private static ArrayList<String> postfixList = new ArrayList<String>();
    private static Stack<String> operatorsStack = new Stack<String>();
    private static Stack<Float> evaluationStack = new Stack<Float>();
    private static Hashtable<String, Integer> operatorsValues = new Hashtable<String, Integer>();

    // Static block initialize variable (runs just once)
    // To compare the operators precedence
    // To know if a value in postfixList is an operand or an operator (in
    // evaluatePostfix function)
    static{
        operatorsValues.put("+", 0);
        operatorsValues.put("-", 0);
        operatorsValues.put("*", 1);
        operatorsValues.put("/", 1);

        // Just to test if the given value to the shuntingYard algorithm is
        // an operand. Doesn't affect the algorithm
        operatorsValues.put("(", 2);
        operatorsValues.put(")", 2);
    }

    // Get postfixList
    static ArrayList<String> getPostfixList(){
        return postfixList;
    }

    // Add the remaining stack elements to the postfix list
    static void flushStack(){
        while(!operatorsStack.isEmpty()){
            postfixList.add(operatorsStack.pop());
        };
    }

    static void shuntingYard(String operator){
        // If current "operator" variable doesn't contain a operator then is a
        // constant/variable
        if(!operatorsValues.containsKey(operator)){
            postfixList.add(operator);
        }
        // If the "operator" is ")", then pop all the stack elements till
        // reach "(". "(" and ")" are discarded
        else if(operator == ")"){

            String stackTopOperator;

            do{
                stackTopOperator = operatorsStack.pop();
                if(stackTopOperator != "("){
                    postfixList.add(stackTopOperator);
                }
            }while(stackTopOperator != "(");
        }
        // If either the current "operator" is "(", the stack is empty, the
        // stack top element is "(" or current "operator" precedence is higher
        // than the stack top element. Then push the "operator" onto the
        // stack
        else if(
                operator == "(" ||
                operatorsStack.isEmpty() ||
                operatorsStack.peek() == "(" ||
                operatorsValues.get(operator) >
                operatorsValues.get(operatorsStack.peek())
               ){

            operatorsStack.push(operator);
        }else{
            int currentOperatorValue = operatorsValues.get(operator);
            int stackTopOperatorValue = operatorsValues.get(operatorsStack.peek());

            // If the current "operator" precedence is lower or equals than
            // the stack top element, then stack elements will be popped
            // till the stack is empty or the stack top element is "(". Then
            // the current operator will be pushed to the stack
            while(
                    currentOperatorValue < stackTopOperatorValue ||
                    currentOperatorValue == stackTopOperatorValue
                 ){

                postfixList.add(operatorsStack.pop());

                if(operatorsStack.isEmpty() || operatorsStack.peek() == "("){
                    break;
                }

                stackTopOperatorValue = operatorsValues.get(operatorsStack.peek());
            };

            operatorsStack.push(operator);
        }
    }

    static float evaluatePostfix(){
        for(String item : postfixList){
            if(operatorsValues.containsKey(item)){
                //It is an operator

                float rightOperand = evaluationStack.pop();
                float leftOperand = evaluationStack.pop();

                if(item == "+"){
                    evaluationStack.push(leftOperand + rightOperand);
                }else if(item == "-"){
                    evaluationStack.push(leftOperand - rightOperand);
                }else if(item == "*"){
                    evaluationStack.push(leftOperand * rightOperand);
                }else if(item == "/"){
                    if(rightOperand == 0.0){
                        System.out.println("Can not divide by 0");
                        System.exit(1);
                    }

                    evaluationStack.push(leftOperand / rightOperand);
                }
            }else{
                //It is not an operator

                evaluationStack.push(Float.parseFloat(item));
            }
        }

        return evaluationStack.pop();
    }
}
