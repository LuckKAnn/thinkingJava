package mind;

import java.util.Arrays;
import java.util.function.IntFunction;

/**
 * @FileName: PrintWithoutFor
 * @Author: LuckKun
 * @Email: 1546165200@qq.com
 * @Date: 2022/3/18 10:43
 */


class tmpNode{


    static int num = 0;

    tmpNode(){
        System.out.println(num++);
    };

}
public class PrintWithoutFor {


    public static void main(String[] args) {
        tmpNode[] arr = new tmpNode[1000];

        Arrays.setAll(arr, new IntFunction<tmpNode>() {
            @Override
            public tmpNode apply(int value) {
                return  new tmpNode();
            }
        });

    }
}
