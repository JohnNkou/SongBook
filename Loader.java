import java.net.http.HttpClient;
import java.net.http.HttpResponse;
import java.net.http.HttpRequest;
import java.net.URI;
import org.json.JSONArray;
import org.json.JSONObject;
import java.util.ArrayList;
import javax.swing.SwingUtilities;
import java.awt.Color;
import org.json.JSONArray;
import org.json.JSONObject;

public class Loader extends Thread{
	URI url = URI.create("http://localhost/api/Categorie?action=getAll");
	String songUrl= "http://localhost/api/Song?action=getAll";
	boolean fetchSongs = false;
	boolean fetchCats = false;
	String catId;
	HttpClient client;
	SongList songList;
	CatNames Categories;
	Object locker = new Object();

	Loader(){
		client = HttpClient.newHttpClient();
	}

	public void setSongList(SongList s){
		songList = s;
	}

	public void setCatNames(CatNames cats){
		Categories = cats;
	}

	private void fetchCategories(){
		try{
			System.out.println("Fetching categorie");
			Categories.updateCats(fetch(url).getJSONArray("data"));
		}
		catch(Exception e){
			System.err.println("Erreur while fetching Categorie");
			System.err.println(e);
		}
	}

	private void fetchSongs(){
		try{
			if(catId.length() > 0){
				URI url = URI.create(songUrl + "&catId="+catId);

				System.out.println("FetchSongs url "+url);
				JSONObject data = fetch(url);

				songList.updateSongs(data.getJSONArray("data"));
			}
			else{
				System.err.println("No catId given");
			}
		}
		catch(Exception err){
			System.err.println("FetchSongs error "+err);
		}
	}

	private JSONObject fetch(URI url) throws Exception{
		HttpRequest req = HttpRequest.newBuilder().GET().uri(url).build();
		HttpResponse<String> res = client.send(req,HttpResponse.BodyHandlers.ofString());
		String body = res.body();

		return new JSONObject(body);
	}

	public void hey(){
		synchronized(locker){
			locker.notify();
		}
	}

	public void run(){
		while(true){
			try{
				synchronized(locker){
					if(fetchCats){
						fetchCategories();
					}
					if(fetchSongs){
						fetchSongs();
					}

					fetchCats = false;
					fetchSongs = false;

					System.out.println("waiting");

					locker.wait();
				}
			}
			catch(InterruptedException err){
				System.err.println(err);
			}
		}
	}
}