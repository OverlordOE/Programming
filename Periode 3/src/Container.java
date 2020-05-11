/*
 * Author: Daylan de Lange
 * StudentNummer: 0962539
 * Klas: TI1D
 * Vakcode: TINPRO02-3
 * Poging: 1
 */
public class Container {

    private int id;
    private String type = "normal";

    public Container(int id) {
        this.id = id;
    }


    public int getId() {
        return id;
    }

    public String getType() {
        return type;
    }
}
