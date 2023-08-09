package cn.ashsmoke.util;

public abstract class AbstractList<E> implements List<E> {
    protected int size;
    protected void outOfBounds(int index) {
        throw new IndexOutOfBoundsException("Index: " + index + ",size: " + size);
    }

    /**
     * 数据越界检查
     *
     * @param index 索引
     */
    protected void rangeCheck(int index) {
        if (index < 0 || index >= size) {
            outOfBounds(index);
        }
    }

    /**
     * Add方法数据越界检查
     *
     * @param index 索引
     */
    protected void rangeCheckForAdd(int index) {
        if (index < 0 || index > size) {
            outOfBounds(index);
        }
    }
    @Override
    public void add(E element){
        add(size,element);
    }
    //需要被实例化访问
    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(E element) {
        return indexOf(element) != ELEMENT_NOT_FOUND;
    }
}
