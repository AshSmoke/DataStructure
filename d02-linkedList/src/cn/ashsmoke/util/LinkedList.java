package cn.ashsmoke.util;

import java.util.Objects;

/**
 * @author ashsmoke
 * @param <E>
 */
public class LinkedList<E> extends AbstractList<E>{
    private ListNode<E> firstNode;
    private static class ListNode<E>{
        E element;
        ListNode<E> next;

        public ListNode() {
        }

        public ListNode(E element, ListNode<E> next) {
            this.element = element;
            this.next = next;
        }

        public E getElement() {
            return element;
        }

        public void setElement(E element) {
            this.element = element;
        }

        public ListNode<E> getNext() {
            return next;
        }

        public void setNext(ListNode<E> next) {
            this.next = next;
        }
    }

    @Override
    public void clear() {
        size=0;
        firstNode=null;
    }

    @Override
    public void add(int index, E element) {
        if(index==0){
            firstNode=new ListNode<>(element,firstNode);
        }else {
            ListNode<E> pre = node(index - 1);
            pre.next=new ListNode<>(element,pre.next);
        }
        size++;
    }
    @Override
    public E get(int index) {
        return node(index).element;
    }

    @Override
    public E set(int index, E element) {
        ListNode<E> node = node(index);
        E old= node.element;
        node.element=element;
        return old;
    }

    @Override
    public E remove(int index) {
        ListNode<E> old=firstNode;
        if(index==0){
            firstNode=firstNode.next;
        }else {
            ListNode<E> pre = node(index - 1);
            old = pre.next;
            pre.next=pre.next.next;
        }
        size--;
        return old.element;
    }

    @Override
    public int indexOf(E element) {
        if(firstNode==null){
            return ELEMENT_NOT_FOUND;
        }else {
            ListNode<E> temp=firstNode;
            for (int i = 0; i < size; i++) {
                if(element.equals(temp.element)){
                    return i;
                }
                temp=temp.next;
            }
            return ELEMENT_NOT_FOUND;
        }
    }
    private ListNode<E> node(int index){
        rangeCheck(index);
        ListNode<E> temp=firstNode;
        for (int i = 0; i < index; i++) {
            temp=temp.next;
        }
        return temp;
    }

    @Override
    public String toString() {
        StringBuilder sb=new StringBuilder();
        ListNode<E> temp = firstNode;
        sb.append("LinkedList:{");
        while (Objects.nonNull(temp)){
            sb.append(temp.element+",");
            temp=temp.next;
        }
        sb.append("}");
        return sb.toString();
    }
}
