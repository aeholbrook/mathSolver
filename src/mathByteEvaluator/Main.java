package mathByteEvaluator;

public class Main {

	public static void main(String[] args) {
		String str = "(12 + 5) + 3 - (3 + 4)";
		System.out.println("To solve: " + str);
		int n = MathEvaluator.evaluate(str);
		System.out.println("solution: " + n);

	}

}
