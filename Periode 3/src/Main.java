/*
 * Author: Daylan de Lange
 * StudentNummer: 0962539
 * Klas: TI1D
 * Vakcode: TINPRO02-3
 * Poging: 1
 */
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        // random for the different container types
        Random rand = new Random();
        int type;

        // make ship and load it with containers of random type
        Ship ship = new Ship(100);
        for (int i = 0; i < ship.getMaxContainers(); i++) {
            type = rand.nextInt(3) + 1;
            ship.addContainer(new Container(i, type));
        }

        Dock dock = new Dock(5);

        Crane crane1 = new Crane("Crane 1", ship, dock);
        Crane crane2 = new Crane("Crane 2", ship, dock);

        Truck truck1 = new Truck("Truck 1", ship, dock);
        Truck truck2 = new Truck("Truck 2", ship, dock);
        Truck truck3 = new Truck("Truck 3", ship, dock);

        crane1.start();
        crane2.start();

        truck1.start();
        truck2.start();
        truck3.start();

    }

}
