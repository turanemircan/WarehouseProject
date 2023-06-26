package project02;

import java.util.*;

public class Action implements DefineProduct, Shelf, Listing,Homepage,InOutbound{

    public static Scanner input = new Scanner(System.in);
    static int id=100;

    static HashMap<Integer, Product> actions = new HashMap<Integer, Product>();
    @Override
    public void mainMenu() {
        final String ANSI_RESET = "\u001B[0m";
        final String ANSI_CYAN = "\u001B[36m";
        final String ANSI_YELLOW = "\u001B[33m";

        System.out.println(ANSI_CYAN + "Select the desired operation in the application." + ANSI_RESET);
        System.out.println("Options:");
        System.out.println(ANSI_YELLOW + "1. Define Product" + ANSI_RESET + "\t\t" + ANSI_YELLOW + "2. List Product" + ANSI_RESET);
        System.out.println(ANSI_YELLOW + "3. Inbound Product" + ANSI_RESET + "\t\t" + ANSI_YELLOW + "4. Assign Shelf Number" + ANSI_RESET);
        System.out.println(ANSI_YELLOW + "5. Outbound Product" + ANSI_RESET + "\t\t" + ANSI_YELLOW + "6. Exit" + ANSI_RESET);

    }

    public void homepage() {

        int choice;

        do {
            mainMenu();
            choice = input.nextByte();

            switch (choice) {
                case 1:
                    defineProduct();
                    break;
                case 2:
                    listing();
                    break;
                case 3:
                    inboundProdct();
                    break;
                case 4:
                    assignShelf();
                    break;
                case 5:
                    try {
                        productOut();
                    } catch (NoSuchElementException e) {
                        System.err.println(e.getMessage());
                    } catch (IllegalArgumentException b) {
                        System.err.println(b.getMessage());
                    } productOut();
                    break;
                case 6:
                    System.exit(6);
                default:
                    System.out.println("The choice is incorrect.\n Please try again.");

            }
        } while (true);
    }

    @Override
    public void defineProduct() {
        input.nextLine();
        System.out.print("urun ismini giriniz : ");
        String productName = input.nextLine();

        System.out.print("uretici bilgisi giriniz : ");
        String producter = input.nextLine();

        System.out.print("urun miktar giriniz : ");
        int amount = input.nextInt();
        input.nextLine();

        System.out.print("urun birimi giriniz : ");
        String unit = input.nextLine();

        System.out.print("urun icin raf  giriniz : ");
        String shelf = input.nextLine();

        Product product = new Product(productName,producter, amount,unit,shelf);
        actions.put(id, product);
        System.out.println(id + " : " + actions.get(id));
        id++;
        System.out.println("Ürün eklemeye devam etmek ister misiniz? E/H girin!");
        String cevap = input.next().toUpperCase();
        if (cevap.equals("E")){
            defineProduct();
        }
    }

    @Override
    public void assignShelf() {
        listing();
        System.out.println("Lütfen rafa koymak istediginiz ürünün id girin");
        int id =input.nextInt();
        if (actions.get(id).getShelf()=="null" ){
            System.out.println("Lutfen raf numarasini giriniz...");
            String shelf = input.nextLine();
            actions.get(id).setShelf(shelf);
            System.out.println("id : "+ id + "raf : " + shelf );
        }else if(actions.get(id).getShelf() != null)

            System.out.println("ID:"  + actions.get(id) +  "Raf: " + actions.get(id).getShelf())  ;

    }

    @Override
    public void listing() {

            System.out.println("------------------------------------------------------------");

            System.out.printf("%-5s %-10s %-15s %-10s %-10s %-5s\n", "ID", "PRODUCT NAME", "PRODUCTER", "AMOUNT", "UNIT", "SHELF");
            Set<Map.Entry<Integer, Product>> actionList = actions.entrySet();

            System.out.println("------------------------------------------------------------");

            for (Map.Entry<Integer, Product> w : actionList) {
                System.out.printf("%-5d %-10s %-15s %-10d %-10s %-5s\n", w.getKey(), w.getValue().getProductName(),
                        w.getValue().getProducter(), w.getValue().getAmount(), w.getValue().getUnit(), w.getValue().getShelf());
            }

            System.out.println("------------------------------------------------------------");
        }


    @Override
    public void inboundProdct() {
        listing();

        System.out.print("Sectiginiz urun id giriniz: ");
        int id = input.nextInt();

        if (actions.containsKey(id)) {
            System.out.println(actions.get(id).getAmount() + " " +
                               actions.get(id).getUnit() + " depoda var." +
                               "\nNe kadar miktar ekleyeceksiniz?");
            int amount = input.nextInt() + actions.get(id).getAmount();
            actions.get(id).setAmount(amount);
            System.out.println(actions.get(id).getAmount() + " " + actions.get(id).getUnit() + " depoda var.");


        } else {
            System.out.println("Bu ID'ye sahip bir ürün tanımlanmamış.");
        }

    }
    @Override
    public void productOut() throws NoSuchElementException {
        listing();

        System.out.print("Sectiginiz urun id giriniz: ");
        int id = input.nextInt();

        if (!actions.containsKey(id)) {
            throw new NoSuchElementException("Belirtilen ID'ye sahip bir ürün bulunamadı.");
        } else {
            Product product = actions.get(id);
            int availableAmount = product.getAmount();
            System.out.print("Cikarmak istediğiniz miktari giriniz: ");
            int amount = input.nextInt();
            amount = Math.abs(amount);
            if (availableAmount < amount) {
                throw new IllegalArgumentException("Yeterli ürün bulunmamaktadır. Mevcut miktar: " + availableAmount);

            } else {
                int newAmount = 0;
                newAmount = availableAmount - amount;
                product.setAmount(newAmount);
                System.out.println("Güncel miktar: " + newAmount);

                if (newAmount == 0) {
                    product.setShelf(null);
                }
            }
        }

    }
}
