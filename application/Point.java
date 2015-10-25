package application101;

public class Point {
	
	public int x;
	public int y;
	
	public Point(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	public String toString(){
		return "("+x+", "+y+")";
	}
	
	public void increase(){
		this.x++;
		this.y++;
	}
	
	public void decrease(){
		this.x--;
		this.y--;
	}	
	
	public void transform(String s){
		
		for(int i=0; i<s.length(); i++){
			
			if(s.charAt(i) == '>'){
				increase();
			}
			
			if(s.charAt(i) == '<'){
				decrease();
			}
			
			if(s.charAt(i) == '~'){
				reverse(s.substring(i+1));
				break;
			}
		}		
	}

	public void reverse(String s){
		
		for(int i=0; i<s.length(); i++){
			
			if(s.charAt(i) == '>'){
				decrease();
			}
			
			if(s.charAt(i) == '<'){
				increase();
			}
			
			if(s.charAt(i) == '~'){
				reverse(s.substring(i+1));
				break;
			}
		}
	}

}
