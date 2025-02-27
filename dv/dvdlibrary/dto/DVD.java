package dv.dvdlibrary.dto;

public class DVD {
   private final String title;
   private String genre;
   private String releaseDate;
   private String mpaa;
   private String director;
   private String studio;
   private String userNotes;

   public DVD(String title) {
      this.title = title;
   }

   public String getTitle() {
      return this.title;
   }

   public String getGenre() {
      return this.genre;
   }

   public void setGenre(String genre) {
      this.genre = genre;
   }

   public String getReleaseDate() {
      return this.releaseDate;
   }

   public void setReleaseDate(String releaseDate) {
      this.releaseDate = releaseDate;
   }

   public String getMPAA() {
      return this.mpaa;
   }

   public void setMPAA(String mpaa) {
      this.mpaa = mpaa;
   }

   public String getDirector() {
      return this.director;
   }

   public void setDirector(String director) {
      this.director = director;
   }

   public String getStudio() {
      return this.studio;
   }

   public void setStudio(String studio) {
      this.studio = studio;
   }

   public String getUserNotes() {
      return this.userNotes;
   }

   public void setUserNotes(String userNotes) {
      this.userNotes = userNotes;
   }
}
