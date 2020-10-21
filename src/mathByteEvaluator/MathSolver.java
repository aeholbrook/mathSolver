package mathByteEvaluator;
/**
 * This class holds three counters, one for the first number, one for the second, 
 * and another for the result of the operation they perform. It also holds a char
 * value for an operator and another to determine if the resultant number is positive or negative. 
 * The pos/neg thing is really only useful for the subtraction for now but if I wanna add more complex 
 * operators into this class that may make things much more handy. 
 * 
 * THis class performs various math operations on counters. It also allows multiple operations to be 
 * performed on the same set of numbers. It also allows those numbers to be replaced and then the resultant
 * equation run. 
 * 
 * @author adam
 *
 */
public class MathSolver {

	private int num1;
	private int num2;
	private int result;
	private char operator;
	private boolean isPositive;

	public MathSolver() {
		this.num1 = 0;
		this.num2 = 0;
	}

	public void setFirst(int num1) {
		this.num1 = num1;
		setOperator(this.operator);
	}

	public void setSecond(int num2) {
		this.num2 = num2;
		setOperator(this.operator);
	}

	public int getFirst() {
		return num1;
	}

	public int getSecond() {
		return num2;
	}

	public int getResult() {
		return result;
	}

	public void setOperator(char op) {
		switch (op) {
		case '+':
			add();
			break;
		case '-':
			subtract();
			break;
		default:
			add();
			break;
		}
		op = this.operator;
	}
	public boolean isPositive() {
		return isPositive;
	}

	public void add() {
		this.result = this.num1 + this.num2;
	}

	public void subtract() {
		this.result = this.num1 - this.num2;
	}
}

	//static methods; probably won't need.