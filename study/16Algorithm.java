package chapter;

public class BinarySearchProblem {

	public static void main(String[] args) {
		int[] numbers = {12,25,31,48,54,66,70,83,95,108};
		
		int target = 83;
		
		int left = 0;
		int right = numbers.length - 1;
		int mid = (left+right) / 2;
		
		int temp = numbers[mid];
		boolean find  = false;
		
		while(left <= right) {
			if(target == temp) {
            // 수를 찾은 경우
				find = true;
				break;
			} else if( target > temp) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
			mid = (left+right)/2;
			temp = numbers[mid];
			
		}
		
		if(find == true) {
			mid++;
			System.out.println("찾고자하는 숫자는" + mid + "번 째에 있습니다.");
		}
		else System.out.println("찾는 수가 없습니다. ");
	}

}
