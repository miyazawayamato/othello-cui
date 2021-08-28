import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		
		game game = new game();
		
		int x = 0;
		int y = 0;
		
		int num = 1;
		
		//ボードの駒の数
		int komaTotal = 4;
		
		
		//ここで終了判定
		while(komaTotal < 65) {
			
			//整数以外の場合の例外
			Scanner sc1 = new Scanner(System.in);
			System.out.println("行を入力してください。");
		    try{
		    	y = sc1.nextInt();
		    }catch (InputMismatchException e){
		        System.out.println("整数を入力してください");
		        continue;
		    }
		    Scanner sc2 = new Scanner(System.in);
		    System.out.println("列を入力してください。");
		    try{
		    	x = sc2.nextInt();
		    }catch (InputMismatchException e){
		    	System.out.println("整数を入力してください");
		    	continue;
		    }
		    
		    
		    //1～8の盤上か
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
			if (sumReverse == 0) {
				System.out.println("有効な場所に置いてください");
				continue;
			}
			
			
			//交代するメソッド
			if (num == 1) {
				num = 2;
			} else if (num == 2) {
				num = 1;
			}
			
			komaTotal++;
			
		}
		
		System.out.println("終了");
		
		
	}
	
	//おける駒がない場合→パスするメソッド
	//一色になる→負け
	//終了メソッド
}
