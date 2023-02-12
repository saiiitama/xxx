import java.util.Scanner;

public class Menu 
{

    private Scanner sc = new Scanner(System.in);
    Clients cltacc;
    Sellers sellacc;
    Menu main;

    public void firstMenu() {
        System.out.println("Menu");
        System.out.println("1 - Register as a client");
        System.out.println("2 - Login as a client");
        System.out.println("3 - Register as a seller");
        System.out.println("4 - Login as a seller");
      
        int inputMenu1 = sc.nextInt();
      
        switch (inputMenu1) {
          case 1:
            cltacc = new Clients();
            cltacc.register();
            mainMenu(cltacc);
            break;
      
          case 2:
            cltacc = new Clients();
            cltacc.login();
            mainMenu(cltacc);
            break;
      
          case 3:
            sellacc = new Sellers();
            sellacc.register();
            mainMenu(sellacc);
            break;
      
          case 4:
            sellacc = new Sellers();
            sellacc.login();
            mainMenu(sellacc);
            break;
        }
      }
      
      public void mainMenu(Person acc) {
        System.out.println("Menu");
        System.out.println("1 - Catalog of candies");
        System.out.println("2 - About us");
        System.out.println("3 - My Info");
        System.out.println("4 - My cart");
        System.out.println("5 - Exit");
        int inputMenu2 = sc.nextInt();
      
        switch (inputMenu2) {
          case 1:
            System.out.println("Sorry, but we don't have products, yet. But, trust us we will have them soon");
            mainMenu(acc);
            break;
      
          case 2:
            System.out.println("Worked on this project Zhumabek Beksultan");
            mainMenu(acc);
            break;
      
          case 3:
            acc.getInfo();
            break;
      
          case 4:
            System.out.println("Sorry, but we don't have that one yet");
            break;
      
          case 5:
            break;
        }
    }
}
