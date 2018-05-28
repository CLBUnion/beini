package com.beini.service;

public class TsetPerson {
	public static void main(String[] args) {
		Person one = new Person();
		System.out.println("输入的年龄为" + one.getAge());
	}
}

class Person {
	private int age;
	// 构造器练习 属性赋值
	public Person() {
		age = 18;
	}
	public void setAge(int a) {
		if (a > 0 & a <= 130) {
			age = a;
		} else {
			throw new RuntimeException("输入数字有误");
		}
	}
	public int getAge() {
		return age;
	}
}
