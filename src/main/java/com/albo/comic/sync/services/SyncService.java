package com.albo.comic.sync.services;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.albo.comic.sync.entities.character.CharacterMarvelResponse;
import com.albo.comic.sync.entities.comic.ComicMarvelResponse;
import com.albo.comic.utils.Helpers;
import com.albo.comic.utils.MD5Hash;

@Service
public class SyncService {
	
	@Value("${env.apiurl}")
	private String apiurl;
	
	@Value("${env.apikey}")
	private String apikey;
	
	@Value("${env.privatekey}")
	private String privatekey;
	
	RestTemplate restTemplate = null;
	
	public SyncService() {
		restTemplate = new RestTemplate();
	}
	
	public CharacterMarvelResponse getMarvelCharacterByName(String name) {
		String endpoint = "/characters?name=" + name;
		String url = buildQuery(endpoint);
		return restTemplate.getForObject(url, CharacterMarvelResponse.class);
	}

	public ComicMarvelResponse getComicsByCharacterId(Long characterId, int page, Boolean updateLastDay, Date lastSync) {
		String updateSt = updateLastDay == true ? "&modifiedSince=" + Helpers.marvelFormattedDate(lastSync) : "";
		String endpoint = "/characters/" + characterId + "/comics?format=comic&formatType=comic&limit=100&offset=" + page + updateSt;
		String url = buildQuery(endpoint);
		return restTemplate.getForObject(url, ComicMarvelResponse.class);
	}
	
	private String buildQuery(String endpoint) {
		String ts = Helpers.getCurrentTimestamp();
		String dataToHash = ts + privatekey + apikey;
		String hash = MD5Hash.generator(dataToHash);
		return apiurl + endpoint + "&ts=" + ts + "&apikey=" + apikey + "&hash=" + hash;
	}
}
