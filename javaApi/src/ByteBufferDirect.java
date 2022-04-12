import java.nio.ByteBuffer;

/**
 * @FileName: ByteBufferDirect
 * @Author: LuckKun
 * @Email: 1546165200@qq.com
 * @Date: 2022/3/17 10:12
 */
public class ByteBufferDirect {


    public static void main(String[] args) {
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(1000);
        for (int i = 0; i < 100; i++) {
            byteBuffer.put(Byte.parseByte(String.valueOf(i)));
            System.out.println(byteBuffer);
           if(i%10==0) {
               byteBuffer.flip();
               byte b = byteBuffer.get();
               System.out.print(b+"\t");
               System.out.println(byteBuffer);
               byteBuffer.rewind();
           }

        }
    }
}
