import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Color;

class Content extends JPanel{
	JLabel title;
	Content(){
		super();

		setBackground(Color.WHITE);

		title = new JLabel("Je suis la");

		add(title);
	}

	public void setTitle(String t){
		title.setText(t);

		validate();
		repaint();
	}
}