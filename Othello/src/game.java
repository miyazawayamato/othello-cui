import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class game {
	
	
	//[3][3],[4][4]は黒、[3][4],[4][3]は白
	static private int[][] bored = new int[8][8];
	
	
	static private int colour = 0;
	
	public game() {
		
		bored[3][3] = 2;
		bored[4][4] = 2;
		bored[3][4] = 1;
		bored[4][3] = 1;
		
		showBoard();
	}
	
	
	static public void showBoard() {
		
		int white = 0;
		int black = 0;
		
		for (int[] nums : bored) {
			
			ArrayList<String> list = new ArrayList<>();
			
			
			for (int a : nums) {
				if (a == 0) {
					list.add("□");
				} else if (a == 1) {
					list.add("●");
					black++;
				} else if (a == 2) {
					list.add("◯");
					white++;
				}
			}
			System.out.println(list);
//			System.out.println(Arrays.toString(nums));
			
		}
		
		System.out.println("黒：" + black + "個");
		System.out.println("白：" + white + "個");
	}
	
	public int turnOver(int y, int x, int num) {
		
		//自分の色のセット
		colour = num;
		
		//裏返せる駒の合計
		int sumReverse = 0;
		
		sumReverse += turnUp(y,x);
		sumReverse += turnDown(y,x);
		sumReverse += turnLeft(y,x);
		sumReverse += turnRight(y,x);
		sumReverse += turnRightUp(y,x);
		sumReverse += turnRightDown(y,x);
		sumReverse += turnLeftUp(y,x);
		sumReverse += turnLeftDown(y,x);
		
		showBoard();
		
		return sumReverse;
		
	}
	
	static public int turnUp(int y, int x) {
		
		int targetY = y - 1;
		
		
		//次のマス目が盤上にあるか
		if(targetY < 0) {
			return 0;
		}
		
		//相手の駒である限りループ
		while(bored[targetY][x] != 0 && bored[targetY][x] != colour) {
			
			targetY--;
			
			//盤外または空なら終了
			if (targetY < 0 ) {
				return 0;
			}
			
			//自分の駒なら
			if (bored[targetY][x] == colour) {
				
				//targetYがyになるまで回す
				for (;targetY <= y; targetY++) {
					
					bored[targetY][x] = colour;
					
				}
				return targetY -y;
			}
			
		}
		
		return 0;
		
	}
	static public int turnDown(int y, int x) {
		
		int targetY = y + 1;
		
		
		//次のマス目が盤上にあるか
		if(targetY > 7) {
			return 0;
		}
		
		//相手の駒である限りループ
		while(bored[targetY][x] != 0 && bored[targetY][x] != colour) {
			
			targetY++;
			
			//盤外または空なら終了
			if (targetY > 7) {
				return 0;
			}
			
			//自分の駒なら
			if (bored[targetY][x] == colour) {
				
				//targetYがyになるまで回す
				for (;targetY >= y; targetY--) {
					
					bored[targetY][x] = colour;
					
				}
				return y - targetY;
			}
			
		}
		
		return 0;
		
	}
	static public int turnRight(int y, int x) {
		
		int targetX = x + 1;
		
		
		//次のマス目が盤上にあるか
		if(targetX > 7) {
			return 0;
		}
		
		//相手の駒である限りループ
		while(bored[y][targetX] != 0 && bored[y][targetX] != colour) {
			
			targetX++;
			
			//盤外または空なら終了
			if (targetX > 7) {
				return 0;
			}
			
			//自分の駒なら
			if (bored[y][targetX] == colour) {
				
				//targetYがyになるまで回す
				for (;targetX >= x; targetX--) {
					
					bored[y][targetX] = colour;
					
				}
				return x - targetX;
			}
			
		}
		
		return 0;
		
	}
	
	static public int turnLeft(int y, int x) {
		
		int targetX = x - 1;
		
		
		//次のマス目が盤上にあるか
		if(targetX < 0) {
			return 0;
		}
		
		//相手の駒である限りループ
		while(bored[y][targetX] != 0 && bored[y][targetX] != colour) {
			
			targetX--;
			
			//盤外または空なら終了
			if (targetX < 0 ) {
				return 0;
			}
			
			//自分の駒なら
			if (bored[y][targetX] == colour) {
				
				//targetYがyになるまで回す
				for (;targetX <= x; targetX++) {
					
					bored[y][targetX] = colour;
					
				}
				return targetX -x;
			}
			
		}
		
		return 0;
		
	}
	
	static public int turnLeftUp(int y, int x) {
		
		int targetX = x - 1;
		int targetY = y - 1;
		
		//盤外または空なら終了
		if (targetX < 0 || targetY < 0) {
			return 0;
		}
		
		//相手の駒である限りループ
		while(bored[targetY][targetX] != 0 && bored[targetY][targetX] != colour) {
			
			targetX--;
			targetY--;
			
			//盤外または空なら終了
			if (targetX < 0 ) {
				return 0;
			}
			
			//自分の駒なら
			if (bored[targetY][targetX] == colour) {
				
				//targetYがyになるまで回す
				for (;targetX <= x; targetX++, targetY++) {
					
					bored[targetY][targetX] = colour;
					
				}
				return targetX -x;
			}
			
		}
		
		return 0;
		
	}
	static public int turnLeftDown(int y, int x) {
		
		int targetX = x - 1;
		int targetY = y + 1;
		
		//盤外または空なら終了
		if (targetX < 0 || targetY > 7) {
			return 0;
		}
		
		//相手の駒である限りループ
		while(bored[targetY][targetX] != 0 && bored[targetY][targetX] != colour) {
			
			targetX--;
			targetY++;
			
			//盤外または空なら終了
			if (targetX < 0 ) {
				return 0;
			}
			
			//自分の駒なら
			if (bored[targetY][targetX] == colour) {
				
				//targetYがyになるまで回す
				for (;targetX <= x; targetX++, targetY--) {
					
					bored[targetY][targetX] = colour;
					
				}
				return targetX -x;
			}
			
		}
		
		return 0;
		
	}
	
	static public int turnRightUp(int y, int x) {
		
		int targetY = y - 1;
		int targetX = x + 1;
		
		
		//次のマス目が盤上にあるか
		if(targetX > 7 || targetY < 0) {
			return 0;
		}
		
		//相手の駒である限りループ
		while(bored[targetY][targetX] != 0 && bored[targetY][targetX] != colour) {
			
			targetX++;
			targetY--;
			
			//盤外または空なら終了
			if (targetX > 7 ) {
				return 0;
			}
			
			//自分の駒なら
			if (bored[targetY][targetX] == colour) {
				
				//targetYがyになるまで回す
				for (;targetX >= x; targetX--, targetY++) {
					
					bored[targetY][targetX] = colour;
					
				}
				return x - targetX;
			}
			
		}
		
		return 0;
		
	}
	static public int turnRightDown(int y, int x) {
		
		int targetX = x + 1;
		int targetY = y + 1;
		
		
		//次のマス目が盤上にあるか
		if(targetX > 7 || targetY > 7 ) {
			return 0;
		}
		
		//相手の駒である限りループ
		while(bored[targetY][targetX] != 0 && bored[targetY][targetX] != colour) {
			
			targetX++;
			targetY++;
			
			//盤外または空なら終了
			if (targetX > 7 ) {
				return 0;
			}
			
			//自分の駒なら
			if (bored[targetY][targetX] == colour) {
				
				//targetYがyになるまで回す
				for (;targetX >= x; targetX--, targetY--) {
					
					bored[targetY][targetX] = colour;
					
				}
				return x - targetX;
			}
			
		}
		
		return 0;
		
	}
}






















