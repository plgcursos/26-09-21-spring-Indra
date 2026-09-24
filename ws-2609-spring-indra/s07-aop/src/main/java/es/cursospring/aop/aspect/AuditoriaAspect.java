package es.cursospring.aop.aspect;


import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AuditoriaAspect {

	@Pointcut("execution(* es.cursospring.aop.service.PedidoService.cancelarPedido(..))")
	public void cancelarPointCut() {}
	
	@Pointcut("within(es.cursospring.aop.service.PedidoService)")
	public void todosPointCut() {}
	
	
	@Before("execution(* es.cursospring.aop.service.PedidoService.crearPedido(..)) ||"
			+ "execution(* es.cursospring.aop.service.PedidoService.cancelarPedido(..))")
	public void antesDeEjecutar() {
		System.err.println("[Interceptor - BEFORE]");
		System.err.println("------------------------");
	}
	
	@Before("cancelarPointCut()")
	public void antesDeEjecutar(JoinPoint jp) {
		System.err.println("[Interceptor - BEFORE - con JoinPoint]");
		System.err.println("Metodo interceptado " + jp.getSignature().getName());
		System.err.println("Argumentos: " + Arrays.asList(jp.getArgs()));
		System.err.println("------------------------");
	}
	
	@After("todosPointCut()")
	public void despuesDeEjecutar() {
		System.err.println("[Interceptor - AFTER]");
		System.err.println("------------------------");
	}
	
	@AfterReturning(pointcut = "todosPointCut()", returning = "resu")
	public void despuesConExito(JoinPoint jp, Object resu) {
		System.err.println("[Interceptor - AFTER RETURNING]");
		System.err.println("Metodo interceptado " + jp.getSignature().getName());
		System.err.println("Valor de retorno " + resu);
		System.err.println("------------------------");
	}
	
	@AfterThrowing(pointcut = "todosPointCut()", throwing = "exc")
	public void despuesConFallo(Exception exc) {
		System.err.println("[Interceptor - AFTER THROWING]");
		System.err.println("Mensaje de la excepcion " + exc.getMessage());
		System.err.println("------------------------");
	}
	
	@Around("todosPointCut()")
	public Object medirTiempo(ProceedingJoinPoint pjp) {
		Object resu = null;
		long t0 = System.currentTimeMillis();
		try {
			resu = pjp.proceed(pjp.getArgs());
		} catch (Throwable e) {
			e.printStackTrace();
		}
		long tf = System.currentTimeMillis();
		
		System.err.println("[Interceptor - AROUND]");
		System.err.println(pjp.getSignature().getName() + " demoro " + (tf-t0) + " ms.");
		System.err.println("------------------------");
		
		return resu;
	}
	
//	@Around("todosPointCut()")
	public Object malvado(ProceedingJoinPoint pjp) {
		Object resu = null;
		
		Object[] args = pjp.getArgs();
		String arg = args[0].toString();
		args[0] = "666";
		
		if (arg.length() < 5) {
			try {
				resu = pjp.proceed(args);
			} catch (Throwable e) {
				e.printStackTrace();
			}
		} else {
			System.err.println("El metodo " + pjp.getSignature().getName() + " no se ha llamado.");
		}
		
		return resu + " ademas agrego esto!";
	}
	
	@Before("@annotation(es.cursospring.aop.aspect.MiLog)")
	public void otroBefore() {
		System.err.println("[Interceptor - BEFORE ANOTACIONES]");
		System.err.println("------------------------");
	}

}
