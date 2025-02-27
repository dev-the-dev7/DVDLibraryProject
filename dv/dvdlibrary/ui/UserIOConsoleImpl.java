package dv.dvdlibrary.ui;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class UserIOConsoleImpl implements UserIO {
   private final Scanner sc;

   public UserIOConsoleImpl() {
      this.sc = new Scanner(System.in);
   }

   public void print(String msg) {
      System.out.println(msg);
   }

   public String readString(String prompt) {
      this.print(prompt);
      return this.sc.nextLine();
   }

   public String readFormatString(String prompt) {
      return this.readString(prompt).trim().replaceAll("::|:$", "");
   }

   public int readInt(String prompt) {
      while(true) {
         try {
            String userInput = this.readString(prompt);
            return Integer.parseInt(userInput);
         } catch (NumberFormatException e) {
            this.print("You must enter a valid integer!");
         }
      }
   }

   public int readInt(String prompt, int min, int max) {
      int val;
      do {
         val = this.readInt(prompt);
      } while(val < min || val > max);

      return val;
   }

   public long readLong(String prompt) {
      while(true) {
         try {
            this.print(prompt);
            String userInput = this.sc.nextLine();
            return Long.parseLong(userInput);
         } catch (NumberFormatException e) {
            this.print("You must enter a valid long!");
         }
      }
   }

   public long readLong(String prompt, long min, long max) {
      long val;
      do {
         val = this.readLong(prompt);
      } while(val < min || val > max);

      return val;
   }

   public float readFloat(String prompt) {
      while(true) {
         try {
            String userInput = this.readString(prompt);
            return Float.parseFloat(userInput);
         } catch (NumberFormatException e) {
            this.print("You must enter a valid float!");
         }
      }
   }

   public float readFloat(String prompt, float min, float max) {
      float val;
      do {
         val = this.readFloat(prompt);
      } while(val < min || val > max);

      return val;
   }

   public double readDouble(String prompt) {
      while(true) {
         try {
            String userInput = this.sc.nextLine();
            return Double.parseDouble(userInput);
         } catch (NumberFormatException e) {
            this.print("You must enter a valid double!");
         }
      }
   }

   public double readDouble(String prompt, double min, double max) {
      double val;
      do {
         val = this.readDouble(prompt);
      } while(val < min || val > max);

      return val;
   }

   public String readDate(String prompt) {
      DateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

      while(true) {
         try {
            String date = this.readString(prompt).trim();
            sdf.parse(date);
            return date;
         } catch (ParseException e) {
            this.print("You must enter a valid date!");
         }
      }
   }

   public String readMPAA(String prompt) {
      while(true) {
         String rating = this.readString(prompt);
         if (rating.matches("^G$|^PG$|^PG-13$|^R$|^NC-17$")) {
            return rating;
         }

         this.print("You must enter a valid MPAA rating!");
      }
   }
}
