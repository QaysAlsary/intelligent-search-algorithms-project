package project;

import java.util.Comparator;

public class AstarComprator3 implements Comparator<NodeM> {

    @Override
    public int compare(NodeM n1, NodeM n2) {
        float n1_physical_exertion =(n1.source.physical_exertion/Logic.physical_exertion)+(n1.physical_exertion/Logic.physical_exertion);
        float n2_physical_exertion = (n2.source.physical_exertion/Logic.physical_exertion)+(n2.physical_exertion/Logic.physical_exertion);
        float n1_money_cost = (n1.source.money_cost/Logic.total_cost)+(n1.money_cost/Logic.total_cost);
        float n2_money_cost =  (n2.source.money_cost/Logic.total_cost)+(n2.money_cost/Logic.total_cost);
        if (n2.time < n1.time && n2_money_cost > n1_money_cost && n2_physical_exertion > n1_physical_exertion)
            return 4;
        else if (n2.time < n1.time && n2_money_cost > n1_money_cost && n2_physical_exertion < n1_physical_exertion)
            return 3;
        else if (n2.time < n1.time && n2_money_cost < n1_money_cost && n2_physical_exertion > n1_physical_exertion)
            return 2;
        else if (n2.time < n1.time && n2_money_cost < n1_money_cost && n2_physical_exertion < n1_physical_exertion)
            return 1;

        else if (n2.time > n1.time && n2_money_cost > n1_money_cost && n2_physical_exertion > n1_physical_exertion)
            return -1;
        else if (n2.time > n1.time && n2_money_cost > n1_money_cost && n2_physical_exertion < n1_physical_exertion)
            return -2;
        else if (n2.time > n1.time && n2_money_cost < n1_money_cost && n2_physical_exertion > n1_physical_exertion)
            return -3;
        else if (n2.time > n1.time && n2_money_cost < n1_money_cost && n2_physical_exertion < n1_physical_exertion)
            return -4;

        return 0;


    }
}