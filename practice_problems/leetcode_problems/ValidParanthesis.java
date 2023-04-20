package leet;
import java.util.*;

public class ValidParanthesis{

    public static void main(String args[]){

        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        if(isBalanced(str))
            System.out.print("Balanced");
        else
            System.out.print("Unbalanced");
        
    }

    public static boolean isBalanced(String str1){

        Stack stack = new Stack();
        char arr[] = str1.toCharArray();
        char current,popChar;

        for(int i=0;i<arr.length;i++){
            current = arr[i];

            if(current =='{' || current =='(' || current =='['){
                stack.push(current);
                continue;
            }

            if(stack.isEmpty()){
                return false;
            }

            switch(current){
                case '}':
                    popChar = (char)stack.pop();
                    if(popChar == '(' || popChar == '['){
                        return false;
                    }
                    break;
                
                 case ')':
                    popChar = (char)stack.pop();
                    if(popChar == '{' || popChar == '['){
                        return false;
                    }
                    break;
                
                 case ']':
                    popChar = (char)stack.pop();
                    if(popChar == '(' || popChar == '{'){
                        return false;
                    }
                    break;
            }
        }

        return stack.isEmpty();
    }
}