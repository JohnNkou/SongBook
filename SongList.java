import javax.swing.JPanel;
import java.util.ArrayList;
import org.json.JSONObject;
import org.json.JSONArray;
import javax.swing.JList;
import javax.swing.JScrollPane;
import java.util.Vector;
import java.awt.Insets;
import java.awt.FlowLayout;
import java.awt.Color;

class SongList extends JPanel{
	ArrayList<JSONObject> songs = new ArrayList<JSONObject>();
	JList<String> p;
	App root;
	Loader updater;
	JScrollPane scroller;

	SongList(App r){
		super();

		root = r;

		root.loader.setSongList(this);

		setLayout(new FlowLayout());
		//setBorder(new LineBorder(Color.BLACK));
		setBackground(Color.WHITE);
	}

	public void updateSongs(JSONArray songs){
		int length = songs.length();
		SongList self = this;
		Vector<String> ss = new Vector<String>(length);

		removeAll();

		for (int c=0; c < length; c++) {
			JSONObject song = songs.getJSONObject(c);
			String name = song.getString("name");

			ss.add(name);
		}

		p = new JList<String>(ss);
		scroller = new JScrollPane(p){
			public Insets getInsets(){
				return new Insets(0,40,0,0);
			}
		};

		p.addListSelectionListener((e)->{
			root.content.setTitle(p.getSelectedValue());
		});

		add(scroller);

		validate();
		repaint();
	}
}