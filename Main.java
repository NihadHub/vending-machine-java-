import java.util.Scanner;
public class Main {
    static void AffichageProd(Product[] product){
        for (int i = 0; i < product.length; i++) {
            if (product[i].stoke != 0)
                System.out.println("Id " + i + " : " + product[i].productName + '(' + product[i].price + " MAD)  - Stoke : " + product[i].stoke);
        }
    }
    public static void main(String[] args) {
        Product product01 = new Product(20,"soda",8.0);
        Product product02 = new Product(10,"Eau",5.0);
        Product product03 = new Product(5,"Chips",12.0);
        Product product04 = new Product(11,"Chocolate",15.0);
        Product[] product = {product01,product02,product03,product04};

        int choix;
        int prod;
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Distributeur Automatique ===");
        System.out.println("1. Afficher les produits");
        System.out.println("2. Acheter un produit");
        System.out.println("3. Quitter");
        do {
            System.out.print("Choix :");
            choix = scanner.nextInt();
            switch (choix) {
                case 1:
                    AffichageProd(product);
                    break;
                case 2:
                    System.out.print("Entrez le numéro du produit : ");
                    prod = scanner.nextInt();
                    break;
                case 3:
                    break;
                default: System.out.println("Il doit étre 1 ou 2 ou 3 !!!!!!");
            }
        }while(choix != 3);
        scanner.close();
    }

}
