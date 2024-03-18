import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Insets;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import java.awt.Point;

class Head2 extends JPanel{
	JButton Settings, Favorite,Stream;
	boolean settingVue = false;
	boolean favoriteVue = false;

	Head2(App root){
		setBackground(Color.WHITE);
		((FlowLayout)getLayout()).setAlignment(FlowLayout.LEFT);
		EmptyBorder empty = new EmptyBorder(0,0,0,0);

		setBorder(new RightBorder(false,false,true,false));

		Settings = new JButton(new ImageIcon("img/settings.png"));
		Favorite = new JButton(new ImageIcon("img/favorite.png"));
		Stream = new JButton(new ImageIcon("img/stream.png"));

		Settings.setBorder(empty);
		Favorite.setBorder(empty);
		Stream.setBorder(empty);

		Settings.addActionListener((e)->{
			Point p = getLocationOnScreen();
			int x = (new Double(p.getX())).intValue();
			int y = getHeight();

			root.settingModal.setVisible(!settingVue);
			root.settingModal.setBounds(x,y,300,400);
			settingVue = !settingVue;
		});

		Favorite.addActionListener((e)->{
			Point p = getLocationOnScreen();
			int x = (new Double(p.getX())).intValue();
			int y = getHeight();

			root.favoriteModal.validate();
			root.favoriteModal.repaint();
			root.favoriteModal.setVisible(!favoriteVue);
			root.favoriteModal.setBounds(x,y,300,400);
			favoriteVue = !favoriteVue;
		});

		add(Settings);
		add(Favorite);
		add(Stream);
	}

	public Insets getInsets(){
		return new Insets(0,0,30,0);
	}

	public Dimension getPreferredSize(){
		return new Dimension(690,50);
	}

	public Dimension getMaximumSize(){
		return getPreferredSize();
	}

	public Dimension getMinimumSize(){
		return getPreferredSize();
	}
}