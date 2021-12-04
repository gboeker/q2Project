import java.awt.Color;
import java.awt.Graphics;

public class Projectile{
	private int x;
	private int y;

	private int width;
	private int height;

	private Color offWhite;
	private Color offBlack;
	private Color red;

  private boolean fire;


	public Projectile(int x, int y){

		this.x = x;
		this.y = y;

		this.width = 25;
		this.height = 25;

		this.red = new Color(245, 29, 0);
		this.offWhite = new Color(237, 232, 234);
		this.offBlack = new Color(46, 45, 43);

    this.fire = false;

	}


	public void drawMe(Graphics g){
		g.setColor(offBlack);
		g.fillRect(x,y,width,height);

		g.setColor(offWhite);
		int[] xdataTP =
		{x+(32-30),    x+(32-30),    x+(32-30),    x+(38-30),    x+(41-30),    x+(44-30),    x+(48-30),    x+(54-30),
		 x+(56-30),    x+(56-30),    x+(56-30),    x+(56-30),    x+(56-30),    x+(52-30),    x+(46-30),    x+(42-30),
		 x+(36-30),    x+(32-30),    x+(34-30),    x+(37-30),    x+(41-30),    x+(48-30),    x+(51-30),    x+(56-30),
		 x+(56-30),    x+(52-30),    x+(46-30),    x+(39-30),    x+(32-30),    x+(24-30),    x+(25-30),    x+(23-30),
		 x+(27-30),    x+(24-30),    x+(28-30),    x+(26-30),    x+(29-30),    x+(23-30),    x+(31-30),    x+(33-30)};
		int[] ydataTP =
		{y+(28-30),    y+(28-30),    y+(53-30),    y+(58-30),    y+(59-30),    y+(59-30),    y+(59-30),    y+(57-30),
		 y+(55-30),    y+(43-30),    y+(37-30),    y+(33-30),    y+(30-30),    y+(33-30),    y+(33-30),    y+(32-30),
		 y+(31-30),    y+(29-30),    y+(27-30),    y+(26-30),    y+(26-30),    y+(25-30),    y+(26-30),    y+(28-30),
		 y+(30-30),    y+(33-30),    y+(33-30),    y+(32-30),    y+(29-30),    y+(27-30),    y+(31-30),    y+(34-30),
		 y+(38-30),    y+(39-30),    y+(41-30),    y+(42-30),    y+(47-30),    y+(48-30),    y+(54-30),    y+(55-30)};
		g.fillPolygon(xdataTP, ydataTP, 40);

		g.setColor(offBlack);
		g.fillOval( x+(80/2)-30,  y+(55/2)-30,  17/2,  7/2 );
	}






  public void moveUp(){
    y-=10;
		if( fire ){
		}
  }

  public void moveDown(){
    y+=10;
		if( fire ){
		}
  }

  public void move(){
    if( fire ){
      x+=10;
		}
  }

	public int getX(){
	return x;
	}

  public void fire(){
    fire = true;
  }

	public boolean isFiring(){
		return fire;
	}


	public void checkCollision(Enemy e){

		if( e.isAlive() ){
			int pX = x;
			int pY = y;
			int pWidth = width;
			int pHeight = height;
			int tX = e.getX();
			int tY = e.getY();
			int tWidth = e.getWidth();
			int tHeight = e.getHeight();

			if( pX+pWidth >= tX && pX <= tX + tWidth  &&
					pY+pHeight >= tY && pY <= tY + tHeight ){

					//System.out.println("Collision");
					e.kill(); //e. because in enemy class
			}
		}
	}


	public void reset(int shipX, int shipY){
		x = shipX;
		y = shipY;
		fire = false;
	}




}
