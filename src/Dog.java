import java.util.Scanner;

public class Dog {

    final private String name;
    final private Integer foodWeight;


    public Dog( String name, Integer foodWeight ) {
        this.name = name;
        this.foodWeight = foodWeight;
    }

    public String getName() {
        return name;
    }

    public Integer getFoodWeight() {
        return foodWeight;
    }

    public void foodPackages( Scanner scanner ) {
        int totalPackageWeight = 0;
        int countPackages = 0;
        while ( totalPackageWeight < getFoodWeight() ) {
            System.out.println( "Enter a package weight(Kg): " );
            int packageWeight = scanner.nextInt();
            totalPackageWeight += packageWeight;
            countPackages++;
        }
        System.out.println( "\n" + getName() + " needs " + countPackages + " packages.\n" );
    }
}
