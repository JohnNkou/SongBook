import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Dimension;
import java.awt.Color;
import javax.swing.border.LineBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SettingModal extends JPanel{
	String message[] = { "JE crois que nous pouvons", "avec la force que nous avons", "arrive a un concenssus" };

	SettingModal(){
		super();

		int length = message.length;
		SettingModal self = this;

		while(length-- != 0){
			add(new JLabel(message[length]));

			setBackground(Color.WHITE);
			setBorder(new LineBorder(Color.BLACK,1,true));
		}

		setVisible(false);

		addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				System.out.println("Gaga");
				self.setVisible(false);
			}
		});
	}
}