package user.entity;

public class User {

    private String username;
    private String userpass;
    private String name;
    private String sex;
    private String age;

    public User() {
    }

    public User(String username, String userpass, String name, String sex, String age) {
        this.username = username;
        this.userpass = userpass;
        this.name = name;
        this.sex = sex;
        this.age = age;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserpass() {
        return userpass;
    }

    public void setUserpass(String userpass) {
        this.userpass = userpass;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}