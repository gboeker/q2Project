import java.awt.Color;
import java.awt.Graphics;


public class Asteroid {
	private int x;
	private int y;

  private int sX;
  private int sY;

	private Color white;
  private Color brown;
  private Color red;
  private Color orange;



	public Asteroid(){
		x = (int)(Math.random()*800);
		y = (int)(Math.random()*598);

    sX = 36;
    sY = 35;

		white = new Color(255,255,255);
    brown = new Color(46, 36, 30);
    red = new Color(74, 15, 15);
    orange = new Color(74, 51, 15);



	}

	public void drawMe(Graphics g){
    // g.setColor(white);
		// g.fillRect(x,y,2,2);
    g.setColor(brown);
    int[] xdata1 =
    {   x+105-sX,   x+105-sX,   x+117-sX,   x+128-sX,   x+131-sX,   x+131-sX,   x+125-sX,   x+117-sX,
        x+109-sX,   x+103-sX,   x+ 97-sX,   x+ 98-sX,   x+100-sX,   x+104-sX};
    int[] ydata1 =
    {   y+39-sY,    y+39-sY,    y+40-sY,    y+45-sY,    y+51-sY,    y+60-sY,    y+67-sY,    y+72-sY,
        y+71-sY,    y+66-sY,    y+60-sY,    y+52-sY,    y+44-sY,    y+40-sY};
    g.fillPolygon(xdata1, ydata1, 14);

    g.setColor(red);
    int[] xdata2 =
    {   x+105-sX,   x+105-sX,   x+117-sX,   x+128-sX,   x+131-sX,   x+131-sX,   x+125-sX,   x+117-sX,
        x+109-sX,   x+103-sX,   x+ 97-sX,   x+ 98-sX,   x+100-sX,   x+104-sX,   x+ 90-sX,   x+ 82-sX,
        x+ 85-sX,   x+ 91-sX,   x+ 82-sX,   x+ 72-sX,   x+ 63-sX,   x+ 71-sX,   x+ 81-sX,   x+ 86-sX,
        x+ 74-sX,   x+ 65-sX,   x+ 51-sX,   x+ 41-sX,   x+ 50-sX,   x+ 61-sX,   x+ 53-sX,   x+ 60-sX,
        x+ 71-sX,   x+ 71-sX,   x+ 59-sX,   x+ 55-sX,   x+ 65-sX,   x+ 81-sX,   x+ 78-sX,   x+ 87-sX,
        x+ 93-sX,   x+104-sX,   x+109-sX,   x+117-sX,   x+126-sX,   x+130-sX,   x+132-sX,   x+128-sX,
        x+117-sX};
    int[] ydata2 =
    {    y+39-sY,    y+39-sY,    y+40-sY,    y+45-sY,    y+51-sY,    y+60-sY,    y+67-sY,    y+72-sY,
         y+71-sY,    y+66-sY,    y+60-sY,    y+52-sY,    y+44-sY,    y+40-sY,    y+38-sY,    y+33-sY,
         y+41-sY,    y+45-sY,    y+43-sY,    y+41-sY,    y+41-sY,    y+44-sY,    y+50-sY,    y+50-sY,
         y+52-sY,    y+48-sY,    y+47-sY,    y+48-sY,    y+51-sY,    y+54-sY,    y+58-sY,    y+59-sY,
         y+63-sY,    y+66-sY,    y+67-sY,    y+70-sY,    y+70-sY,    y+71-sY,    y+77-sY,    y+74-sY,
         y+74-sY,    y+73-sY,    y+71-sY,    y+73-sY,    y+67-sY,    y+61-sY,    y+51-sY,    y+46-sY,
         y+41-sY};
    g.fillPolygon(xdata2, ydata2, 49);

    g.setColor(orange);
    int[] xdata3 =
    {   x+105-sX,   x+105-sX,   x+117-sX,   x+128-sX,   x+131-sX,   x+131-sX,   x+125-sX,   x+117-sX,
        x+109-sX,   x+103-sX,   x+ 97-sX,   x+ 98-sX,   x+100-sX,   x+104-sX,   x+ 90-sX,   x+ 82-sX,
        x+ 85-sX,   x+ 91-sX,   x+ 82-sX,   x+ 72-sX,   x+ 63-sX,   x+ 71-sX,   x+ 81-sX,   x+ 86-sX,
        x+ 74-sX,   x+ 65-sX,   x+ 51-sX,   x+ 41-sX,   x+ 50-sX,   x+ 61-sX,   x+ 53-sX,   x+ 60-sX,
        x+ 71-sX,   x+ 71-sX,   x+ 59-sX,   x+ 55-sX,   x+ 65-sX,   x+ 81-sX,   x+ 78-sX,   x+ 87-sX,
        x+ 93-sX,   x+104-sX,   x+109-sX,   x+ 97-sX,   x+100-sX,   x+105-sX,   x+100-sX,   x+ 90-sX,
        x+ 78-sX,   x+ 76-sX,   x+ 68-sX,   x+ 56-sX,   x+ 60-sX,   x+ 43-sX,   x+ 33-sX,   x+ 23-sX,
        x+ 13-sX,   x+ 34-sX,   x+ 43-sX,   x+ 36-sX,   x+ 56-sX,   x+ 50-sX,   x+ 65-sX,   x+ 73-sX,
        x+ 88-sX,   x+104-sX,   x+118-sX,   x+126-sX,   x+132-sX,   x+136-sX,   x+137-sX,   x+132-sX,
        x+121-sX,   x+111-sX,   x+103-sX};
    int[] ydata3 =
    {    y+39-sY,    y+39-sY,    y+40-sY,    y+45-sY,    y+51-sY,    y+60-sY,    y+67-sY,    y+72-sY,
         y+71-sY,    y+66-sY,    y+60-sY,    y+52-sY,    y+44-sY,    y+40-sY,    y+38-sY,    y+33-sY,
         y+41-sY,    y+45-sY,    y+43-sY,    y+41-sY,    y+41-sY,    y+44-sY,    y+50-sY,    y+50-sY,
         y+52-sY,    y+48-sY,    y+47-sY,    y+48-sY,    y+51-sY,    y+54-sY,    y+58-sY,    y+59-sY,
         y+63-sY,    y+66-sY,    y+67-sY,    y+70-sY,    y+70-sY,    y+71-sY,    y+77-sY,    y+74-sY,
         y+74-sY,    y+73-sY,    y+71-sY,    y+60-sY,    y+44-sY,    y+38-sY,    y+33-sY,    y+31-sY,
         y+25-sY,    y+33-sY,    y+31-sY,    y+31-sY,    y+39-sY,    y+39-sY,    y+45-sY,    y+48-sY,
         y+52-sY,    y+54-sY,    y+64-sY,    y+68-sY,    y+68-sY,    y+72-sY,    y+74-sY,    y+81-sY,
         y+81-sY,    y+76-sY,    y+77-sY,    y+74-sY,    y+66-sY,    y+58-sY,    y+48-sY,    y+40-sY,
         y+35-sY,    y+36-sY,    y+35-sY};
    g.fillPolygon(xdata3, ydata3, 75);

	}

  public void move(){
    x--;
    if( x <= -sX ){
      x = 800;
      y = (int)(Math.random()*598);
    }
  }



}
