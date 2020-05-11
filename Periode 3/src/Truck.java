/*
 * Author: Daylan de Lange
 * StudentNummer: 0962539
 * Klas: TI1D
 * Vakcode: TINPRO02-3
 * Poging: 1
 */
import java.util.Random;

public class Truck extends Thread {

    Random rand = new Random();
    private String name;
    Ship ship;
    Dock dock;
    Container container;


    public Truck(String name, Ship ship, Dock dock) {
        this.name = name;
        this.ship = ship;
        this.dock = dock;
    }


    @Override
    public void run() {
        // as long as there are containers left keep shipping.
        while (ship.amountLeft() > 0 || dock.amountLeft() > 0) {
            System.out.println(this.name + ": is waiting on a container");

            // take container from dock
            container = dock.removeContainer();
            if (container.getType() == "warm") {
                System.out.println("Container " + container.getId() + ": coupling heating system to " + this.name);
            } else if (container.getType() == "cold") {
                System.out.println("Container " + container.getId() + ": coupling cooling system to " + this.name);
            }
            System.out.println(this.name + ": received container " + container.getId());

            // simulated shipping delay of 3.5-7.5 seconds
            int delay = rand.nextInt(4000) + 3500;
            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // transfer container to docks
            System.out.println(this.name + ": shipping container " + container.getId() + " completed.");
        }

        //debug
        dock.printList();
    }
}
