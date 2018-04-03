package homework.hw0324;

import java.util.ArrayList;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * АВЛ ДЕРЕВО
 *
 * @param <T> - тип ключа
 * @param <M> - тип значений
 */

public class Tree<T extends Comparable<T>, M> {

    private ArrayList<Node<T, M>> list;
    private Node<T, M> root;

    public Tree(T key, M value) {
        list = new ArrayList<>();
        this.root = new Node<>(key, value);
        list.add(root);
    }




    public void put(T key, M value)
    {
        Node<T,M> newNode = new Node<>(key,value);
        if (root.put(newNode))
        {
            list.add(newNode);
        }else list.add(newNode);
    }


    public boolean isEmpty()
    {
        return list.isEmpty();
    }

    /**
     * Getters
     */

    public Set<T> getKeySet()
    {
        return list.stream().collect(
                Collectors.groupingBy(
                        node -> root.getKey())).keySet();
    }

    public ArrayList<Node<T, M>> getList() {
        return list;
    }

    public Node<T, M> getRoot() {
        return root;
    }

    public void printTree() {
        for (Node<T, M> a : list)
        {
            System.out.println(a);
        }
    }
}
