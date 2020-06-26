package CNPM;

public class News {

		private int IdNews;
		public int getIdNews() {
			return IdNews;
		}

		public void setIdNews(int idNews) {
			IdNews = idNews;
		}

		public String getTitle() {
			return Title;
		}

		public void setTitle(String title) {
			Title = title;
		}

		public String getLinktoWeb() {
			return LinktoWeb;
		}

		public void setLinktoWeb(String linktoWeb) {
			LinktoWeb = linktoWeb;
		}

		public String getDatepost() {
			return Datepost;
		}

		public void setDatepost(String datepost) {
			Datepost = datepost;
		}

		private String Title;
		private String LinktoWeb;
		private String Datepost;
		
	public News(int idNews, String title, String linktoWeb, String datepost) {
			super();
			IdNews = idNews;
			Title = title;
			LinktoWeb = linktoWeb;
			Datepost = datepost;
		}
	

	public News(String title, String linktoWeb, String datepost) {
		super();
		Title = title;
		LinktoWeb = linktoWeb;
		Datepost = datepost;
	}

	public News(String title, String date) {
		super();
		Title = title;
		Datepost = date;
	}

	public static void main(String[] args) {

	}

}
