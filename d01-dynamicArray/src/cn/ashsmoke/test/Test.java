package cn.ashsmoke.test;

import cn.ashsmoke.pojo.Student;
import cn.ashsmoke.util.ArrayList;

import java.util.Objects;

public class Test {
    public static void main(String[] args) {
//        ArrayList array=new ArrayList();
//        array.add(99);
//        array.add(88);
//        array.add(77);
//        array.add(66);
//        array.add(55);
//        array.add(44);
//        array.remove(0);
//        array.add(1,100);
//        System.out.println(array.size());
//        System.out.println(array.toString());
        //创建对象数组
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student(22, "asdf"));
        students.add(new Student(12, "qwer"));
        students.add(new Student(45, "hjk"));
        students.add(new Student());
        students.add(null);
        students.add(new Student(33, "ytuoi"));
        students.remove(0);
        students.add(1, new Student(21, "AshSmoke"));
        System.out.println(students);
        System.out.println(students.indexOf(null));
        System.out.println(students.indexOf(new Student()));
    }
}
