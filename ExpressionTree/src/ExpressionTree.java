import java.util.Stack;

/**
 * @author mcecc
 *
 */
public class ExpressionTree extends TreeNode implements Expressions {

	/**
	 * @param initValue
	 */
	public ExpressionTree(Object initValue) {
		super(initValue);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param initValue
	 * @param initLeft
	 * @param initRight
	 */
	public ExpressionTree(Object initValue, TreeNode initLeft, TreeNode initRight) {
		super(initValue, initLeft, initRight);
		// TODO Auto-generated constructor stub
	}

	@Override
	public ExpressionTree buildTree(String[] exp) {
		Stack<ExpressionTree> stack = new Stack<>();

		for (String element : exp) {
			if (isOperator(element)) {
				ExpressionTree right = stack.pop();
				ExpressionTree left = stack.pop();
				stack.push(new ExpressionTree(element, left, right));
			} 
			else {
				stack.push(new ExpressionTree(element));
			}
		}

		return stack.pop();
	}

	@Override
	public int evalTree() {
		if (!isOperator(getValue().toString()))
			return Integer.parseInt(getValue().toString());

		int leftValue = ((ExpressionTree) getLeft()).evalTree();
		int rightValue = ((ExpressionTree) getRight()).evalTree();

		String operator = getValue().toString();
		if (operator.equals("+"))
			return leftValue + rightValue;
		else
			return leftValue * rightValue;
	}

	@Override
	public String toPrefixNotation() {
		String result = getValue().toString();

		if (getLeft() != null)
			result = getValue().toString() + " " + ((ExpressionTree) getLeft()).toPrefixNotation();

		if (getRight() != null)
			result += " " + ((ExpressionTree) getRight()).toPrefixNotation();

		return result;
	}

	@Override
	public String toInfixNotation() {
		String result = "";

		if (getLeft() != null)
			result += "(" + ((ExpressionTree) getLeft()).toInfixNotation() + ")";

		result += " " + getValue() + " ";

		if (getRight() != null)
			result += "(" + ((ExpressionTree) getRight()).toInfixNotation() + ")";

		return result.toString();
	}

	@Override
	public String toPostfixNotation() {
		String result = "";

		if (getLeft() != null)
			result += ((ExpressionTree) getLeft()).toPostfixNotation() + " ";

		if (getRight() != null)
			result += ((ExpressionTree) getRight()).toPostfixNotation() + " ";

		result += getValue();
		return result.toString();
	}

	@Override
	public int postfixEval(String[] exp) {
		Stack<Integer> stack = new Stack<>();

		for (String element : exp) {
			if (element.equals("+")) {
				int right = stack.pop();
				int left = stack.pop();
				stack.push(left + right);
			}
			else if (element.equals("*")) {
				int right = stack.pop();
				int left = stack.pop();
				stack.push(left * right);
			}
			else
				stack.push(Integer.parseInt(element));
		}

		return stack.pop();
	}

	public boolean isOperator(String s) {
		return s.equals("+") || s.equals("*");
	}

}