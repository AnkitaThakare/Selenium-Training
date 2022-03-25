package java_package;

public class Call_Method
{
	static void myFirstMethod() {
		System.out.println("I just got executed! First");
	}
	
	static void mySecondMethod() {
		System.out.println("I just got executed! Second");
	}

	public static void main(String[] args) {
		myFirstMethod();
		mySecondMethod();
	}

}
