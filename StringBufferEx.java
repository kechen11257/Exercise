public class StringBufferEx {
    /*
    输入商品名称和商品价格，要求按照要求输出效果
    商品名 商品价格
    123   3,456,789.88
    要求：价格的小数点前面三位用逗号隔开，再输出
     */
    public static void main(String[] args) {

        // 1。 定义一个Scanner对象，接收用户输入的价格(String)
        // 2。 希望使用到StringBuffer的insert，需要将String转成StringBuffer
        // 3。然后使用相关方法进行字符串的处理

        String price = "3456789.88";
        StringBuffer sb = new StringBuffer(price);
        for (int i = sb.lastIndexOf(".")-3; i > 0; i -= 3) {
            sb = sb.insert(i, ",");
        }
        System.out.println(sb);
    }
}
