package com.fh.util;

import java.security.MessageDigest;

/**
 * 
 * <pre>项目名称：yao-movie-admin    
 * 类名称：Md5Util    
 * 类描述：    md5加密工具类
 * 创建人：姚展博 yao_zb@163.com  
 * 创建时间：2018年3月30日 下午5:48:03    
 * 修改人：姚展博 yao_zb@163.com   
 * 修改时间：2018年3月30日 下午5:48:03    
 * 修改备注：       
 * @version </pre>
 */
public class Md5Util {
	public final static String md5(String s){
		char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
		try {
			byte[] strTemp = s.getBytes();
			// 使用MD5创建MessageDigest对象
			MessageDigest mdTemp = MessageDigest.getInstance("MD5");
			mdTemp.update(strTemp);
			byte[] md = mdTemp.digest();
			int j = md.length;
			char str[] = new char[j * 2];
			int k = 0;
			for (int i = 0; i < j; i++) {
				byte b = md[i];
				// 将没个数(int)b进行双字节加密
				str[k++] = hexDigits[b >> 4 & 0xf];
				str[k++] = hexDigits[b & 0xf];
			}
			return new String(str);
		} catch (Exception e) {
			return null;
		}
	}

	public static String sign(String text,String secret){
		return md5(text+secret);
	}
}
