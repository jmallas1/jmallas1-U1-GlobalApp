package org.jrm;

import org.jrm.data.PlaceRecord;
import org.jrm.data.StuffRecord;
import org.jrm.io.FileInput;

import java.util.ArrayList;

public class Main {


    public static void main(String[] args)
    {
        PlaceRecord pr = new PlaceRecord();
        StuffRecord sr = new StuffRecord();

        ArrayList<PlaceRecord> places = pr.genListFromFileIO(new FileInput("places.csv"));
        ArrayList<StuffRecord> stuffs = sr.genListFromFileIO(new FileInput("stuff.csv"));

        System.out.println("hi");
    }
}
