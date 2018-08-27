package org.fkjava.oa.core.common.security;

import java.security.MessageDigest;

/**
 * MD5加密工具类
 */
public final class MD5 {

	/**
	 * MD5加密方法
	 */
	public static String getMD5(String passWord) throws Exception {
		// 创建MD5加密对象
		MessageDigest md = MessageDigest.getInstance("MD5");
		// 加密处理
		md.update(passWord.getBytes());
		// 获取加密后的16位字节数组
		byte[] md5Bytes = md.digest();
//		System.out.println("加密前:" + Arrays.toString(passWord.getBytes()));
//		System.out.println("加密后:" + Arrays.toString(md5Bytes));
		String res = "";
		// 将16字节数组转换为32位的字符串，将一个字节转换成16进制的两位,0XFF 255
		for (int i = 0; i < md5Bytes.length; i++) {
			int temp =  md5Bytes[i] & 0XFF;
			// 转换成16进制不够两位，前面补0
			if (temp <= 0XF) {
				res += "0";
			}
			res += Integer.toHexString(temp);
		}
		
		return res;
	}
	
	public static void main(String[] args) {
		try {
			getMD5("123456");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
