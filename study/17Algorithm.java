package chapter;

public class InsertionSort {
	
	public static void insertionSort(int[] arr, int count) {
		int temp = 0;
		int i = 0; int j = 0;
		
		for(i = 1; i < count; i++) 
		{	
			temp = arr[i];
			j = i;
			while((j > 0) && arr[j-1] > temp) {
				arr[j] = arr[j-1];
				j = j-1;
			}
			arr[j] = temp;
			
			System.out.println("반복 -" + i);
			printSort(arr, count);
		}
	}	
		public static void printSort(int value[], int count)
		{
			int i = 0;
			for(i = 0; i < count; i++) {
				System.out.print(value[i] + "\t");
			}
			System.out.println();
		}

		public static void main(String[] args) {
			int[] arr = {80, 50, 70, 10, 60, 20, 40, 30 };
		
			insertionSort(arr, 8);


	}

}
