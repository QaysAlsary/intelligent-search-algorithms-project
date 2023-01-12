package  project;

import project.NodeM;

import java.util.Comparator;

public class AstarComprator4 implements Comparator<NodeM> {

    @Override
    public int compare(NodeM n1, NodeM n2) {

        if (n2.Heuristic_time < n1.Heuristic_time && n2.Heuristic_total > n1.Heuristic_total)
            return 2;
        else if (n2.Heuristic_time < n1.Heuristic_time && n2.Heuristic_total < n1.Heuristic_total)
            return 1;
        else if (n2.Heuristic_time > n1.Heuristic_time && n2.Heuristic_total > n1.Heuristic_total)
            return -1;
        else if (n2.Heuristic_time > n1.Heuristic_time && n2.Heuristic_total < n1.Heuristic_total)
            return -2;
        return 0;


    }
}