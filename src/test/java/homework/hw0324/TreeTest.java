package homework.hw0324;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TreeTest {
    private Tree<Integer, String> tree = new Tree<>(10, "I'm root");

    @BeforeEach
    void init() {

        tree.put(7, "7");
        tree.put(15, null);
        tree.put(12, "12");
        tree.put(17, "17");
        tree.put(6, "6");
        tree.put(8, "8");
        tree.put(19, "I am max");
        tree.put(9, "9");
        tree.put(5, "I am min");
    }

    @Test
    void find() {
        Assert.assertEquals(tree.find(12).getElement(), "12");
        Assert.assertEquals(tree.find(100), null);
    }

    @Test
    void put() {
        tree.printTree();
        tree.put(16, "I am new element");
        System.out.println("-----------------");
        tree.printTree();
    }

    @Test
    void remove() {
        Assert.assertEquals(tree.find(9).getElement(), "9");
        tree.remove(9);
        Assert.assertEquals(tree.find(9), null);
    }

    @Test
    void getMin() {
        Assert.assertEquals(tree.getMin().getElement(), "I am min");
    }

    @Test
    void getMax() {
        Assert.assertEquals(tree.getMax().getElement(), "I am max");
    }
}