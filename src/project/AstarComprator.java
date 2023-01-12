package project;

import java.util.Comparator;

public class AstarComprator implements Comparator<NodeM> {


    @Override
    public int compare(NodeM n1, NodeM n2) {
        if (((float)n2.money_cost/n2.source.money_cost)+n2.Heuristic_total > (((float)n1.money_cost/n1.source.money_cost)+n1.Heuristic_total)  &&n2.time < n1.time)
            return 2;
        else if (((float)n2.money_cost/n2.source.money_cost)+n2.Heuristic_total > (((float)n1.money_cost/n1.source.money_cost)+n1.Heuristic_total) &&n2.time > n1.time)
            return 1;
        else if (((float)n2.money_cost/n2.source.money_cost)+n2.Heuristic_total < (((float)n1.money_cost/n1.source.money_cost)+n1.Heuristic_total) && n2.time < n1.time)
            return -1;
        else if (((float)n2.money_cost/n2.source.money_cost)+n2.Heuristic_total < (((float)n1.money_cost/n1.source.money_cost)+n1.Heuristic_total) && n2.time > n1.time)
            return -2;
        return 0;

}

}