package dv.dvdlibrary.ui;

import dv.dvdlibrary.dto.DVD;
import java.util.Iterator;
import java.util.List;

public class DVDLibraryView {
   private final UserIO io;
   public static final String DELIMITER = " | ";

   public DVDLibraryView(UserIO io) {
      this.io = io;
   }

   public int printMenuAndGetSelection() {
      this.io.print("Main Menu");
      this.io.print("1. List DVDs");
      this.io.print("2. Create New DVD");
      this.io.print("3. View a DVD");
      this.io.print("4. Remove a DVD");
      this.io.print("5. Exit");
      return this.io.readInt("Please select from the above choices.", 1, 5);
   }

   public void displayCreateDVDBanner() {
      this.io.print("=== Create DVD ===");
   }

   public DVD getNewDVDInfo() {
      String title = this.io.readFormatString("Please enter title");
      String genre = this.io.readFormatString("Please enter genre");
      String releaseDate = this.io.readDate("Please enter the release date (dd/MM/yyyy)");
      String mpaa = this.io.readMPAA("Please enter the MPAA rating (G, PG, PG-13, R, NC-17)");
      String director = this.io.readFormatString("Please enter the director's name");
      String studio = this.io.readFormatString("Please enter the studio");
      String userNotes = this.io.readFormatString("Please enter any personal notesabout the DVD (review, feedback, etc.)");
      DVD currentDVD = new DVD(title);
      currentDVD.setGenre(genre);
      currentDVD.setReleaseDate(releaseDate);
      currentDVD.setMPAA(mpaa);
      currentDVD.setDirector(director);
      currentDVD.setStudio(studio);
      currentDVD.setUserNotes(userNotes);
      return currentDVD;
   }

   public void displayCreateSuccessBanner(DVD dvd) {
      if (dvd == null) {
         this.io.print("DVD successfully created.");
      } else {
         this.io.print("DVD " + dvd.getTitle() + " already exist.");
      }

      this.io.readString("Please hit enter to continue.");
   }

   public void displayDisplayAllBanner() {
      this.io.print("=== Display All DVDs ===");
   }

   public void displayDVDInfo(DVD dvd) {
      String dvdInfo = String.join(" | ", "Title: " + dvd.getTitle(), "Genre: " + dvd.getGenre(), "ReleaseDate: " + dvd.getReleaseDate(), "MPAA Rating: " + dvd.getMPAA(), "Director: " + dvd.getDirector(), "Studio: " + dvd.getStudio(), "Notes: " + dvd.getUserNotes());
      this.io.print(dvdInfo);
   }

   public void displayDVDList(List<DVD> dvdList) {
      Iterator<DVD> iterator = dvdList.iterator();

      while(iterator.hasNext()) {
         DVD currentDVD = (DVD)iterator.next();
         this.displayDVDInfo(currentDVD);
      }

      if (dvdList.isEmpty()) {
         this.io.print("- No DVDs registered -");
      }

      this.io.readString("Please hit enter to continue.");
   }

   public void displayDisplayDVDBanner() {
      this.io.print("=== Display DVD ===");
   }

   public String getTitleChoice() {
      return this.io.readString("Please enter the DVD title.");
   }

   public void displayDVD(DVD dvd) {
      if (dvd != null) {
         this.displayDVDInfo(dvd);
      } else {
         this.io.print("DVD not found.");
      }

      this.io.readString("Please hit enter to continue.");
   }

   public void displayRemoveDVDBanner() {
      this.io.print("=== Remove DVD ===");
   }

   public void displayRemoveResult(DVD dvdRecord) {
      if (dvdRecord != null) {
         this.io.print("DVD successfully removed.");
      } else {
         this.io.print("DVD not found.");
      }

      this.io.readString("Please hit enter to continue.");
   }

   public void displayExitBanner() {
      this.io.print("Good Bye!!!");
   }

   public void displayUnknownCommandBanner() {
      this.io.print("Unknown Command!!!");
   }

   public void displayErrorMessage(String errorMsg) {
      this.io.print("=== ERROR ===");
      this.io.print(errorMsg);
   }
}
