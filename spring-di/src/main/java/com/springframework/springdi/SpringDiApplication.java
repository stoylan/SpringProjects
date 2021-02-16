package com.springframework.springdi;

import com.springframework.springdi.controllers.ConstructorInjectedController;
import com.springframework.springdi.controllers.MyController;
import com.springframework.springdi.controllers.PropertyInjectedController;
import com.springframework.springdi.controllers.SetterInjectedController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringDiApplication {

	public static void main(String[] args) {

		ApplicationContext ctx =SpringApplication.run(SpringDiApplication.class, args);
		MyController MyController = (MyController)ctx.getBean("myController");

		String sayHello = MyController.sayHelloWorld();

		System.out.println(sayHello);

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
