package project;

import java.util.Comparator;

public class AstarComprator5 implements Comparator<NodeM> {


    @Override
    public int compare(NodeM n1, NodeM n2) {
        if (n2.Heuristic_money_cost > n1.Heuristic_money_cost &&n2.Heuristic_time < n1.Heuristic_time)
            return 2;
        else if (n2.Heuristic_money_cost > n1.Heuristic_money_cost &&n2.Heuristic_time > n1.Heuristic_time)
            return 1;
        else if ((n2.Heuristic_money_cost < n1.Heuristic_money_cost ) && (n2.Heuristic_time < n1.Heuristic_time))
            return -1;
        else if ((n2.Heuristic_money_cost < n1.Heuristic_money_cost) && (n2.Heuristic_time > n1.Heuristic_time))
            return -2;
        return 0;

    }

}