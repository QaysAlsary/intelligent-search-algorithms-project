package project;

public class EdgeW {
    float distance;
    NodeM source;
    NodeM destination;
    boolean bus_available;
    boolean taxi_available;
    String name_of_bus;
    float bus_speed;
    float taxi_speed;
    float human_speed= 5.5F;

    public EdgeW() {

    }


    public EdgeW(float distance, boolean bus_available, boolean taxi_available, String name_of_bus, float bus_speed, float taxi_speed, NodeM source, NodeM destination) {
        this.distance = distance;
        this.bus_available = bus_available;
        this.taxi_available = taxi_available;
        this.name_of_bus = name_of_bus;
        this.bus_speed = bus_speed;
        this.taxi_speed = taxi_speed;
        this.source = source;
        this.destination = destination;

    }


}
