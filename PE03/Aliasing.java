/* NOTE: Aliasing is a concept that applies to ALL reference types, not just Strings
 *       Whenever two references hold the same reference (i.e. point to the same thing)
 *       those two reference variables are considered to be aliases (i.e. another name
 *       name for the same thing.
 */
public class Aliasing {
    public static void main(String[] args) {
        String a = "Suzy";
        String b = "Suzy";
        System.out.println(a); // prints Suzy
        System.out.println(b); // prints Mark
        System.out.println(a==b);

        a = b; // a and b reference the same thing and are called "aliases"
         
        System.out.println(a); // prints Mark
        System.out.println(b); // prints Mark

        b = "Mary";
       
        System.out.println(a); // prints Mark
        System.out.println(b); // prints Mary
        
        a = "Suzy";
        b = "Mark";
        
        System.out.println("\n***** Comparing two strings with DIFFERENT content *****");
        System.out.println(a); // prints Suzy
        System.out.println(b); // prints Mark
        System.out.println(a == b); // false because a and b are NOT aliases

        System.out.println("\n***** Comparing two strings that ARE aliases *****");
        a = b; // a and b reference the same thing and are called "aliases"
        System.out.println(a); // prints Mark
        System.out.println(b); // prints Mark
        System.out.println(a == b); // true because == on reference types tests for "aliasing"
        System.out.println(a.compareTo(b)); // returns 0 because content is the same
        System.out.println(a.equals(b)); // true because content is the same
        
        System.out.println("\n***** Comparing two strings with SAME content that ARE NOT aliases *****");
        String c = new String("Mary");
        String d = new String("Mary");
        System.out.println(c); // prints Mary
        System.out.println(d); // prints Mary
        System.out.println(c == d); // FALSE!? NOT ALIASES even though content is the same
        System.out.println(c.compareTo(d)); // returns 0 because content is the same
        System.out.println(c.equals(d)); // TRUE! because content is the same
    }
}