/**
 * 
 */

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
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public int evalTree() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String toPrefixNotation() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String toInfixNotation() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String toPostfixNotation() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int postfixEval(String[] exp) {
		// TODO Auto-generated method stub
		return 0;
	}

}
