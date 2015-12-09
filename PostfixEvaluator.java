import java.util.*;

public class PostfixEvaluator {
    private static final char ADD = '+', SUBTRACT = '-';
    private static final char MULTIPLY = '*', DIVIDE = '/';

    private ArrayStack stack;

    public PostfixEvaluator() 
    {
        stack = new ArrayStack();
    }

    public int evaluate(String expr) 
    {
        stack = new ArrayStack();
        int op1, op2, result = 0;
        String token;
        StringTokenizer tokenizer = new StringTokenizer(expr);

        while (tokenizer.hasMoreTokens()) 
        {
            token = tokenizer.nextToken();

            if (isOperator(token)) 
            {
                op2 = ((Integer) stack.pop()).intValue();
                op1 = ((Integer) stack.pop()).intValue();
                result = evalSingleOp(token.charAt(0), op1, op2);
                stack.push(new Integer(result));
            }
            else
                stack.push(new Integer(Integer.parseInt(token)));
        }

        result = ((Integer) stack.pop()).intValue();
        return result;
    }

    private boolean isOperator(String token) 
    {
        return (
            token.equals("+")
                || token.equals("-")
                || token.equals("*")
                || token.equals("/"));
    }


    private int evalSingleOp(char operation, int op1, int op2) 
    {
        int result = 0;

        switch (operation) {
            case ADD :
                result = op1 + op2;
                break;
            case SUBTRACT :
                result = op1 - op2;
                break;
            case MULTIPLY :
                result = op1 * op2;
                break;
            case DIVIDE :
                result = op1 / op2;
        }

        return result;
    }
}
