import java.io.*; 
import java.util.Locale; 
//Java program to demonstrate PrintWriter 
class fft { 

    public static void main(String[] args) 
        { 
        String s="GeeksforGeeks"; 

        // create a new writer 
        PrintWriter out = new PrintWriter(System.out); 
        char c[]={'G','E','E','K'}; 
        
        //illustrating print(boolean b) method 
        out.print(true); 
        
        //illustrating print(int i) method 
        out.print(1); 
        
        //illustrating print(float f) method 
        out.print(4.533f); 
        
        //illustrating print(String s) method 
        out.print("GeeksforGeeks"); 
        out.println(); 
        
        //illustrating print(Object Obj) method 
        out.print(out); 
        out.println(); 
        
        //illustrating append(CharSequence csq) method 
        out.append("Geek"); 
        out.println(); 
        
        //illustrating checkError() method 
        out.println(out.checkError()); 
        
        //illustrating format() method 
        out.format(Locale.UK, "This is my %s program", s); 
        
        //illustrating flush method 
        out.flush(); 
        
        //illustrating close method 
        out.close(); 
    } 
} 
