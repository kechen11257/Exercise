public class AnnoymousInnerClassEx {
    public static void main(String[] args) {
        /*
        1. 有一个铃声接口Bell,里面有个ring方法
        2. 有一个手机类CellPhone,具有闹钟功能alarmClock,参数是Bell类型
        3. 测试手机类的闹钟功能，通过匿名内部类（对象）作为参数，打印：懒猪起床了
        4. 再传入另一个匿名内部类（对象）。打印：小伙伴上课了

         */
        CellPhone cellphone = new CellPhone();
        cellphone.alarmclock(new Bell(){

            @Override
            public void ring() {
                System.out.println("懒猪起床了");
            }
        });

        cellphone.alarmclock(new Bell(){

            @Override
            public void ring() {
                System.out.println("小伙伴上课了");
            }
        });

    }
}

interface Bell{
    void ring();
}

class CellPhone{
    public void alarmclock(Bell bell){  //形参是接口类型
        bell.ring();
    }
}

