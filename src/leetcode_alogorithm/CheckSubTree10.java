package leetcode_alogorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CheckSubTree10 {

    public boolean checkSubTree(TreeNode t1, TreeNode t2) {
        List<String> ori = new ArrayList<>();
        List<String> target = new ArrayList<>();
        dfs(t1,ori);
        dfs(t2,target);
        int[] next = findNext(target);
        return findSubTree(ori,target,next);
    }

    private boolean findSubTree(List<String> ori, List<String> target,int []next) {

        int i =0,j=0;
        while (i<ori.size() && j<target.size()){
            if (Objects.equals(ori.get(i),target.get(j))){
                i++;
                j++;
            } else{
                if (j==0){
                    i++;
                } else{
                    j = next[j-1];
                }
            }
        }
        return  j==target.size();
    }


    public  int[] findNext(List<String> target){
        int []next = new int[target.size()];
        int preLen = 0;

        for (int i = 1; i < target.size(); i++) {
            if (Objects.equals(target.get(i),target.get(preLen))){
                preLen++;
                next[i] = preLen;
            }else{
                if (preLen==0){
                    next[i] = preLen;
                } else{
                    preLen = next[preLen-1];
                    i--;
                }
            }

        }
        return next;
    }

    public  void  dfs(TreeNode t1,List<String> list){
        if (t1==null){
            list.add("null");
            return;
        }
        list.add(t1.val+"");
        dfs(t1.left,list);
        dfs(t1.right,list);
    }



}
