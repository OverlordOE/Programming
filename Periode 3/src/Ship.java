/*
 * Author: Daylan de Lange
 * StudentNummer: 0962539
 * Klas: TI1D
 * Vakcode: TINPRO02-3
 * Poging: 1
 */
import java.util.ArrayList;

public class Ship {

    private int maxContainers;
    private ArrayList<Container> storage;


    public Ship(int maxContainers) {
        this.maxContainers = maxContainers;
        this.storage = new ArrayList<>();
    }


    // no try wait here because its initialized before the threads run
    public void addContainer(Container container) {
        storage.add(container);
        System.out.println("Ship: added container with id " + container.getId() + " and type " + container.getType());
    }

    public synchronized Container removeContainer() {
        Container container;
        // if ship is empty wait
        while (this.storage.size() == 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("Interrupted Exception occurred with getContainer");
            }
        }

        // if ship has containers notify the trucks
        notifyAll();

        container = this.storage.remove(0);
        if (container.getType() == 2) {
            System.out.println("Container " + container.getId() + ": decoupling heating system");
        } else if (container.getType() == 3) {
            System.out.println("Container " + container.getId() + ": decoupling cooling system");
        }
        System.out.println("Ship: given container " + container.getId());
        return container;
    }

    // prints all container objects that are left in the ship
    public void printList() {
        for (Container container : storage) {
            System.out.println(container);
        }
    }


    public int amountLeft() {
        return this.storage.size();
    }

    public int getMaxContainers() {
        return maxContainers;
    }
}
