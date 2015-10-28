package application;

import java.util.Scanner;

public class WordGame {

    public static boolean isPalindrome(String s){
		int size=s.length();
		char[] a = s.toCharArray();
		for(int i=0, j=size-1; j>i; i++, j--){
			if(a[i] != a[j]){
				return false;
			}			
		}
		return true;
	}
	
	public static int countContains(String source, String substr){
	    int count=0;
		int allLength = source.length();
		int withoutL = source.replace(substr, "").length();
		int subLength = substr.length();
		count = (allLength - withoutL)/subLength;
		return count;		
	}
	
	public static int rowCount(char[][] a, String str){
		int result=0;
		for(int i=0; i<a.length; i++){
			String row = "";
			for(int j=0; j<a[i].length; j++){
				row += a[i][j];
				result+=countContains(row, str);
			}
		}
		return result;
	}
	
	public static int colCount(char[][] a, String str){
		int count = 0;
		for(int i=0; i<a.length; i++){
			String col = "";
			for(int j=0; j<a[i].length; j++){
				col += a[j][i];
				count += countContains(col, str);
			}
		}
		return count;
	}
	
	public static int diagCount(char[][] a, String str){
		int n = a.length;
		int m = a[0].length;
		int count = 0;
		int i = n - 1;
		int j = 0;
		
		while(j <= m - 1) {
			String diag = "";
			int ii = i;
			int jj = j;
			while(ii <= n - 1 && jj <= m - 1) {
				diag += a[ii][jj];
				ii++;
				jj++;
			}
			count += countContains(diag, str);
			//change i
			if(i != 0)
				i--;
			//change j
			else
				j++;
		}
		return count;
	}
	
	public static char[][] rowReverse(char[][] a){
		int n = a.length;
		int m = a[0].length;
		char[][] result = new char[n][m];

		for(int i=0; i<n; i++){
			int k=0;
			for(int j=m-1; j>=0; j--){
				result[i][k] = a[i][j];
				k++;
			}
		}
		return result;
	}
	
	public static char[][] colReverse(char[][] a){ 
		int n = a.length;
		int m = a[0].length;		
		char[][] result = new char[n][m];
		for(int i = n-1; i>=0; i--){
			int k=0;
			for(int j=0; j < m; j++){
				result[k][j] = a[i][j];
				k++;
			}
		}
		return result;
	}
	
	public static int wordCount(char[][] a, String word){
		int count = 0;
		count += rowCount(a, word);
		count += colCount(a, word);
		count += diagCount(a, word);
		count += diagCount(rowReverse(a), word);
		
		if(!isPalindrome(word)){
			count += rowCount(rowReverse(a), word);
			count += colCount(colReverse(a), word);
			count += diagCount(colReverse(a), word);
		}
		return count;
	}
	
	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		System.out.println("type a word:");
		String word = sc.nextLine();
		
		System.out.println("rows:");
		int n = sc.nextInt();
		
		System.out.println("cols:");
		int m = sc.nextInt();
		
		char[][] table = new char[n][m];
		System.out.println("Input the table:");
		
		for(int i=0; i<n; i++){
			for(int j=0; j<m; j++){
				table[i][j]=sc.next().charAt(0);
			}
		}
		System.out.println(wordCount(table, word));		
		sc.close();
	}
