import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * @author : LuckKAnn
 * @date : 15:48 2021/9/11
 * @email: 1546165200@qq.com
 */
class toys{
    int x;int y;
    int r;
    toys(int x,int y,int r){
        this.x = x;
        this.y = y;
        this.r = r;
    }
}
public class CircleGame {
    public int circleGame(int[][] toys, int[][] circles, int r) {
        Set<toys> set = new HashSet<>();
        for (int []toy: toys){
            set.add(new toys(toy[0],toy[1],toy[2]));
        }
        int count = 0;
        for(int []circle :circles){
            if(set.isEmpty()) break;
            int left = circle[0]-r;
            int right = circle[0]+r;
            int bottom = circle[1]-r;
            int up = circle[1]+r;
            Iterator<toys>it = set.iterator();
            while (it.hasNext()){
                toys t = it.next();
                if(t.x>left&&t.x<right&&t.y<up&&t.y>bottom){
                    // 圆心在内
                    double d = Math.sqrt((circle[0]-t.x)*(circle[0]-t.x)+(circle[1]-t.y)*(circle[1]-t.y));
                    if(r-d>=t.r){
                        count++;
                        it.remove();
                    }
                }

            }

        }
        return  count;
    }
}
