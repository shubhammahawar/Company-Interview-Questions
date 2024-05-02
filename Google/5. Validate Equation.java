
Q. Validate if the equation is syntactically correct.

Valid operators: +, -, a-z, (, )
Test cases:
Valid - a + x = b + (c + a)
Invalid - a + x = (ending with =; doesn't have RHS)
Invalid - a + -x = a + b (- in -x is a unary operator)


T.C = the overall time complexity of the provided code is O(M + N), 
      where M is the length of the input string and N is the length of the longest part of the equation.


import java.util.*;
import java.io.*;

class Equation {


public static boolean validateEquation(String str, int index, boolean operator, boolean constant, boolean openBracket, 
boolean closeBracket, int countBracket){


if(index==str.length()){
if(countBracket!=0 || constant)
return false;

return true;
}


char ch = str.charAt(index);

if(ch>='a' && ch<='z'){
if(!constant)
return false;

return validateEquation(str, index+1, true, false, false, true, countBracket);

}


if(ch=='+' || ch=='-'){
if(!operator)
return false;

return validateEquation(str, index+1, false, true, true, false, countBracket);
}

if(ch=='('){
if(!openBracket)
return false;

return validateEquation(str, index+1, false, true, true, false, countBracket+1);

}

if(ch==')'){

if(!closeBracket || countBracket==0)
return false;

//return validateEquation(str, index+1, true, false, false, true, countBracket-1);

return true;
}

return validateEquation(str, index+1, operator, constant, openBracket, closeBracket, countBracket);
}




public static boolean validate(String str){
String equation[] = str.split("=");

if(equation.length!=2){
return false;
}

System.out.print(str+" ");
return ( validateEquation(equation[0], 0, false, true, true, false, 0) && 
validateEquation(equation[1], 0, false, true, true, false, 0));

}


public static void main(String args[]){

System.out.println(validate("a+b=c+d"));
        System.out.println(validate("(a + c) = ((c + d))"));
        System.out.println(validate("a + ((c)) + d = (x + y) + z"));
        System.out.println(validate("a ( + b) = c"));
        System.out.println(validate("a  + (b) = c"));
        System.out.println(validate("Hello World!"));
}

}
