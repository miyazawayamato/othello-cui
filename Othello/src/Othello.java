import java.util.InputMismatchException;
import java.util.Scanner;

//パスメソッド
//cpuの強さ

public class Othello {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		
		game game = new game();
		
		int x = 0;
		int y = 0;
		
		//１なら黒、２なら白
		int num = 1;
		
		//ボードの駒の数
		int komaTotal = 4;
		
		//裏返せる駒
		int sumReverse = 0;
		
		Scanner sc = new Scanner(System.in);
		
		//ここで終了判定
		while(komaTotal < 64) {
			
			//1（黒）は自分のターン
			if (num == 1) {
				
				//整数入力、それ以外の場合の例外
				try{
					
					System.out.println("行を入力してください。");
					y = sc.nextInt();
					System.out.println("列を入力してください。");
					x = sc.nextInt();
					
				}catch (InputMismatchException e){
					
					System.out.println("整数を入力してください");
					sc.next();
					continue;
					
				}
				
				//盤上か(1～8)
				if (x <= 0 || x > 8) {
					System.out.println("盤上に置いてください");
					continue;
				} else if (y <= 0 || y > 8) {
					System.out.println("盤上に置いてください");
					continue;
				}
				
				//指定した位置が置けるかのチェック
				sumReverse = game.checkReverse(y - 1, x - 1, num);
				
				//0なら不可
				if (sumReverse == 0) {
					System.out.println("有効な場所に置いてください");
					continue;
				}
				
			//2（白）はCPUのターン
			} else if (num ==2) {
				
				//はじからループして該当する（１以上が返る）まで
				LABEL1:{
					
					for (x = 1; x < 9; x++) {
						
						for (y = 1; y < 9; y++) {
							
							sumReverse = game.checkReverse(y - 1, x - 1, num);
							
							//１マス以上で
							if (sumReverse > 0) {
								
								//ラベルで２重ループを抜ける
								break LABEL1;
								
							}
						}
						
					}
				}
				
			}
			
			
			//裏返し
			int gameOver = game.turnOver(y - 1, x - 1, num);
			
			
			// 全部一色になった時
			if (gameOver == -1) {
				break;
			}
			
			//交代
			if (num == 1) {
				num = 2;
			} else if (num == 2) {
				num = 1;
			}
			
			komaTotal++;
			
		}
		
		sc.close();
		System.out.println("終了");
		
		game.showResult();
	}
	
}
