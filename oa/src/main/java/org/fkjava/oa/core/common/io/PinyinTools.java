package org.fkjava.oa.core.common.io;

import java.util.Arrays;

import net.sourceforge.pinyin4j.PinyinHelper;

/**
 * 拼音工具类
 */
public final class PinyinTools {
	
	/**
	 * 汉字转拼音的工具方法
	 * @param str 原文
	 * @return 拼音
	 */
	public static String getPinyin(String str){
		String res = "";
		for (int i = 0; i < str.length(); i++){
			char temp = str.charAt(i);
			String[] arrays = PinyinHelper.toHanyuPinyinStringArray(temp);
			System.out.println(Arrays.toString(arrays));
			res += arrays[0];
		}
		return res.replaceAll("\\d+", "");
	}
	
	public static void main(String[] args) {
		System.out.println(getPinyin("李刚"));
		System.out.println(Integer.toHexString('李'));
		System.out.println("\u674e");
	}
}