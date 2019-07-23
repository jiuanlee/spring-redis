/**
 * 
 */
package com.ssm.framework.redismsg;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

/**
 * @author jal
 *
 */

public class Message implements Serializable {
	private static final long serialVersionUID = 5666074806146177601L;
	@Setter
	private int id;
	@Getter
	private String content;

}
