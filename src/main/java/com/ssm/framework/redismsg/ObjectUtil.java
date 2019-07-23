/**
 * 
 */
package com.ssm.framework.redismsg;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * @author jal
 *
 */
public class ObjectUtil {
	/**
	 * 
	 * @param obj
	 * @return
	 * @throws IOException
	 */
	public static byte[] object2Bytes(Object obj) throws IOException {
		try (ByteArrayOutputStream bo = new ByteArrayOutputStream();
				ObjectOutputStream oo = new ObjectOutputStream(bo)) {
			oo.writeObject(obj);
			return bo.toByteArray();
		}
	}

	public static Object bytes2Object(byte[] bytes) throws Exception {
		try (ByteArrayInputStream in = new ByteArrayInputStream(bytes);
				ObjectInputStream sIn = new ObjectInputStream(in)) {
			return sIn.readObject();
		}

	}

}
