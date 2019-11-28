import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.*;
import java.util.Scanner;

public class ExempleURL {
	
	public static void main (String[] args) {
		//Creem el objecte URL
		URL url = null;
		Scanner teclado = new Scanner(System.in);
		
		try {
			
			System.out.println("Constructor per a protocol + URL + port: ");
			
			//Demanem un constructor
			System.out.println("Introdueix protocol: (Exemple: http, https)");
			String protocol = teclado.nextLine();
			
			//Demanem la URL
			System.out.println("Introdueix URL: (Exemple: doc.oracle.com, www.insbaixcamp.org)"); 
			String link = teclado.nextLine();
			
			//Demanem el port
			System.out.println("Introdueix un port: (Exemple: 80)");
			int port = teclado.nextInt();
			
			//Demanem el directori
			System.out.println("Introdueix un directori: (Exemple: /javase/7)");
			String directori = teclado.nextLine();
			
			url = new URL(protocol, link, port, directori);
			Visualitzar (url);
			
			System.out.println("Constructor simple per a un URL: ");
			url = new URL("http://docs.oracle.com/");
			Visualitzar (url);
			
			System.out.println("Altra constructor simple per a un URL: ");
			url = new URL("http://localhost/moodle/");
			Visualitzar (url);
			
			System.out.println("Constructor per a protocol + URL + directori: ");
			url = new URL("http", "doc.oracle.com", "/javase/7");
			Visualitzar (url);
			
			System.out.println("Constructor per a protocol + URL + port + directori: ");
			url = new URL("http", "doc.oracle.com", 80, "/javase/7");
			Visualitzar (url);
			
			System.out.println("Constructor per a un objecte URL i un directori: ");
			URL urlBase = new URL("http://docs.oracle.com/");
			url = new URL(urlBase, "/javase/7/docs/api/java/net/URL.html");
			Visualitzar (url);
			
		} catch (MalformedURLException e) { System.out.println(e); }
		BufferedReader in;
		try {
			
			InputStream inputStream = url.openStream();
			in = new BufferedReader(new InputStreamReader(inputStream));
			
			String inputLine;
			
			while ((inputLine = in.readLine()) != null)
				System.out.println(inputLine);
			in.close();
			
		} catch (IOException e) {e.printStackTrace(); }
	}
	
	//Metode per visualitzar les URL mitjançant el objecte URL i el metode visualitzar
	private static void Visualitzar(URL url) {
		
		System.out.println("\tURL complerta: "+url.toString());
		System.out.println("\tgetProtocol: "+url.getProtocol());
		System.out.println("\tgetHost: "+url.getHost());
		System.out.println("\tgetPort: "+url.getPort());
		System.out.println("\tgetFile: "+url.getFile());
		System.out.println("\tgetUserInfo: "+url.getUserInfo());
		System.out.println("\tgetPath: "+url.getPath());
		System.out.println("\tgetAuthority: "+url.getAuthority());
		System.out.println("\tgetQuery: "+url.getQuery());
		System.out.println("=====================================================");
	}

}
