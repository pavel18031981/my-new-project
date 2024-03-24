package kata;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception{
        Scanner scanner=new Scanner(System.in);
        System.out.print("Input: ");
        String task=scanner.nextLine();
        scanner.close();

        char[] taskArray=task.toCharArray();
        if(!action(taskArray)){
            throw new Exception("Формат математической операции не удовлетворяет заданию");
        }
        for(int i=0;i<taskArray.length;i++){
            if(taskArray[i]=='+'){
                String[] tasks=task.split("\\+");
                sum(tasks[0],tasks[1]);
            }
            if(taskArray[i]=='-'){
                String[] tasks=task.split("-");
                dif(tasks[0],tasks[1]);
            }
            if(taskArray[i]=='*'){
                String[] tasks=task.split("\\*");
                com(tasks[0],tasks[1]);
            }
            if(taskArray[i]=='/'){
                String[] tasks=task.split("/");
                pri(tasks[0],tasks[1]);
            }
        }
    }
    static void sum(String tasks0,String tasks1)throws Exception {
        if(check(tasks0)>10||check(tasks0)<0||check(tasks1)>10||check(tasks1)<0){
            throw new Exception("Неподходящее число");
        }
        if (check(tasks0)!=0&&check(tasks1)!=0) {
            int res = check(tasks0) + check(tasks1);
            System.out.println("Output: " + res);
        }
        if(check(tasks0)==0&&check(tasks1)==0){
            int res =ArabicTo.convert(tasks0) + ArabicTo.convert(tasks1);
            String result = ArabicTo.reconvert(res);
            System.out.println("Output:" + result);
        }
        if(check(tasks0)==0&&check(tasks1)!=0||check(tasks0)!=0&&check(tasks1)==0){
            throw new Exception("Используются разные системы счисления");
        }
    }
    static void dif(String tasks0,String tasks1)throws Exception {
        if(check(tasks0)>10||check(tasks0)<0||check(tasks1)>10||check(tasks1)<0){
            throw new Exception("Неподходящее число");
        }
        if (check(tasks0)!=0&&check(tasks1)!=0) {
            int res = check(tasks0) - check(tasks1);
            System.out.println("Output: " + res);
        }
        if(check(tasks0)==0&&check(tasks1)==0){
            if(ArabicTo.convert(tasks0)<=ArabicTo.convert(tasks1)){
                throw new Exception("Результат действия в римской системе чисел будет меньше или равен нулю");
            }
            int res = ArabicTo.convert(tasks0) - ArabicTo.convert(tasks1);
            String result = ArabicTo.reconvert(res);
            System.out.println("Output:" + result);
        }
        if(check(tasks0)==0&&check(tasks1)!=0||check(tasks0)!=0&&check(tasks1)==0){
            throw new Exception("Используются разные системы счисления");
        }
    }
    static void com(String tasks0,String tasks1)throws Exception  {
        if(check(tasks0)>10||check(tasks0)<0||check(tasks1)>10||check(tasks1)<0){
            throw new Exception("Неподходящее число");
        }
        if (check(tasks0)!=0&&check(tasks1)!=0) {
            int res = check(tasks0) * check(tasks1);
            System.out.println("Output: " + res);
        }
        if(check(tasks0)==0&&check(tasks1)==0){
            int res = ArabicTo.convert(tasks0) * ArabicTo.convert(tasks1);
            String result = ArabicTo.reconvert(res);
            System.out.println("Output:" + result);
        }
        if(check(tasks0)==0&&check(tasks1)!=0||check(tasks0)!=0&&check(tasks1)==0){
            throw new Exception("Используются разные системы счисления");
        }
    }
    static void pri(String tasks0,String tasks1)throws Exception {
        if(check(tasks0)>10||check(tasks0)<0||check(tasks1)>10||check(tasks1)<0){
            throw new Exception("Неподходящее число");
        }
        if (check(tasks0)!=0&&check(tasks1)!=0) {
            int res = check(tasks0) / check(tasks1);
            System.out.println("Output: " + res);
        }
        if(check(tasks0)==0&&check(tasks1)==0){
            if(ArabicTo.convert(tasks0)< ArabicTo.convert(tasks1)){
                throw new Exception("Результат действия в римской системе чисел будет равен нулю");
            }
            int res = ArabicTo.convert(tasks0) / ArabicTo.convert(tasks1);
            String result = ArabicTo.reconvert(res);
            System.out.println("Output:" + result);
        }
        if(check(tasks0)==0&&check(tasks1)!=0||check(tasks0)!=0&&check(tasks1)==0){
            throw new Exception("Используются разные системы счисления");
        }
    }
    static boolean action(char[] task){
        char[] actionArray=new char[]{'+','-','*','/'};
        int x=0;
        for(char t:task){
            for(char a:actionArray){
                if (t==a){
                    x++;
                }
            }
        }
        if(x==1){
            return true;
        }
        return false;
    }
    static int check(String task){
        try{
            return Integer.parseInt(task);
        }
        catch(Exception e){
            return 0;
        }
    }
}
