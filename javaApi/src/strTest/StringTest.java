package strTest;

/**
 * @FileName: StringTest
 * @Author: LuckKun
 * @Email: 1546165200@qq.com
 * @Date: 2022/3/22 11:43
 */
public class StringTest {
    /**
     * 每次调用new String(Str) 首先会创建一个str的string对象放入到字符串常量池内部
     * 然后new String又会拷贝和新创建一个string对象，所以两个并不相同
     *
     * 切记每次new String都会至少创建一个新的string对象，一般不会用到字符串常量池
     * @param args
     */
    public static void main(String[] args) {
        String str1 = new String("sas");

        String str2 = "sas";
        System.out.println(str1==str2);

        String str3 = str2.intern();

        String str4 = new String("sas");
        String str5 = "sas";

        System.out.println(str3==str4);
        System.out.println(str3==str5);

    }
}
