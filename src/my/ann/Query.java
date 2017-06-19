package my.ann;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by hbbliyong on 2017/6/18.
 */
public class Query<T> {
    public String query(T myt){

        StringBuilder sqlSb=new StringBuilder("select * from ");
        Class c=myt.getClass();
      boolean isExists=  c.isAnnotationPresent(Table.class);
      if(!isExists) {
          return null;
      }
          //取出表名
          Table table=(Table) c.getAnnotation(Table.class);
          sqlSb.append(table.value()).append(" where 1=1 ");
          //取出所有列
          Field[] fields=c.getDeclaredFields();
          for (Field f:fields){
              //取出列名
              Column column=f.getAnnotation(Column.class);
              //取出列值
              String filedName=f.getName();
              String methodName="get"+filedName.substring(0,1).toUpperCase()+filedName.substring(1);
              try {
                  Method method=c.getMethod(methodName);

                  Object object=method.invoke(myt);
                  if(object==null||(object instanceof Integer &&(Integer)object==0))
                      continue;
                  sqlSb.append(" and ").append(column.value());
                  if(object instanceof String){
                      sqlSb.append("=").append("'").append(object).append("'");
                  }else
                  {
                      sqlSb.append("=").append(object.toString());
                  }

              } catch (Exception e) {
                  e.printStackTrace();
              }
          }

    return sqlSb.toString();
    }
}
