import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class game {
	
	
	static int[][] bored;
	
	static int white = 0;
	static int black = 0;
	
	static private int colour = 0;
	
	//コンストラクタ
	public game() {
		
		//初期配置。[3][3],[4][4]は白、[3][4],[4][3]は黒
		bored = new int[8][8];
		bored[3][4] = 1;
		bored[4][3] = 1;
		bored[3][3] = 2;
		bored[4][4] = 2;
		
		showBoard();
	}
	
	//ターン
	public int turnOver(int y, int x, int num) {
		
		//裏返した駒の合計
		int sumReverse = 0;
		//自分の色（数字）のセット
		colour = num;
		
		//置く場所が空なら
		if (bored[y][x] == 0) {
			
			sumReverse += turnUp(y,x);
			sumReverse += turnDown(y,x);
			sumReverse += turnLeft(y,x);
			sumReverse += turnRight(y,x);
			sumReverse += turnRightUp(y,x);
			sumReverse += turnRightDown(y,x);
			sumReverse += turnLeftUp(y,x);
			sumReverse += turnLeftDown(y,x);
			
		}
		
		showBoard();
		
		//どちらか一色になったら
		if (white == 0 || black == 0) {
			return -1;
		}
		
		return sumReverse;
		
	}
	
	//結果
	public void showResult() {
		
		showBoard();
		
		if (black < white) {
			System.out.println("白の勝ち");
		} else if (white < black) {
			System.out.println("黒の勝ち");
		} else {
			System.out.println("引き分け");
		}
		
	}
	
	//ボードの状況
	static public void showBoard() {
		
		white = 0;
		black = 0;
		
		//arrayListに数字と対応する駒を入れて表示と各色のカウント
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
			
		}
		
		System.out.println("黒：" + black + "個");
		System.out.println("白：" + white + "個");
	}
	
	
	//以下それぞれの方向の裏返すメソッド
	static public int turnUp(int y, int x) {
		
		//次のマスのインデックスへ
		int targetY = y - 1;
		
		//次のマス目が盤上にあるか
		if(targetY < 0) {
			return 0;
		}
		
		//相手の駒である限りループ（空または自分の色でない）
		while(bored[targetY][x] != 0 && bored[targetY][x] != colour) {
			
			//次のマスへ
			targetY--;
			
			//盤外なら終了
			if(targetY < 0) {
				break;
			}
			
			//自分の駒までたどり着いたら
			if (bored[targetY][x] == colour) {
				
				//置いた位置からたどり着いた自分の駒の分ループして色を変える
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
		
		if(targetY > 7) {
			return 0;
		}
		
		while(bored[targetY][x] != 0 && bored[targetY][x] != colour) {
			
			targetY++;
			
			
			if (targetY > 7) {
				break;
			}
			
			if (bored[targetY][x] == colour) {
				
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
		
		if(targetX > 7) {
			return 0;
		}
		
		while(bored[y][targetX] != 0 && bored[y][targetX] != colour) {
			
			targetX++;
			
			if (targetX > 7) {
				break;
			}
			
			if (bored[y][targetX] == colour) {
				
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
		
		
		if(targetX < 0) {
			return 0;
		}
		
		while(bored[y][targetX] != 0 && bored[y][targetX] != colour) {
			
			targetX--;
			
			if (targetX < 0 ) {
				break;
			}
			
			if (bored[y][targetX] == colour) {
				
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
		
		if (targetX < 0 || targetY < 0) {
			return 0;
		}
		
		while(bored[targetY][targetX] != 0 && bored[targetY][targetX] != colour) {
			
			targetX--;
			targetY--;
			
			if (targetX < 0 || targetY < 0) {
				break;
			}
			
			if (bored[targetY][targetX] == colour) {
				
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
		
		if (targetX < 0 || targetY > 7) {
			return 0;
		}
		
		while(bored[targetY][targetX] != 0 && bored[targetY][targetX] != colour) {
			
			targetX--;
			targetY++;
			
			if (targetX < 0 || targetY > 7) {
				break;
			}
			
			if (bored[targetY][targetX] == colour) {
				
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
		
		
		if(targetX > 7 || targetY < 0) {
			return 0;
		}
		
		while(bored[targetY][targetX] != 0 && bored[targetY][targetX] != colour) {
			
			targetX++;
			targetY--;
			
			if (targetX > 7 || targetY < 0) {
				break;
			}
			
			if (bored[targetY][targetX] == colour) {
				
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
		
		if(targetX > 7 || targetY > 7 ) {
			return 0;
		}
		
		while(bored[targetY][targetX] != 0 && bored[targetY][targetX] != colour) {
			
			targetX++;
			targetY++;
			
			if (targetX > 7 || targetY > 7) {
				break;
			}
			
			if (bored[targetY][targetX] == colour) {
				
				for (;targetX >= x; targetX--, targetY--) {
					
					bored[targetY][targetX] = colour;
					
				}
				return x - targetX;
			}
			
		}
		
		return 0;
		
	}
}