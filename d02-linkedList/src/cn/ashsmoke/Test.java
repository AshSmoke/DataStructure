package cn.ashsmoke;

import cn.ashsmoke.util.LinkedList;
import cn.ashsmoke.util.List;

import static cn.ashsmoke.util.List.ELEMENT_NOT_FOUND;

public class Test {
    public static void main(String[] args) {
        LinkedList<String> list=new LinkedList<>();
        //AbstractList中的protected成员不能被访问
        int elementNotFound = ELEMENT_NOT_FOUND;
        list.add("Sda");
        list.add("qwer");
        list.add("sadgf");
        System.out.println(list.toString());
    }
}
