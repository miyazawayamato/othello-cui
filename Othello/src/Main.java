import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		
		game game = new game();
		
		game.testPrint();
		
		int num = 0;
		
		//ここで終了判定
		while(num == 0) {
			
			System.out.println("入力してください。");
			
			Scanner sc1 = new Scanner(System.in);
			String line1 = sc1.nextLine();
			
			num = Integer.parseInt(line1);
			
			System.out.println("数は" + num);
			
			
			
		}
		
	}
	
	//コンソールから入力を確認
	//値を変えるメソッドの実行
	
	//上下斜め8つの方向のパネルの確認
	//交代のメソッド
	
	//スタートと終了のメソッド

}
