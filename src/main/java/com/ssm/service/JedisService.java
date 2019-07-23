/**
 * 
 */
package com.ssm.service;

/**
 * @author jal
 *
 */
public interface JedisService {
	
	String set(String key,String value);
	
	String get(String key);
	
	long hset(String key,String item,String value);
	
	String hget(String key,String field);

}
