import java.awt.Color;
import java.awt.Graphics;

public class Enemy{

	private int x;
	private int y;

	private int width;
	private int height;

	private int oX;
	private int oY;

	private int randomUD;

	private Color green;
	private Color white;
	private Color black;

	private boolean alive;
 	private boolean offScreen;


	public Enemy(int x, int y){

		this.x = x;
		this.y = y;

		this.width = 50;
		this.height = 40;

		this.oX = 16;
		this.oY = 35;

		this.randomUD = (int)(Math.random()*2.99)-1;

		this.alive = true; //this is not needed, but for consistency

		this.green = new Color(17, 127, 45); //19, 46, 209
		this.white = new Color(214, 224, 240);
		this.black = new Color(0,0,0);
	}


	public void drawMe(Graphics g){
		if( alive ){ //doesnt need == true bc boolean
			g.setColor(black);
			g.fillRect(x,y,width,height);

			g.setColor(green);
			int[] xdata1 =
			{    x+(32-oX),    x+(32-oX),    x+(32-oX),    x+(28-oX),    x+(24-oX),    x+(24-oX),    x+(26-oX),    x+(32-oX),
					 x+(37-oX),    x+(44-oX),    x+(48-oX),    x+(50-oX),    x+(44-oX),    x+(39-oX),    x+(39-oX),    x+(34-oX),
					 x+(32-oX),    x+(28-oX),    x+(25-oX),    x+(19-oX),    x+(16-oX),    x+(16-oX),    x+(18-oX),    x+(20-oX),
					 x+(25-oX),    x+(31-oX),    x+(34-oX),    x+(34-oX),    x+(28-oX),    x+(40-oX),    x+(42-oX),    x+(43-oX),
					 x+(46-oX),    x+(50-oX),    x+(54-oX),    x+(55-oX),    x+(56-oX),    x+(55-oX),    x+(55-oX),    x+(50-oX),
					 x+(47-oX),    x+(44-oX),    x+(39-oX),    x+(44-oX),    x+(50-oX),    x+(52-oX),    x+(53-oX),    x+(58-oX),
					 x+(66-oX),    x+(67-oX),    x+(67-oX),    x+(65-oX),    x+(60-oX),    x+(56-oX),    x+(56-oX),    x+(55-oX),
					 x+(55-oX),    x+(49-oX),    x+(43-oX)};
			int[] ydata1 =
			{    y+(36-oY),    y+(36-oY),    y+(28-oY),    y+(28-oY),    y+(24-oY),    y+(19-oY),    y+(18-oY),    y+(17-oY),
					 y+(21-oY),    y+(17-oY),    y+(19-oY),    y+(23-oY),    y+(27-oY),    y+(27-oY),    y+(36-oY),    y+(37-oY),
					 y+(35-oY),    y+(37-oY),    y+(36-oY),    y+(33-oY),    y+(34-oY),    y+(49-oY),    y+(63-oY),    y+(76-oY),
					 y+(79-oY),    y+(79-oY),    y+(73-oY),    y+(66-oY),    y+(64-oY),    y+(66-oY),    y+(65-oY),    y+(74-oY),
					 y+(78-oY),    y+(79-oY),    y+(75-oY),    y+(68-oY),    y+(54-oY),    y+(39-oY),    y+(34-oY),    y+(33-oY),
					 y+(35-oY),    y+(37-oY),    y+(36-oY),    y+(38-oY),    y+(33-oY),    y+(34-oY),    y+(31-oY),    y+(30-oY),
					 y+(32-oY),    y+(42-oY),    y+(56-oY),    y+(61-oY),    y+(63-oY),    y+(62-oY),    y+(54-oY),    y+(43-oY),
					 y+(34-oY),    y+(33-oY),    y+(38-oY)};
			g.fillPolygon(xdata1, ydata1, 59);

			g.setColor(white);
			int[] xdata2 =
			{    32-oX+x,    32-oX+x,    32-oX+x,    28-oX+x,    24-oX+x,    24-oX+x,    26-oX+x,    32-oX+x,
					 37-oX+x,    44-oX+x,    48-oX+x,    50-oX+x,    44-oX+x,    39-oX+x,    39-oX+x,    34-oX+x,
					 32-oX+x};
			int[] ydata2 =
			{    36-oY+y,    36-oY+y,    28-oY+y,    28-oY+y,    24-oY+y,    19-oY+y,    18-oY+y,    17-oY+y,
					 21-oY+y,    17-oY+y,    19-oY+y,    23-oY+y,    27-oY+y,    27-oY+y,    36-oY+y,    37-oY+y,
					 35-oY+y};
			g.fillPolygon(xdata2, ydata2, 17);




		}
	}

	public void kill(){
		alive = false;
	}

	public boolean isAlive(){
		return alive;
	}


	public int getX(){
		return x;
	}

	public int getY(){
		return y;
	}

	public int getWidth(){
		return width;
	}

	public int getHeight(){
		return height;
	}

	public void move(){
    x--;
		y-=randomUD;
		y = Math.min(y, 570);
		y = Math.max(y, 20);

		if(alive == true){
			if( x <= -50 ){
				x = 800;
				y = (int)(Math.random()*598);
				offScreen = true;
			}
		}
  }

	public void moveFast(){
		x-=2;
		y+=randomUD;
		y = Math.min(y, 570);
		y = Math.max(y, 20);

		if(alive == true){
			if( x <= -50 ){
				x = 800;
				y = (int)(Math.random()*598);
				offScreen = true;
			}
		}
	}


	public boolean offScreen(){
		return offScreen;
	}

	public void resetOffScreen(){
		offScreen = false;
	}






}
