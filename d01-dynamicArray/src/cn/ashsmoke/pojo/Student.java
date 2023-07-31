package cn.ashsmoke.pojo;

import java.util.Objects;

public class Student {
    private int age;
    private String name;

    public Student() {
    }

    public Student(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        //判断地址是否相同
        if (this == o) return true;
        //判断是否属于同一个类
        if (o == null || getClass() != o.getClass()) return false;
        //强制类型转换 进入以下代码 o必为Student类
        Student student = (Student) o;
        //判断封装的属性是否equals 类用equals 数据类型用==
        return age == student.age && Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(age, name);
    }
}
