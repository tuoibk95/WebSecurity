package Bai2;

public class CD {
	private String artist;
	private String title;
	
	public CD() {
		
	}
	
	public CD(String artist, String title) {
		this.artist = artist;
		this.title = title;
	}
	/**
	 * @return the artist
	 */
	public String getArtist() {
		return artist;
	}
	/**
	 * @param artist the artist to set
	 */
	public void setArtist(String artist) {
		this.artist = artist;
	}
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	
	@Override
	public String toString() {
		return "CD này có tiêu đề là: " + title + " của ca sĩ: " + artist;
	}
}
