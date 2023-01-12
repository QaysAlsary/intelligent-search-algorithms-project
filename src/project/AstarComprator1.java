package project;

import java.util.Comparator;

public class AstarComprator1 implements Comparator<NodeM> {

    @Override
    public int compare(NodeM n1,NodeM n2){

        if (((float)n2.physical_exertion/n2.source.physical_exertion)+n2.Heuristic_total > (((float)n1.physical_exertion/n1.source.physical_exertion)+n1.Heuristic_total)  &&n2.time < n1.time)
            return 2;
        else if (((float)n2.physical_exertion/n2.source.physical_exertion)+n2.Heuristic_total > (((float)n1.physical_exertion/n1.source.physical_exertion)+n1.Heuristic_total) &&n2.time > n1.time)
            return 1;
        else if (((float)n2.physical_exertion/n2.source.physical_exertion)+n2.Heuristic_total < (((float)n1.physical_exertion/n1.source.physical_exertion)+n1.Heuristic_total) && n2.time < n1.time)
            return -1;
        else if (((float)n2.physical_exertion/n2.source.physical_exertion)+n2.Heuristic_total < (((float)n1.physical_exertion/n1.source.physical_exertion)+n1.Heuristic_total) && n2.time > n1.time)
            return -2;
        return 0;


    }


}
