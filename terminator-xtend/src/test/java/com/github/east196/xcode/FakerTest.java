package com.github.east196.xcode;

import java.util.Locale;

import org.junit.Test;

import com.github.javafaker.Faker;

public class FakerTest {

	@Test
	public void test() {
	       Locale local = new Locale("zh","CN");
	       //创建对象
	       Faker faker = new Faker(local) ;
	       Hello hello = new Hello() ;
	       hello.setId(faker.phoneNumber().phoneNumber());
	       hello.setName(faker.name().name());
	       hello.setAddress(faker.address().streetAddress());
	       hello.setJob(faker.job().seniority());
	       System.out.println(hello.toString());
	}

}
