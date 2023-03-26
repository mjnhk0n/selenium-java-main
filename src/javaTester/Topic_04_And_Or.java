package javaTester;

public class Topic_04_And_Or {

	public static void main(String[] args) {
		boolean statusA;
		boolean statusB;

		// And - && - phải thỏa mãn cả 2 điều kiện đúng
		// 1 trong 2 điều kiện sai > sai
		// 1 trong 2 điều kiện đúng > sai
		// 2 điều kiện đều sai > sai
		statusA = True;
		statusB = False;
		System.out.println(statusA&&statusB);
		
		statusA = False;
		statusB = True;
		System.out.println(statusA&&statusB);
		
		statusA = False;
		statusB = False;
		System.out.println(statusA&&statusB);
		
		statusA = True;
		statusB = True;
		System.out.println(statusA&&statusB);
		
		// Or - || - chỉ cần thỏa mãn 1 điều kiện đúng
		// 1 trong 2 sai > đúng
		// cả 2 sai > sai
		// cả 2 đúng > đúng

		System.out.println(statusA||statusB);

	}

}
