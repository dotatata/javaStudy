package interviewTest;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

// countһ���ַ�����ÿ���ַ��ĸ��� �� ���εĴ���
public class StringCount {
	public static void main(String[] args) {
		String s = "adsfnvbsnvcoivqmagf";
		System.out.println("�����ַ���: " + s);
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
		System.out.println("���������ַ���:"+ maxS + "; ������:" + maxCount);
	}
}
