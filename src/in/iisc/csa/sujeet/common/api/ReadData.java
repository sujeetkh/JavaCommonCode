package in.iisc.csa.sujeet.common.api;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URL;

import javax.ws.rs.core.MediaType;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.codehaus.jackson.map.ObjectMapper;

import in.iisc.csa.sujeet.common.pojo.LogType;

public class ReadData {

	public static void printAsString(String url) throws Exception {
		DefaultHttpClient httpClient = new DefaultHttpClient();
		HttpParams params = httpClient.getParams();
		HttpConnectionParams.setConnectionTimeout(params, 10000);
		HttpConnectionParams.setSoTimeout(params, 10000);

		URI uri;
		uri = new URI(url);
		HttpPost post = new HttpPost(uri);
		post.setHeader("Content-Type", MediaType.APPLICATION_JSON);

		HttpResponse response = httpClient.execute(post);

		BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));

		StringBuffer result = new StringBuffer();
		String line = "";
		while ((line = rd.readLine()) != null) {
			result.append(line);
		}
		System.out.println(result.toString());
	}

	public static void readIntoClass(String urlString) throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		URL url = new URL(urlString);
		LogType[] logs = mapper.readValue(url, LogType[].class);
		for (LogType log : logs)
			System.out.println(log.getLogtype() + ":" + log.getUniquekey());
	}

	public static void main(String[] args) throws Exception {
		String url = "";
		readIntoClass(url);

	}
}
