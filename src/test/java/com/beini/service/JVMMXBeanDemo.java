package com.beini.service;

import java.lang.management.CompilationMXBean;
import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.MemoryPoolMXBean;
import java.lang.management.MemoryUsage;
import java.lang.management.OperatingSystemMXBean;
import java.lang.management.RuntimeMXBean;
import java.lang.management.ThreadMXBean;
import java.util.List;

public class JVMMXBeanDemo {
    /**
     * @param args
     */
    public static void main(String[] args) {
        //==========================Memory=========================
        System.out.println("==========================Memory=========================");
        MemoryMXBean memoryMBean = ManagementFactory.getMemoryMXBean();   
        MemoryUsage usage = memoryMBean.getHeapMemoryUsage();   
        System.out.println("初始化 Heap: " + (usage.getInit()/1024/1024) + "mb");   
        System.out.println("最大Heap: " + (usage.getMax()/1024/1024) + "mb");   
        System.out.println("已经使用Heap: " + (usage.getUsed()/1024/1024) + "mb");   
        System.out.println("Heap Memory Usage: " + memoryMBean.getHeapMemoryUsage());   
        System.out.println("Non-Heap Memory Usage: " + memoryMBean.getNonHeapMemoryUsage());   
        //==========================Runtime=========================
        System.out.println("==========================Runtime=========================");
        RuntimeMXBean runtimeMBean = ManagementFactory.getRuntimeMXBean();
        System.out.println("JVM name : " + runtimeMBean.getVmName());
        System.out.println("lib path : " + runtimeMBean.getLibraryPath());
        System.out.println("class path : " + runtimeMBean.getClassPath());
        System.out.println("getVmVersion() " + runtimeMBean.getVmVersion());  
        //java options
        List<String> argList = runtimeMBean.getInputArguments();
        for(String arg : argList){
            System.out.println("arg : " + arg);
        }
        //==========================OperatingSystem=========================
        System.out.println("==========================OperatingSystem=========================");
        OperatingSystemMXBean osMBean = (OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();  
        //获取操作系统相关信息  
        System.out.println("getName() "+ osMBean.getName()); 
        System.out.println("getVersion() " + osMBean.getVersion()); 
        System.out.println("getArch() "+osMBean.getArch());  
        System.out.println("getAvailableProcessors() " + osMBean.getAvailableProcessors());  
        //==========================Thread=========================
        System.out.println("==========================Thread=========================");
        //获取各个线程的各种状态，CPU 占用情况，以及整个系统中的线程状况  
        ThreadMXBean threadMBean=(ThreadMXBean)ManagementFactory.getThreadMXBean();  
        System.out.println("getThreadCount() " + threadMBean.getThreadCount());  
        System.out.println("getPeakThreadCount() " + threadMBean.getPeakThreadCount());  
        System.out.println("getCurrentThreadCpuTime() " + threadMBean.getCurrentThreadCpuTime());  
        System.out.println("getDaemonThreadCount() " + threadMBean.getDaemonThreadCount());  
        System.out.println("getCurrentThreadUserTime() "+ threadMBean.getCurrentThreadUserTime());  
        //==========================Compilation=========================
        System.out.println("==========================Compilation=========================");
        CompilationMXBean compilMBean=(CompilationMXBean)ManagementFactory.getCompilationMXBean();   
        System.out.println("getName() " + compilMBean.getName());  
        System.out.println("getTotalCompilationTime() " + compilMBean.getTotalCompilationTime());  
        //==========================MemoryPool=========================
        System.out.println("==========================MemoryPool=========================");
        //获取多个内存池的使用情况  
        List<MemoryPoolMXBean> mpMBeanList= ManagementFactory.getMemoryPoolMXBeans();  
        for(MemoryPoolMXBean mpMBean : mpMBeanList){  
            System.out.println("getUsage() " + mpMBean.getUsage());  
            System.out.println("getMemoryManagerNames() "+ mpMBean.getMemoryManagerNames().toString());  
        } 
        //==========================GarbageCollector=========================
        System.out.println("==========================GarbageCollector=========================");
        //获取GC的次数以及花费时间之类的信息  
        List<GarbageCollectorMXBean> gcMBeanList=ManagementFactory.getGarbageCollectorMXBeans();  
        for(GarbageCollectorMXBean gcMBean : gcMBeanList){  
            System.out.println("getName() " + gcMBean.getName());  
            System.out.println("getMemoryPoolNames() "+ gcMBean.getMemoryPoolNames());  
        } 
        //==========================Other=========================
        System.out.println("==========================Other=========================");
        //Java 虚拟机中的内存总量,以字节为单位  
        int total = (int)Runtime.getRuntime().totalMemory()/1024/1024;
        System.out.println("内存总量 ：" + total + "mb");  
        int free = (int)Runtime.getRuntime().freeMemory()/1024/1024; 
        System.out.println("空闲内存量 ： " + free + "mb");  
        int max = (int) (Runtime.getRuntime().maxMemory() /1024 / 1024); 
        System.out.println("最大内存量 ： "  + max + "mb");  

    }
}