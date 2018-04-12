package com.beini.util;
/**
 * 检测当前项目使用的内存情况
 * @author lb_chen
 *
 */
public class TestMemory {
	public static void main(String[] args) {
		System.out.println(" 内存信息 :" + toMemoryInfo());
	}
	/**
	 * 获取当前 jvm 的内存信息
	 * @return
	 */
	public static String toMemoryInfo() {
		Runtime currRuntime = Runtime.getRuntime();
		int nFreeMemory = (int) (currRuntime.freeMemory() / 1024 / 1024);
		int nTotalMemory = (int) (currRuntime.totalMemory() / 1024 / 1024);
		return nFreeMemory + "M/" + nTotalMemory + "M(free/total)";
	}
}
