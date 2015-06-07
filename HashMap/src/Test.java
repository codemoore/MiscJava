import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Tests for the performance of MyHashMap against jdk when :
 * both have to rehash, one of them doesn't have to rehash, and when they both don't
 * @author Joshua Moore
 *
 */
public class Test {

	/** max size of tests */
	private static final int MAX = 20000000;
	/**
	 * @param args
	 * @throws UnsupportedEncodingException 
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {

		File f = new File("test.csv");
		PrintWriter w =  new PrintWriter(f, "UTF-8");

		final Random rand = new Random();
		w.println("myHashMap put and get default size");
		System.out.println("Number of Items,Time(ms)\n");
		w.println("Number of Items,Time(ms)");
		////--------myHashMap put and get---///////////////////////////
		for(int i = 2048; i <= MAX; i *= 2) {
			MyHashMap<Integer, Integer> map = new MyHashMap<Integer, Integer>();
			int n = i;

			long startT = System.currentTimeMillis();
			for(int j = 0; j < n; j++) {
				int temp = (int)(rand.nextInt()% (1.5 * n));
				map.put(temp, 0);
				for(int k = 0; k < 10; k++) {
					map.get(temp);
				}
			}
			//			for(int k = 0; k < 10* n; k++) {
			//				map.get()
			//			}
			long endT = System.currentTimeMillis();
			System.out.println( n + "," + (endT-startT)+ "\n");
			w.println(n + "," + (endT-startT));

		}

		w.println();
		w.println("jdk HashMap put and get default size");
		w.println("Number of Items,Time(ms)");
		////---------java hash map put and get------////////////////////////////////////
		for(int i = 2048; i <= MAX; i *= 2) {
			Map<Integer, Integer> map2 = new HashMap<Integer, Integer>();
			int n = i;

			long startT = System.currentTimeMillis();
			for(int j = 0; j < n; j++) {
				int temp = (int)(rand.nextInt()% (1.5 * n));
				map2.put(temp, 0);
				for(int k = 0; k < 10; k++) {
					map2.get(temp);
				}
			}
			//			for(int k = 0; k < 10* n; k++) {
			//				map.get()
			//			}
			long endT = System.currentTimeMillis();
			System.out.println( n + "," + (endT-startT)+ "\n");
			w.println(n + "," + (endT-startT));

		}

		//-----------------When myHashMap doesn't have to rehash
		w.println();
		w.println("myHashMap put and get with size MAX");
		w.println("Number of Items,Time(ms)");
		////--------myHashMap put and get---///////////////////////////
		for(int i = 2048; i <= MAX; i *= 2) {
			MyHashMap<Integer, Integer> map = new MyHashMap<Integer, Integer>(MAX);
			int n = i;

			long startT = System.currentTimeMillis();
			for(int j = 0; j < n; j++) {
				int temp = (int)(rand.nextInt()% (1.5 * n));
				map.put(temp, 0);
				for(int k = 0; k < 10; k++) {
					map.get(temp);
				}
			}
			//			for(int k = 0; k < 10* n; k++) {
			//				map.get()
			//			}
			long endT = System.currentTimeMillis();
			System.out.println( n + "," + (endT-startT)+ "\n");
			w.println(n + "," + (endT-startT));

		}
		w.println();
		w.println("jdk HashMap put and get with max size(no rehash)");
		w.println("Number of Items,Time(ms)");
		////---------java hash map put and get------////////////////////////////////////
		for(int i = 2048; i <= MAX; i *= 2) {
			Map<Integer, Integer> map2 = new HashMap<Integer, Integer>(MAX);
			int n = i;

			long startT = System.currentTimeMillis();
			for(int j = 0; j < n; j++) {
				int temp = (int)(rand.nextInt()% (1.5 * n));
				map2.put(temp, 0);
				for(int k = 0; k < 10; k++) {
					map2.get(temp);
				}
			}
			//			for(int k = 0; k < 10* n; k++) {
			//				map.get()
			//			}
			long endT = System.currentTimeMillis();
			System.out.println( n + "," + (endT-startT)+ "\n");
			w.println(n + "," + (endT-startT));

		}



		w.close();
	}
}
