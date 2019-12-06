import java.util.ArrayList;
import java.util.Stack;
import java.util.Hashtable;
import java.util.Arrays;

public class Postfix {
    private static ArrayList<String> postfixList = new ArrayList<String>();
    private static Stack<String> operatorsStack = new Stack<String>();
    private static Hashtable<String, Operator> operatorsValues = new Hashtable<String, Operator>();
    private static Stack<String> intermediateCodeStack = new Stack<String>();
    private static ArrayList<ArrayList<String>> cuadruples = new ArrayList<ArrayList<String>>();
    private static ArrayList<Integer> toJumpCuadrupleIndexes = new ArrayList<Integer>();

    // Static block initialize variable (runs just once)
    // To compare the operators precedence
    // To know if a value in postfixList is an operand or an operator (in
    // evaluatePostfix function)
    static {
        operatorsValues.put("=", new Operator("=", 0, false));

        operatorsValues.put("==", new Operator("==", 1, true));
        operatorsValues.put("!=", new Operator("!=", 1, true));

        operatorsValues.put("<", new Operator("<", 2, true));
        operatorsValues.put(">", new Operator(">", 2, true));
        operatorsValues.put("<=", new Operator("<=", 2, true));
        operatorsValues.put(">=", new Operator(">=", 2, true));

        operatorsValues.put("+", new Operator("+", 3, true));
        operatorsValues.put("-", new Operator("-", 3, true));

        operatorsValues.put("*", new Operator("*", 4, true));
        operatorsValues.put("/", new Operator("/", 4, true));

        // Just to test if the given value to the shuntingYard algorithm is
        // an operand. Doesn't affect the algorithm
        operatorsValues.put("(", new Operator("(", 5, true));
        operatorsValues.put(")", new Operator(")", 5, true));
    }

    // Get postfixList
    static ArrayList<String> getPostfixList() {
        return postfixList;
    }

    // Add the remaining stack elements to the postfix list
    static void flushStack() {
        while (!operatorsStack.isEmpty()) {
            postfixList.add(operatorsStack.pop());
        }
    }

    static void shuntingYard(String operator) {
        // If current "operator" variable doesn't contain a operator then is a
        // constant/variable
        if (!operatorsValues.containsKey(operator)) {
            postfixList.add(operator);
        }
        // If the "operator" is ")", then pop all the stack elements till
        // reach "(". "(" and ")" are discarded
        else if (operator == ")") {

            String stackTopOperator;

            do {
                stackTopOperator = operatorsStack.pop();
                if (stackTopOperator != "(") {
                    postfixList.add(stackTopOperator);
                }
            } while (stackTopOperator != "(");
        }
        // If either the current "operator" is "(", the stack is empty, the
        // stack top element is "(" or current "operator" precedence is higher
        // than the stack top element. Then push the "operator" onto the
        // stack
        else if (
                operator == "("
                || operatorsStack.isEmpty()
                || operatorsStack.peek() == "("
                || operatorsValues.get(operator).precedence > operatorsValues.get(operatorsStack.peek()).precedence
                || operatorsValues.get(operator).precedence == operatorsValues.get(operatorsStack.peek()).precedence
                && !operatorsValues.get(operator).isLeftToRight
                ) {

            operatorsStack.push(operator);
        } else {
            int currentOperatorPrecedence = operatorsValues.get(operator).precedence;
            int currentTopOperatorPrecedence = operatorsValues.get(operatorsStack.peek()).precedence;

            // If the current "operator" precedence is lower or equals than
            // the stack top element, then stack elements will be popped
            // till the stack is empty or the stack top element is "(". Then
            // the current operator will be pushed to the stack
            while (
                    currentOperatorPrecedence < currentTopOperatorPrecedence
                    || currentOperatorPrecedence == currentTopOperatorPrecedence
                    && operatorsValues.get(operator).isLeftToRight
                  ) {

                postfixList.add(operatorsStack.pop());

                if (operatorsStack.isEmpty() || operatorsStack.peek() == "(") {
                    break;
                }

                currentTopOperatorPrecedence = operatorsValues.get(operatorsStack.peek()).precedence;
                  }

            operatorsStack.push(operator);
        }
    }

