package project;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner add = new Scanner(System.in);  // Create a Scanner object
        System.out.println("inset total money");
        Logic.total_cost = add.nextFloat();
        Logic.physical_exertion = 160;
        Logic logic = new Logic();
        NodeM abbassiyyin_square = new NodeM("Abbassiyyin Square", 0.16f, 0.03f);
        abbassiyyin_square.money_cost = (int) Logic.total_cost;
        abbassiyyin_square.physical_exertion = (int) Logic.physical_exertion;
        abbassiyyin_square.time=0;
        NodeM al_adawi = new NodeM("Al-Adawi", 0.16f, 0.03f);
        NodeM share_baghdad = new NodeM("share baghdad", 0.16f, 0.03f);
        NodeM bab_touma = new NodeM("Bab_Touma", 0.16f, 0.03f);
        NodeM al_thawra_st = new NodeM("Al Thawra St", 0.16f, 0.03f);
        NodeM al_mahafza_square = new NodeM("Al Mahafza Square", 0.16f, 0.03f);
        NodeM al_hamidya = new NodeM("al_hamidya", 0.16f, 0.03f);
        NodeM al_qaimarryeh_street = new NodeM("Al-Qaimarryeh Street", 0.16f, 0.03f);
        NodeM al_hijaz_square = new NodeM("Al Hijaz Square", 0.16f, 0.03f);
        NodeM al_rais_bridge = new NodeM("Al_Rais_Bridge", 0.16f, 0.03f);
        EdgeW Edge1 = new EdgeW(6, true, true, "bus1", 10, 15, abbassiyyin_square, al_adawi);
        abbassiyyin_square.add_station(al_adawi, Edge1);
        EdgeW Edge2 = new EdgeW(4, true, true, "bus2", 10, 15, abbassiyyin_square, share_baghdad);
        abbassiyyin_square.add_station(share_baghdad, Edge2);
        EdgeW Edge3 = new EdgeW(4, true, true, "bus3", 10, 15, abbassiyyin_square, bab_touma);
        abbassiyyin_square.add_station(bab_touma, Edge3);
        EdgeW Edge4 = new EdgeW(7, false, true, null, 0, 15, al_adawi, al_mahafza_square);
        al_adawi.add_station(al_mahafza_square, Edge4);
        EdgeW Edge5 = new EdgeW(5.6f, true, true, "bus1", 10, 15, al_adawi, al_thawra_st);
        al_adawi.add_station(al_thawra_st, Edge5);
        EdgeW Edge6 = new EdgeW(4, true, true, "bus2", 10, 15, share_baghdad, al_thawra_st);
        share_baghdad.add_station(al_thawra_st, Edge6);
        EdgeW Edge7 = new EdgeW(4.5f, false, true, null, 0, 15, share_baghdad, al_hamidya);
        share_baghdad.add_station(al_hamidya, Edge7);
        EdgeW Edge8 = new EdgeW(1.5f, false, false, null, 0, 0, bab_touma, al_qaimarryeh_street);
        bab_touma.add_station(al_qaimarryeh_street, Edge8);
        EdgeW Edge9 = new EdgeW(7, false, true, null, 0, 15, al_mahafza_square, al_rais_bridge);
        al_mahafza_square.add_station(al_rais_bridge, Edge9);
        EdgeW Edge10 = new EdgeW(7, true, true, "bus3", 10, 15, al_thawra_st, al_rais_bridge);
        al_thawra_st.add_station(al_rais_bridge, Edge10);
        EdgeW Edge11 = new EdgeW(3, false, false, null, 0, 0, al_thawra_st, al_hamidya);
        al_thawra_st.add_station(al_hamidya, Edge11);
        EdgeW Edge12 = new EdgeW(0.5f, false, false, null, 0, 0, al_qaimarryeh_street, al_hamidya);
        al_qaimarryeh_street.add_station(al_hamidya, Edge12);
        EdgeW Edge13 = new EdgeW(1.5f, false, false, null, 0, 0, al_hamidya, al_hijaz_square);
        al_hamidya.add_station(al_hijaz_square, Edge13);
        EdgeW Edge14 = new EdgeW(4, false, true, null, 0, 15, al_hijaz_square, al_rais_bridge);
        al_hijaz_square.add_station(al_rais_bridge, Edge14);


        logic.astar(abbassiyyin_square);


    }

}


