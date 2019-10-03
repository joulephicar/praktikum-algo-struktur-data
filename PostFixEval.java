package Stack;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class PostFixEval {
   // Method to evaluate value of a postfix expression 

   static int evaluatePostfix(String exp) {
      //create a stack 
      Stack<Integer> stack = new Stack<>();
      System.out.printf("|%-4s|%-9s|%-20s|%-40s\n", "NO", "SIMBOL", "STACK", "PERHITUNGAN");
      
      // Scan all characters one by one 
      for (int i = 0; i < exp.length(); i++) {
         
         char c = exp.charAt(i);
         
         // If the scanned character is an operand (number here), 
         // push it to the stack. 
         if (Character.isDigit(c)) {
            stack.push(c - '0');
            System.out.printf("|%-4d|%-9s|%-20s|%-40s\n", i, c, Arrays.toString(stack.toArray()), "-");  
         } //  If the scanned character is an operator, pop two 
         // elements from stack apply the operator 
         else {
            int val1 = stack.pop();
            int val2 = stack.pop();

            switch (c) {
               case '+':
                  stack.push(val2 + val1);
                  break;

               case '-':
                  stack.push(val2 - val1);
                  break;

               case '/':
                  stack.push(val2 / val1);
                  break;

               case '*':
                  stack.push(val2 * val1);
                  break;
                  
               case '^':
                  stack.push(val2 ^ val1);
                  break;
               
               default:
                  System.out.println("Ada Operator yang belum didukung!");
                  System.exit(0);
            }
            System.out.printf("|%-4d|%-9s|%-20s| val1 = %d, val2 = %d, operasi = %d%c%d = %d\n", i, c, Arrays.toString(stack.toArray()), val1, val2, val2, c, val1, stack.peek()); 
         }
          
      }
      return stack.pop();
   }

   // Driver program to test above functions 
   public static void main(String[] args) {
      Scanner in = new Scanner(System.in);
      System.out.print("Masukan persamaan postfix: (co/ 812-*3+)");
      String exp = in.nextLine();
      System.out.println("postfix evaluation: " + evaluatePostfix(exp));
   }
} 
