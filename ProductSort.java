import java.util.*;
import java.io.*;


class ProductSort{
      static int lineCounter;
      public static Scanner inp;
      public static Scanner line;
      static int i;
      static PrintWriter output;
      static String sort;
      static Product[] items;

  public static void main(String[] args) {
    try{
      /*********************************************
      * Check the length of command line arguments *
      **********************************************/
      if(args.length < 1) {
        print("You Must Enter atleast 1 arguement!\n\n");
        System.exit(1);
      }
      else {
        String ans = args[0];
        sort = ans.toLowerCase();
        print("Sorting using:: " + sort + '\n');
      }

      /*****************************************
      * Test if command line for input is given *
      ******************************************/
      if(args.length == 2 || args.length == 3) {
        String input = args[1];
        File file = new File(input);
        inp = new Scanner(file);
        line = new Scanner(file);
      }
      else {
        print("Please enter file name in directory you want to read from:: ");
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        File file = new File(input);
        inp = new Scanner(file);
        line = new Scanner(file);
      }

      /*******************************************
      * Test if command line for output is given *
      ********************************************/
      if(args.length == 3){
        String next = args[2];
        output = new PrintWriter(next);
      } else {
        print("Please enter output file name you want to write to:: ");
        Scanner out = new Scanner(System.in);
        String next = out.next();
        output = new PrintWriter(next);
      }

      try {
        while(line.hasNextLine()) {
            lineCounter++;
            line.nextLine();
        }

        line.close();

        items = new Product[lineCounter];

        while(inp.hasNextLine())  {
            Long x = inp.nextLong();
            String one = inp.next();
            String two = inp.next();
            int y = inp.nextInt();
            items[i] = new Product(x, one, two, y);
            i++;
        }

        String t = "id";
        String y = "brand";
        String u = "name";
        String p = "price";

        /***********************************************
        * Use first command line to determine the sort *
        ************************************************/
        if(sort.equalsIgnoreCase(t)){
          byID(items, items.length);
          for(int i = 0; i < items.length;i++){
              output.println(items[i] + "\t");
          }
          print("Sorted by " + sort);
          output.close();
        }
        if(sort.equalsIgnoreCase(y)){
          byBrand(items, items.length);
          for(int i = 0; i < items.length;i++){
              output.println(items[i] + "\t");
          }
          print("Sorted by " + sort);
          output.close();
        }
        if(sort.equalsIgnoreCase(u)){
          byName(items, items.length);
          for(int i = 0; i < items.length;i++){
              output.println(items[i] + "\t");
          }
          print("Sorted by " + sort);
          output.close();
        }
        if(sort.equalsIgnoreCase(p)){
          byPrice(items, items.length);
          for(int i = 0; i < items.length;i++){
              output.println(items[i] + "\t");
          }
          print("Sorted by " + sort);
          output.close();
        }
      } catch(NullPointerException npe) {
        npe.printStackTrace();
      }

      inp.close();
      } catch (FileNotFoundException fnfe){
        System.err.println("File was not found in directory!! ");
      }
    }

    /*************
    * Sort By ID *
    **************/
    public static void byID(Product[] items, int n) {
      for (int i = 1; i < n; ++i) {
        Product nextItem = items[i];
        int location = i;
        while ((location > 0) && (items[location-1].getID() > (nextItem.getID()) )) {
          items[location] = items[location-1];
          location--;
        }
        items[location] = nextItem;
      }
    }

    /****************
    * Sort By Brand *
    ****************/
    public static void byBrand(Product[] items, int n) {
      for (int unsorted = 1; unsorted < n; ++unsorted) {
        Product nextItem = items[unsorted];
        int location = unsorted;
        while ((location > 0) &&(items[location-1].getBrand().compareToIgnoreCase(nextItem.getBrand()) > 0)) {
          items[location] = items[location-1];
          location--;
        }
        items[location] = nextItem;
      }
    }

    /****************
    * Sort By Name *
    ****************/
    public static void byName(Product[] items, int n) {
      for (int unsorted = 1; unsorted < n; ++unsorted) {
        Product nextItem = items[unsorted];
        int location = unsorted;
        while ((location > 0) &&(items[location-1].getName().compareToIgnoreCase(nextItem.getName()) > 0)) {
          items[location] = items[location-1];
          location--;
        }
        items[location] = nextItem;
      }
    }

    /****************
    * Sort By Price *
    ****************/
    public static void byPrice(Product[] items, int n) {
      for (int i = 1; i < n; ++i) {
        Product nextItem = items[i];
        int location = i;
        while ((location > 0) && (items[location-1].getPrice() > (nextItem.getPrice()) )) {
          items[location] = items[location-1];
          location--;
        }
      items[location] = nextItem;
    }
  }

  public static void print(Object o) {
    System.out.print(o);
  }
}
