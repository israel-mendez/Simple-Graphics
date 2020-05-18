//ISRAEL MÉNDEZ CRESPO
//COMP2400 PROGRAMACIÓN ORIENTADA A OBJETOS

//ASIGNACIÓN 05: ANIMACIÓN DE BOTE Y GLOBO

import java.awt.*;

public class AnimaBoteGlobo extends java.applet.Applet
{
	public void paint (Graphics g)
	{
		Bote bote1 = new Bote();
		Globo globo1 = new Globo();
		Globo globo2 = new Globo();	
	
		for (int i = 0; i != -1;)
		{	 
		   while (i < 138)
			{
			Image img = getImage(getCodeBase(),"panorama.png");
			g.drawImage(img, 10,10,350,350,this);
			g.drawRect(10,10,350,350);
			bote1.moveRight(g,i);
			globo1.moveLeft(g,i+50);
			globo2.draw(g,-250,i,"RED");
			
			
			bote1.delayMiliSecs(15);
			i++;
			}//while
			
			while (i > 137 && i < 275)
			{
			Image img = getImage(getCodeBase(),"panorama.png");
			g.drawImage(img,10,10,350,350,this);
			g.drawRect(10,10,350,350);
			bote1.moveLeft(g,i-275);
			globo1.moveRight(g,i-325);
			globo2.draw(g,-250,-i+275,"RED");
			
			bote1.delayMiliSecs(15);
			i++;
			}//while
			
			if (i == 275)
			{
				i = 0; 
			}//if
		}//for

	}//Paint
//----------------------------------------------------------------------------------------------------------------------//	
	class Bote
	{
		int x,
			 y;
//----------------------------------------------------------------------------------------------------------------------//
		Bote()
		{
			x=0;
			y=0;
		}//No Argument Constructor
		Bote(int IniX,int IniY)
		{
			x=IniX;
			y=IniY;
		}//Argument Constructor
//----------------------------------------------------------------------------------------------------------------------//
		void draw(Graphics g, int moveDistance, String color)
		{
			String c = color;
			int d = moveDistance;
			
			int [] poly1x = {50+d, 180+d, 180+d, 50+d};
			int [] poly1y = {300 , 300  , 340  , 340 };//BoatBase
		
			int [] poly2x = {20+d, 50+d, 50+d};
			int [] poly2y = {300 , 300 , 340 };//RearBoatEdge
		
			int [] poly3x = {180+d, 210+d, 180+d};
			int [] poly3y = {300  , 300  , 340  };//FrontBoatEdge
		
			int [] poly4x = {103+d, 103+d,107+d,107+d};
			int [] poly4y = {170  , 300  ,300  ,170  };//MainMast
		
			int [] poly5x = {25+d, 25+d, 150+d, 150+d};
			int [] poly5y = {280 , 275 , 275  , 280  };//Boom
		
			int [] poly6x = {104+d, 104+d, 28+d};
			int [] poly6y = {274  , 173  , 274 };//MainSail
		
			int [] poly7x = {107+d, 140+d,107+d};
			int [] poly7y = {195  , 275  ,275  };//JibSail
			
			g.setColor(Color.ORANGE);
			g.fillPolygon(poly1x,poly1y,4);
			g.fillPolygon(poly2x,poly2y,3);
			g.fillPolygon(poly3x,poly3y,3);//Boat Base
		
			g.fillPolygon(poly4x,poly4y,4);//MainMast
			g.fillPolygon(poly5x,poly5y,4);//Boom
			
			switch(c)
			{
				case "RED" : 
				{
					g.setColor(Color.RED);
					break;
				}
				case "BLUE" : 
				{
					g.setColor(Color.BLUE);
					break;
				}	
				case "GREEN" : 
				{
					g.setColor(Color.GREEN);
					break;
				}	
				case "YELLOW" : 
				{
					g.setColor(Color.YELLOW);
					break;
				}	
				default :
				{
					g.setColor(Color.PINK);
				}
			}
			g.fillPolygon(poly6x,poly6y,3);//MainSail
			g.fillPolygon(poly7x,poly7y,3);//JibSail
		
		
			g.setColor(Color.BLACK);
			g.drawLine(poly2x[0],poly1y[0],poly3x[1],poly1y[0]);
			g.drawLine(poly2x[0],poly2y[0],poly2x[2],poly2y[2]);
			g.drawLine(poly2x[2],poly2y[2],poly3x[2],poly3y[2]);
			g.drawLine(poly3x[2],poly3y[2],poly3x[1],poly3y[1]);//BoatOutline
		
			g.drawLine(poly4x[0],poly4y[0],poly4x[1],poly4y[1]);
			g.drawLine(poly4x[1],poly4y[1],poly4x[2],poly4y[2]);
			g.drawLine(poly4x[2],poly4y[2],poly4x[3],poly4y[3]);
			g.drawLine(poly4x[3],poly4y[3],poly4x[0],poly4y[0]);//MainMastOutline
		
			g.drawLine(poly5x[0],poly5y[0],poly5x[1],poly5y[1]);
			g.drawLine(poly5x[1],poly5y[1],poly5x[2],poly5y[2]);
			g.drawLine(poly5x[2],poly5y[2],poly5x[3],poly5y[3]);
			g.drawLine(poly5x[3],poly5y[3],poly5x[0],poly5y[0]);//BoomOutline
		
			g.drawLine(poly6x[2],poly6y[2],poly6x[1]-1,poly6y[1]);//MainSailOutline
			g.drawLine(poly7x[0],poly7y[0],poly7x[1],poly7y[1]);//JibSailOutline
		
			g.drawLine(165+d,300,165+d,285);
			g.drawLine(161+d,295,165+d,300);
			g.drawLine(161+d,295,168+d,285);
			g.fillOval(160+d,275,10   ,10 );//SailorOutline

		}
//----------------------------------------------------------------------------------------------------------------------//
		void moveLeft(Graphics g,int moveDistance)
		{
			int d = 0;
			d = d - moveDistance;
			draw(g,d,"");
		}
		void moveRight(Graphics g,int moveDistance)
		{
			int d = 0;
			d = d + moveDistance;
			draw(g,d,"");
		}
//----------------------------------------------------------------------------------------------------------------------//
		void delayMiliSecs(int delay)
   	{
   		try
	 		{
	   		Thread.sleep(delay);
	 		}
	 		catch(InterruptedException e)
	 		{ 
			}
  		}
//----------------------------------------------------------------------------------------------------------------------//					
		void setColor(Graphics g,String color)
		{
			String c = color;
		   draw(g,0,c);
		}//setColor		
//----------------------------------------------------------------------------------------------------------------------//
	}//Bote
//----------------------------------------------------------------------------------------------------------------------//		
	class Globo
	{
		int x,
			 y;
//----------------------------------------------------------------------------------------------------------------------//			
		Globo()
		{
			x=0;
			y=0;
		}//No Argument Constructor
		Globo(int IniX, int IniY)
		{
			x=0;
			y=0;
		}//Argument Constructor	
//----------------------------------------------------------------------------------------------------------------------//	
		void draw(Graphics g, int moveDistanceX, int moveDistanceY, String color)
		{
			String c = color;
			int dx = moveDistanceX;
			int dy = moveDistanceY;
			
			switch(c)
			{
				case "RED" : 
				{
					g.setColor(Color.RED);
					break;
				}
				case "BLUE" : 
				{
					g.setColor(Color.BLUE);
					break;
				}	
				case "GREEN" : 
				{
					g.setColor(Color.GREEN);
					break;
				}	
				case "YELLOW" : 
				{
					g.setColor(Color.YELLOW);
					break;
				}	
				default :
				{
					g.setColor(Color.GREEN);
				}
			}
			g.fillOval(275+dx,25+dy,100,100);//Balloon
		
			g.setColor(Color.ORANGE);
			int [] poly1x = {295+dx,355+dx,335+dx,315+dx};
			int [] poly1y = {180+dy,180+dy,210+dy,210+dy};
		
			g.fillPolygon(poly1x,poly1y,4);//Basket
		
			g.setColor(Color.BLACK);
			g.drawLine(281+dx,50+dy,369+dx,50+dy);//Equator
		
			g.drawLine(281+dx,50+dy,300+dx,180+dy);
			g.drawLine(302+dx,50+dy,315+dx,180+dy);
			g.drawLine(347+dx,50+dy,335+dx,180+dy);
			g.drawLine(369+dx,50+dy,350+dx,180+dy);//EquatorLines
		
			g.drawLine(325+dx,180+dy,325+dx,170+dy);
			g.drawLine(315+dx,170+dy,325+dx,178+dy);
			g.drawLine(335+dx,170+dy,325+dx,178+dy);
			g.fillRect(320+dx,160+dy,10,10);//Ballonist
		
			g.drawOval(275+dx,25+dy,100,100);//BalloonOutline
			g.drawPolygon(poly1x,poly1y,4);//BasketOutline

		}//draw
//----------------------------------------------------------------------------------------------------------------------//		
		void moveUp(Graphics g, int moveDistance)
		{
			int d = 0;
			d = d - moveDistance;
			draw(g,0,d,"");
		}
		void moveDown(Graphics g, int moveDistance)
		{
			int d = 0;
			d = d + moveDistance;
			draw(g,0,d,"");
		}
		void moveLeft(Graphics g, int moveDistance)
		{
			int d = 0;
			d = d - moveDistance;
			draw(g,d,0,"");
		}
		void moveRight(Graphics g, int moveDistance)
		{
			int d = 0;
			d = d + moveDistance;
			draw(g,d,0,"");
		}
//----------------------------------------------------------------------------------------------------------------------//					
		void setColor(Graphics g,String color)
		{
			String c = color;
		   draw(g,0,0,"");
		}//setColor	
//----------------------------------------------------------------------------------------------------------------------//	
	}//Globo
//----------------------------------------------------------------------------------------------------------------------//		
}//Class