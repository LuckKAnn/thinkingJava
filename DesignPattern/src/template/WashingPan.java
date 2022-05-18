package template;

/**
 * @FileName: WashingPan
 * @Author: LuckKun
 * @Email: 1546165200@qq.com
 * @Date: 2022/5/18 17:34
 */
public abstract class WashingPan {



    public void prePareWashing(){
        System.out.println("收集盘子");
        System.out.println("准备洗洁精");
        System.out.println("打水");
        washing();
        System.out.println("清洗");
        System.out.println("存放");

    }


    public  abstract void  washing();



}
