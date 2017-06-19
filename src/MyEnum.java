/**
 * Created by hbbliyong on 2017/6/15.
 */
public enum MyEnum {
    A(100,"a"),B(200,"x"),C(301,"这里显示自定义信息");

     MyEnum(Integer myKey,String myValue){
    this.key=myKey;
    this.value=myValue;
    }
    @SuppressWarnings("")
    private Integer key;
    private String value;
    public Integer getKey(){
        return key;
    }
    public String getValue(){
        return value;
    }
}
