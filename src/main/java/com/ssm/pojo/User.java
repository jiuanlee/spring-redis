/**
 *
 */
package com.ssm.pojo;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

/**
 * @author lijiuan
 */
//
// @Setter
// @Getter
public class User implements Serializable {

    private static final long serialVersionUID = -4260619761538644683L;

    private int id;
    private String userName;
    private String sex;
    private int age;

    public User() {
    }

    public User(int id, String userName, int age) {
        this.id = id;
        this.userName = userName;
        this.age = age;
    }

    /**
     * @return Returns the id.
     */
    public int getId() {
        return id;
    }

    /**
     * @param id The id to set.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return Returns the userName.
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param userName The userName to set.
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * @return Returns the sex.
     */
    public String getSex() {
        return sex;
    }

    /**
     * @param sex The sex to set.
     */
    public void setSex(String sex) {
        this.sex = sex;
    }

    /**
     * @return Returns the age.
     */
    public int getAge() {
        return age;
    }

    /**
     * @param age The age to set.
     */
    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", userName=" + userName + ", sex=" + sex + ", age=" + age + "]";
    }

}
