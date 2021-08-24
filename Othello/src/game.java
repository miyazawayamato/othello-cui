import java.util.Arrays;

public class game {
	
	
	//[3][3],[4][4]は黒、[3][4],[4][3]は白
	static private int[][] bored = new int[8][8];
	
	//ボードの駒の数
	private int komaTotal = 4;
	
	
	public void testPrint() {
		
		
		for (int[] nums : bored) {
			
			System.out.println(Arrays.toString(nums));
			
		}
		
	}
	
	
}