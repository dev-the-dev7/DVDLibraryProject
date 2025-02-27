package dv.dvdlibrary.dao;

import dv.dvdlibrary.dto.DVD;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class DVDLibraryDaoFileImpl implements DVDLibraryDao {
   public static final String COLLECTION_FILE = "collection.txt";
   public static final String DELIMITER = "::";
   private Map<String, DVD> dvds = new HashMap<String, DVD>();

   public DVD addDVD(String title, DVD dvd) throws DVDLibraryDaoException {
      DVD newDVD = (DVD)this.dvds.put(title, dvd);
      this.writeCollection();
      return newDVD;
   }

   public List<DVD> getAllDVDs() throws DVDLibraryDaoException {
      return new ArrayList<DVD>(this.dvds.values());
   }

   public DVD getDVD(String title) throws DVDLibraryDaoException {
      return (DVD)this.dvds.get(title);
   }

   public DVD removeDVD(String title) throws DVDLibraryDaoException {
      DVD removedDVD = (DVD)this.dvds.remove(title);
      this.writeCollection();
      return removedDVD;
   }

   private DVD unmarshallDVD(String dvdAsText) {
      String[] dvdTokens = dvdAsText.split("::");
      DVD dvdFromFile = new DVD(dvdTokens[0]);
      dvdFromFile.setGenre(dvdTokens[1]);
      dvdFromFile.setReleaseDate(dvdTokens[2]);
      dvdFromFile.setMPAA(dvdTokens[3]);
      dvdFromFile.setDirector(dvdTokens[4]);
      dvdFromFile.setStudio(dvdTokens[5]);
      dvdFromFile.setUserNotes(dvdTokens[6]);
      return dvdFromFile;
   }

   public void loadCollection() throws DVDLibraryDaoException {
      Scanner sc;
      try {
         sc = new Scanner(new BufferedReader(new FileReader("collection.txt")));
      } catch (FileNotFoundException e) {
         throw new DVDLibraryDaoException("(\u00b4\u03b5`\uff1b) Could not load roster data into memory.", e);
      }

      while(sc.hasNextLine()) {
         String currentLine = sc.nextLine();
         DVD currentDVD = this.unmarshallDVD(currentLine);
         this.dvds.put(currentDVD.getTitle(), currentDVD);
      }

      sc.close();
   }

   private String marshallDVD(DVD aDVD) {
      String dvdAsText = String.join("::", aDVD.getTitle(), aDVD.getGenre(), aDVD.getReleaseDate(), aDVD.getMPAA(), aDVD.getDirector(), aDVD.getStudio(), aDVD.getUserNotes());
      return dvdAsText;
   }

   private void writeCollection() throws DVDLibraryDaoException {
      PrintWriter out;
      try {
         out = new PrintWriter(new FileWriter("collection.txt"));
      } catch (IOException e) {
         throw new DVDLibraryDaoException("Could not save dvd data.", e);
      }

      List<DVD> dvdList = new ArrayList<DVD>(this.dvds.values());
      Iterator<DVD> iterator = dvdList.iterator();


      while(iterator.hasNext()) {
         DVD currentDVD = (DVD)iterator.next();
         String dvdAsText = this.marshallDVD(currentDVD);
         out.println(dvdAsText);
         out.flush();
      }

      out.close();
   }
}
