package project;

import java.util.*;

public class Graph {

    Map<String, NodeM> map_nodes = new HashMap<>();
    List<EdgeW> edgeList = new ArrayList<EdgeW>();

    public void addNode(String name, NodeM node) {
        map_nodes.put(name, node);
    }
}
