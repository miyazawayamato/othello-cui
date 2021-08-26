import java.util.Arrays;

public class game {
	
	
	//[3][3],[4][4]は黒、[3][4],[4][3]は白
	static private int[][] bored = new int[8][8];
	
	
	static private int colour = 0;
	
	public game() {
		
		bored[3][3] = 2;
		bored[4][4] = 2;
		bored[3][4] = 1;
		bored[4][3] = 1;
		
		testPrint();
	}
	
	
	static public void testPrint() {
		
		for (int[] nums : bored) {
			
			System.out.println(Arrays.toString(nums));
			
		}
		
	}
	
	public void turnOver(int y, int x, int num) {
		
		//自分の色のセット
		colour = num;
		
		
//		bored[y][x] = num;
		turnUp(y,x);
		turnDown(y,x);
		turnLeft(y,x);
		turnRight(y,x);
		
		testPrint();
		//置くことができるのか  盤外ではないか、裏返せる駒はあるか
		
		
	}
	
	static public void turnUp(int y, int x) {
		
		int targetY = y - 1;
		
		
		//次のマス目が盤上にあるか
		if(targetY < 0) {
			return;
		}
		
		//相手の駒である限りループ
		while(bored[targetY][x] != 0 && bored[targetY][x] != colour) {
			
			targetY--;
			
			//盤外または空なら終了
			if (targetY < 0 ) {
				break;
			}
			
			//自分の駒なら
			if (bored[targetY][x] == colour) {
				
				System.out.println("OK");
				//targetYがyになるまで回す
				for (;targetY <= y; targetY++) {
					
					bored[targetY][x] = colour;
					
				}
				break;
			}
			
		}
		
	}
	static public void turnDown(int y, int x) {
		
		int targetY = y + 1;
		
		
		//次のマス目が盤上にあるか
		if(targetY > 8) {
			return;
		}
		
		//相手の駒である限りループ
		while(bored[targetY][x] != 0 && bored[targetY][x] != colour) {
			
			targetY++;
			
			//盤外または空なら終了
			if (targetY < 0 ) {
				break;
			}
			
			//自分の駒なら
			if (bored[targetY][x] == colour) {
				
				//targetYがyになるまで回す
				for (;targetY >= y; targetY--) {
					
					bored[targetY][x] = colour;
					
				}
				break;
			}
			
		}
		
	}
	static public void turnRight(int y, int x) {
		
		int targetX = x + 1;
		
		
		//次のマス目が盤上にあるか
		if(targetX > 8) {
			return;
		}
		
		//相手の駒である限りループ
		while(bored[y][targetX] != 0 && bored[y][targetX] != colour) {
			
			targetX++;
			
			//盤外または空なら終了
			if (targetX < 0 ) {
				break;
			}
			
			//自分の駒なら
			if (bored[y][targetX] == colour) {
				
				//targetYがyになるまで回す
				for (;targetX >= x; targetX--) {
					
					bored[y][targetX] = colour;
					
				}
				break;
			}
			
		}
		
	}
	
	static public void turnLeft(int y, int x) {
		
		int targetX = x - 1;
		
		
		//次のマス目が盤上にあるか
		if(targetX < 0) {
			return;
		}
		
		//相手の駒である限りループ
		while(bored[y][targetX] != 0 && bored[y][targetX] != colour) {
			
			targetX--;
			
			//盤外または空なら終了
			if (targetX < 0 ) {
				break;
			}
			
			//自分の駒なら
			if (bored[y][targetX] == colour) {
				
				System.out.println("OK");
				//targetYがyになるまで回す
				for (;targetX <= x; targetX++) {
					
					bored[y][targetX] = colour;
					
				}
				break;
			}
			
		}
		
	}
}






















