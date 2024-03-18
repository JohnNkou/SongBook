import javax.swing.JPanel;
import org.json.JSONArray;
import org.json.JSONObject;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.BoxLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class CatNames extends JPanel{
	Loader loader;
	CatNames(Loader loader){
		super();
		this.loader = loader;

		loader.setCatNames(this);
		loader.fetchCats = true;

		System.out.println("Notifying");

		loader.hey();

		setBackground(Color.WHITE);
		setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		setVisible(false);
	}

	public void updateCats(JSONArray cats){
		int length = cats.length();
		CatNames self = this;

		System.out.println("Updating cats");

		try{
			for (int i=0; i < length; i++) {
				JSONObject current = cats.getJSONObject(i);
				JLabel l = new JLabel(current.getString("name"));

				l.addMouseListener(new MouseAdapter(){
					String i = current.getString("id");
					@Override
					public void mouseClicked(MouseEvent e){
						loader.catId = i;
						loader.fetchSongs = true;
						loader.hey();

						self.setVisible(false);
					}
				});

				add(l);
			}
		}
		catch(Exception err){
			System.err.println("updateCats Error "+err);
		}

		validate();
		repaint();
	}
}