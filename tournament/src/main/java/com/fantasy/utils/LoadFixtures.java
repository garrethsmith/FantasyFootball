package com.fantasy.utils;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

import com.fantasy.dao.FixtureDAO;
import com.fantasy.model.Fixture;

public class LoadFixtures {
	
	private String fixtureUrl;
	private FixtureDAO dao;
	
	public void init () throws Exception {
		List<Fixture> loadedfixtures = dao.getAllFixtures();
		List<Fixture> unloadedFixtures = getFixtures();
		
		if (loadedfixtures != null && unloadedFixtures != null) {
			// Assumption loaded fixtures are in unloaded through the json
			for (Fixture f: loadedfixtures) {
				if (unloadedFixtures.contains(f)) {
					System.out.println("Found match... " + f.getGameid());
					unloadedFixtures.remove(f);
				}
			}
			
			if (unloadedFixtures.size() > 0)
				dao.loadFixtures (unloadedFixtures);
		}
		
	}
	
	private List<Fixture> getFixtures () throws IOException, ParseException {
		String url = "C:/tmp/data.json";
		JSONObject json;
		List<Fixture> result = new ArrayList<Fixture>();
		
		// TODO: Rewrite to read from URL 
		// InputStream is = new URL(url).openStream();
		FileInputStream is = new FileInputStream(url);
	    try {
	      BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
	      String jsonText = readAll(rd);
	      json = new JSONObject(jsonText);
	    } finally {
	      is.close();
	    }
	    
	    JSONObject data = json.getJSONObject("data");
	    JSONArray rounds = data.getJSONArray("rounds");
	    
	    for (int i=0; i<rounds.length(); i++) {
	    	JSONObject obj = rounds.getJSONObject(i);
	    		    	
	    	Fixture f = new Fixture(obj.getInt("identifier"), 
	    			obj.getString("home_team"),
	    			obj.getString("away_team"),
	    			new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").parse(obj.getString("date_match").substring(0, 19)),
	    			obj.getString("match_result"),
	    			obj.getString("name"));
	    	result.add(f);
	    }
	    
	    return result;
	}
	
	private String readAll(Reader rd) throws IOException {
	    StringBuilder sb = new StringBuilder();
	    int cp;
	    while ((cp = rd.read()) != -1) {
	      sb.append((char) cp);
	    }
	    return sb.toString();
	  }
	
	public FixtureDAO getDao() {
		return dao;
	}

	@Autowired
	public void setDao(FixtureDAO dao) {
		this.dao = dao;
	}

	public String getFixtureUrl() {
		return fixtureUrl;
	}

	public void setFixtureUrl(String fixtureUrl) {
		this.fixtureUrl = fixtureUrl;
	}
}
