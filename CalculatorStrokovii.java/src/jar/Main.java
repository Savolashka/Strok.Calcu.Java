package jar;
import java.util.Scanner;



class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите значение");
        String exp = scanner.nextLine();
        String[] num;
        String[] input;
        input = exp.split("[+\\-*/]");
        if ((input[0].length() > 13) || (input[1].length() > 13))    //Ограничение 13 с учетом кавычек которые вводим.
            throw new Exception("Введено более 10 символов");
        if (!input[0].contains("\"")) throw new Exception("Первым аргументом должна быть строка");



        if (exp.contains(" + ")) {
            num = exp.split(" \\+ ");
            //if (!num[0].contains("\"")) throw new Exception("Первым аргументом должна быть строка");
            printText(num[0] + num[1]);
        }
        else if (exp.contains(" * ")) {
            num = exp.split(" \\* ");
            if (num[1].contains("\"")) throw new Exception("Строку можно умножать или делить только на число");
            //if (!num[0].contains("\"")) throw new Exception("Первым аргументом должна быть строка");
            int mult = Integer.parseInt(num[1]);
            String result = "";
            for (int i = 0; i < mult; i++) {
                result += num[0];
            }if (mult>10 || mult<1) throw new Exception("Число может быть от 1 до 10");
            printText(result);
        }
        else if (exp.contains(" / ")) {
            num = exp.split(" / ");
            if (num[1].contains("\"")) throw new Exception("Строку можно умножать или делить только на число");
            //if (!num[0].contains("\"")) throw new Exception("Первым аргументом должна быть строка");
            int newLen = num[0].length() / Integer.parseInt(num[1]);
            String result = num[0].substring(0, newLen);
            if (newLen>10 || newLen<1) throw new Exception("Число может быть от 1 до 10");
            printText(result);
        }
        else if (exp.contains(" - ")) {
            num = exp.split(" - ");
            //if (!num[0].contains("\"")) throw new Exception("Первым аргументом должна быть строка");
            num[1] = num[1].replace("\"", "");
            int index = num[0].indexOf(num[1]);
            if(index == -1){
                printText(num[0]);
            }else{
                String result = num[0].substring(0, index);
                result+=num[0].substring(index+num[1].length());
                printText(result);
            }
        }

    }
    static void printText (String text){
        text = (text.replace("\"",""));
        String result = text;
        if (text.length() >= 40){
            text = text.substring(0,40);
            text = text+"...";
        }
        System.out.println("\"" + text + "\"");
    }
}






