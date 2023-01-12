package project;

import java.util.ArrayList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class Logic {
    static float total_cost;
    static float physical_exertion;

    long startTime;
    long endTime;
    long elapsedTime;


    public void astar(NodeM root) {
        startTime = System.currentTimeMillis();
        Queue<NodeM> queue = new PriorityQueue<>(new AstarComprator2());
        int count = 1;
        root.source = null;

        queue.add(root);
        while (!queue.isEmpty()) {
            root = queue.poll();
            if (root.is_final()) {
                print_the_path(root);
                System.out.println("the count of visited node " + count);
                break;
            }
            count++;

            ArrayList array = root.get_next_state(root);
            for (int i = 0; i < array.size(); i++) {
                NodeM son = (NodeM) array.get(i);
                Heuristic_total(son);
                    queue.add(son);
            }
        }

    }



    public void Heuristic(NodeM node) {
        float speed = node.distance / node.time;
        float avg_cost_per_second = (((Logic.total_cost - node.money_cost) * 100) / total_cost) / node.time;
        float avg_physical_exertion_per_second = (((Logic.physical_exertion - node.physical_exertion) * 100) / physical_exertion) / node.time;
        float distance = distance(node, 0);
        float new_time = distance / speed;
        node.Heuristic_time = node.time + new_time;
        node.Heuristic_money_cost = node.money_cost - (new_time * avg_cost_per_second);
        node.Heuristic_physical_exertion = node.physical_exertion - (new_time * avg_physical_exertion_per_second);
        float source_total_cost = (node.money_cost / Logic.total_cost) - (node.physical_exertion / Logic.physical_exertion);
        float node_total_cost = (node.Heuristic_money_cost / Logic.total_cost) - (node.Heuristic_physical_exertion / Logic.physical_exertion);
        node.Heuristic_total = source_total_cost + node_total_cost;

    }

    public float distance(NodeM node, float distance) {
        if (node.is_final()) {

            return distance;
        }
        float temp_distance = Integer.MAX_VALUE;
        for (Map.Entry<NodeM, EdgeW> ma : node.next_stations.entrySet()) {
            float temp = distance(ma.getKey(), distance + ma.getValue().distance);
            if (temp < temp_distance)
                temp_distance = temp;

        }
        return temp_distance;


    }





    public void Heuristic_total(NodeM node) {
        node.Heuristic_total =  ((float) node.money_cost / Logic.total_cost)  +((float) node.physical_exertion / Logic.physical_exertion);

    }
    public void Heuristic_money_cost(NodeM node) {
        node.Heuristic_total = ((float) node.money_cost / Logic.total_cost) ;

    }
    public void Heuristic_physical_exertion(NodeM node) {
        node.Heuristic_total = ((float) node.physical_exertion / Logic.physical_exertion) ;

    }



    public boolean visit(NodeM node, ArrayList visited) {
        for (int i = 0; i < visited.size(); i++) {
            NodeM elemnet = (NodeM) visited.get(i);
            if (elemnet.equal(node))
                return true;
        }
        return false;
    }



























    public void print_the_path(NodeM node) {

        do {
            node.print();
            node = node.source;

        } while (node != null);
        endTime = System.currentTimeMillis();
        elapsedTime = endTime - startTime;
        System.out.println("the time : " + elapsedTime + "ms");

    }

//    public void Heuristic2(NodeM node) {
//        ArrayList<NodeM> array = new ArrayList<>();
//        distance2(node, array);
//        float temp = Integer.MAX_VALUE;
//        NodeM n = null;
//        for (int i = 0; i < array.size(); i++) {
//            NodeM son = array.get(i);
//            float avg_cost_per_second = (((total_cost - son.money_cost) * 100) / total_cost) / son.time;
//            float avg_physical_exertion_per_second = (((Logic.physical_exertion - son.physical_exertion) * 100) / physical_exertion) / son.time;
//            float total_avg = (avg_cost_per_second + avg_physical_exertion_per_second) / 2;
//
//            if (total_avg < temp) {
//                temp = total_avg;
//                n = son;
//            }
//        }
//        if (n != null) {
//            node.Heuristic_time = node.time + n.time;
//            node.Heuristic_money_cost = node.money_cost - n.money_cost;
//            node.Heuristic_physical_exertion = node.physical_exertion - n.physical_exertion;
//        }
//    }

//    public ArrayList distance2(NodeM node, ArrayList<NodeM> arr) {
//        if (node.is_final()) {
//            arr.add(node);
//            return arr;
//        }
//
//        ArrayList array = node.get_next_state(node);
//        for (int i = 0; i < array.size(); i++) {
//            NodeM son = (NodeM) array.get(i);
//            distance2(son, arr);
//        }
//        return arr;
//
//    }







}




