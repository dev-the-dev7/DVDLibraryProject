package dv.dvdlibrary.ui;

public interface UserIO {
   void print(String message);

   String readString(String prompt);

   String readFormatString(String format);

   int readInt(String prompt);

   int readInt(String prompt, int min, int max);

   long readLong(String prompt);

   long readLong(String prompt, long min, long max);

   float readFloat(String prompt);

   float readFloat(String prompt, float min, float max);

   double readDouble(String prompt);

   double readDouble(String prompt, double min, double max);

   String readDate(String prompt);

   String readMPAA(String prompt);
}
