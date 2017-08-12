/**
 * Created by youzhang on 2017/8/12.
 */
public class LongestCommonSubsequence {
    public static void main(String args[]){
        String x = "ACCGGTCGAGTGCGCGGAAGCCGGCCGAA";
        String y = "GTCGTTCGGAATGCCGTTGCTCTGTAAA";
        System.out.println(findLCS(x, y));
    }
    public static String findLCS(String x, String y){
        int m = x.length(),n = y.length();
        int[][] c = new int[m+1][n+1];
        for(int i=1;i<=m;i++){
            c[i][0] = 0;
        }
        for(int j=0;j<=n;j++){
            c[0][j] = 0;
        }
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(x.charAt(i-1)==y.charAt(j-1)){
                    c[i][j] = c[i-1][j-1]+1;
                }
                else if(c[i-1][j]>=c[i][j-1]){
                    c[i][j] = c[i-1][j];
                }
                else{
                    c[i][j] = c[i][j-1];
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        int i = m,j=n;
        while(i>0&&j>0){
            if(c[i][j]==c[i-1][j]){
                i--;
            }
            else if(c[i][j]==c[i][j-1]){
                j--;
            }
            else{
                sb.append(x.charAt(i-1));
                i--;
                j--;
            }
        }
        return sb.reverse().toString();
    }
}
