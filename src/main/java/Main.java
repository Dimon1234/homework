import homework.hw0324.Tree;

public class Main {

    public static void main(String[] args) {
        Tree<Integer, String> tree = new Tree<>(10,"I'm root");
        tree.put(11,"11");
        tree.put(1,"11");
        tree.put(15,"11");

        tree.printTree();
    }
}