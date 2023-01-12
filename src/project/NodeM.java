package project;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class NodeM {
    String name;
    float bus_waiting_time;
    float taxi_waiting_time;
    float time;
    int money_cost;
    int physical_exertion;
    NodeM source;
    EdgeW edge;
    String type;
    String name_of_bus;
    float distance;
    float Heuristic_time;
    float Heuristic_money_cost;
    float Heuristic_physical_exertion;
    float Heuristic_total;

    Map<NodeM, EdgeW> next_stations = new HashMap<>();

    public NodeM() {

    }

    public NodeM(String name, float bus_waiting_time, float taxi_waiting_time) {
        this.name = name;
        this.bus_waiting_time = bus_waiting_time;
        this.taxi_waiting_time = taxi_waiting_time;
    }

    public NodeM(NodeM obj) {
        this.source = obj.source;
        this.edge = obj.edge;
        this.name = obj.name;
        this.bus_waiting_time = obj.bus_waiting_time;
        this.taxi_waiting_time = obj.taxi_waiting_time;
        this.time = obj.time;
        this.money_cost = obj.money_cost;
        this.physical_exertion = obj.physical_exertion;
        this.type = obj.type;
        for (Map.Entry<NodeM, EdgeW> map : obj.next_stations.entrySet()) {
            this.next_stations.put(map.getKey(), map.getValue());
        }


    }

    public void add_station(NodeM station, EdgeW edge) {
        next_stations.put(station, edge);
    }

    public void calculate_bus_time() {
        this.time = source.time + bus_waiting_time + (edge.distance / edge.bus_speed);

    }

    public void calculate_taxi_time() {
        this.time = source.time + taxi_waiting_time + (edge.distance / edge.taxi_speed);

    }

    public void calculate_walk_time() {
        this.time =  (source.time + (edge.distance /edge.human_speed));

    }

    public void money_cost_bus() {
        if (source.name_of_bus == null) {
            this.money_cost = source.money_cost - 400;
            return;
        }
        if (source.name_of_bus.equals(name_of_bus)) {
            this.money_cost = source.money_cost;
        }
        else
            this.money_cost = source.money_cost -400;

    }

    public void money_cost_taxi() {
        this.money_cost = source.money_cost - (int) (edge.distance * 1000);

    }

    public void money_cost_walk() {
        this.money_cost = source.money_cost;

    }

    public void physical_exertion_bus() {
        this.physical_exertion = source.physical_exertion - (int) (edge.distance * 5);

    }

    public void physical_exertion_taxi() {
        this.physical_exertion = source.physical_exertion + (int) (edge.distance * 5);

    }

    public void physical_exertion_walk() {
        this.physical_exertion = source.physical_exertion - (int) (edge.distance * 10);

    }

    public boolean check_bus() {
        return edge.bus_available;
    }

    public boolean check_taxi() {
        return edge.taxi_available;
    }

    public boolean check_walk() {
        return true;
    }

    public void move_by_bus() {
        this.type = "move_by_bus";
        this.name_of_bus=edge.name_of_bus;
        calculate_bus_time();
        money_cost_bus();
        physical_exertion_bus();
        this.distance = source.distance+ this.edge.distance;
    }

    public void move_by_taxi() {
        this.type = "move_by_taxi";
        calculate_taxi_time();
        money_cost_taxi();
        physical_exertion_taxi();
        this.distance = source.distance + this.edge.distance;

    }

    public void move_by_walk() {
        this.type = "move_by_walk";
        calculate_walk_time();
        money_cost_walk();
        physical_exertion_walk();
        this.distance = source.distance + this.edge.distance;
    }

    public ArrayList cost(NodeM node) {
        ArrayList<NodeM> array = new ArrayList<>();
        if (node.check_bus()) {
            NodeM node1 = new NodeM(node);
            node1.move_by_bus();
            if (node1.money_cost >= 0 && node1.physical_exertion >0)
                array.add(node1);
        }
        if (node.check_taxi()) {
            NodeM node2 = new NodeM(node);
            node2.move_by_taxi();
            if (node2.money_cost >= 0 && node2.physical_exertion > 0)
                array.add(node2);
        }
        if (node.check_walk()) {
            NodeM node3 = new NodeM(node);
            node3.move_by_walk();
            if (node3.money_cost >= 0 && node3.physical_exertion > 0)
                array.add(node3);
        }
        if (array.isEmpty()) {
            return null;
        }


        return array;

    }



    public ArrayList get_next_state(NodeM source) {
        ArrayList<NodeM> Next_States = new ArrayList<>();
        for (Map.Entry<NodeM, EdgeW> ma : next_stations.entrySet()) {
            ma.getKey().source = source;
            ma.getKey().edge = ma.getValue();
            ArrayList array = ma.getKey().cost(ma.getKey());
            if (array!=null) {
               for(int i=0;i<=array.size()-1;i++){
                   Next_States.add((NodeM) array.get(i));
               }
            }
        }
        return Next_States;
    }


    public void print() {
        System.out.println(" name " + name + " " + "time:" + time + " " + "money_cost:" + money_cost + " " + "physical_exertion:" + physical_exertion+" "+"distance:" + distance);
        if (type != null) {
            System.out.println("                       ^           ");
            System.out.println("                       |           ");
            System.out.println("                       |           ");
            System.out.println("                       |           ");
            System.out.println("type :            " + type);
            if(name_of_bus!=null){
                System.out.println("name of bus :     " + name_of_bus);
            }
            System.out.println("                       |           ");
            System.out.println("                       |           ");
            System.out.println("                       |           ");
            System.out.println("                       |           ");
        }
    }

    public boolean is_final() {
        return this.name.equals("Al_Rais_Bridge");

    }


    public boolean equal(NodeM obj){
        return this.source == obj.source &&
                this.edge == obj.edge &&
                this.name.equals(obj.name) &&
                this.bus_waiting_time == obj.bus_waiting_time &&
                this.taxi_waiting_time == obj.taxi_waiting_time &&
                this.time == obj.time &&
                this.money_cost == obj.money_cost &&
                this.physical_exertion == obj.physical_exertion &&
                this.type.equals(obj.type);

    }

}