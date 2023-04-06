package TryCatch;

import java.util.Scanner;

/*
    编写应用程序，接收命令行的两个参数（整数），计算两数相除
    计算两个数相除，要求使用方法cal（int n1， int n2）
    对数据格式不正确(NumberFormatException),缺少命令行参数(ArrayIndexOutOfBoundsException)，
    除0进行异常处理(ArithmeticException)进行异常处理。
 */
public class TryCatchHW1 {
    public static void main(String[] args) {
        // 先验证输入的参数个数是否正确

        try{
            if(args.length != 2){
                throw new ArrayIndexOutOfBoundsException("参数个数不对");
            }
            //把接收到的参数，转成整数
            int n1 = Integer.parseInt(args[0]);
            int n2 = Integer.parseInt(args[1]);

            double res = cal(n1, n2);

            System.out.println(res);

        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("缺少命令行参数");
        }catch(NumberFormatException e){
            System.out.println("数据格式不正确");
        }catch(ArithmeticException e){
            System.out.println("除0");
        }

    }

    public static double cal(int n1, int n2){
        return n1 / n2;
    }
}
