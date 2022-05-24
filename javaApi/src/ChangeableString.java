import java.util.HashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @FileName: ChangeableString
 * @Author: LuckKun
 * @Email: 1546165200@qq.com
 * @Date: 2022/5/19 17:26
 */
public class ChangeableString {


    private final byte[] value;

    private int len = -1;

    ChangeableString(int len){
        value = new byte[len];
    }


    public   boolean changeString(int index,byte c ){
        len++;
        value[index] = c;

        return true;
    }
    public void printString(){

        for (int i = 0; i <=len; i++) {
            System.out.print((char) value[i]);
        }
        System.out.println();
    }
    public byte[] getValue(){
        return value;
    }


    /**
     * 这里主要想比对的是为什么String类型不可变
     * 因为final+private导致不可访问
     * 并不是单纯的因为final关键字导致不可变，final只是说明这个字节数组的引用不可变
     * @param args
     */
    public static void main(String[] args) {

        ChangeableString cs = new ChangeableString(10);
        cs.changeString(0, (byte) 'c');
            cs.printString();


    }
}
