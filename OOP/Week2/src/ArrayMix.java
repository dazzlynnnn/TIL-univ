
public class ArrayMix {

	public static void main(String[] args) {
		int[] number = new int[10];
		int i, n, temp;
		System.out.println("<Original Array>");
		for(i=0 ; i<10 ; i++) {   //printing original array
			number[i] = i;
			System.out.print(number[i]+" ");
		}
		
		System.out.println();   //next line
		for (i=0; i<100; i++) {   //switching 100 times
			n = (int)(Math.random()*10);   //getting random number 0~9
			temp = number[0];   //switching two elements
			number[0] = number[n];
			number[n] = temp;
		}
		System.out.println("\n<Mixed Array>");
		for(i=0; i<10; i++)
			System.out.print(number[i]+ " ");
	}

}
