import java.util.ArrayList;
import java.util.Arrays;

public class game {
	
	
	private int[][] bored = new int[8][8];
	
	private int white = 0;
	private int black = 0;
	
	private int colour = 0;
	
	//コンストラクタ
	public game() {
		
		//初期配置。[3][3],[4][4]は白、[3][4],[4][3]は黒
		bored[3][4] = 1;
		bored[4][3] = 1;
		bored[3][3] = 2;
		bored[4][4] = 2;
		
		showBoard();
	}
	
	//裏返しの個数チェック
	public int checkReverse(int y, int x, int num) {
		
		colour = num;
		
		//裏返した駒の合計
		int sumReverse = 0;
		
		//置く場所が空なら
		if (bored[y][x] == 0) {
			
			sumReverse = sumTurnOver(y, x).size();
			
		}
		System.out.println(1);;
		return sumReverse;
	}
	
	
	//ターン
	public int turnOver(int y, int x, int num) {
		
		//裏返した駒の合計
		int sumReverse = 0;
		//自分の色（数字）のセット
		colour = num;
		
		ArrayList<int[]> sumKoma = new ArrayList<int[]>();
		
		sumKoma = sumTurnOver(y, x);
		int[] put = {y, x};
		sumKoma.add(put);
		turn(sumKoma);
		
		
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
	public void showBoard() {
		
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
	
	//裏返しマスの合計メソッドの実行
	public ArrayList<int[]> sumTurnOver(int y, int x) {
		
		ArrayList<int[]> sumKoma = new ArrayList<int[]>();
		
		sumKoma.addAll(turnUp(y,x));
		sumKoma.addAll(turnDown(y,x));
		sumKoma.addAll(turnRight(y,x));
		sumKoma.addAll(turnLeft(y,x));
		sumKoma.addAll(turnRightUp(y,x));
		sumKoma.addAll(turnRightDown(y,x));
		sumKoma.addAll(turnLeftUp(y,x));
		sumKoma.addAll(turnLeftDown(y,x));
		
		int[] put = {y, x};
		for (int i = 0; i < sumKoma.size(); i++) {
			if (Arrays.equals(sumKoma.get(i), put)) {
				sumKoma.remove(i);
			}
		}
		
		return sumKoma;
		
	}
	
	//裏返し
	public void turn(ArrayList<int[]> sumKoma) {
		
		for (int[] k: sumKoma) {
			bored[k[0]][k[1]] = colour;
		}
		
	}
	
	
	
	//以下それぞれの方向の裏返すメソッド
	public ArrayList<int[]> turnUp(int y, int x) {
		
		ArrayList<int[]> reverseKoma = new ArrayList<int[]>();
		
		//次のマスのインデックスへ
		int targetY = y - 1;
		
		//次のマス目が盤上にあるか
		if(targetY < 0) {
			return reverseKoma;
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
				for (; targetY < y; y--) {
					
					int[] komaList = {y, x};
					reverseKoma.add(komaList);
					
				}
				
				return reverseKoma;
			}
			
		}
		
		return reverseKoma;
		
	}
    public ArrayList<int[]> turnDown(int y, int x) {
		
    	ArrayList<int[]> reverseKoma = new ArrayList<int[]>();
    	
		int targetY = y + 1;
		
		if(targetY > 7) {
			return reverseKoma;
		}
		
		while(bored[targetY][x] != 0 && bored[targetY][x] != colour) {
			
			targetY++;
			
			
			if (targetY > 7) {
				break;
			}
			
			if (bored[targetY][x] == colour) {
				
				
				for (;y < targetY; y++) {
					
					int[] komaList = {y, x};
					reverseKoma.add(komaList);
					
				}
				return reverseKoma;
			}
			
		}
		
		return reverseKoma;
		
	}
	public ArrayList<int[]> turnRight(int y, int x) {
		
		ArrayList<int[]> reverseKoma = new ArrayList<int[]>();
		
		int targetX = x + 1;
		
		if(targetX > 7) {
			return reverseKoma;
		}
		
		while(bored[y][targetX] != 0 && bored[y][targetX] != colour) {
			
			targetX++;
			
			if (targetX > 7) {
				break;
			}
			
			if (bored[y][targetX] == colour) {
				
				for (;x < targetX; x++) {
					
					int[] komaList = {y, x};
					reverseKoma.add(komaList);
				}
				return reverseKoma;
			}
			
		}
		
		return reverseKoma;
		
	}
	
	public ArrayList<int[]> turnLeft(int y, int x) {
		
		int targetX = x - 1;
		
		ArrayList<int[]> reverseKoma = new ArrayList<int[]>();
		
		if(targetX < 0) {
			return reverseKoma;
		}
		
		while(bored[y][targetX] != 0 && bored[y][targetX] != colour) {
			
			targetX--;
			
			if (targetX < 0 ) {
				break;
			}
			
			if (bored[y][targetX] == colour) {
				
				for (;targetX < x; x--) {
					
					int[] komaList = {y, x};
					reverseKoma.add(komaList);
				}
				return reverseKoma;
			}
			
		}
		
		return reverseKoma;
		
	}
	
	public ArrayList<int[]> turnLeftUp(int y, int x) {
		
		ArrayList<int[]> reverseKoma = new ArrayList<int[]>();
		
		int targetX = x - 1;
		int targetY = y - 1;
		
		if (targetX < 0 || targetY < 0) {
			return reverseKoma;
		}
		
		while(bored[targetY][targetX] != 0 && bored[targetY][targetX] != colour) {
			
			targetX--;
			targetY--;
			
			if (targetX < 0 || targetY < 0) {
				break;
			}
			
			if (bored[targetY][targetX] == colour) {
				
				
				
				for (;targetX < x; x--, y--) {

					int[] komaList = {y, x};
					reverseKoma.add(komaList);
				}
				return reverseKoma;
			}
			
		}
		
		return reverseKoma;
		
	}
	public ArrayList<int[]> turnLeftDown(int y, int x) {
		
		ArrayList<int[]> reverseKoma = new ArrayList<int[]>();
		
		int targetX = x - 1;
		int targetY = y + 1;
		
		if (targetX < 0 || targetY > 7) {
			return reverseKoma;
		}
		
		while(bored[targetY][targetX] != 0 && bored[targetY][targetX] != colour) {
			
			targetX--;
			targetY++;
			
			if (targetX < 0 || targetY > 7) {
				break;
			}
			
			if (bored[targetY][targetX] == colour) {
				
				
				
				for (;targetX < x; x--, y++) {

					int[] komaList = {y, x};
					reverseKoma.add(komaList);
				}
				
				return reverseKoma;
			}
			
		}
		
		return reverseKoma;
		
	}
	
	public ArrayList<int[]> turnRightUp(int y, int x) {
		
		ArrayList<int[]> reverseKoma = new ArrayList<int[]>();
		
		int targetY = y - 1;
		int targetX = x + 1;
		
		
		if(targetX > 7 || targetY < 0) {
			return reverseKoma;
		}
		
		while(bored[targetY][targetX] != 0 && bored[targetY][targetX] != colour) {
			
			targetX++;
			targetY--;
			
			if (targetX > 7 || targetY < 0) {
				break;
			}
			
			if (bored[targetY][targetX] == colour) {
				
				for (;x < targetX; x++, y--) {

					int[] komaList = {y, x};
					reverseKoma.add(komaList);
				}
				return reverseKoma;
			}
			
		}
		
		return reverseKoma;
		
	}
	public ArrayList<int[]> turnRightDown(int y, int x) {
		
		ArrayList<int[]> reverseKoma = new ArrayList<int[]>();
		
		int targetX = x + 1;
		int targetY = y + 1;
		
		if(targetX > 7 || targetY > 7 ) {
			return reverseKoma;
		}
		
		while(bored[targetY][targetX] != 0 && bored[targetY][targetX] != colour) {
			
			targetX++;
			targetY++;
			
			if (targetX > 7 || targetY > 7) {
				break;
			}
			
			if (bored[targetY][targetX] == colour) {
				
				//1ツ足りない
				for (;x < targetX; x++, y++) {

					int[] komaList = {y, x};
					reverseKoma.add(komaList);
				}
				
				return reverseKoma;
			}
			
		}
		
		return reverseKoma;
		
	}
}