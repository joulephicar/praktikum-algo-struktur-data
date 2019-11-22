/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Praktikum05;
import java.util.LinkedList;
/**
 *
 * @author joulephicar
 */


class Node {
    public Node next;
    public Object data;

    public Node(Object data, Node next) {
        this.next = next;
        this.data = data;
    }
}

public class Circular {
    public static void main(String[] args) {
        LinkedList a = new LinkedList();
        a.add("Hello");
        System.out.println(a);
    }
    private Node head = null;
    private int numberOfElements = 0;
    private Node actualElement = null;
    private int index = 0;

    /**
     *
     * @return
     */
    public boolean isEmpty() {
        return (numberOfElements == 0);
    }

    /**
     *
     * @return
     */
    public int getNumberOfElements() {
        return numberOfElements;
    }

    /**
     *
     * @param data
     */
    public void insertFirst(Object data) {
        if (!(isEmpty())) {
            index++;
        }
        Node listNode = new Node(data, head);
        head = listNode;
        numberOfElements++;
    }

    /**
     *
     * @param data
     */
    public void insertAfterActual(Object data) {
        Node listNode = new Node(data, actualElement.next);
        actualElement.next = listNode;
        numberOfElements++;
    }

    /**
     *
     * @return
     */
    public boolean deleteFirst() {
        if (isEmpty())
            return false;
        if (index > 0)
            index--;
        head = head.next;
        numberOfElements--;
        return true;
    }

    /**
     *
     * @return
     */
    public boolean deleteActualElement() {
        if (index > 0) {
            numberOfElements--;
            index--;
            Node Node = head;
            while (!Node.next.equals(actualElement))
                Node = Node.next;
            Node.next = actualElement.next;
            actualElement = Node;
            return true;
        }
        else {
            actualElement = head.next;
            index = 0;
            return deleteFirst();
        }
    }

    /**
     *
     * @return
     */
    public boolean goToNextElement() {
        if (isEmpty())
            return false;
        index = (index + 1) % numberOfElements;
        if (index == 0)
            actualElement = head;
        else
            actualElement = actualElement.next;
        return true;
    }

    /**
     *
     * @return
     */
    public Object getActualElementData() {
        return actualElement.data;
    }

    /**
     *
     * @param data
     */
    public void setActualElementData(Object data) {
        actualElement.data = data;
    }
}

