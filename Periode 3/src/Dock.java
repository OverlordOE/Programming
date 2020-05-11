/*
 * Author: Daylan de Lange
 * StudentNummer: 0962539
 * Klas: TI1D
 * Vakcode: TINPRO02-3
 * Poging: 1
 */
import java.util.ArrayList;

public class Dock {

    private ArrayList<Container> storage = new ArrayList<>();
    private int maxContainers;


    public Dock(int maxContainers) {
        this.maxContainers = maxContainers;
    }


    public synchronized void addContainer(Container container) {
        while (this.storage.size() == this.maxContainers) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("Interrupted Exception occurred with addContainer");
            }
        }

        notifyAll();

        System.out.println("Dock: received container " + container.getId());
    }

    public synchronized Container removeContainer() {
        Container container;
        // if dock is empty wait
        while (this.storage.size() == 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("Interrupted Exception occurred with getContainer");
            }
        }

        // if dock has containers notify the trucks
        container = this.storage.remove(0);
        notifyAll();
        System.out.println("Dock: given container " + container.getId());
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
}