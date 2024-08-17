public class BalancedBTree {
    int val;
    BalancedBTree left;
    BalancedBTree right;
    BalancedBTree() {}
    BalancedBTree(int val) { 
        this.val = val; 
    }
    BalancedBTree(int val, BalancedBTree left, BalancedBTree right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
    public boolean isBalanced(BalancedBTree root) {
        return height(root)!=-1;
    }
    private int height(BalancedBTree root){
        if(root==null){
            return 0;
        }

        int leftTree=height(root.left);
        if(leftTree==-1){
            return -1;
        }
        int rightTree=height(root.right);
        if(rightTree==-1){
            return -1;
        }

        int a=leftTree-rightTree;
        if(Math.abs(a)>1){
            return -1;
        }
        return Math.max(leftTree, rightTree)+1;
    }
    
    public static void main(String[] args) {
        Solution solution = new Solution();
        BalancedBTree root = new BalancedBTree(3);
        root.left = new BalancedBTree(9);
        root.right = new BalancedBTree(20);
        root.right.left = new BalancedBTree(15);
        root.right.right = new BalancedBTree(7);
        
        System.out.println(solution.isBalanced(root));  // Output: true
    }
}