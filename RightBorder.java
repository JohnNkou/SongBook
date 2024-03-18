import javax.swing.border.EmptyBorder;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Color;

class RightBorder extends EmptyBorder{
	boolean top,right,bottom,left;

	RightBorder(boolean t, boolean r, boolean b, boolean l){
		super(10,10,10,10);

		top = t;
		right = r;
		bottom = b;
		left = l;
	}

	public void paintBorder(Component c, Graphics g, int x, int y, int width, int height){
		super.paintBorder(c,g,x,y,width,height);

		g.setColor(Color.BLACK);

		if(left){
			g.drawLine(x, y, 2, height);
		}
		if(top){
			g.drawLine(x,y,width,2);
		}
		if(bottom){
			int new_y = y + height - 1;
			int new_x = x + width - 1;

			g.drawLine(x,new_y,new_x,new_y);
		}

		if(right){
			int new_x = 299;
			int y2 = height;

			g.drawLine(new_x,0,new_x,y2);
		}
	}
}