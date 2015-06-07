import java.util.HashMap;

import java.awt.Point;  // We'll do some testing with this

// Here's a little Student class for testing purposes

class Student {

    private String firstName;
    private String lastName;
    
    Student(String first, String last) {
        firstName = first;
        lastName = last;
    }
    
    public int hashCode() {
        return (firstName+lastName).hashCode();
    }
    
    // author = 342 Student Brandon Soto
    public boolean equals(Object obj) {
        if (obj != null && getClass().equals(obj.getClass())) {
            Student other = (Student) obj;
            return firstName.equals(other.firstName) 
                   && lastName.equals(other.lastName);
        }
        return false; 
    }
}



/*   
   Correct output for main is:
   
   125
   java.awt.Point[x=84,y=84]
   java.awt.Point[x=55,y=55]
   ByeLong
   
*/  

public class CompatibilityTest {

     public static void main(String[] args) {
     
         // first hash map is  String -> Integer
         MyHashMap<String,Integer> map = new MyHashMap<String,Integer>();
         map.put("Smith", 25);
         map.put("Jones", 100);
         System.out.println(map.get("Smith")+map.get("Jones"));
         
         // second hash map is Student -> Point
         Student stu1 = new Student("Barbara", "Walters");
         Student stu2 = new Student("Brian", "Williams");
         MyHashMap<Student,Point> map2 = new MyHashMap<Student,Point>();
         map2.put(stu1, new Point(84,84));
         map2.put(stu2, new Point(55,55));
         System.out.println(map2.get(stu1));
         System.out.println(map2.get(stu2));
         
         // as indicated in the instructions, your hash map will need
         // a constructor that accepts an integer ...
         MyHashMap<String,String> map3 = new MyHashMap<String,String>(10);
         map3.put("Good","Bye");
         map3.put("So","Long");
         System.out.println(map3.get("Good")+map3.get("So"));
     }

}