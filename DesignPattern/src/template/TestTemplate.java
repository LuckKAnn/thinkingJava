package template;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * @FileName: TestTemplate
 * @Author: LuckKun
 * @Email: 1546165200@qq.com
 * @Date: 2022/5/18 17:36
 */
public class TestTemplate {

    public static void main(String[] args) {
        WashingPan washingPan = new WashingPanImpl01();
        WashingPan w2 = new WashingPanImpl02();
        washingPan.prePareWashing();


        System.out.println("----------");
        w2.prePareWashing();

    }
}
