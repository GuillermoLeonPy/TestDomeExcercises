package com.testdome.excercises.spring.aop.logger;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggerAOP {

	@Autowired
	private Logger logger;

	@Before("@annotation(LogExecution)")
	public void loggingAdvice(JoinPoint jp) {
		boolean isPublic = java.lang.reflect.Modifier.isPublic(jp.getSignature().getModifiers());
		if(isPublic) {
			String methodName = jp.getSignature().getName();
			logger.log(methodName);	
		}		
	}
}

@Component
class NameRepository {
	@LogExecution
	public List<String> getNames() {
		List<String> names = new ArrayList<>();
		names.add("John");
		names.add("Mary");
		return names;
	}
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface LogExecution {
}

interface Logger {
	public void log(String data);
}

@Configuration
@EnableAspectJAutoProxy
@Import({ LoggerAOP.class, NameRepository.class })
class Config {
	@Bean
	public Logger logger() {
		return (message) -> System.out.println(message);
	}
}
