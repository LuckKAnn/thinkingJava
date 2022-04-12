package classic;

/**
 * @FileName: BTree
 * @Author: LuckKun
 * @Email: 1546165200@qq.com
 * @Date: 2021/10/26 14:52
 */
public class RBTree<K extends Comparable<K>,V> {

    public static final boolean RED =false;
    public static final boolean BLACK = true;

    private RBNode root ;

    public RBNode getRoot() {
        return root;
    }

    public void setRoot(RBNode root) {
        this.root = root;
    }


    /**
     * 左旋操作
     *           p                             pr
     *          /\                            /\
     *         pl pr    ==========>          p   rr
     *            /\                        /\
     *          rl  rr                     pl rl
     *==============================
     * 左旋的时候:
     *      pl和rr不变
     *      pr-rl变为p-rl
     *    判断P结点有父节点
     *          如果没有父节点，则pr为root结点
     *          如果有 则pr.parent = p.parent
     *          还要设置pr为p.parent的左右子节点
     *
     *      最后设置p-pr为pr-p
     */
    public   void leftRotate(RBNode p){
        if (p==null) return;
        RBNode pr = p.right;
    //    pr-rl变为p-rl
        p.right = pr.left;
        if (pr.left!=null){
            pr.left.parent = p;
        }
        // 判断P结点有父节点
        //直接赋值不判断
        pr.parent = p.parent;
        if (p.parent==null){
            //没有父节点，则为根节点
            root =  pr;
        }
        else if(p.parent.left == p){
            p.parent.left = pr;
        }
        else p.parent.right = pr;
        //设置pr和p的关系即可
        pr.left = p;
        p.parent = pr;

    }

    /**
     * 右旋，类比与左旋
     * @param p
     */
    public   void rightRotate(RBNode p){
        if (p==null) return;
        RBNode pl = p.left;
        //    pr-rl变为p-rl
        p.left = pl.right;
        if (pl.right!=null){
            pl.right.parent = p;
        }
        // 判断P结点有父节点
        //直接赋值不判断
        pl.parent = p.parent;
        if (p.parent==null){
            //没有父节点，则为根节点
            root =  pl;
        }
        else if(p.parent.left == p){
            p.parent.left = pl;
        }
        else p.parent.right = pl;
        //设置pr和p的关系即可
        pl.right = p;
        p.parent = pl;

    }

    /**
     * 常用方法
     * @param node
     * @return
     */
    private boolean colorOf(RBNode node){
        return  node==null?BLACK:node.color;
    }


    private RBNode parentOf(RBNode node){
        return  node!=null?node.parent:null;
    }


    private RBNode leftOf(RBNode node){
        return  node==null?null:node.left;
    }
    private RBNode  rightOf(RBNode node){
        return  node==null?null:node.right;
    }

    private  void setColor(RBNode node,boolean color){
        if (node!=null){
            node.setColor(color);
        }
    }


    /**
     * 新增结点
     * 红黑树结点的新增
     *      1. 普通的二叉树的插入
     *          先查询到插入的位子
     *          将KV封装成NODE对象，插入到Tree中
     *      2.红黑树的平衡（调整，变色+旋转）
     * @param key
     * @param val
     */
    public void put(K key,V val){
        RBNode root = this.root;
        if (root==null){
            //插入的就是根节点
            RBNode<K, V> kvrbNode = new RBNode<>(null, key, val, BLACK);
            root = kvrbNode;
            return;
        }
        //记录比较值
        int cmp;
        //记录父节点
        RBNode parent;
        if (key==null) throw  new NullPointerException();

        do {
            parent = root;
             cmp = key.compareTo((K) root.key);
             if (cmp>0){

                 root = root.right;
             }
             else if(cmp<0){
                 root = root.left;
             }
             else{
                 root.setVal(val==null?key:val);
                 return;
             }
        }while (root!=null);
    //  找到插入位置为parent的子节点
        RBNode<K, V> kvrbNode = new RBNode<>(parent, key, val, RED);

        if (cmp<0) parent.left = kvrbNode;
        else parent.right = kvrbNode;
        //平衡处理，旋转，变色
        fixAfterPut(kvrbNode);
    }


    private  void  fixAfterPut(RBNode e){

    }





    static class  RBNode<K extends Comparable<K>,V>{

        private  RBNode parent;
        private  RBNode left;
        private  RBNode right;

        private  K key;
        private  V val;


        private boolean color;

        public RBNode() {
        }

        public RBNode(RBNode parent, RBNode left, RBNode right, K key, V val, boolean color) {
            this.parent = parent;
            this.left = left;
            this.right = right;
            this.key = key;
            this.val = val;
            this.color = color;
        }

        public RBNode(RBNode parent, K key, V val, boolean color) {
            this.parent = parent;
            this.key = key;
            this.val = val;
            this.color = color;
        }

        public RBNode getParent() {
            return parent;
        }

        public void setParent(RBNode parent) {
            this.parent = parent;
        }

        public RBNode getLeft() {
            return left;
        }

        public void setLeft(RBNode left) {
            this.left = left;
        }

        public RBNode getRight() {
            return right;
        }

        public void setRight(RBNode right) {
            this.right = right;
        }

        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public V getVal() {
            return val;
        }

        public void setVal(V val) {
            this.val = val;
        }

        public boolean isColor() {
            return color;
        }

        public void setColor(boolean color) {
            this.color = color;
        }
    }

}
