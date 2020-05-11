/*
 * Author: Daylan de Lange
 * StudentNummer: 0962539
 * Klas: TI1D
 * Vakcode: TINPRO02-3
 * Poging: 1
 */
import java.util.Random;

public class Crane extends Thread {

    Random rand = new Random();
    private String name;
    Ship ship;
    Dock dock;
    Container container;


    public Crane(String name, Ship ship, Dock dock) {
        this.name = name;
        this.ship = ship;
        this.dock = dock;
    }


    @Override
    public void run() {
        // as long as there are containers on the boat keep transferring.
        while (ship.amountLeft() > 0) {
            System.out.println(this.name + ": is waiting on a container");

            // take container from ship
            container = ship.removeContainer();
            System.out.println(this.name + ": received container " + container.getId() + " transferring to dock");

            // simulated transfer delay of 1-6 seconds
            int delay = rand.nextInt(5000) + 1000;
            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // transfer container to docks
            System.out.println(this.name + ": is ready to place container " + container.getId());
            dock.addContainer(container);
            System.out.println(this.name + ": transferring container " + container.getId() + " completed.");
        }
        ship.printList();
    }
}
