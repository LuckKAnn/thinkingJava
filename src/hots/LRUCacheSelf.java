package hots;

import java.util.HashMap;

class LRUCacheSelf {

    private HashMap<Integer,Node> map;
    private DoubleList cache;
    private int capacity;


    public LRUCacheSelf(int capacity) {
        this.capacity=capacity;
        map=new HashMap<>();
        cache=new DoubleList();
    }

    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        }
        int value=map.get(key).value;
        put(key,value);//把该节点提前
        return value;

    }

    public void put(int key, int value) {
        Node cur=new Node(key,value);
        //之前插入过该节点
        if(map.containsKey(key)){
            cache.remove(map.get(key));
        }
        //之前没有插入过该节点
        else{
            if(capacity==cache.size()){
                Node last=cache.removeLast();
                map.remove(last.key);
            }
        }
        cache.addFirst(cur);
        map.put(key,cur);

    }
}
class Node{
    int key;
    int value;
    Node pre;
    Node next;
    public Node(int key,int value){
        this.key=key;
        this.value=value;
    }
}
class DoubleList{
    Node head;
    Node tail;
    int size=0;
    //在链表头部插入节点
    public void addFirst(Node node){
        if(head==null){
            head=node;
            tail=node;
        }
        else{
            Node temp=head;
            temp.pre=node;
            node.next=temp;
            head=node;
        }
        size++;
    }
    //删除某个节点
    public void remove(Node node){
        //如果该链表只有一个节点
        if(head==node && tail==node){
            head=null;
            tail=null;
        }
        //如果待删除节点是头节点
        else if(node==head){
            Node temp=node.next;
            head=temp;
            temp.pre=null;

        }
        //如果待删除节点是尾节点
        else if(node==tail){
            Node temp=node.pre;
            tail=temp;
            temp.next=null;
        }
        //如果待删除节点是中间节点
        else{
            Node temp1=node.pre;
            Node temp2=node.next;
            temp1.next=temp2;
            temp2.pre=temp1;
        }
        size--;
    }
    //删除最后一个节点，并返回
    public Node removeLast(){
        Node temp=tail;
        remove(temp);
        return temp;
    }
    //链表长度
    public int size(){
        return size;
    }
}
