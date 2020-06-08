package com.dred.spring.web.aspectos;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class EjemploAspectos {
	
	private static final Logger LOGGER = LogManager.getLogger(EjemploAspectos.class);
	
	@Before("execution(* com.dred.spring.web.controladores.*.* (..))")
	public void mensajeInicio(JoinPoint  jointPoint) {
		 LOGGER.info("####inciando el método##### "+jointPoint.getSignature().getName()+"...");
	}
	
@After("execution(* com.dred.spring.web.controladores.*.* (..))")
public void mensajeFin(JoinPoint  jointPoint) {
		LOGGER.info("####Saliendo del método##### "+jointPoint.getSignature().getName()+"...");
}
	
	@Around("execution(* com.dred.spring.web.controladores.*.* (..))")
	public Object calculaTiempo(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		long inicio = System.currentTimeMillis();
		long tiempo;
		
		Object valor=null;
		valor = proceedingJoinPoint.proceed();
		tiempo = System.currentTimeMillis()-inicio;

		LOGGER.info("####Tiempo de ejecución: "+ tiempo +" msg #####");
		return valor;
	}

}
