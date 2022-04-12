package leetcode_alogorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : LuckKAnn
 * @date : 23:51 2021/9/4
 * @email: 1546165200@qq.com
 */

/**
 * 5848. 树上的操作
 * 给你一棵 n 个节点的树，编号从 0 到 n - 1 ，以父节点数组 parent 的形式给出，其中 parent[i] 是第 i 个节点的父节点。树的根节点为 0 号节点，所以 parent[0] = -1 ，因为它没有父节点。你想要设计一个数据结构实现树里面对节点的加锁，解锁和升级操作。
 *
 * 数据结构需要支持如下函数：
 *
 * Lock：指定用户给指定节点 上锁 ，上锁后其他用户将无法给同一节点上锁。只有当节点处于未上锁的状态下，才能进行上锁操作。
 * Unlock：指定用户给指定节点 解锁 ，只有当指定节点当前正被指定用户锁住时，才能执行该解锁操作。
 * Upgrade：指定用户给指定节点 上锁 ，并且将该节点的所有子孙节点 解锁 。只有如下 3 个条件 全部 满足时才能执行升级操作：
 * 指定节点当前状态为未上锁。
 * 指定节点至少有一个上锁状态的子孙节点（可以是 任意 用户上锁的）。
 * 指定节点没有任何上锁的祖先节点。
 * 请你实现 LockingTree 类：
 *
 * LockingTree(int[] parent) 用父节点数组初始化数据结构。
 * lock(int num, int user) 如果 id 为 user 的用户可以给节点 num 上锁，那么返回 true ，否则返回 false 。如果可以执行此操作，节点 num 会被 id 为 user 的用户 上锁 。
 *
 *
 * ******************************力扣周赛题
 */
class LockingTree {

    private class TreeNode {
        int lockId = -1;        // 上锁的用户Id
        int parent = -1;        // 父亲节点的下标
        List<Integer> children = new ArrayList<Integer>();  // 子节点的下标列表
    }

    TreeNode[] map; // 节点数组，代替HashMap

    public LockingTree(int[] parent) {
        map = new TreeNode[parent.length];
        // 初始化节点数组
        for (int i = 0; i < parent.length; i++) {
            map[i] = new TreeNode();
        }
        // 确定父子关系
        for (int i = 1; i < parent.length; i++) {
            TreeNode father = map[parent[i]];
            TreeNode child = map[i];
            father.children.add(i);
            child.parent = parent[i];
        }

    }


    public boolean lock(int num, int user) {
        if(map[num].lockId==-1){
            map[num].lockId = user;
            return  true;
        }
        else return  false;
    }

    public boolean unlock(int num, int user) {
        if(map[num].lockId==user){
            map[num].lockId = -1;
            return  true;
        }
        else return  false;
    }

    /**
     * 这个方法的实现比较难，涉及多个条件的判断，可以分别写函数来做
     * @param num
     * @param user
     * @return
     */
    public boolean upgrade(int num, int user) {
        //指定结点未上锁
        if(map[num].lockId!=-1) return false;
        else{
        //    至少一个子孙上锁
            if(!ifDescendentLock(map[num])) {
                return false;
            }
            if(!ifPreNotLock(map[num])) {
                return false;
            }

            lock(num,user);
            unLockDescendent(map[num]);
            return  true;
        }
    }
    //可以用队列来做
    public  boolean ifDescendentLock(TreeNode node){
        List<Integer> childrens = node.children;
        for(Integer children:childrens){
            if(map[children].lockId!=-1) return true;
            else {
                boolean ifson = ifDescendentLock(map[children]);
                if(ifson) {
                    return true;
                }
            }
        }
        return  false;

    }

    public  boolean ifPreNotLock(TreeNode node){
        while(node.parent!=-1){
            if(map[node.parent].lockId!=-1) return  false;
            node = map[node.parent];
        }
        return  true;

    }
    public  boolean unLockDescendent(TreeNode node){
        List<Integer> childrens = node.children;
        for(Integer children:childrens){
            map[children].lockId = -1;
            unLockDescendent(map[children]);
        }
        return  true;
    }

    public static void main(String[] args) {
        int []arr = {-1, 0, 0, 1, 1, 2, 2};
        LockingTree lockingTree = new LockingTree(arr);
    }

}