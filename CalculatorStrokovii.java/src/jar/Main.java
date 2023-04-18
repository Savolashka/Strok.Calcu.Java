package jar;
import java.util.Scanner;



 class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите значение");
        String exp = scanner.nextLine();
        char a;
        String[] num;



        if (exp.contains(" + ")) {
            num = exp.split(" \\+ ");
            a = '+';
            printText(num[0] + num[1]);
        }
         if (exp.contains(" * ")) {
             num = exp.split(" \\* ");
             a = '*';
             int multiplier = Integer.parseInt(num[1]);
             String result = "";
             for (int i = 0; i < multiplier; i++) {
                 result += num[0];
             }
             printText(result);
         }


             if (exp.contains(" / ")) {
                 num = exp.split(" / ");
                 a = '/';
                 int newLen = num[0].length() / Integer.parseInt(num[1]);
                 String result = num[0].substring(0, newLen);
                 printText(result);
             } else if (exp.contains(" - ")) {
                 num = exp.split(" - ");
                 a = '-';
                 int index = num[0].indexOf(num[1]);
                 if (index == -1) {
                     printText(num[0]);
                 } else {
                     String result = num[0].substring(0, index);
                     result += num[0].substring(index + num[1].length());
                     printText(result);
                 }
             }
    }
    static void printText (String text){
        System.out.println("\"" + text + "\"");
             }
         }







