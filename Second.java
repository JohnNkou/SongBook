import javax.swing.JPanel;
import java.awt.Dimension;
import javax.swing.BoxLayout;
import java.awt.Color;

class Second extends JPanel{
	static private Dimension dim = new Dimension(690,800);
	App root;

	Second(App r){
		super();

		root = r;

		setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		setBackground(Color.WHITE);

		Content content = new Content();

		root.setContent(content);

		add(new Head2(r));
		add(content);
	}

	public Dimension getPreferredSize(){
		return dim;
	}
	public Dimension getMaximumSize(){
		return getPreferredSize();
	}
	public Dimension getMinimumSize(){
		return getPreferredSize();
	}
}