package mi;

import java.util.ConcurrentModificationException;

/**
 * @FileName: TestIImpl
 * @Author: LuckKun
 * @Email: 1546165200@qq.com
 * @Date: 2022/3/16 16:02
 */
public class TestIImpl extends  TestAb implements TestInterface{

    public static void main(String[] args) {

        TestInterface testI = new TestIImpl();
        testI.test();
    }

    @Override
    public void test02() {

    }

    @Override
    public void abtest02() {

    }
}
