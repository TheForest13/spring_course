package aop.aspects;

import aop.Book;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;


@Component
@Aspect
@Order(10)
public class LoggingAspect {
//    static int i = 1;
//    static int j = 1;
//    static int p = 1;

//    @Pointcut("execution(* aop.UniLibrary.*(..))")
//    private void allMethodsFromUniLibrary(){}
//
//    @Pointcut("execution(public void aop.UniLibrary.returnMagazine())")
//    private void returnMagazineFromUniLibrary(){}
//
//    @Pointcut("allMethodsFromUniLibrary() && !returnMagazineFromUniLibrary()")
//    private void allMethodExceptReturnMagazineFromUniLibrary(){}
//
//
//    @Before("allMethodExceptReturnMagazineFromUniLibrary()")
//    public void beforeAllMethodsExceptReturnMagazineAdvice(){
//        System.out.println("beforeAllMethodsExceptReturnMagazineAdvice: Log #10");
//    }


//    @Pointcut("execution(* aop.UniLibrary.get*())")
//    private void allGetMethodsUniLibrary(){}
//
//    @Pointcut("execution(* aop.UniLibrary.return*())")
//    private void allReturnMethodsUniLibrary(){}
//
//    @Pointcut("allGetMethodsUniLibrary() || allReturnMethodsUniLibrary()")
//    public void allGetAndReturnMethodsUniLibrary(){}
//
//
//    @Before("allGetMethodsUniLibrary()")
//    public void beforeGetLoggingAdvice(){
//        System.out.println("beforeGetLoggingAdvice: writing Log #1 №" + i);
//        i++;
//    }
//
//    @Before("allReturnMethodsUniLibrary()")
//    public void beforeReturnLoggingAdvice(){
//        System.out.println("beforeReturnLoggingAdvice: writing Log #2 №" + j);
//        j++;
//    }
//
//    @Before("allGetAndReturnMethodsUniLibrary()")
//    public void beforeGetAndReturnLoggingAdvice(){
//        System.out.println("beforeGetAndReturnLoggingAdvice: writing Log #3 №" + p);
//        p++;
//    }


//    @Pointcut("execution(* get*())")
//    private void allGetMethods() {}

    @Before("aop.aspects.MyPointcuts.allAddMethods()")
    public void beforeAddLoggingAdvice(JoinPoint joinPoint) {

        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        System.out.println("methodSignature = " + methodSignature);
        System.out.println("methodSignature.getMethod() = " +
                methodSignature.getMethod());
        System.out.println("methodSignature.getReturnType() = " +
                methodSignature.getReturnType());
        System.out.println("methodSignature.getName() = " +
                methodSignature.getName());

        if (methodSignature.getName().equals("addBook")) {
            Object[] arguments = joinPoint.getArgs();

            for (Object obj : arguments) {
                if (obj instanceof Book) {
                    Book myBook = (Book) obj;
                    System.out.println("Информация о книге: название книги - "
                            + myBook.getName() + "\nавтор - " + myBook.getAuthor() +
                            "\nгод издания - " + myBook.getYearPublication());
                } else if (obj instanceof String){
                    System.out.println("Книгу в библиотеку добавляет - " + obj);
                }
            }
        }

        System.out.println("beforeAddLoggingAdvice: логирование " +
                "попытки получить книгу/журнал");
        System.out.println("___________________________________________________________");

    }
}