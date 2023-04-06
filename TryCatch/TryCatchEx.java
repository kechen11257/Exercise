package TryCatch;

import java.util.Scanner;

public class TryCatchEx {
    public static void main(String[] args) {
        //如果用户输入的不是一个整数，就提示他反复输入，知道输入一个整数为止
        // 1。 创建scanner对象
        // 2。 使用无限循环，去接受一个输入
        // 3。 将该输入的值转换成int
        // 4。 如果在转换时，抛出异常，说明输入的内容不是一个可以转成int的内容
        Scanner scanner = new Scanner(System.in);
        int num = 0;
        String inputStr = " ";
        while(true){

            System.out.println("请输入一个整数");
            inputStr = scanner.next();
            try{
                num = Integer.parseInt(inputStr);
                break;
            }catch(NumberFormatException e){
                System.out.println("输入的不是一个整数");
            }
        }
        System.out.println(num);
    }
}
