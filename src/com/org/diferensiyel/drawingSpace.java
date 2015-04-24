package com.org.diferensiyel;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.util.ArrayList;

import javax.swing.JComponent;

public class drawingSpace extends JComponent
{
	Graphics2D gr;
	
	public int x1, y1;
	public int x, y;
	public ArrayList<Double> c;
	private double i;
	private int fY;
	public drawingSpace() 
	{
		c = new ArrayList<Double>();
		c.add((double) 0);
	}
	public void paint(Graphics g)
	{
		x = x1/2;
		y = y1/2;
		System.out.println(x + " " +y);
		gr =  (Graphics2D)g;
		gr.setColor(Color.RED);
		gr.setStroke(new BasicStroke(1));

		Line2D lX = new Line2D.Double(x, 0, x, y1);
		
		gr.draw(lX);
		gr.drawLine(0, y, x1, y);
		int j = c.size()-1;
		while(j>=0)
		{
			for(i = -x; i<x; i=i+0.1)
			{
				if(c.get(j)!=0)
				{
					
					gr.setColor(Color.BLUE);
					fY = (int) (c.get(j)*(i) + 10/c.get(j));
					gr.drawOval((int)i+x, y-fY, 1, 1);
					//fY = (int) ( ( (-1)*c.get(j) )*(i) + 1/( (-1)*c.get(j) ));
					//gr.drawOval(i+232, 250-fY, 1, 1);
				}
			}
			j--;
		}
		
	}
}
