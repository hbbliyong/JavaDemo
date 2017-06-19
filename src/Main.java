

import my.ann.Query;
import sun.security.krb5.internal.crypto.Des;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        System.out.println(MyEnum.A.getKey());
        System.out.println(MyEnum.B.getValue());
User user=new User();
user.setName("hbbliyong");
        Query<User> query=new Query<>();
       String sql= query.query(user);
        System.out.println(sql);
        test();
    }

    public static void test()  {

        try{
            //1.使用类加载器加载类
            Class c=Class.forName("Person");
            //2.类型是否存在注解
            boolean isExist=c.isAnnotationPresent(Description.class);
            if(isExist){
                //3.获取注解
                Description description=(Description)c.getAnnotation(Description.class);
                System.out.println(description.desc());
            }

            //找到方法上的注解
            Method[] methods=c.getMethods();
            for (Method m: methods){
                boolean isMExist=m.isAnnotationPresent(Description.class);
                if(isMExist){
                    //3.获取注解
                    Description description=(Description)m.getAnnotation(Description.class);
                    System.out.println(description.desc());
                }
            }
            //另外一种解析方式
            for (Method m:methods){
                Annotation[] as=m.getAnnotations();
                for (Annotation a:as){
                    if(a instanceof Description){
                        Description d=(Description)a;
                        System.out.println(d.desc());
                    }
                }
            }
        }catch (ClassNotFoundException ex){
            ex.printStackTrace();
        }
    }
}
