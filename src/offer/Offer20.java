package offer;

/**
 * @FileName: Offer20
 * @Author: LuckKun
 * @Email: 1546165200@qq.com
 * @Date: 2022/3/30 17:47
 */
public class Offer20 {

    private int index =  0;
    private boolean flag = false;
    private boolean preNum = false;
    //这道题相当于要实现一个词法分析器
    public boolean isNumber(String s) {
        if (s==null) return false;
        //省去空格的解析
        s = s.trim();
        if (s.length()==0) return false;
        while (index<s.length()){

            char c= s.charAt(index++);
            if (c=='+'||c=='-'){
                if (flag||preNum) return false;
                flag=true;
            }
            else if(Character.isDigit(c)) {

                preNum = true;
            }
            else if (c=='.'){
                if (!phareFloat(s)) return false;
            }
            else if(c=='e'||c=='E'){
                if (!preNum) return  false;
                if (!pharesInt(s)) return false;
            }
            else  return false;
        }
        return true;


    }

    public boolean phareFloat(String s){

        boolean hasNum = false;
        while (index<s.length()){
            char c= s.charAt(index++);
            if(Character.isDigit(c)) hasNum = true;
            else if(c=='e'||c=='E'){
                if (!pharesInt(s)) return false;
            }
            else return false;
        }

        if (!preNum){
            if (!hasNum) return false;
            else  return true;
        }
        return true;
    }

    public boolean pharesInt(String s){
        boolean hasNum = false;
        boolean hasFlag = false;
        while (index<s.length()){
            char c= s.charAt(index++);
            if(Character.isDigit(c)) {
                hasNum = true;
            }
            else if (c=='+'||c=='-'){
                if (hasFlag||hasNum) return false;
                hasFlag=true;
            }
            else return false;
        }

        if (hasNum) return true;
        else return  false;

    }

    public static void main(String[] args) {
        Offer20 offer20 = new Offer20();
        System.out.println(offer20.isNumber("+100"));
        System.out.println(offer20.isNumber("+5e2"));
        System.out.println(offer20.isNumber("+12e+5.4"));
        System.out.println(offer20.isNumber("   "));
    }

}
