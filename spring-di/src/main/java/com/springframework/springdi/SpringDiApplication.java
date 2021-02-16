package com.springframework.springdi;

import com.springframework.springdi.controllers.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringDiApplication {

	public static void main(String[] args) {

		ApplicationContext ctx =SpringApplication.run(SpringDiApplication.class, args);

		I18nController i18nController = (I18nController) ctx.getBean("i18nController");

		System.out.println(i18nController.getGreeting());

		MyController MyController = (MyController)ctx.getBean("myController");

		System.out.println(MyController.sayHelloWorld());

		System.out.println("-----------Property Injected");

		PropertyInjectedController propertyInjectedController = (PropertyInjectedController) ctx.getBean("propertyInjectedController");

		System.out.println(propertyInjectedController.getGreeting());

		System.out.println("-----------Setter Injected");

		SetterInjectedController setterInjectedController = (SetterInjectedController) ctx.getBean("setterInjectedController");

		System.out.println(setterInjectedController.getGreeting());

		System.out.println("-----------Constructor Injected");

		ConstructorInjectedController constructorInjectedController = (ConstructorInjectedController) ctx.getBean("constructorInjectedController");

		System.out.println(constructorInjectedController.getGreeting());


	}

}
