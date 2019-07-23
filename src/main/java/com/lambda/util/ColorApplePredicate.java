/**
 * 
 */
package com.lambda.util;

/**
 * @author Administrator
 *
 */
public class ColorApplePredicate implements ApplePredicate {

	@Override
	public boolean test(Apple apple) {
		return "green".equals(apple.getColor());
	}

}
