package test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class MapTest {
	public static void main(String[] args){
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("first", 1);
		map.put("second", 2);
		map.put("three", 3);
		// map中再次存入同一key时 将替换key的value
		map.put("first", 4);
		String key;
		Integer value;
		// 返回map集合的全部key组成的集合
		Set<String> keySet = map.keySet();
		Iterator<String> i = keySet.iterator();
		while(i.hasNext()){
			key = i.next();
			value = map.get(key);
			System.out.println(key + ":" + value.toString());
		}
		// 返回map集合的全部value组成的集合
		Collection<Integer> values = map.values();
		for(Integer v : values){
			System.out.println(v);
		}
		// 返回map集合的键值对Entry对象组成的集合
		Set<Entry<String, Integer>> entriesSet = map.entrySet();
		for(Entry<String, Integer> e : entriesSet){
			key = e.getKey();
			value = e.getValue();
			System.out.println(key + ":" + value);
		}
	}
}
