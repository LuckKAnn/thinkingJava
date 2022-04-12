package leetcode_alogorithm;

/**
 * @FileName: MyBitMap
 * @Author: LuckKun
 * @Email: 1546165200@qq.com
 * @Date: 2021/11/15 17:40
 */
public class MyBitMap {
    byte[] bits ;

    public int bulbSwitch(int n) {
        bits = new byte[n/8+1];
        return 0;

    }

    public int getIndex(int num){
        return  num%8;
    }

    public int getPosition(int num){
        return  num&0x7;
    }
    public boolean contains( int num){
        return (bits[getIndex(num)] & 1 << getPosition(num)) != 0;
    }
    public  void  setBitmap(int num){
        bits[getIndex(num)] |=1<<getPosition(num);
    }
    public  void  reBitmap(int num){
        bits[getIndex(num)] &= ~(1 << getPosition(num));
    }


}
