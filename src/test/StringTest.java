package test;

public class StringTest {
	private static String log = "sssss";

	public static void main(String[] args) {
		String msg = "JavaIsABestProgrmmingLanguage.";
		System.out.println("int i is " + msg.codePointAt(5)); // Int i is 105
		System.out.println("char c is " + msg.charAt(5)); // char c is i
		System.out.println(msg.substring(4)); // is a best programming language.
		System.out.println(msg.indexOf(1));
		System.out.println(msg.indexOf("Is"));
		// String[] x = {"x"};
		// LoopMenu.main(x);
		// String类型的不可变行
		System.out.println("private static String log = " + log);
		msg = log;
		log = "xxxx";
		System.out.println("msg = " + msg + "\nlog = " + log);
		
	}
}
