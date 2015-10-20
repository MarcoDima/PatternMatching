public class Exec {

	public static void main(String[] args) {
		// start
		String[] x = {"a", "i", "n", "b", "c", "a", "t"};
		String[] y = {"a", "b", "c", "a", "b"};
		
		for(int i=0; i<x.length; i++){
			System.out.print(x[i]+" ");
		}
		System.out.println();
		
		for(int i=0; i<y.length; i++){
			System.out.print(y[i]+" ");
		}
		System.out.println();
		
		int n=x.length;
		int m=y.length;
		
		System.out.println();
		
		String[] z = LongestCommonSubseq.lcs(x, y, n, m);
		
		if (z != null){
			System.out.println("Longest common subsequence is:");
			for(int i=0; i< z.length; i++){
				System.out.print(z[i] +" ");
			}
		}else
			System.out.println("NO match found");
	}
}
