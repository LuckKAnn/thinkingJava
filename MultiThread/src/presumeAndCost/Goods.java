package presumeAndCost;

/**
 * @FileName: Goods
 * @Author: LuckKun
 * @Email: 1546165200@qq.com
 * @Date: 2022/3/2 11:11
 */
public class Goods {


    private String goodName;


    private  int id;

    public Goods() {
    }

    public Goods(String goodName, int id) {
        this.goodName = goodName;
        this.id = id;
    }

    public String getGoodName() {
        return goodName;
    }

    public void setGoodName(String goodName) {
        this.goodName = goodName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
