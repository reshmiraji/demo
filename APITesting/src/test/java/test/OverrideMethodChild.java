package test;

public class OverrideMethodChild extends OverridePropertyParent{

	void show() {
		super.show();
        System.out.println("Child's show()");
	}
 
	public static void main(String[] args) {
		OverridePropertyParent obj = new OverrideMethodChild();
        obj.show();
	}

}
