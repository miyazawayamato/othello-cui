import java.util.InputMismatchException;
import java.util.Scanner;

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
		
		Scanner sc = new Scanner(System.in);
		
		//ここで終了判定
		while(komaTotal < 64) {
			
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
		    
		    
			//メソッドの実行  裏返した駒の合計
			int sumReverse = game.turnOver(y - 1, x - 1, num);
			
			//0なら裏返せてない＝無効な場所
			//-1ならどちらかが一色になって決着
			if (sumReverse == 0) {
				System.out.println("有効な場所に置いてください");
				continue;
			} else if (sumReverse == -1) {
				break;
			}
			
			System.out.println("裏返した総数は" + sumReverse);
			
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
