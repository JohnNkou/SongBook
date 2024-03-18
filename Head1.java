import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Point;
import javax.swing.border.EmptyBorder;

class Head1 extends JPanel{
	JButton bookICon;
	JTextField searchInput;
	boolean catVisible = false;

	Head1(App root){
		super();

		setLayout(new FlowLayout(FlowLayout.LEFT));

		bookICon = new JButton(new ImageIcon("img/cat.png"));
		searchInput = new JTextField(15);

		bookICon.setBorder(new EmptyBorder(0,0,0,0));

		bookICon.addActionListener((e)->{
			Point p = getLocationOnScreen();
			int x = (new Double(p.getX())).intValue();
			int y = (new Double(p.getY())).intValue();

			root.categorieModal.setVisible(!catVisible);
			root.categorieModal.setBounds(x,getHeight(),300,300);

			catVisible = !catVisible;
		});

		add(bookICon);
		add(searchInput);
	}

	public Dimension getPreferredSize(){
		return new Dimension( 300,50);
	}

	public Dimension getMaximumSize(){
		return getPreferredSize();
	}

	public Dimension getMinimumSize(){
		return getPreferredSize();
	}
}