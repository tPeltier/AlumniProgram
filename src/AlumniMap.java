

import java.util.HashMap;

public class AlumniMap {
    HashMap<Integer, Object> alumni;

    /**
     * Constructs an alumni map object
     */
    public AlumniMap() {
        alumni = new HashMap<>();
    }

    /**
     * assigns the initial values to the alumni map
     */
    public void constructAlumniMap(int id, Alumni a) {
        alumni.put(id, a);
    }

    /**
     * edits and adds to alumni map
     */
    public void addAlumni() {

    }

    /**
     *
     * @return returns the alumni map
     */
    public HashMap<Integer, Object> getAlumni() {
        return alumni;
    }


}
