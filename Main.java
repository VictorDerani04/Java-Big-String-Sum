import java.util.*;
import java.awt.*;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        System.out.println("----- Large Integer Arithmetic -----");

        //variables of the problem
        String num1 = "123456789";
        String num2 = "987654321";
        String num3 = "5058425662";
        String num4 = "6469266614";
        String num5 = "111222333444555666777888999";
        String num6 = "314159265358979323846";

        //calling the add function
        String ans1 = addTwoBigInts(num1, num2);
        String ans2 = addTwoBigInts(num3, num4);
        String ans3 = addTwoBigInts(num5, num6);
        System.out.println("add:"+addTwoBigInts("1368", "9130"));
//        calling the mult function
        String ans4 = multTwoBigInts(num1, num2);
        String ans5 = multTwoBigInts(num3, num4);
        String ans6 = multTwoBigInts(num5, num6);

        System.out.println("   " + num1);
        System.out.println("+  " + num2);
        System.out.println("_____________");
        System.out.println("   " + ans1 + "\n\n\n");

        System.out.println("   " + num3);
        System.out.println("+  " + num4);
        System.out.println("______________");
        System.out.println("   " + ans2 + "\n\n\n");

        System.out.println(num5);
        System.out.println("+     " + num6);
        System.out.println("_____________________________");
        System.out.println(ans3 + "\n\n\n");

        System.out.println("            " + num1);
        System.out.println("*           " + num2);
        System.out.println("_________________________");
        System.out.println("   " + ans4 + "\n\n\n");

        System.out.println("             " + num3);
        System.out.println("*            " + num4);
        System.out.println("_________________________");
        System.out.println("   " + ans5 + "\n\n\n");

        System.out.println("                       " + num5);
        System.out.println("*                            " + num6);
        System.out.println("___________________________________________________");
        System.out.println("   " + ans6 + "\n\n\n");

    }
    public static String addTwoBigInts(String first, String second){
        int length1 = first.length(); //gives me the length of both strings
        int length2 = second.length();
        int sum = 0;
        int num = 0;
        String Final = "";
        String zeros = "000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000";
        int max = 0;
        if(length1>length2) {
            int difference = length1-length2;
            second = zeros.substring(0,difference) + second;
            length2 = length2 + difference;
            max = length1;
        }
        else if(length2>length1){
            int difference = length2-length1;
            first = zeros.substring(0,difference) + first;
            length1 = length1 + difference;
            max = length2;
        }
        else{
            int difference = 0;
            max = length1;
        }


        for(int i=1; i<=Math.min(length1,length2); i++){ //loop that goes on until all of the digits of the variable are executed
            int convFirst = Integer.parseInt(first.substring(length1 - i, length1 - (i - 1))); // converts a part of the string into to an integer
            int convSecond = Integer.parseInt(second.substring(length2 - i, length2 - (i - 1)));
            sum = convFirst + convSecond + num; //it sums the digits converted
            String str = String.valueOf(sum); // it converts back to a string
            if(sum<10 || (sum>10 && i==max)) {
                Final = str + Final;// it gets the result of the sum and add to a final string
                num = 0;
            }
            else{ // in this case the sum was higher than 10
                String mid = str.substring(1); // it calls the part of the string we are going to add to the final one
                num = Integer.parseInt(str.substring(0,1)); // it turns the ten back to a number
                Final = mid + Final;
            }
        }
        if(num==1){
            Final = "1" + Final;
            num = 0;
        }
        return Final;
    }
    public static String multTwoBigInts(String first, String second){
        int length1 = first.length();
        int length2 = second.length();
        String sum = "";
        int num = 0;
        int mult = 0;
        String Final = "0";

        for (int i=1; i<=length1; i++){
            int convFirst = Integer.parseInt(first.substring(length1 - i, length1 - (i - 1)));
            sum = "";
            num = 0;

            for(int x=1; x<=length2; x++) {
                int convSecond = Integer.parseInt(second.substring(length2 - x, length2 - (x - 1)));
                mult = convFirst * convSecond + num;
                String str = String.valueOf(mult);
                if (mult < 10 || x == length2) {
                    sum = str + sum;
                    num=0;
                } else {
                    String mid = str.substring(1);
                    num = Integer.parseInt(str.substring(0, 1));
                    sum = mid + sum;
                }

            }

            //\tack on some zeros onto the end of sum
            String zeros = "00000000000000000000000000000000000000000000000000000000000000000000000000000000000000000";

            if(i==1){
                Final = addTwoBigInts(sum,Final);
            }
            else if(i>1){
                String realZeros = zeros.substring(0, i-1);
                sum = sum + realZeros;
                Final = addTwoBigInts(sum, Final);
            }
        }
        return Final;
    }
}