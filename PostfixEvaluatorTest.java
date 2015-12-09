import java.util.*;

public class PostfixEvaluatorTest
{
    public static void main(String[] args)
    {
        Scanner keyboard = new Scanner(System.in);
        PostfixEvaluator post = new PostfixEvaluator();
        System.out.println("Enter the expression: ");
        String eval = keyboard.nextLine();
        int result = 0;
        result = post.evaluate(eval);
        System.out.println(result);

    }
}
