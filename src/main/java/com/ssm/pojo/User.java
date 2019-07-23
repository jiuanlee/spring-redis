/**
 * 
 */
package com.ssm.pojo;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

/**
 * @author lijiuan
 *
 */

@Setter
@Getter
public class User implements Serializable {
	private static final long serialVersionUID = -4260619761538644683L;

	private int id;
	private String userName;
	private String sex;
	private int age;

	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", sex=" + sex
				+ ", age=" + age + "]";
	}

}
