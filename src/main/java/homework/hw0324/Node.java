package homework.hw0324;

import java.util.*;

/**
 * @link https://ru.wikipedia.org/wiki/%D0%90%D0%92%D0%9B-%D0%B4%D0%B5%D1%80%D0%B5%D0%B2%D0%BE
 */
public class Node<T extends Comparable<T>, M> {

    private T key;
    private M value;
    private Node<T, M> left, right;
    private int height;


    public Node(T key, M element) {
        this.key = key;
        this.value = element;
        this.height = 0;
    }


    /**
     * corrects height of the node, in case left subtree height and right subtree height
     * is correct
     */
    private void correctHeight(Node<T, M> node) {
        if (node == null) return;
        int heightLeft = node.isLeaf() ? 0 : getSize(node.getLeft());
        int heightRight = node.isLeaf() ? 0 : getSize(node.getRight());
        node.setHeight(((heightLeft > heightRight) ? heightLeft : heightRight) + 1);
    }

    /**
     * returns balance factor of the node
     */
    private int bfactor(Node<T, M> node) {
        if (node == null) return 0;
        return getSize(node.getRight()) - getSize(node.getLeft());
    }

    private int getSize(Node<T, M> root) {
        int deep = 0;
        List<Node<T, M>> listNodes = getChildren(root);
        if (listNodes == null) return deep;
        for (Node<T, M> node : listNodes) {
            if (node != null) deep = Integer.max(deep, getSize(node));
        }
        return deep + 1;
    }

    /**
     * function used to balance node
     */
    public Node<T, M> balance(Node<T, M> node) {
        correctHeight(node);
        if (bfactor(node) == 2) {
            if (bfactor(node.getRight()) < 0) {
                node.setRight(rotateRight(node.getRight()));
            }
            return rotateLeft(node);
        }
        if (bfactor(node) == -2) {
            if (bfactor(node.getLeft()) > 0) {
                node.setLeft(rotateLeft(node.getLeft()));
            }
            return rotateRight(node);
        }
        return node;
    }

    /**
     * perform rotation around specific node
     */
    private Node<T, M> rotateRight(Node<T, M> node) {
        Node<T, M> tempNode = node.getLeft();
        node.setLeft(tempNode.getRight());
        tempNode.setRight(node);

        correctHeight(node);
        correctHeight(tempNode);

        return tempNode;
    }

    /**
     * perform rotation left around specific node
     */
    private Node<T, M> rotateLeft(Node<T, M> node) {
        Node<T, M> tempNode = node.getRight();
        tempNode.setRight(node.getLeft());
        node.setLeft(node);

        correctHeight(node);
        correctHeight(tempNode);

        return node;
    }

    /**
     * @param node which we wanna add
     * @return null if node did not add;
     * true if node added successfully like a right child;
     * false if node added successfully like a left child
     */
    public Boolean put(Node<T, M> node) {
        Node<T, M> nodeToAdd = findToAdd(node.getKey());
        if (node.getKey().compareTo(nodeToAdd.getKey()) > 0) {
            nodeToAdd.setRight(node);
            return true;
        } else if (node.getKey().compareTo(nodeToAdd.getKey()) < 0) {
            nodeToAdd.setLeft(node);
            return false;
        }
        return null;
    }

    public Node<T, M> put(Node<T, M> node, T key, M value) {
        if (node == null) return new Node<>(key, value);
        if (node.getKey().compareTo(key) > 0) {
            node.setLeft(put(node.getLeft(), key, value));
        } else if (node.getKey().compareTo(key) < 0) {
            node.setRight(put(node.getRight(), key, value));
        } else if (node.getKey().compareTo(key) == 0) {
            node.setValue(value);
        }
        node.setHeight(1 + getSize(node.getLeft()) + getSize(node.getRight()));
        return balance(node);

    }

    public Node<T, M> delete(Node<T, M> root, T key) {
        if (root == null) return null;
        if (key.compareTo(root.getKey()) < 0)
            root.setLeft(delete(root.getLeft(), key));
        else if (key.compareTo(root.getKey()) > 0)
            root.setRight(delete(root.getRight(), key));
        else if (root.getLeft() != null && root.getRight() != null) {
            root.setKey(root.getRight().minNode().getKey());
            root.setRight(delete(root.getRight(), root.getKey()));
        } else {
            if (root.getLeft() != null) root = root.getLeft();
            else root = root.getRight();
        }
        return balance(root);
    }

    private Node<T, M> minNode() {
        if (this.getLeft() == null && this.getRight() == null) return this;
        else if (this.getLeft() == null) return this.getRight();
        else return this.getLeft();
    }

    /**
     * Вызывается у корня
     */
    public Node<T, M> find(T key) {
        return find(key, this, false);
    }

    private Node<T, M> findToAdd(T key) {
        return find(key, this, true);
    }


    private Node<T, M> find(T key, Node<T, M> pointer, boolean toAdd) {
        if (key.compareTo(pointer.getKey()) == 0) return pointer;
        else if (key.compareTo(pointer.getKey()) > 0 && pointer.getRight() != null)
            return find(key, pointer.getRight(), toAdd);
        else if (key.compareTo(pointer.getKey()) < 0 && pointer.getLeft() != null)
            return find(key, pointer.getLeft(), toAdd);

        return toAdd ? pointer : null;
    }

    /**
     * Вызывается у корня
     *
     * @return max node
     */
    public Node<T, M> findMax() {
        if (this.getRight() == null) return this;
        else return this.getRight().findMax();
    }

    /**
     * Вызывается у корня
     *
     * @return min node
     */
    public Node<T, M> findMin() {
        if (this.getLeft() == null) return this;
        else return this.getLeft().findMin();
    }


    /**
     * Print method
     */
    public void print(Node<T, M> node, int depth) {
        if (node != null) {
            print(node.getRight(), depth + 1);
            for (int k = 0; k < depth; k++) {
                System.out.print("    ");
            }
            System.out.println(node.getKey());
            print(node.getLeft(), depth + 1);
        }
    }


    /**
     * Getters and Setters
     */

    public T getKey() {
        return key;
    }

    public M getElement() {
        return value;
    }

    public Node<T, M> getLeft() {
        return left;
    }

    public Node<T, M> getRight() {
        return right;
    }

    public boolean isLeaf() {
        return (this.getLeft() == null) && (this.getRight() == null);
    }

    public void setLeft(Node<T, M> left) {
        this.left = left;
    }

    public void setRight(Node<T, M> right) {
        this.right = right;
    }

    public void setKey(T key) {
        this.key = key;
    }

    public void setValue(M value) {
        this.value = value;
    }

    public M getValue() {
        return value;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public List<Node<T, M>> getChildren(Node<T, M> node) {
        List<Node<T, M>> nodes = null;
        try {
            nodes = new ArrayList<>(Arrays.asList(node.getLeft(), node.getRight()));
        } catch (NullPointerException e) {
            return null;
        }
        return nodes;
    }

    @Override
    public String toString() {
        if (isLeaf())
            return "BalanceNode{" +
                    "key=" + key +
                    ", value=" + value +
                    ", left=" + "null" +
                    ", right=" + "null" +
                    '}';

        else return "BalanceNode{" +
                "key=" + key +
                ", value=" + value +
                ", left=" + left.getKey() +
                ", right=" + right.getKey() +
                '}';
    }

}
