
public class LongestCommonSubseq {
		
	private static int[][] mx;
	private static String[] lcs_seq;
	
	public static int max(int x, int y){
		if (x >= y)
			return x;
		else
			return y;
	}
	
	public static void build_matrix(int n, int m){
		mx = new int[n][m];
		
		for(int i=0; i<n; i++){
			for(int j=0; j<m; j++){
				mx[i][j]=-1;
			}
		}
	}
	
	public static String[] lcs(String[] x, String[] y, int n, int m){
		build_matrix(n+1, m+1);
	
		for(int i=0; i<n+1; i++) {mx[i][0]=0;}
		for(int j=1; j<m+1; j++) {mx[0][j]=0;}
		
		for(int i=1; i<n+1; i++){
			for(int j=1; j<m+1; j++){
				if (x[i-1]==y[j-1]){
					mx[i][j] = 1 + mx[i-1][j-1];
				}else{
					mx[i][j] = max(mx[i][j-1], mx[i-1][j]);
				}
			}	
		}
		int length=mx[n][m];
		lcs_seq=new String[length];
	
		if (length>0){
			lcs1(x, y, n-1, m-1);
			return lcs_seq;
		}else
			return null;
	}
	
	public static void lcs1(String[] x, String[] y, int i, int j){
		
		if (i>=0 && j>=0){
			if (x[i]==y[j]){
				lcs_seq[mx[i+1][j+1]-1]=x[i];
				lcs1(x, y, i-1, j-1);
			}else{
				if (mx[i+1][j] >= mx[i][j+1]){ // se metto strettamente maggiore troverà un'altra 
					lcs1(x, y, i, j-1);		   // sottosequenza ma sempre di lunghezza massima
				}else{
					lcs1(x, y, i-1, j);
				}
			}
		}
	}
}
