/**
 * 
 */
package com.lambda.util;

import java.io.Serializable;
import java.math.BigDecimal;

/**苹果实体类
 * @author jal
 *
 */
public class Apple implements Serializable{
 	private static final long serialVersionUID = -2251468697043353655L;
	private String color;
	private BigDecimal weight;
	
	public Apple(String color,BigDecimal weight){
		this.color = color;
		this.weight = weight;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public BigDecimal getWeight() {
		return weight;
	}

	public void setWeight(BigDecimal weight) {
		this.weight = weight;
	}
	
	@Override
	public String toString(){
		return "color:"+this.getColor()+" weight:"+this.getWeight();
	}

}
