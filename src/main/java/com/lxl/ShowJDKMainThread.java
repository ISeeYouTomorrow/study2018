package com.lxl;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

/**
 * jdk主函数线程背景
 * @author lxl lukas
 * @description
 * @create 2018/4/17
 *  6:Monitor Ctrl-Break 监听中断信号线程
    5:Attach Listener 获取内存 dump线程
    4:Signal Dispatcher 信号分发给jvm线程
    3:Finalizer 执行对象的finalize方法线程
    2:Reference Handler 清除引用的线程
 */
public class ShowJDKMainThread {

    public static void main(String[] args) {

        ThreadMXBean bean = ManagementFactory.getThreadMXBean();
        ThreadInfo[] threads =  bean.dumpAllThreads(false,false);
        for (ThreadInfo threadInfo:threads
             ) {
            System.out.println(threadInfo.getThreadId()+":"+threadInfo.getThreadName());
        }
    }
}
