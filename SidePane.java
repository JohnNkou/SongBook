import javax.swing.JPanel;
import java.awt.Dimension;
import javax.swing.BoxLayout;


class SidePane extends JPanel{
	static Dimension dim = new Dimension(300,800);
	SidePane(App root){
		super();

		setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		setBorder(new RightBorder(false,true,false,false));

		add(new Head1(root));
		add(new SongList(root));
	}

	public Dimension getPreferredSize(){
		return new Dimension(SidePane.dim);
	}

	public Dimension getMaximumSize(){
		return getPreferredSize();
	}

	public Dimension getMinimumSize(){
		return getPreferredSize();
	}
}