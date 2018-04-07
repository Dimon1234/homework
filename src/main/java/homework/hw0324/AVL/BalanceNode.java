package homework.hw0324.AVL;

public class Node extends homework.hw0324.Node {
    private int balance;


    public Node(Comparable key, Object element) {
        super(key, element);
        balance = 1;
    }
}
