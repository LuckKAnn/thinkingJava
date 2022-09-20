package leetcode_alogorithm;

/**
 * @FileName: SolveEquation640
 * @Author: LuckKun
 * @Email: 1546165200@qq.com
 * @Date: 2022/8/10 22:47
 */
public class SolveEquation640 {
    /**
     * 求解方程
     * @param equation
     * @return
     */
    public String solveEquation(String equation) {
        int x = 0,num = 0;
        char [] sc = equation.toCharArray();
        for(int i=0,op=1;i<equation.length();){
            if(sc[i]=='+'){
                op=1;i++;
            }else if (sc[i]=='-'){
                op=-1;i++;
            }else if (sc[i]=='='){
                x*=-1;
                num*=-1;
                op = 1;
                i++;
            }else{
                int j = i;
                while (j<equation.length()&&sc[j]!='+'&&sc[j]!='-'&&sc[j]!='='){
                    j++;
                }
                if (sc[j-1]=='x'){
                    if(i==j-1) x+=(op);
                    else{
                        int numb = Integer.valueOf(equation.substring(i, j-1));
                        x+=(op*numb);
                    }

                } else{
                    int numb = Integer.valueOf(equation.substring(i,j));
                    num+=(op*numb);
                }
                i = j;
            }
        }
        if (x==0&& num==0) return "Infinite solutions";
        else if(x==0) return "No solution";
        else {
            return "x="+String.valueOf(-num/x);
        }
    }
}

