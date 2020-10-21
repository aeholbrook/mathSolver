package mathByteEvaluator;


public class MathEvaluator {

	public static Integer evaluate(String expression) 
	{
		char[] tokens = expression.toCharArray();

		Stack<Integer> values = new Stack<Integer>();

		Stack<Character> ops = new Stack<Character>();

		for (int i = 0; i < tokens.length; i++) {

			if (tokens[i] == ' ')
				continue;

			if (tokens[i] >= '0' && tokens[i] <= '9')
			{
				StringBuffer sbuf = new StringBuffer();

				while (i < tokens.length && (tokens[i] >= '0') && (tokens[i] <= '9'))

					sbuf.append(tokens[i++]);
				values.push(Integer.parseInt(sbuf.toString()));
			}

			else if (tokens[i] == '(') {
				ops.push(tokens[i]);
			}

			else if (tokens[i] == ')')
			{
				while (ops.peek() != '(')
					values.push(applyOp(ops.pop(), values.pop(), values.pop()));
				ops.pop();
			}

			//current token is operator
			else if (tokens[i] == '+' || tokens[i] == '-' ||
					tokens[i] == '*' || tokens[i] == '/')

			{

				while (!ops.isEmpty() && hasPrecedence(tokens[i], ops.peek())) 
					values.push(applyOp(ops.pop(), values.pop(), values.pop()));

				ops.push(tokens[i]);
			}
		}


		while (!ops.isEmpty() && values.size() > 1) {
			if (ops.peek() == '(') ops.pop();
			values.push(applyOp(ops.pop(), values.pop(), values.pop()));}

		return values.pop();
	}
	public static boolean hasPrecedence(char operation1, char operation2)
	{
		if (operation2 == '(' || operation1 == ')') 
			return false; 
		if ((operation1 == '*' || operation1 == '/') 
				&& (operation2 == '+' || operation2 == '-'))
			return false;
		else 
			return true;
	}

	public static Integer applyOp(char op, Integer b, Integer a)
	{
		MathSolver solver = new MathSolver();
		solver.setFirst(a);
		solver.setSecond(b);
		solver.setOperator(op);
		return solver.getResult();

	}



}
