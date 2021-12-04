import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class Screen extends JPanel implements KeyListener{

	private Projectile p1;
	private Projectile p2;
	private Ship s1;
	private Ship s2;

	private Enemy[] enemies; //enemy array not int!
	private Enemy[] enemies2;
	private Star[] starList;
	private Asteroid[] asteroidList;

	private Color black;
	private Color white;

	private int level;

	//private int lives;


	public Screen(){

		level = 1;

		//lives = 3;

		starList = new Star[100];
		for(int i=0; i < starList.length; i++){
			starList[i] = new Star();
		}

		asteroidList = new Asteroid[10];
		for(int i=0; i < asteroidList.length; i++){
			asteroidList[i] = new Asteroid();
		}

		//setup the color
		black = new Color(0,0,0);
		white = new Color(255,255,255);

		s1 = new Ship(50,200);
		s2 = new Ship(50,400);

		p1 = new Projectile(50,200);
		p2 = new Projectile(50,400);

		// enemies = new Enemy[3];
		// enemies[0] = new Enemy(800,10);
		// enemies[1] = new Enemy(800,250);
		// enemies[2] = new Enemy(800,450);

		createEnemies();


    setFocusable(true);
    addKeyListener(this);
	}



	public Dimension getPreferredSize() {
		//Sets the size of the panel
        	return new Dimension(800,600);
	}



	public void paintComponent(Graphics g) {
    super.paintComponent(g);

		//draw black background
		g.setColor(black);
		g.fillRect(0,0,800,600);


//		g.setColor(black);
	//	g.fillRect(0,0,800,600);

		//draw the stars
		for(int i=0; i < starList.length; i++){
			starList[i].drawMe(g);
		}

		if(level == 2){
			for(int i=0; i < asteroidList.length; i++){
				asteroidList[i].drawMe(g);
			}
		}




		//Draw ship
		s1.drawMe(g);
		s2.drawMe(g);

		//draw enemies





		//Draw Projectile
		p1.drawMe(g);
		p2.drawMe(g);

		//Draw enemies
    // if( level == 1 ){
		    for(int i=0; i<enemies.length; i++)
			enemies[i].drawMe(g);
    // }

    // if( level == 2 ){
    //     for(int i=0; i<enemies2.length; i++)
    //   enemies2[i].drawMe(g);
    // }




		drawScore(g);

		g.setColor(white);
		g.drawString("level: " + level, 500, 30);

		if(level == 3){
			gameOver(g);
		}

		if( s1.lives == 0 /*&& s2.lives == 0*/ ){
			restart(g);

			s1.lives = 3; //add s2 lives
			s2.lives = 3;
			s1.reset(50,200);
			s2.reset(50,400);
			p1.reset(50,200);
			p2.reset(50,400);

			createEnemies();
			level = 1;

		}

	}

	public void restart(Graphics g){
		Font font = new Font("Arial", Font.PLAIN, 200);
		g.setColor(black);
		g.fillRect(0,0,800,600);
		g.setColor(white);
		g.drawString("RESTART", 300, 250);
	}

		public void gameOver(Graphics g){
			Font font = new Font("Arial", Font.PLAIN, 200);
			g.setColor(black);
			g.fillRect(0,0,800,600);
			g.setColor(white);
			g.drawString("GAME OVER", 300, 250);
		}

    public void drawScore(Graphics g){
    	Font font = new Font("Arial", Font.PLAIN, 30);  //30 represents the font size
    	g.setFont(font);
    	g.setColor(white);
    	g.drawString("Lives: " + s1.lives, 50, 50);
		//	g.drawString("P2 Lives: " + s2.lives, 50, 100);

    }

	private void createEnemies()
	{
		enemies = new Enemy[3];
		for(int i=0; i<enemies.length; i++){
			int randomY = (int)(Math.random()*551);
			int randomX = (int)(Math.random()*300+800);
			enemies[i] =  new Enemy(randomX,randomY);
		}

		enemies2 = new Enemy[5];
		//go though enemies2 setup each enemy in there
		for(int i=0; i<enemies2.length; i++){
			int randomY = (int)(Math.random()*551);
			int randomX = (int)(Math.random()*300+800);
			enemies2[i] =  new Enemy(randomX,randomY);
		}

	}


	public void animate(){

		while(true){

			//move each star
			for(int i=0; i<starList.length; i++){
				starList[i].move();
			}

			if( level == 2 ){
				for(int i=0; i<asteroidList.length; i++){
					asteroidList[i].move();
				}
			}

			//move enemies
			for(int i=0; i<enemies.length; i++){
				if(level == 1){
					enemies[i].move();
				}else if(level == 2){
					enemies[i].moveFast();
				}
					if(enemies[i].offScreen() == true){
	          s1.lives--;
					//	s2.lives--;
	          enemies[i].resetOffScreen();
					}
			}


			//move projectile
			p1.move();
			p2.move();

			//reset Projectile
			//when projectile is off Screen
				//bring it back to the ship
				//change fire to false
			if( p1.getX() > 800 ){
				p1.reset( s1.getX(), s1.getY() );
			}

			if( p2.getX() > 800 ){
				p2.reset( s2.getX(), s2.getY() );
			}


  			int totalDead = 0;
  			for(int i=0; i<enemies.length; i++){
  				if( enemies[i].isAlive() == false ){
  					totalDead++;
  				}
  			}

  			if( totalDead == 3 && level == 1 ){
  				level = 2;
					enemies = enemies2;

			} else if( level == 2 && totalDead == 5){
					level = 3;
				}



			//check collision with each Enemy
      // if( level == 1){
  			for(int i=0; i<enemies.length; i++){
  				p1.checkCollision(enemies[i]);
  				s1.checkCollision(enemies[i]);
					p2.checkCollision(enemies[i]);
  				s2.checkCollision(enemies[i]);
  			}
      // }

			//wait for .01 second
			try {
			    Thread.sleep(10);
			} catch(InterruptedException ex) {
			    Thread.currentThread().interrupt();
			}



			//repaint the graphics drawn
			repaint(); //only one repaint
		}

	}





  public void keyPressed(KeyEvent e){
    System.out.println( e.getKeyCode() );

		switch(e.getKeyCode()){
			case 38:
				//up
			 	s1.moveUp();
				if( !p1.isFiring() ){
					p1.moveUp();
				}
				break;

			case 40:
				//down
	      s1.moveDown();
	      if( !p1.isFiring() ){
			 		p1.moveDown();
				}
				break;

			case 10:
				p1.fire();
				break;

			//PLAYER 2
			case 87:
			//up
				s2.moveUp();
				if( !p2.isFiring() ){
					p2.moveUp();
				}
				break;

			case 83:
			//down
				s2.moveDown();
				if( !p2.isFiring() ){
					p2.moveDown();
				}
				break;

			case 32:
				p2.fire();
				break;

			case 80:
				if( level == 1 || level == 2 ){
					for(int i=0; i<enemies.length; i++){
					enemies[i].kill();
					}
				}
				break;

		}
	}





//
// //PLAYER UNO
//
//     if( e.getKeyCode() == 38 ){
//       //up
//       s1.moveUp();
// 			if( !p1.isFiring() ){
// 				p1.moveUp();
// 			}
//
//
//     } else if( e.getKeyCode() == 40 ){
//       //down
//       s1.moveDown();
//       if( !p1.isFiring() ){
// 				p1.moveDown();
// 			}
//
//
//
//     } else if( e.getKeyCode() == 10 ){
//       p1.fire();
//
//
//
// 			//PLAYER DOSE
//
//
// 		}else if( e.getKeyCode() == 87 ){
// 			//up
// 			s2.moveUp();
// 			if( !p2.isFiring() ){
// 				p2.moveUp();
// 			}
//
// 		} else if( e.getKeyCode() == 83 ){
// 			//down
// 			s2.moveDown();
// 			if( !p2.isFiring() ){
// 				p2.moveDown();
// 			}
//
//
// 		} else if( e.getKeyCode() == 32 ){
// 			p2.fire();



    // } else if( e.getKeyCode() == 80 ){
		// 	if( level == 1 || level == 2 ){
		// 		for(int i=0; i<enemies.length; i++){
		// 		enemies[i].kill();
		// 		}
		// 	}
		//
		// }



  //}



  public void keyReleased(KeyEvent e){}
  public void keyTyped(KeyEvent e){} //type is push down and release





}
