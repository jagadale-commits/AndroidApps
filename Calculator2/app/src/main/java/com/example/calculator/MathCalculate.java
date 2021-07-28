package com.example.calculator;
import java.util.Stack;

public class MathCalculate {

    public static String CalculateExpression(String expression) {
        if(expression.charAt(0)=='-') expression = "0" + expression;
        System.out.println(expression);
        while (expression.contains("%")) {
            int Index = expression.indexOf("%");
            expression = expression.substring(0, Index)
                    + "/100"
                    + expression.substring(Index + 1,
                    expression.length());
        }
        return calculate(expression);

    }

    public static String calculate(String expression)
    {
        if(expression.charAt(0)=='-') expression = "0" + expression;
        char[] tokens = expression.toCharArray();


        Stack<Double> values = new
                Stack<Double>();
        Stack<Character> ops = new
                Stack<Character>();

        for (int i = 0; i < tokens.length; i++)
        {

            if (tokens[i] == ' ')
                continue;


            if ((tokens[i] >= '0' &&
                    tokens[i] <= '9') || tokens[i] == '.')
            {
                StringBuffer sbuf = new
                        StringBuffer();

                while (i < tokens.length &&
                        ((tokens[i] >= '0' &&
                                tokens[i] <= '9') || tokens[i] == '.'))
                    sbuf.append(tokens[i++]);
                values.push(Double.parseDouble(sbuf.
                        toString()));
                i--;
            }
            else if (tokens[i] == '(')
                ops.push(tokens[i]);
            else if (tokens[i] == ')')
            {
                while (ops.peek() != '(')
                    values.push(applyOp(ops.pop(),
                            values.pop(),
                            values.pop()));
                ops.pop();
            }
            else if (tokens[i] == '+' ||
                    tokens[i] == '-' ||
                    tokens[i] == '*' ||
                    tokens[i] == '/')
            {
                while (!ops.empty() &&
                        hasPrecedence(tokens[i],
                                ops.peek()))
                    values.push(applyOp(ops.pop(),
                            values.pop(),
                            values.pop()));
                ops.push(tokens[i]);
            }
        }


        while (!ops.empty())
            values.push(applyOp(ops.pop(),
                    values.pop(),
                    values.pop()));


        return values.pop().toString();
    }


    public static boolean hasPrecedence(
            char op1, char op2)
    {
        if (op2 == '(' || op2 == ')')
            return false;
        if ((op1 == '*' || op1 == '/') &&
                (op2 == '+' || op2 == '-'))
            return false;
        else
            return true;
    }

    public static double applyOp(char op,
                                 double b, double a)
    {
        switch (op)
        {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                if (b == 0)
                    throw new
                            UnsupportedOperationException(
                            "Cannot divide by zero");
                return a / b;
        }
        return 0;
    }

}