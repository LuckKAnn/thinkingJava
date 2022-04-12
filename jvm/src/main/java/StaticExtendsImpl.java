/**
 * @FileName: StaticExtendsImpl
 * @Author: LuckKun
 * @Email: 1546165200@qq.com
 * @Date: 2022/3/25 11:15
 */
public class StaticExtendsImpl extends StaticExtends{
    @Override
    public void fatherMethod() {

        System.out.println("medhod son");
    }

    public static void staticFather(){
        System.out.println("static son");

    }

    public static void main(String[] args) {
        StaticExtends staticExtends = new StaticExtendsImpl();

        staticExtends.fatherMethod();

        StaticExtendsImpl.staticFather();
    }
}
