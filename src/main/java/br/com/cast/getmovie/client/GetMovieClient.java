package br.com.cast.getmovie.client;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import br.com.cast.getmovie.dto.MovieDTO;

@Component
public class GetMovieClient {
	
	private static final String KEY = "5770f373";
	private static final String API_URL = "http://www.omdbapi.com/?t={title}&apikey={key}";
	
	private RestTemplate restTemplate;
	
	private GetMovieClient(RestTemplateBuilder builder){
		this.restTemplate = builder.build();
	}
	
	public MovieDTO searchByTitleOnAPI(String title){
		MovieDTO movieDTO = this.restTemplate.getForObject(API_URL, 
				MovieDTO.class, title, KEY);
		
		return movieDTO;
	}
}
