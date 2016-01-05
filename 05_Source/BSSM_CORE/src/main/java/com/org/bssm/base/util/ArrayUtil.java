package com.org.bssm.base.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈功能详细描述〉
 *
 * @author x-wang
 */
public class ArrayUtil {

	
	/**
	 * 功能描述: <br>
	 * 取两个数组的并集
	 *
	 * @param a  数组a
	 * @param b 数组b
	 * @return c 数组并集 A∪B
	 */
	public static <T>T[] Union(T[] a,T[] b){
		if(a==null){
			if(b==null){
				//ab均为空
				return null;
			}
			//a为空
			return b.clone();
		}else{
			if(b==null){
				//b为空
				return a.clone();
			}
			//均不为空
			T[] c = Arrays.copyOf(a, a.length + b.length);
			System.arraycopy(b, 0, c, a.length, b.length);
			return c;
		}
	}
	

	/**
	 * 功能描述: <br>
	 * 取两个列表的并集
	 *
	 * @param a  列表a
	 * @param b 列表b
	 * @return c 列表并集 A∪B
	 */
	public static <T>List<T> Union(List<T> a,List<T> b){
		if(a==null){
			if(b==null){
				//ab均为空
				return null;
			}
			//a为空
			return b;
		}else{
			if(b==null){
				//b为空
				return a;
			}
			//均不为空
			List<T> c = new ArrayList<T>();
				c.addAll(a);
				c.addAll(b);
			return c;
		}
	}
	
	/**
	 * 功能描述: <br>
	 *判断列表是否为null或空
	 *
	 * @param src  源列表
	 * @return boolean 是否
	 */
	public static <T> boolean  isNullorEmpty(List<T>src){
		if(src!=null&&!src.isEmpty()){
			return false;
		}
		return true;
	}
	
	
	/**
	 * 功能描述: <br>
	 * 取两个简单列表的交集
	 *
	 * @param a  列表a
	 * @param b 列表b
	 * @return c 列表交集 A∩B
	 */
	public static <T> List<T> Mix(List<T> a,List<T> b){
		if(isNullorEmpty(a)||isNullorEmpty(b)){
			return null;
		}
		List<T> c=new ArrayList<T>();
		for(T at:a){
			for(T bt:b){
				if(at.equals(bt)){
					c.add(at);
				}
			}
		}
		return c;
	}
	
	
	/**
	 * 功能描述: <br>
	 * 取两个简单列表的差集
	 * @param <E>
	 *
	 * @param a  列表a
	 * @param b 列表b
	 * @return c 列表交集 A-B
	 */
	public static <T> List<T> Diff(List<T> a,List<T> b){
		if(a==null){
			return null;
		}		
		if(isNullorEmpty(b)){
			return a;
		}
		List<T> c=new ArrayList<T>();
		c.addAll(a);
		for(T at:a){
			for(T bt:b){
				if(at.equals(bt)){
					c.remove(at);
				}
			}
		}
		return c;
	}
}
