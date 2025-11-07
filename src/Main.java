import java.util.Scanner;
import java.util.Arrays;
public class Main {
    static void AffichageProd(Product[] product){
        for (int i = 0; i < product.length; i++) {
            if (product[i].stoke != 0)
                System.out.println("Id " + i + " : " + product[i].productName + '(' + product[i].price + " MAD)  - Stoke : " + product[i].stoke);
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Product product01 = new Product(20,"soda",8.0);
        Product product02 = new Product(10,"Eau",5.0);
        Product product03 = new Product(5,"Chips",12.0);
        Product product04 = new Product(11,"Chocolate",15.0);
        Product[] product = {product01,product02,product03,product04};
        int choix;
        do {
            System.out.println("=== Distributeur Automatique ===");
            System.out.println("1. Afficher les produits");
            System.out.println("2. Acheter un produit");
            System.out.println("3. Quitter");
            System.out.print("Entrez votre choix :");
            choix= scanner.nextInt();
            switch (choix) {
                case 1:
                    AffichageProd(product);
                    break;
                case 2:
                    AcheterProduit( product,  scanner);
                    break;
                case 3:
                    break;
                default: System.out.println("choix invalide!");
            }
        }while(choix != 3);
        scanner.close();
    }
    static void AcheterProduit(Product[] product, Scanner scanner) {
        System.out.print("\nEntrez le numéro du produit à acheter : ");
        int choix = scanner.nextInt();


        if (choix < 0 || choix >= product.length) {
            System.out.println("Numéro invalide !");
            return;
        }

        Product p = product[choix];

        if (p.stoke == 0) {
            System.out.println("Ce produit est en rupture de stock !");
            return;
        }

        System.out.print("Entrez le montant inséré (MAD) : ");
        double montant = scanner.nextDouble();

        if (montant < p.price) {
            double manque = p.price - montant;
            System.out.println("Montant insuffisant ! Il manque " + manque + " MAD.");
            return;
        }
        p.stoke--;
        double monnaie = montant - p.price;
        System.out.println("Vous avez acheté : " + p.productName);
        System.out.println("Monnaie rendue : " + monnaie + " MAD");
        updateStock(p);
    }
    static void updateStock(Product product){
        product.stoke-=1;
    }


    }

