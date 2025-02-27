package dv.dvdlibrary.dao;

import dv.dvdlibrary.dto.DVD;
import java.util.List;

public interface DVDLibraryDao {
   void loadCollection() throws DVDLibraryDaoException;

   DVD addDVD(String dvdId, DVD dvd) throws DVDLibraryDaoException;

   List<DVD> getAllDVDs() throws DVDLibraryDaoException;

   DVD getDVD(String dvdId) throws DVDLibraryDaoException;

   DVD removeDVD(String dvdId) throws DVDLibraryDaoException;
}
