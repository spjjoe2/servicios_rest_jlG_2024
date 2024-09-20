

package model;

public class Resultado {
	private String url;
	private String tematica; 
	private String comentario;
	public Resultado(String url, String temática, String comentario) {
		super();
		this.url = url;
		this.tematica = temática;
		this.comentario = comentario;
	}
	
	
	public Resultado() {
		super();
		// TODO Auto-generated constructor stub
	}


	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getTematica() {
		return tematica;
	}
	public void setTematica(String temática) {
		this.tematica = temática;
	}
	public String getComentario() {
		return comentario;
	}
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	
	
}
