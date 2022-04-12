import java.nio.ByteBuffer;

/**
 * @FileName: ByteBufferExp
 * @Author: LuckKun
 * @Email: 1546165200@qq.com
 * @Date: 2022/3/10 10:53
 */
public class ByteBufferExp {

    public static void main(String[] args) {
        ByteBuffer byteBuffer = ByteBuffer.allocate(10);
        System.out.println(byteBuffer);
        String ans = "sadasdas1111111111d";
        byteBuffer.put(ans.getBytes());
        System.out.println(byteBuffer);
        for (int i = 0; i < ans.length(); i++) {
            byte b = byteBuffer.get(i);
            System.out.print(b+"\t");
            System.out.println(byteBuffer);
        }
    }
}