    static void generateIntermediateCode() {
        int tempCounter = 1;
        String currentTempVar = "";

        for (String item : postfixList) {
            if (operatorsValues.containsKey(item)) {
                // It is an operator

                String rightOperand = intermediateCodeStack.pop();
                String leftOperand = intermediateCodeStack.pop();

                if(operatorsValues.get(item).isLeftToRight){
                    currentTempVar = String.format("T%s", tempCounter);
                    // String[] cuadruple = {item, leftOperand, rightOperand, currentTempVar};
                    // cuadruples.add(String.format("%s,%s,%s,%s", item, leftOperand, rightOperand, currentTempVar));
                    cuadruples.add(new ArrayList<String>(Arrays.asList(item, leftOperand, rightOperand, currentTempVar)));
                    intermediateCodeStack.push(currentTempVar);
                    tempCounter++;
                }else{
                    // String[] cuadruple = {item, rightOperand, "", leftOperand};
                    // cuadruples.add(String.format("%s,%s,,%s", item, rightOperand, leftOperand));
                    cuadruples.add(new ArrayList<String>(Arrays.asList(item, rightOperand, "", leftOperand)));
                    intermediateCodeStack.push(leftOperand);
                }
            } else {
                // It is not an operator
                intermediateCodeStack.push(item);
            }
        }
    }

    static void evaluateCurrentExpression(){
        Postfix.flushStack();
        Postfix.generateIntermediateCode();
        postfixList.removeAll(postfixList);
    }

    static void printCuadruples(){
        for (ArrayList<String> item : cuadruples) {
            System.out.println("["+cuadruples.indexOf(item)+"]: "+item);
        }
    }

    static void addJumpCuadruple(boolean inElseBlock){
        // The condition sets whether is a conditional jump
        if(!inElseBlock){
            ArrayList<String> lastCuadruple = cuadruples.get(cuadruples.size()-1);
            String lastTempVar = lastCuadruple.get(lastCuadruple.size()-1);
            cuadruples.add(new ArrayList<String>(Arrays.asList("TRZ", "", "", lastTempVar)));
        }else{
            cuadruples.add(new ArrayList<String>(Arrays.asList("TR", "", "", "")));
        }
        toJumpCuadrupleIndexes.add(cuadruples.size()-1);
    }

    static void setJumpCuadruple(){
        if(!toJumpCuadrupleIndexes.isEmpty()){
            String nextCuadrupleIndex = String.valueOf(cuadruples.size());
            ArrayList<String> cuadrupleToSet = cuadruples.get(toJumpCuadrupleIndexes.remove(0));
            cuadrupleToSet.set(1, nextCuadrupleIndex);
        }
    }

    static float evaluatePostfix(Hashtable <String, Id> symbols_table) {
        Stack<Float> evaluationStack = new Stack<Float>();

        for (String item : postfixList) {
            if (operatorsValues.containsKey(item)) {
                // It is an operator

                float rightOperand = evaluationStack.pop();
                float leftOperand = evaluationStack.pop();

                if (item == "+") {
                    evaluationStack.push(leftOperand + rightOperand);
                } else if (item == "-") {
                    evaluationStack.push(leftOperand - rightOperand);
                } else if (item == "*") {
                    evaluationStack.push(leftOperand * rightOperand);
                } else if (item == "/") {
                    if (rightOperand == 0.0) {
                        System.exit(1);
                    }

                    evaluationStack.push(leftOperand / rightOperand);
                }
            } else {
                // It is not an operator
                if(symbols_table.containsKey(item)){
                    evaluationStack.push(Float.parseFloat(symbols_table.get(item).value));
                }else{
                    evaluationStack.push(Float.parseFloat(item));
                }
            }
        }

        return evaluationStack.pop();
    }
}

