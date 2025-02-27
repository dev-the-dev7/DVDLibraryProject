package dv.dvdlibrary.controller;

import dv.dvdlibrary.dao.DVDLibraryDao;
import dv.dvdlibrary.dao.DVDLibraryDaoException;
import dv.dvdlibrary.dto.DVD;
import dv.dvdlibrary.ui.DVDLibraryView;
import java.util.List;

public class DVDLibraryController {
   private final DVDLibraryView view;
   private final DVDLibraryDao dao;

   public DVDLibraryController(DVDLibraryDao dao, DVDLibraryView view) {
      this.dao = dao;
      this.view = view;
   }

   public void run() {
      boolean keepGoing = true;
      int menuSelection = 0;

      try {
         this.dao.loadCollection();

         while(keepGoing) {
            menuSelection = this.getMenuSelection();
            switch (menuSelection) {
               case 1:
                  this.listDVDs();
                  break;
               case 2:
                  this.createDVD();
                  break;
               case 3:
                  this.viewDVD();
                  break;
               case 4:
                  this.removeDVD();
                  break;
               case 5:
                  keepGoing = false;
                  break;
               default:
                  this.unknownCommand();
            }
         }

         this.exitMessage();
      } catch (DVDLibraryDaoException e) {
         this.view.displayErrorMessage(e.getMessage());
      }

   }

   private int getMenuSelection() {
      return this.view.printMenuAndGetSelection();
   }

   private void createDVD() throws DVDLibraryDaoException {
      this.view.displayCreateDVDBanner();
      DVD newDVD = this.view.getNewDVDInfo();
      newDVD = this.dao.addDVD(newDVD.getTitle(), newDVD);
      this.view.displayCreateSuccessBanner(newDVD);
   }

   private void listDVDs() throws DVDLibraryDaoException {
      this.view.displayDisplayAllBanner();
      List<DVD> dvdList = this.dao.getAllDVDs();
      this.view.displayDVDList(dvdList);
   }

   private void viewDVD() throws DVDLibraryDaoException {
      this.view.displayDisplayDVDBanner();
      String title = this.view.getTitleChoice();
      DVD dvd = this.dao.getDVD(title);
      this.view.displayDVD(dvd);
   }

   private void removeDVD() throws DVDLibraryDaoException {
      this.view.displayRemoveDVDBanner();
      String title = this.view.getTitleChoice();
      DVD removedDVD = this.dao.removeDVD(title);
      this.view.displayRemoveResult(removedDVD);
   }

   private void unknownCommand() {
      this.view.displayUnknownCommandBanner();
   }

   private void exitMessage() {
      this.view.displayExitBanner();
   }
}
