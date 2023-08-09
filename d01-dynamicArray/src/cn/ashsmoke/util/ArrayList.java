package cn.ashsmoke.util;

import java.util.Arrays;

public class ArrayList<E> {
    /**
     * 元素的数量
     */
    private int size;
    /**
     * 数组
     */
    private E[] elements;
    /**
     * 数组默认大小
     */
    private static final int DEFAULT_CAPATICY = 10;
    private static final int ELEMENT_NOT_FOUND = -1;

    /**
     * 无参构造器
     */
    public ArrayList() {
        this(DEFAULT_CAPATICY);
    }

    /**
     * 有参构造器
     *
     * @param capaticy 元素数量
     */
    public ArrayList(int capaticy) {
        capaticy = Math.max(capaticy, DEFAULT_CAPATICY);
        elements = (E[]) new Object[capaticy];
    }

    /**
     * 数据越界异常
     *
     * @param index 索引
     */
    private void outOfBounds(int index) {
        throw new IndexOutOfBoundsException("Index: " + index + ",size: " + size);
    }

    /**
     * 数据越界检查
     *
     * @param index 索引
     */
    private void rangeCheck(int index) {
        if (index < 0 || index >= size) {
            outOfBounds(index);
        }
    }

    /**
     * Add方法数据越界检查
     *
     * @param index 索引
     */
    private void rangeCheckForAdd(int index) {
        if (index < 0 || index > size) {
            outOfBounds(index);
        }
    }

    /**
     * 动态扩容
     *
     * @param capaticy size+1 询问当前操作所需空间是否满足
     */
    private void ensureCapacity(int capaticy) {
        int oldCapacity = elements.length;
        if (oldCapacity >= capaticy) return;
        //避免浮点数计算
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        E[] newElements = (E[]) new Object[newCapacity];
        //数组复制 引用 没有开辟新的地址存放array
        if (size >= 0) System.arraycopy(elements, 0, newElements, 0, size);
        elements = newElements;
        //System.out.println("kuorong"+newCapacity);
    }

    /**
     * 判断数据大小
     *
     * @return 返回size
     */
    public int size() {
        return size;
    }

    /**
     * 判断是否为空
     *
     * @return 返回true or false
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 获取指定索引处元素
     *
     * @param index 传入的索引
     * @return 返回索引对应的元素
     */
    public E get(int index) {
        rangeCheck(index);
        return elements[index];
    }

    /**
     * 在对应索引处设置元素
     *
     * @param index   索引
     * @param element 元素
     * @return 返回旧的元素
     */
    public E set(int index, E element) {
        rangeCheck(index);
        E old = elements[index];
        elements[index] = element;
        return old;
    }

    /**
     * 获取指定元素的索引
     *
     * @param element 元素
     * @return 返回索引 如果不存在返回负一
     */
    public int indexOf(E element) {
        //object null 处理
        if(element==null){
            for (int i = 0; i < size; i++) {
                if (elements[i]==null)return i;
            }
        }else {
            for (int i = 0; i < size; i++) {
                //需要重写equals
                if (element.equals(elements[i])) return i;
            }
        }
        return ELEMENT_NOT_FOUND;
    }

    /**
     * 是否包含某元素
     *
     * @param element 元素
     * @return 返回布尔表达式
     */
    public boolean contains(E element) {
        return indexOf(element) != ELEMENT_NOT_FOUND;
    }

    /**
     * 清空动态数据 只需将size置为0 屏蔽后续访问
     */
    public void clear() {
        for (int i = 0; i < size; i++) {
            //释放内存 解引用操作 数组对应的堆中对象通过垃圾回收机制自动释放内存
            elements[i] = null;
        }
        size = 0;
    }

    /**
     * 向动态数组添加元素
     *
     * @param element 元素
     */
    public void add(E element) {
        add(size, element);
    }

    public void add(int index, E element) {
        rangeCheckForAdd(index);
        ensureCapacity(size + 1);
        for (int i = size; i > index; i--) {
            elements[i] = elements[i-1];
        }
        elements[index] = element;
        size++;
    }

    /**
     * 删除元素
     *
     * @param index 索引
     * @return 返回被删除的元素值
     */
    public E remove(int index) {
        rangeCheck(index);
        for (int i = index; i < size - 1; i++) {
            elements[i] = elements[i + 1];
        }
        //释放内存
        elements[--size] = null;
        return elements[index];
    }

    /**
     * 删除指定元素
     * @param element 元素
     */
    public void remove(E element){
        remove(indexOf(element));
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("size=").append(size).append(",[");
        for (int i = 0; i < size; i++) {
            //不要加tostring 对象可能没有重写tostring方法
            stringBuilder.append(elements[i]);
            if (i != size - 1) {
                stringBuilder.append(",");
            } else {
                stringBuilder.append("]");
            }
        }
        return stringBuilder.toString();
    }
}
