public class Square extends Rectangle {
	
	private int x;
	private int y;
	private int width;
	private int height;
	
   public Square (int width, int x, int y) {
	   
	  super(width, width, x, y);
      this.x = x;
      this.y = y;
      this.width = width;
      this.height = width;
   }
}
