import homework.hw0324.Tree;

public class Main {

    public static void main(String[] args) {
        Tree<Integer, String> tree = new Tree<>(10,"I'm root");
        tree.put(7,"7");
        tree.put(15,null);
        tree.put(12,"12");
        tree.put(17,"17");
        tree.put(6,"6");
        tree.put(8,"8");
        tree.put(19,"");
        tree.put(9,"");
        tree.put(5,"");

        tree.printTree();

        System.out.println(tree.getMin());
        System.out.println(tree.getMax());
    }

}