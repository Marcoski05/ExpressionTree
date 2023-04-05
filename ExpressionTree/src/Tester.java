import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * @author mcecc
 *
 */
public class Tester {
    
	public static void main(String[] args) {
        
		String fileName;
		if (args.length > 0)
			fileName = args[0];
		else
			fileName = "postFixExpressions.txt";
        
		File file = new File(fileName);
        if (!file.exists() || file.isDirectory()) {
            System.out.println("File not found, please enter a valid file name: ");
            Scanner scanner = new Scanner(System.in);
            fileName = scanner.nextLine();
            file = new File(fileName);
            scanner.close();
        }

        
        try (Scanner scanner = new Scanner(file); PrintWriter writer = new PrintWriter("MyAnswers.txt")) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] postfix = line.split("\\s+");
                ExpressionTree tree = new ExpressionTree("");
                tree = tree.buildTree(postfix);
                
                writer.println("evalTree: " + tree.evalTree());
                writer.println("Prefix notation: " + tree.toPrefixNotation());
                writer.println("Infix notation: " + tree.toInfixNotation());
                writer.println("Postfix notation: " + tree.toPostfixNotation());
                writer.println("postfixEval: " + tree.postfixEval(postfix));
                writer.println();
                writer.println();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}