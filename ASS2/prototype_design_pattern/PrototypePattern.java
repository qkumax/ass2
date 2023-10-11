package prototype_design_pattern;

import java.util.ArrayList;
import java.util.List;

// Prototype class for creating vehicle objects
class Vehicle implements Cloneable {
    private List<String> vehicleList;

    public Vehicle() {
        this.vehicleList = new ArrayList<String>();
    }

    public Vehicle(List<String> list) {
        this.vehicleList = list;
    }

    public void insertData() {
        // Populate the vehicleList with some initial data
        vehicleList.add("Honda Amaze");
        vehicleList.add("Audi A4");
        vehicleList.add("Hyundai Creta");
        vehicleList.add("Maruti Baleno");
        vehicleList.add("Renault Duster");
    }

    public List<String> getVehicleList() {
        return this.vehicleList;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        // Create a deep copy of the object by copying the list
        List<String> tempList = new ArrayList<String>();
        for (String s : this.getVehicleList()) {
            tempList.add(s);
        }
        return new Vehicle(tempList);
    }
}

public class PrototypePattern {
    public static void main(String[] args) throws CloneNotSupportedException {
        Vehicle a = new Vehicle();
        a.insertData();

        Vehicle b = (Vehicle) a.clone();
        List<String> list = b.getVehicleList();
        list.add("Honda new Amaze");

        System.out.println("Original Vehicle List: " + a.getVehicleList());
        System.out.println("Cloned Vehicle List: " + list);

        b.getVehicleList().remove("Audi A4");
        System.out.println("Modified Cloned List: " + list);
        System.out.println("Original Vehicle List: " + a.getVehicleList());
    }
}
``
