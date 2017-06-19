package my.ann;

import java.lang.annotation.*;

/**
 * Created by hbbliyong on 2017/6/18.
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface Table {
    String value();
}
