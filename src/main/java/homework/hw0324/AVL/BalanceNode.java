package homework.hw0324.AVL;

import homework.hw0324.Node;

public class BalanceNode<K extends Comparable<K>, V> extends homework.hw0324.Node {

    private int balance;

    public BalanceNode(Comparable key, Object element) {
        super(key, element);
        balance = 1;
    }



    public int getHeight(Node<K, V> node) {
        return recHeight(node, 0);
    }

    private int recHeight(Node<K, V> node, int maxHeight) {
        if (node.isLeaf()) return maxHeight;
        else {
            int left =0, right = 0;
            if (node.getLeft() != null) left = recHeight(node.getLeft(), maxHeight + 1);
            if (node.getRight() != null) right = recHeight(node.getRight(), maxHeight + 1);

            maxHeight = Math.max(left,right);
        }
        return maxHeight;
    }


}
