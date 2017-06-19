package my.ann;

import java.lang.annotation.*;

@Target( {ElementType.METHOD,ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface Column{
    String value();
}
