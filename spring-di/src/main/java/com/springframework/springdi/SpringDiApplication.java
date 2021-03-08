package com.springframework.springdi;

import com.springframework.springdi.controllers.*;
import com.springframework.springdi.examplebeans.FakeDataSources;
import com.springframework.springdi.examplebeans.FakeJmsBroker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
//@ComponentScan(basePackages = {"com.springframework.springdi.controllers","com.springframework.springdi.services"})
public class SpringDiApplication {

	public static void main(String[] args) {

		ApplicationContext ctx = SpringApplication.run(SpringDiApplication.class, args);

		MyController controller = (MyController) ctx.getBean("myController");

		FakeDataSources fakeDataSources = (FakeDataSources) ctx.getBean("fakeDataSources");
		System.out.println(fakeDataSources.getUser());

		FakeJmsBroker fakeJmsBroker = (FakeJmsBroker) ctx.getBean(FakeJmsBroker.class);
		System.out.println(fakeJmsBroker.getUsername());

		/*System.out.println(controller.hello());


		System.out.println(ctx.getBean(PropertyInjectedController.class).sayHello());
		System.out.println(ctx.getBean(GetterInjectedController.class).getGreeting());
		System.out.println(ctx.getBean(ConstructorInjectedController.class).getGreeting());*/

	}

}
