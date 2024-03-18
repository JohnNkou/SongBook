import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Dimension;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import java.awt.Container;
import java.awt.Color;
import javax.swing.JLayeredPane;

class App extends JFrame{
	protected Content content;
	protected SettingModal settingModal;
	protected FavoriteModal favoriteModal;
	protected CatNames categorieModal;
	Loader loader;

	static Dimension dim = new Dimension(1000,800);
	App (){
		Container ContentPane = getContentPane();
		JLayeredPane lPane = getLayeredPane();
		settingModal = new SettingModal();
		favoriteModal = new FavoriteModal();
		loader = new Loader();

		loader.start();
		
		categorieModal = new CatNames(loader);

		ContentPane.add(new SidePane(this));
		ContentPane.add(new Second(this));
		lPane.add(settingModal,JLayeredPane.POPUP_LAYER);
		lPane.add(favoriteModal,JLayeredPane.POPUP_LAYER);
		lPane.add(categorieModal,JLayeredPane.POPUP_LAYER);

		setLayout(new FlowLayout(FlowLayout.LEFT));
		ContentPane.setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setSize(App.dim);
	}

	protected void setContent(Content c){
		content = c;
	}
}