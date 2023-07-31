package cn.ashsmoke.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class TimeUtil {
    private static final SimpleDateFormat SIMPLE_DATE_FORMAT=new SimpleDateFormat("HH:mm:ss.SSS");
    public interface Task{
        void execute();
    }
    public static void check(String title,Task task){
        if(Objects.isNull(task)) return;
        title=Objects.isNull(title)?"":"["+title+"]";
        System.out.println(title);
        System.out.println("开始时间："+SIMPLE_DATE_FORMAT.format(new Date()));
        long begin = System.currentTimeMillis();
        task.execute();
        long end = System.currentTimeMillis();
        System.out.println("结束时间"+SIMPLE_DATE_FORMAT.format(new Date()));
        long delta=(end-begin);
        System.out.println("执行任务耗时："+delta+"毫秒");
        System.out.println("======================================");
    }
}
