package com.testdome.excercises.weather.forecast.service.application;



import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.event.ApplicationContextEvent;

import com.testdome.excercises.weather.forecast.service.config.Config;

public class Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Runnable app = new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
				context.addApplicationListener(new ApplicationListener<ApplicationContextEvent>() {

					@Override
					public void onApplicationEvent(ApplicationContextEvent event) {
						// TODO Auto-generated method stub
						System.out.println("application lister: " + event.toString());
					}
					
				});
				context.register(Config.class);
				context.refresh();
				System.out.println("running...");

			}
		};
		Thread thread = new Thread(app);
		thread.start();		
	}

}
