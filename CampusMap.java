import java.util.ArrayList;

public class CampusMap {

    ArrayList<Building> buildings;

    /* Default constructor, initializes empty ArrayList */
    public CampusMap() {
        buildings = new ArrayList<Building>();
    }

    /**
     * Adds a Building to the map
     * @param b the Building to add
     */
    public void addBuilding(Building b) {
        System.out.println("Adding building...");
        buildings.add(b);
        System.out.println("-->Successfully added " + b.getName() + " to the map.");
    }

    /**
     * Removes a Building from the map
     * @param b the Building to remove
     * @return the removed Building
     */
    public Building removeBuilding(Building b) {
        System.out.println("Removing building...");
        buildings.remove(b);
        System.out.println("-->Successfully removed " + b.getName() + " to the map.");
        return b;
    }

    /**
     * Displays the list of buildings on the map.
     */
    public void showBuildings() {
        System.out.println("DIRECTORY of BUILDINGS");
        for (int i = 0; i < this.buildings.size(); i++) {
            System.out.println("  " + (i + 1) + ". " + this.buildings.get(i).getName() + " (" + this.buildings.get(i).getAddress() + ")");
        }
    }

    /**
     * Interactive method to explore the campus map.
     */
    public void explore() {
        // Implementation omitted for brevity
    }

    public static void main(String[] args) {
        CampusMap myMap = new CampusMap();
        
        // Add at least 10 buildings of different types
        
        // 1. House
        myMap.addBuilding(new House("Gardiner House", "1 Paradise Road", 4, false));
        
        // 2. Library
        myMap.addBuilding(new Library("Neilson Library", "7 Neilson", 4));
        
        // 3. Cafe
        myMap.addBuilding(new Cafe("Campus Cafe", "100 Elm Street", 1, 100, 50, 20, 50));
        
        // 4. Building
        myMap.addBuilding(new Building("Bass Hall", "4 Tyler Court", 4));
        
        // 5. House
        myMap.addBuilding(new House("Albright House", "7 Bedford Terrace", 4, false));
        
        // 6. Library
        myMap.addBuilding(new Library("Hillyer Library", "20 Elm Street", 2));
        
        // 7. Cafe
        myMap.addBuilding(new Cafe("Compass Cafe", "7 Neilson Drive", 1, 150, 75, 30, 100));
        
        // 8. Building
        myMap.addBuilding(new Building("Seelye Hall", "2 Seelye Drive", 4));

        // 9. House
        myMap.addBuilding(new House("King", "180 Elm Street", 4, true));

        //10. Building
        myMap.addBuilding(new Building("Ford Hall", "100 Green Street", 3));
        

  
        
        // Show the buildings on the map
        myMap.showBuildings();
    }
}
