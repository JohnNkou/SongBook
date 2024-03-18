import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;
import java.awt.Color;

class FavoriteModal extends JPanel{
	String message[] = { "Il est avec moi", "Je crois en sa parole", "il est tout puissant" };

	FavoriteModal(){
		super();

		int length = message.length;

		while(length-- != 0){
			add(new JLabel(message[length]));
		}

		setVisible(false);
		setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		setBorder(new LineBorder(Color.BLACK,1,true));
		setBackground(Color.WHITE);
	}
}