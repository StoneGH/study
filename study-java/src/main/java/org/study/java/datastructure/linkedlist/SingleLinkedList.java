package org.study.java.datastructure.linkedlist;

/**
 * 单链表
 * Created by shitao on 2018/4/2.
 */
public class SingleLinkedList {
}

class Node {
    private int data;//存储数据
    private Node next;//存放节点

    public Node(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public void addNode(Node node) {
        Node temp = next;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = node;
    }
}
