package classic;

import org.w3c.dom.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @FileName: MySkipList
 * @Author: LuckKun
 * @Email: 1546165200@qq.com
 * @Date: 2022/3/24 17:13
 */
public class MySkipList {

    public static final int MAX_LEVEL = 16;

    private int levelCount =  1;
    private List<Node> index = new ArrayList<>(MAX_LEVEL);

    private Random random = new Random();

    public MySkipList() {
        for (int i = 0; i < MAX_LEVEL; i++) {
            index.add(new Node(-1));
        }

    }

    public boolean search(int target) {
        int tmpLevel = levelCount-1;
        Node head = index.get(levelCount-1);
        while (head!=null&&head.getVal()!=-1){
            if (target==head.getVal()) return true;
            else  if (target>head.getVal()&&head.getNext()==null){
                head = head.getDown();
            }
            else  if (target>head.getVal()&&head.getNext().getVal()>target){
                head  = head.getDown();
            }
            else{
                if (tmpLevel-1>=0) head = index.get(--tmpLevel);
                else  return false;
            }

        }
        return  false;

    }

    public void add(int num) {

        int level = randomLevel();
        if(level>levelCount) level = levelCount+1;
        levelCount = level;


        Node downNode = null;
        Node pre = null;
        Node tmp = null;
        for (int i = 0; i < level; i++) {
            if (index.get(i).getVal()==-1){
                index.set(i,new Node(null,downNode,num));
                downNode = index.get(i);
            }
            else{
                Node head = index.get(i);
                if (head.getVal()>num){
                    Node node = new Node(head, downNode, num);
                    index.set(i,node);
                    downNode = node;
                    continue;
                }
                Node thisTmp = new Node();
                while (head.next!=null&&head.next.getVal()<num)  head = head.next;

                tmp = head.next;
                head.next = thisTmp;
                thisTmp.setVal(num);
                thisTmp.setNext(tmp);
                thisTmp.setDown(downNode);
                downNode = thisTmp;
            }
        }

    }

    // 随机函数
    private int randomLevel(){
        int level = 1;
        for(int i = 1; i < MAX_LEVEL; ++i){
            if(random.nextInt() % 2 == 1){
                level++;
            }
        }
        return level;
    }

    public boolean erase(int num) {
        boolean flag = false;
        for (int i = 0; i < levelCount; i++) {
            Node head = index.get(i);
            if (head.getVal()==num){
                if (head.next!=null) index.set(i,head.next);
                else if (head.next==null) index.set(i,new Node(-1));
                flag = true;
                continue;
            }
            if (head.getVal()!=-1){
                while (head.getNext()!=null){
                    if (head.getNext().getVal()==num){
                        head.setNext(head.getNext().getNext());
                        flag = true;
                       break;

                    }
                    head=head.getNext();
                }
            }
        }
        return  flag;
    }

    public static void main(String[] args) {
        MySkipList mySkipList = new MySkipList();
        mySkipList.add(1);
        mySkipList.add(2);
        mySkipList.add(3);

        for (Node node : mySkipList.index){

            mySkipList.dfs(node);
            System.out.println();
        }
        System.out.println(mySkipList.search(0));
        mySkipList.add(4);
        System.out.println(mySkipList.search(1));
        mySkipList.add(5);

        for (Node node : mySkipList.index){

            mySkipList.dfs(node);
            System.out.println();
        }
        System.out.println(mySkipList.search(3));
        System.out.println(mySkipList.search(6));


    }


    public  void  dfs(Node e ){
        System.out.print(e.getVal()+"---------->");
        if (e.getNext()!=null) dfs(e.getNext());

    }






    static class Node {

        private Node next;
        private Node down;
        private   int val;


        Node(){


        }

        Node(int v){
            this.val = v;
        }

        Node(Node n,int v){
            this.next = n;

            this.val = v;
        }

        Node(Node n,Node d,int v){
            this.next = n;
            this.down = d;

            this.val = v;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public Node getDown() {
            return down;
        }

        public void setDown(Node down) {
            this.down = down;
        }

        public int getVal() {
            return val;
        }

        public void setVal(int val) {
            this.val = val;
        }
    }
}
