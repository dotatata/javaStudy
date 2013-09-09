package interviewTest;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

// count一个字符串中每个字符的个数 和 最多次的次数
public class StringCount {
	public static void main(String[] args) {
		String s = "adsfnvbsnvcoivqmagf";
		System.out.println("测试字符是: " + s);
		String[] sArr = s.split("");
		Map<String, Integer> countSs = new HashMap<String, Integer>();
		for (String ss : sArr) {
			if(countSs.get(ss) == null){
				// 
				countSs.put(ss, 1);
			}else{
				countSs.put(ss, countSs.get(ss)+1);
			}
		}
		String maxS = new String();
		int maxCount = 0;
		for(Entry<String, Integer> e : countSs.entrySet()){
			if(e.getValue() >= maxCount){
				maxS = e.getKey();
				maxCount = e.getValue();
			}
		}
		System.out.println("出现最多的字符是:"+ maxS + "; 次数是:" + maxCount);
	}
}
