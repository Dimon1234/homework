package homework.hw0324.AVL;

import homework.hw0324.Node;

public class BalanceNode<K extends Comparable<K>, V> extends homework.hw0324.Node<K, V> {
    private int height;

    public BalanceNode(K key, V element) {
        super(key, element);
        height = 0;
    }

    private BalanceNode(Node<K, V> node) {
        super(node.getKey(), node.getElement());
        height = 0;
    }


    public int getHeight(BalanceNode<K, V> node) {
        return recHeight(node, 0);
    }

    private int recHeight(BalanceNode<K, V> node, int maxHeight) {
        if (node.isLeaf()) return maxHeight;
        else {
            int left = 0, right = 0;
            if (node.getLeft() != null) left = recHeight(node.getLeft(), maxHeight + 1);
            if (node.getRight() != null) right = recHeight(node.getRight(), maxHeight + 1);

            maxHeight = Math.max(left, right);
        }
        return maxHeight;
    }


    @Override
    public Boolean put(Node node) {
        return null;
    }


    public Node<K, V> remove(Node<K, V> node, K key) {
        if (node == null) return null;
        if (node.getKey().compareTo(key) > 0) node.setLeft(remove(node.getLeft(), key));
        else if (node.getKey().compareTo(key) < 0) node.setRight(remove(node.getRight(), key));
        else {
            if (node.getRight() == null) return node.getLeft();
            if (node.getLeft() == null) return node.getRight();
            Node<K, V> t = node;
            node = getMin(t.getRight());
            node.setRight(deleteMin(t.getRight()));
            node.setLeft(t.getLeft());

//            return balance(node);
        }

//        return balance(node);

        return null;
    }

    /**
     * recursive function used to delete minimal item in the tree
     * recuresively we are checking if node has left child. if no - return right child.
     *
     * @param {node} node object.
     */
    private Node<K, V> deleteMin(Node<K, V> node) {
        if (node.getLeft() == null) return node.getRight();

//        node.getLeft() = deleteMin(node.left);
//        node.height = 1 + getSize(node.left) + getSize(node.right);

        return node;
    }

    private Node<K, V> getMin(Node<K, V> node) {

        if (node.getLeft() == null) return node;

        return getMin(node.getLeft());
    }

    @Override
    public void print(Node<K, V> node, int depth) {
        super.print(node, depth);
    }

    @Override
    public K getKey() {
        return super.getKey();
    }

    @Override
    public V getElement() {
        return super.getElement();
    }


    public BalanceNode<K, V> getLeft() {
        return new BalanceNode<>(super.getLeft());
    }

    public BalanceNode<K, V> getRight() {
        return new BalanceNode<>(super.getRight());
    }

    @Override
    public boolean isLeaf() {
        return super.isLeaf();
    }

    @Override
    public void setLeft(Node<K, V> left) {
        super.setLeft(left);
    }

    @Override
    public void setRight(Node<K, V> right) {
        super.setRight(right);
    }

    @Override
    public void setKey(K key) {
        super.setKey(key);
    }

    @Override
    public void setValue(V value) {
        super.setValue(value);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
