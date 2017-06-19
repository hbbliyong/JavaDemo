import my.ann.Column;
import my.ann.Table;

/**
 * Created by hbbliyong on 2017/6/18.
 */
@Table("user")
public class User {
    @Column("id")
    private int id;
    @Column("name")
    private String name;
    @Column("email")
    private String email;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}
