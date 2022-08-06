import java.util.InputMismatchException;
import java.util.Scanner;

import static java.lang.System.exit;

public class Main {

    final static String[] options = { "1- Load Dog defaults", "2- Get number of food packages", "3- Exit" };
    final static Scanner scanner = new Scanner( System.in );
    static int menuOption = 1;

    static Dog dog;

    public static void main( String[] args ) {
        run();
    }

    static void run() {
        while ( menuOption != 4 ) {
            printMenu();
            menuActions();
        }
    }

    public static void printMenu() {
        for ( String option : options ) {
            System.out.println( option );
        }
        System.out.print( "Choose your option : " );
    }

    private static void menuActions() {
        try {
            selectAction();
        } catch ( InputMismatchException ex ) {
            System.out.println( "Please enter an integer value between 1 and " + options.length );
            scanner.next();
        } catch ( Exception exception ) {
            System.out.println( "An unexpected error happened. Please try again" );
            scanner.next();
        }
    }

    private static void selectAction() throws InputMismatchException {
        menuOption = scanner.nextInt();
        switch ( menuOption ) {
            case 1:
                option1();
                break;
            case 2:
                option2();
                break;
            case 3:
                exit( 0 );
        }
    }

    private static void option1() {
        scanner.nextLine();
        System.out.println( "Enter your dog name: " );
        String dogName = scanner.nextLine();
        System.out.println( "Enter how much food your dog eats (kg): " );
        Integer foodWeight = scanner.nextInt();

        dog = new Dog( dogName, foodWeight );
    }

    private static void option2() {
        try {
            loadFoodPackages();
        } catch ( DogException ex ) {
            System.out.println( ex.getMessage() );
        }
    }

    private static void loadFoodPackages() throws DogException {
        try {
            dog.foodPackages( scanner );
        } catch ( NullPointerException exception ) {
            throw new DogException( "\nYou must first load your dog defaults, with option 1\n", exception );
        }

    }
}
