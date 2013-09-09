package test.Class;

public class Genericity<T1, T2> {
	public static void main(String[] args) {
		
	}

	private T1 person;
	private T2 job;
	public Genericity(T1 person, T2 job){
		this.person = person;
		this.job = job;
	}
}
