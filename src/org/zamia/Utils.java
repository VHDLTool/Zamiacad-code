package org.zamia;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import org.zamia.instgraph.IGObject;
import org.zamia.util.ZdbList;
import org.zamia.zdb.ZDB;

public class Utils {
		
	public static <T> T removeLast(List<T> list) {
		int i = list.size()-1;
		T res = list.get(i);
		list.remove(i);
		return res;
	}
	public static String concatenate(Object[] collection) {
		return concatenate(Arrays.asList(collection), ",");
	}
	
	public static String concatenate(Object[] collection, String separator) {
		return concatenate(Arrays.asList(collection), separator);
	}
	
	public static String concatenate(Object[] collection, String separator, boolean... keepLastDot) {
		return concatenate(Arrays.asList(collection), separator, keepLastDot);
	}
	
	public static String concatenate(Collection c) {
		return concatenate(c, ",");
	}
	public static String concatenate(Collection c, String separator, boolean... keepLastDot) {
		StringBuffer sb = new StringBuffer();
		for (Object o: c)
			sb.append(o.toString()).append(separator);
				
		if (!c.isEmpty() && keepLastDot.length == 0) // remove extra separator at the end
			sb.setLength(sb.length() - separator.length()); 
				
		return sb.toString();
	}

	public static <T> ArrayList<T> createArrayList(Iterable<T> items, int size) {
		ArrayList<T> al = new ArrayList<>(size);
		for (T item : items) {
			al.add(item);
		}
		return al;
	}
	public static int getEnvInt(String name, int deflt) {
		try {
			String sVal = System.getenv(name);
			if (sVal != null) 
				return Integer.parseInt(sVal); 
		} catch (NumberFormatException ne) {
			ExceptionLogger.getInstance().logException(ne);
		}
		return deflt; 
	}

	public static boolean getEnvBool(String name, boolean deflt) {
		String override = System.getenv(name);
		if (override != null) {
			override = override.toLowerCase();
			if (override.equals("yes") || override.equals("1") || override.equals("true") || override.startsWith("enable")) 
				return true;
			if (override.equals("no") || override.equals("0") || override.equals("false") || override.startsWith("disable"))
				return false;
		}
		return deflt;
	}
	
	public static class StatCounter extends HashMap<String, Long> {
		public void inc(String clsName, long l) {
			Long cnt = get(clsName);
			cnt = (cnt != null ? cnt : 0) + l;
			put(clsName, cnt);
		}
		public void inc(String clsName) {
			inc(clsName, 1);
		}
		
	}

	public static String formatTime(BigInteger femto) {
		if (femto.equals(BigInteger.ZERO))
			return "0";
		StringBuilder time = new StringBuilder(femto.toString());
		String[] units = {"fs", "ps", "ns", "us", "ms", "sec", "ksec", "Msec"};
		for (String unit: units) {
			if (time.length() <=3 || !time.toString().endsWith("000"))
				return time + " " + unit;
			time.setLength(time.length() - 3);
		}
		return time + " " + units[units.length-1];
	}
}

