package dv.dvdlibrary;

import dv.dvdlibrary.controller.DVDLibraryController;
import dv.dvdlibrary.dao.DVDLibraryDao;
import dv.dvdlibrary.dao.DVDLibraryDaoFileImpl;
import dv.dvdlibrary.ui.DVDLibraryView;
import dv.dvdlibrary.ui.UserIO;
import dv.dvdlibrary.ui.UserIOConsoleImpl;

public class App {
   public static void main(String[] args) {
      UserIO myIo = new UserIOConsoleImpl();
      DVDLibraryView myView = new DVDLibraryView(myIo);
      DVDLibraryDao myDao = new DVDLibraryDaoFileImpl();
      DVDLibraryController controller = new DVDLibraryController(myDao, myView);
      controller.run();
   }
}
