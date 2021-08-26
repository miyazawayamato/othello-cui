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
		while(komaTotal < 10) {
			
			System.out.println("行を入力してください。");
			Scanner sc1 = new Scanner(System.in);
			String gyou = sc1.nextLine();
			y = Integer.parseInt(gyou);
			
			System.out.println("列を入力してください。");
			Scanner sc2 = new Scanner(System.in);
			String retu = sc2.nextLine();
			x = Integer.parseInt(retu);
			
//			System.out.println(y +"-" + x);
			
			//メソッドの実行
			game.turnOver(y - 1, x - 1, num);
			
			
			if (num == 1) {
				num = 2;
			} else if (num == 2) {
				num = 1;
			}
			
			komaTotal++;
			
		}
		
		System.out.println("終");
		
		
	}
	
	
	//交代のメソッド
	
	//スタートと終了のメソッド

}
