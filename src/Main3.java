import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @FileName: Main3
 * @Author: LuckKun
 * @Email: 1546165200@qq.com
 * @Date: 2022/8/13 16:47
 */
public class Main3 {

    public  void pro(int []card){
        int []ori = new int[card.length];
        int index  = 0;
        int path = 0;
        for (int i = 0; i < card.length; i++) {
            path = (path+2)%(card.length-i);
            //int tmp = (path+1)%card.length;
            ori[path] = card[i];
        }
        System.out.println(Arrays.toString(ori));
    }

    /**
     * 放两张翻一张
     * 第i张牌是第i次翻开的，
     * 第1张牌，表示原牌的第三位
     * 第2张牌，表示原牌的第6位，但是6明显大于了，所以应该是上面翻下来的
     * 6%4 = 2
     * @param card
     */
    public void  doProcess(int []card){
        int path = 2;
        int i = -1;

        int []arr = new int[card.length];
        int left = card.length;
        int index = 0;
        List<Integer> lst = new ArrayList<>();
        List<Integer> lstLeft = new ArrayList<>();
        while (index!=card.length){
            i=(i+2);
            if (!lst.isEmpty()) i++;
            int lp = i;
            System.out.print(lp+"    ");
            if (!lst.isEmpty()){
                for (int j = lst.size()-1; j >=0 ; j--) {
                    //lp-lst.get(i)+1
                    lp = ((lp)%lstLeft.get(j));
                    if (j!=0) lp+=lstLeft.get(j);
                    //lp = ((lp)%lstLeft.get(j));
                }
                //arr[lp] = card[index];
            }
            System.out.println(lp);

            lst.add(i);
            lstLeft.add(left);
            index++;
            left--;
        }

        System.out.println(Arrays.toString(arr));
    }

    /**
     * dp[n]  = dp[]
     * @param card
     */
    public  void process(int []card){
        int []ori = new int[card.length];
        int index  = 0;
        int path = 0;
        for (int i = 0; i < card.length; i++) {
            path = (path+2)%(card.length-i);
            //int tmp = (path+1)%card.length;
            ori[path] = card[i];
        }
        System.out.println(Arrays.toString(ori));
    }
    public static void main(String[] args) {
        Main3 main3 = new Main3();
        int []arr = {1,2,3,4};
        main3.pro(arr);
    }
}
