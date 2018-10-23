package br.com.cast.getmovie.dto;

public class WatchDTO {
	private Integer id;
	private UserDTO userDTO;
	private MovieDTO movieDTO;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public UserDTO getUserDTO() {
		return userDTO;
	}
	public void setUserDTO(UserDTO userDTO) {
		this.userDTO = userDTO;
	}
	public MovieDTO getMovieDTO() {
		return movieDTO;
	}
	public void setMovieDTO(MovieDTO movieDTO) {
		this.movieDTO = movieDTO;
	}
	
	

}
