package base;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

import java.util.Arrays;
import java.util.Date;

/**
 * Created by Fred on 17/02/2015.
 */

@Aspect
public class MesAspects {

    @Before("execution(* base.ClientDao.*(..))")
    public void logBefore(JoinPoint joinPoint) {
        System.out.print("+++ log : "+new Date());
        System.out.print(" appel de " + joinPoint.getSignature().getName());
        System.out.println(" +++");
    }
    @AfterReturning(pointcut="execution(* base.ClientDao.addClientReturnValue(..))",returning="result")
    public void logAfterReturning(JoinPoint joinPoint, Object result) {
        System.out.print("+++ log :");
        System.out.print(" retour de " + joinPoint.getSignature().getName());
        System.out.print(" avec la valeur : " + result);
        System.out.println(" +++");
    }
    @Around("execution(* base.ClientDao.addClientAround(..))")
    public void logAround(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.print("+++ log arround : ");
        System.out.print("interception de : " + joinPoint.getSignature().getName());
        System.out.println(" avec les args : " + Arrays.toString(joinPoint.getArgs())+ " +++");
        System.out.println("   +++ appel");
        joinPoint.proceed();
        System.out.println("   +++ retour");
    }

    @AfterThrowing(pointcut="execution(* base.ClientDao.addClientThrowException(..))", throwing = "t")
    public void logException(JoinPoint joinPoint, Throwable t) {
        System.err.println("+++ log Exception levee par "+joinPoint.getSourceLocation()+".  l'Exception est : "+t+" +++");
    }



//    @Around("execution(* base.ClientDao.addClientAround(..))")
//    public void logAround(ProceedingJoinPoint joinPoint) throws Throwable {
//        System.out.print("+++ log arround : ");
//        System.out.print("interception de : " + joinPoint.getSignature().getName());
//        System.out.println(" avec les args : " + Arrays.toString(joinPoint.getArgs())+ " +++");
//        System.out.println("   ++ Appel");
//        joinPoint.proceed(); // lance la vraie
//        System.out.println("   ++ Retour");
//    }


}
