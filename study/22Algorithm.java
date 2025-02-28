미로 정의
public class Maze {

	public int[][] myMaze ={
			{0, 1, 1, 1, 0, 1, 1, 1},
			{0, 0, 0, 1, 0, 0, 0, 0},
			{1, 1, 0, 0, 0, 1, 0, 1},
			{1, 1, 0, 1, 1, 1, 0, 1},
			{1, 0, 0, 1, 0, 0, 0, 0},
			{0, 1, 1, 1, 0, 1, 1, 1},
			{1, 0, 1, 1, 0, 0, 0, 0},
			{0, 1, 1, 0, 1, 1, 1, 0}

	};
}
움직이는 위치
public class Move {

	int direction=0;
	
	public int x=0;
	public int y=0;
	
	public Move(int x,int y){
		this.x = x;
		this.y = y;
		
	}
	
}
움직임을 표시할 변수(Robot.java)
public static int NUMDIRECTIONS =  4;
	// 미로 크기
	public static int WIDTH = 8;
	public static int HEIGHT = 8;
	
	Stack<Move> stack = new Stack<Move>();
	Move Move;
	Maze maze = new Maze();
	
	public int[][] DIRECTION_OFFSETS = 
	{
    	// 이것을 MOVE 좌표에 적용 해줌
		{0, -1},		// 위쪽으로 이동.
		{1, 0},			// 오른쪽으로 이동.
		{0, 1},			// 아래쪽으로 이동.
		{-1, 0}			// 왼쪽으로 이동.
	};
	
	public static int NOTVISIT = 0;
	public static int WALL = 1;
	public static int VISIT = 2;
	int[][] markArray = new int[8][8];
출구 찾기
public void findPath( int startX, int startY, int endX, int endY) {
		
		boolean isEmpty = false; 
		boolean isFound = false;
		int i = 0;

		Move start = new Move(startX, startY);

		start.direction = 0;
		stack.push(start);
		
		while(isEmpty == false && isFound == false) {
			
				Move curPos = stack.pop();
				int x = curPos.x;
				int y = curPos.y;
				int direction = curPos.direction;

				while(isFound == false && direction < NUMDIRECTIONS) {
				
					int newX = x + DIRECTION_OFFSETS[direction][0];
					int newY = y + DIRECTION_OFFSETS[direction][1];
					// 갈만한 곳이 있으면 new position 으로 업데이트
					if (newX >= 0 && newX < WIDTH
								&& newY >= 0 && newY < HEIGHT
								&& maze.myMaze[newY][newX] == NOTVISIT
								&& markArray[newY][newX] == NOTVISIT) {										
						Move newPosition = new Move(newX, newY);
						newPosition.direction = direction + 1;
						stack.push(newPosition);
						markArray[y][x] = VISIT;

						x = newX;
						y = newY;
						direction = 0;

						if (newX == endX && newY == endY) {
							isFound = true;
							newPosition.x = newX;
							newPosition.y = newY;
							newPosition.direction = 0;
							stack.push(newPosition);
							markArray[newY][newX] = VISIT;
						}
					}
					else direction++;
				}//end-of-while
			isEmpty = stack.isEmpty();
		}//end-of-while
	}
