package javaPracticeProblems;
import java.util.Scanner;
public class CosmeticsDriver {

	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		Cosmetics cosmetics=new Cosmetics();
		while(true) {
			//menu driven program
			System.out.println("1. Add a new cosmetic");
			System.out.println("2. Display all the cosmetics");
			System.out.println("3. Search cosmetics by given range");
			System.out.println("4. Search cosmetic brands by given cosmetic Name");
			System.out.println("5. Update the quantity of the cosmetic by given id");
			System.out.println("9. exit");
			System.out.println("Enter choice");
			int ch=in.nextInt();
			switch(ch) {
			case 1:cosmetics.addNewCosmetic();
			break;
			case 2:cosmetics.displayAllCosmetics();
			break;
			case 3:cosmetics.searchCosmeticsByRange();
			break;
			case 4:cosmetics.searchCosmeticBrandByName();
			break;
			case 5:cosmetics.updateQuantity();
			break;
			case 9:System.exit(0);
			break;
			default:System.out.println("Incorrect Input");
			}
		}
	}

}
