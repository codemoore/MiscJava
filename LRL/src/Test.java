import java.util.Scanner;


public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		 Scanner scan = new Scanner(System.in); 
		 System.out.print("Enter file name: "); 
		 String fileName = scan.next(); 
		 LRLTree tr = new LRLTree(fileName); 
		 tr.print(); 
		 System.out.println(); 
		 tr.eval(); 
		 System.out.println(tr.toJavaString()); 
		 scan.close();
	}

}
