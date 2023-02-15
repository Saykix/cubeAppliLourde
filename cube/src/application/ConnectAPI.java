package application;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.http.HttpClient;

import org.json.JSONArray;
import org.json.JSONObject;

import Class.utilisateur;

public class ConnectAPI {
	public static Object sendGetRequest() {
		URL url;
		try {
			url = new URL("https://localhost:7257/api/Article");
			try {
				HttpURLConnection con = (HttpURLConnection)url.openConnection();
				con.setRequestMethod("GET");
				con.setRequestProperty("Content-Type", "application/json");
				System.out.println("status : " + con.getResponseCode());
				
				String line = "";
				InputStreamReader input = new InputStreamReader(con.getInputStream());
				BufferedReader reader = new BufferedReader(input);
				StringBuilder response = new StringBuilder();
				while((line=reader.readLine()) != null) {
					response.append(line);
				}
				
				reader.close();
				
				System.out.println("Response : " + response.toString());
				parseJsonResponse();
				return response;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("Error in get method");
				return null;
			}
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Error in get method");
				return null;
		}
	}
	
	public static Object sendPostRequest() {
		URL url;
//		String string = "{\"name\": \"Sam Smith\", \"technology\": \"Python\"}";  
//		JSONObject json = new JSONObject(string);    
		String post_data ="{'prenom': 'b', 'nom':'b','email': 'b',  'mot_de_passe': 'b', 'adresse': 'b', 'code_postal': 'b', 'ville': 'b', 'numero_de_telephone' : 'b', 'admin': 'true'}";
		JSONObject json = new JSONObject(post_data); 
//		utilisateur toto = new utilisateur("b", "b", "b", "b", "b", "b", "b", "b", "b", true);

		post_data.toString();
		try {
			url = new URL("https://localhost:7257/api/Utilisateur");
			try {
				HttpURLConnection con = (HttpURLConnection)url.openConnection();
				con.setRequestMethod("POST");
				con.setRequestProperty("Content-Type", "application/json");
				con.setDoOutput(true);
//				OutputStream output = con.getOutputStream();
//				OutputStreamWriter writer = new OutputStreamWriter(output);
				try(OutputStream os = con.getOutputStream()) {
				    byte[] input = post_data.toString().getBytes("utf-8");
				    os.write(input, 0, input.length);	
				}
//				writer.write(post_data);
//				writer.flush();
//				writer.close();
				System.out.println("status : " + con.getResponseCode());
				String line = "";
				InputStreamReader input = new InputStreamReader(con.getInputStream());
				BufferedReader reader = new BufferedReader(input);
				StringBuilder response = new StringBuilder();
				while((line=reader.readLine()) != null) {
					response.append(line);
				}
				reader.close();
				System.out.println("Response : " + response.toString());
				return response;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("Error in post method");
				return null;
			}
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Error in post method");
				return null;
		}
	}
	public static Object parseJsonResponse() {
		URL url;
		try {
			url = new URL("https://localhost:7257/api/Article");
			try {
				HttpURLConnection con = (HttpURLConnection)url.openConnection();
				con.setRequestMethod("GET");
				
				System.out.println("status : " + con.getResponseCode());
				
				String line = "";
				InputStreamReader input = new InputStreamReader(con.getInputStream());
				BufferedReader reader = new BufferedReader(input);
				StringBuilder response = new StringBuilder();
				while((line=reader.readLine()) != null) {
					response.append(line);
				}
				
				reader.close();
				
				System.out.println("Response : " + response.toString());
				
				JSONArray jsonArray = new JSONArray(response.toString());
				
				for(int i = 0; i < jsonArray.length(); i++) {
					System.out.println("IdArticle : " + jsonArray.getJSONObject(i).getInt("IdArticle"));
					System.out.println("nomArticle : " + jsonArray.getJSONObject(i).getString("nomArticle"));
					System.out.println("anneeArticle : " + jsonArray.getJSONObject(i).getString("anneeArticle"));
					System.out.println("prixUnitaireArticle : " + jsonArray.getJSONObject(i).getString("prixUnitaireArticle"));
					System.out.println("prixCartonArticle : " + jsonArray.getJSONObject(i).getString("prixCartonArticle"));
					System.out.println("prixFournisseurArticle : " + jsonArray.getJSONObject(i).getString("prixFournisseurArticle"));
					System.out.println("referenceArticle : " + jsonArray.getJSONObject(i).getString("referenceArticle"));
					System.out.println("tvaArticle : " + jsonArray.getJSONObject(i).getString("tvaArticle"));
					System.out.println("domaineArticle : " + jsonArray.getJSONObject(i).getString("domaineArticle"));
					System.out.println("descriptionArticle : " + jsonArray.getJSONObject(i).getString("descriptionArticle"));
					System.out.println("familleArticle : " + jsonArray.getJSONObject(i).getString("familleArticle"));
					System.out.println("coutStockageArticle : " + jsonArray.getJSONObject(i).getString("coutStockageArticle"));
					System.out.println("=========================================================\n");
				}
				return response;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("Error in get method");
				return null;
			}
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Error in get method");
				return null;
		}
	}
}