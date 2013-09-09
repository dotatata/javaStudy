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
		// map���ٴδ���ͬһkeyʱ ���滻key��value
		map.put("first", 4);
		String key;
		Integer value;
		// ����map���ϵ�ȫ��key��ɵļ���
		Set<String> keySet = map.keySet();
		Iterator<String> i = keySet.iterator();
		while(i.hasNext()){
			key = i.next();
			value = map.get(key);
			System.out.println(key + ":" + value.toString());
		}
		// ����map���ϵ�ȫ��value��ɵļ���
		Collection<Integer> values = map.values();
		for(Integer v : values){
			System.out.println(v);
		}
		// ����map���ϵļ�ֵ��Entry������ɵļ���
		Set<Entry<String, Integer>> entriesSet = map.entrySet();
		for(Entry<String, Integer> e : entriesSet){
			key = e.getKey();
			value = e.getValue();
			System.out.println(key + ":" + value);
		}
	}
}
