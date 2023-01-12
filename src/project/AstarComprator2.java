package  project;

import project.NodeM;

import java.util.Comparator;

public class AstarComprator2 implements Comparator<NodeM> {

    @Override
    public int compare(NodeM n1, NodeM n2) {

        if (n2.time < n1.time && ((float)n2.money_cost/n2.source.money_cost)+((float)n2.physical_exertion/n2.source.physical_exertion)+n2.Heuristic_total> ((float)n1.money_cost/n1.source.money_cost)+((float)n1.physical_exertion/n1.source.physical_exertion)+n1.Heuristic_total)
            return 2;
        else if (n2.time < n1.time && ((float)n2.money_cost/n2.source.money_cost)+((float)n2.physical_exertion/n2.source.physical_exertion)+n2.Heuristic_total< ((float)n1.money_cost/n1.source.money_cost)+((float)n1.physical_exertion/n1.source.physical_exertion)+n1.Heuristic_total)
            return 1;
        else if (n2.time > n1.time && ((float)n2.money_cost/n2.source.money_cost)+((float)n2.physical_exertion/n2.source.physical_exertion)+n2.Heuristic_total> ((float)n1.money_cost/n1.source.money_cost)+((float)n1.physical_exertion/n1.source.physical_exertion)+n1.Heuristic_total)
            return -1;
        else if (n2.time > n1.time &&  ((float)n2.money_cost/n2.source.money_cost)+((float)n2.physical_exertion/n2.source.physical_exertion)+n2.Heuristic_total< ((float)n1.money_cost/n1.source.money_cost)+((float)n1.physical_exertion/n1.source.physical_exertion)+n1.Heuristic_total)
            return -2;
        return 0;


    }
}