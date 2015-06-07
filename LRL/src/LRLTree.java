/*
 * Joshua Moore
 * Chris Fahlin
 * TCSS342A Spring 14
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Creates a Tree data structure from a LRL code file,
 * evaluate the code from the tree, and convert the tree to java code
 * 
 * @author Joshua Moore
 * @author Chris Fahlin
 * @version 5/5/14
 * TCSS342A Spring 14
 *
 */
public class LRLTree {

	/** Points to the top node of the tree */
	private Node root;

	/** Map of variables and their assigned values */
	public Map<String, Integer> vars;

	/**
	 * Creates a new LRLTree from the file at file_name
	 * @param file_name string for the file path LRL code
	 */
	public LRLTree(final String file_name) {
		root = null;
		vars = new HashMap<String, Integer>();
		final File f = new File(file_name);
		try {
			final Scanner sc = new Scanner(f);
			root = createTree(sc);
			sc.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Creates a LRL tree from Scanner input
	 * @param sc Scanner for  the LRL file
	 * @return a LRL node
	 */
	private Node createTree(final Scanner sc) {
		String str = sc.next();
		if (str.equals("(")) { // Beginning of an expressions
			final String op = sc.next();
			final Node node = new Node(op);
			node.left = createTree(sc);
			if(!op.equals("print")) {
				node.right = createTree(sc);
			}
			return node;
		} else if (str.equals(")")) { // end of an expression
			return createTree(sc);
		} else {//leaf
			// keep track of variables
			if(!isNum(str)) {
				vars.put(str, 0);
			}
			return new Node(str);
		}
	}

	/**
	 * @param s String being checked
	 * @return true if the string is a integer value
	 */
	private boolean isNum(final String s) {
		boolean isVar = false;
		try{
			Integer.parseInt(s);
			isVar = true;
		} catch (Exception e){
			isVar = false;
		}
		return isVar;
	}

	/**
	 * Prints LRL code from the tree
	 */
	public void print() {
		final StringBuilder sb = new StringBuilder();
		sb.append("( ");
		helpPrint(root, sb);
		System.out.println(sb.toString());
	}

	/**
	 * Recursively walks through tree and prints it
	 * @param cur the current node
	 */
	private void helpPrint(final Node cur, final StringBuilder sb) {
		if(cur != null) {

			sb.append(cur.data + " ");
			if(cur.left != null) {
				if(cur.left.left != null){
					sb.append("( ");
				}
				helpPrint(cur.left, sb);
				if(cur.data.equals("print")){;
				sb.append(") ");
				}
			}
			if(cur.right != null) {
				if(cur.left.left != null || (cur.right != null && cur.right.right != null)){
					sb.append("( ");
				}
				helpPrint(cur.right, sb);
				sb.append(") ");
			}
		}
	}

	/**
	 * Executes and prints the LRL 
	 */
	public void eval() {
		evalHelp(root);
	}

	/**
	 * Recursive helper method for eval
	 * @param cur the current node
	 * @return the int evaluation of that operation
	 */
	private int evalHelp(final Node cur) {
		if(cur == null) {
			return 0;
		}else if(isNum(cur.data)) { 
			return Integer.parseInt(cur.data);
		} else if (vars.containsKey(cur.data)) {
			return vars.get(cur.data);
		} else {
			switch (cur.data) {
			case "print" :
				System.out.println(evalHelp(cur.left));
				return 0;
			case "while" :
				if(evalHelp(cur.left) == 1) {
					evalHelp(cur.right);
					evalHelp(cur);
				} 
				return 0;
			case "if" :
				if(evalHelp(cur.left) == 1) {
					return evalHelp(cur.right);
				} else {
					return 0;
				}
			case "<" :
				if(evalHelp(cur.left) < evalHelp(cur.right)) {
					return 1;
				} else {
					return 0;
				}
			case "==" :
				if(evalHelp(cur.left) == evalHelp(cur.right)) {
					return 1;
				} else {
					return 0;
				}
			case "=" :
				if(cur.left != null && vars.containsKey(cur.left.data)) {
					vars.put(cur.left.data, evalHelp(cur.right));
				} 
				return 0;
			case "+" :
				return evalHelp(cur.left) + evalHelp(cur.right);
			case "-" :
				return evalHelp(cur.left) - evalHelp(cur.right); 
			case "*" :
				return evalHelp(cur.left) * evalHelp(cur.right);
			case "/" :
				return evalHelp(cur.left) / evalHelp(cur.right);
			case "block" :
				evalHelp(cur.left);
				evalHelp(cur.right);
				return 0;
			default : 
				evalHelp(cur.left);
				evalHelp(cur.right);
				return 0;
			}
		}
	}

	/**
	 * @return the Java equivalent of the LRL code
	 */
	public String toJavaString() {
		final StringBuilder sb = new StringBuilder();
		sb.append("public class JavaCode { \n\tpublic static void main(String[] args) {\n");
		for (String s : vars.keySet()) {
			sb.append("\t\tint " + s + ";\n");
		}
		makeJavaString(sb, root);
		sb.append("\t}\n}");
		return sb.toString();
	}

	/**
	 * Recursive Helper method for ToJavaString
	 * @param sb StringBuilder that holds to the Java String
	 * @param cur current node
	 */
	private void makeJavaString(final StringBuilder sb, final Node cur) {
		if(cur != null && cur.data != null) {
			String str = cur.data;
			if(str.equals("block")) {
				sb.append("\t");
				makeJavaString(sb, cur.left);
				makeJavaString(sb, cur.right);

			} else if(str.equals("while") || str.equals("if")) {
				sb.append("\t");
				sb.append(str);
				sb.append("(");
				makeJavaString(sb, cur.left);
				sb.append(") {\n");
				makeJavaString(sb, cur.right);
				sb.append("\t\t");
				sb.append("}");
				sb.append("\n");
			} else if(str.equals("<") || str.equals("==") || str.equals("+") ||
						str.equals("-") || str.equals("/") || str.equals("*")) {
				sb.append("(");
				makeJavaString(sb, cur.left);
				sb.append(str);
				makeJavaString(sb, cur.right);
				sb.append(")");

			} else if(str.equals("print")) {
				sb.append("\t");
				sb.append("System.out.println (");
				makeJavaString(sb, cur.left);
				sb.append(");\n");
				
			} else if (str.equals("=")){
				sb.append("\t");
				makeJavaString(sb, cur.left);
				sb.append(str);
				makeJavaString(sb, cur.right);
				sb.append(";\n");
			} else {	
				makeJavaString(sb, cur.left);
				sb.append(str);
				makeJavaString(sb, cur.right);
				if(cur.right !=null && cur.right.right == null) {
					sb.append(";\n");
				}

			}
		} 
	}




}
