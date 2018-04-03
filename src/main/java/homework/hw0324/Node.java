package homework.hw0324;


//TODO поиск минимального
//TODO поиск максимального
//TODO поиск следующей ноды после заданного ключа, если нет, то выводить все поддерево
//TODO добавление элементов
//TODO удаление элементов
//TODO балансировка

/**
 * https://ru.wikipedia.org/wiki/%D0%90%D0%92%D0%9B-%D0%B4%D0%B5%D1%80%D0%B5%D0%B2%D0%BE
 */
class Node<T extends Comparable<T>, M> {

    private T key;
    private M value;
    private Node<T, M> left, right;


    public Node(T key, M element) {
        this.key = key;
        this.value = element;
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

    /**
     * Предполагается, что метод будет вызываться у корня
     *
     * @param key
     * @return
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
     * Getters & toString()
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

    public boolean isLeaf(Node<T, M> node) {
        return (node.getLeft() == null) && (node.getRight() == null);
    }

    public void setLeft(Node<T, M> left) {
        this.left = left;
    }

    public void setRight(Node<T, M> right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "Node{" +
                "key=" + key +
                ", value=" + value +
                ", left=" + left.getKey() +
                ", right=" + right.getKey() +
                '}';
    }

}
