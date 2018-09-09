package org.jrm;

import org.jrm.data.PlaceRecord;
import org.jrm.data.StuffRecord;
import org.jrm.io.FileInput;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args)
    {
        String line;
        String[] workingArray;
        ArrayList<PlaceRecord> places = new ArrayList<>();
        ArrayList<StuffRecord> stuffs = new ArrayList<>();

        FileInput placeFI = new FileInput("places.csv");
        while((line = placeFI.readLine()) != null)
        {
            workingArray = line.split(",");
            // places.add(new PlaceRecord())
        }
    }
}
