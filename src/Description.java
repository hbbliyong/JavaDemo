import java.lang.annotation.*;

/**
 * Created by hbbliyong on 2017/6/17.
 */
@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface Description {
    /*
    成员类型是受限的，合法的类型包含原始类型以及String,Class,Annotation,Enumeration
     */
    //成员必须以没有参数，没有异常的方式声明
    String desc();
    String auth();
    int age() default 18;//可给成员指定默认值
}
