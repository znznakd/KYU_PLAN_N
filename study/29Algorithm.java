import java.util.*;

public class Main
{
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
	    
	    int n = scan.nextInt();
		scan.nextLine();
		String route = scan.nextLine().replaceAll(" ", "");
	
		int x = 1, y = 1;
		
		for(char direction : route.toCharArray()){
		    switch(direction){
		        case 'U':
		            x = (x - 1 < 1 ? x : x - 1);
		            break;
		        case 'D':
		            x = (x + 1 > n ? x : x + 1);
		            break;
		        case 'L':
		            y = (y - 1 < 1 ? y : y - 1);
		            break;
		        case 'R':
		            y = (y + 1 > n ? y : y + 1);
		            break;
		    }
		}
		
		System.out.println(String.format("result point = (%d, %d)", x, y));
	}
}

public class sub
{
	public static void main(String[] args) {
	    Scanner scan = new Scanner(System.in);
	    
	    int n = scan.nextInt();
	    int result = 0;
	    
	    for(int hour = 0; hour <= n; hour++){
	        for(int minute = 0; minute <= 59; minute++){
	            for(int second = 0; second <= 59; second++){
	               String time = String.valueOf(hour) + minute + second;
	               
	               if(time.indexOf("3") > -1){
	                   result ++;
	               }
	            }
	        }
	    }
	    
	    System.out.println("result =" + result);
	}
}

public class sub2
{
	public static void main(String[] args) {
	    // 체스판 사이즈 정의 
	    final int MAP_SIZE = 8;
	    
	    // 입력 값 받기
	    Scanner scan = new Scanner(System.in);
	    
	    String position = scan.next();
	    int cases = 0;
	    int x = Character.getNumericValue(position.charAt(1));
	    int y = Integer.valueOf(position.charAt(0) - ('a' - 1));

	    // 4가지 방향에 대한 이동 확인
	    if(y - 2 >= 1){
	        cases += (x == 1 || x == MAP_SIZE) ? 1 : 2;
	    }
	    
	    if(y + 2 <= MAP_SIZE){
	       cases += (x == 1 || x == MAP_SIZE) ? 1 : 2;
	    }
	    
	    if(x - 2 >= 1){
	        cases += (y == 1 || y == MAP_SIZE) ? 1 : 2;
	    }
	    
	    if(x + 2 <= MAP_SIZE){
	        cases += (y == 1 || y == MAP_SIZE) ? 1 : 2;
	    }
	    
	    System.out.println("result = " + cases);
	}
}
