package project01;

import java.util.*;

public class Action {
    public static final String R = "\u001B[31m";
    public static final String B = "\u001B[34m";

    public static Scanner input = new Scanner(System.in);
    static int id;

    static HashMap<Integer, Urunler> actions = new HashMap<Integer, Urunler>();

    public static void mainmenu(){
        final String ANSI_RESET = "\u001B[0m";
        final String ANSI_CYAN = "\u001B[36m";
        final String ANSI_YELLOW = "\u001B[33m";

        System.out.println(ANSI_CYAN + "Select the desired operation in the application." + ANSI_RESET);
        System.out.println("Options:");
        System.out.println(ANSI_YELLOW + "1. Define Product" + ANSI_RESET + "\t\t" + ANSI_YELLOW + "2. List Product" + ANSI_RESET);
        System.out.println(ANSI_YELLOW + "3. Inbound Product" + ANSI_RESET + "\t\t" + ANSI_YELLOW + "4. Assign Shelf Number" + ANSI_RESET);
        System.out.println(ANSI_YELLOW + "5. Outbound Product" + ANSI_RESET + "\t\t" + ANSI_YELLOW + "6. Exit" + ANSI_RESET);
    }
    public static void homepage(){

        System.out.println("Select the desired operation in the application.");
        int choice;

        do { mainmenu();
            choice= input.nextByte();

            switch (choice) {
                case 1:
                    defineProduct();
                    break;
                case 2:
                    listOfProduct ();
                    break;
                case 3:
                    System.out.println("Please enter the ID of the product you want to inbound.");
                    //method
                    break;
                case 4:
                    assignShelf();
                    break;
                case 5:
                    System.out.println("Please enter the product you want to outbound");
                    //method
                    break;
                case 6:
                    System.exit(6);
                default:
                    System.out.println("The choice is incorrect.\n Please try again.");

            }
        } while (true);

    }


    public static void defineProduct(){
        input.nextLine();
        System.out.println();
        System.out.print("urun ismini giriniz : ");
        String productName = input.nextLine();
        //input.nextLine();

        System.out.print("uretici bilgisi giriniz : ");
        String producter = input.nextLine();

        System.out.print("urun miktar giriniz : ");
        int amount = input.nextInt();
        input.nextLine();

        System.out.print("urun birimi giriniz : ");
        String unit = input.nextLine();

        System.out.print("urun icin raf  giriniz : ");
        String shelf = input.nextLine();

        Urunler product = new Urunler(productName,producter, amount,unit,shelf);
        actions.put(id, product);
        System.out.println(id + " : " + actions.get(id));
        id++;
        System.out.println("Ürün eklemeye devam etmek ister misiniz? E/H girin!");
        String cevap = input.next().toUpperCase();
        if (cevap.equals("E")){
            defineProduct();
        }



    }
    public static void assignShelf(){
        System.out.println("Lütfen rafa koymak istediginiz ürünün id girin");
          int id =input.nextInt();
        if (actions.get(id).getShelf() == null){
            System.out.println("Lutfen raf numarasini giriniz...");
            String shelf = input.nextLine();
            actions.get(id).setShelf(shelf);
            System.out.println("id : "+ id + "raf : " + shelf );
        }else if(actions.get(id).getShelf() != null)

        System.out.println("ID:"  + actions.get(id) +  "Raf: " +actions)  ;
        listOfProduct();
    }
    public static void productOut(){

        //System.out.println(listOfProduct ());

        System.out.print("Sectiginiz urun id giriniz: ");
        int id = input.nextInt();

        System.out.print("Cikarmak istediğiniz miktari giriniz: ");
        int amount = input.nextInt();

        if (actions.containsKey(id)){
            Urunler product = actions.get(id);
            int availableAmount = product.getAmount();
            if (availableAmount >= amount){
                int newAmount = availableAmount - amount;
                product.setAmount(newAmount);
                if (newAmount == 0){
                    product.setShelf(null);
                }
            } else {
                System.out.println("Yeterli miktarda ürün bulunmamaktadır.");
            }
        } else {
            System.out.println("Bu ID'ye sahip bir ürün tanımlanmamış.");
        }
    }
    public static void listOfProduct (){

        System.out.printf("%-5s %-10s %-10s %-10s %-10s %-10s%n", "ID", "ISMI", "URETICISI", "MIKTARI", "BIRIMI", "RAF");
        System.out.println("-----------------------------------------------------------------------------------");

        Set<Map.Entry<Integer, Urunler>> actionList= actions.entrySet();

        for (Map.Entry<Integer,Urunler> w: actionList){
            System.out.print(w.getKey()+ "\t");
            System.out.println(w.getValue());
        }

    }
}
