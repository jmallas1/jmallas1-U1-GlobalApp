package org.jrm;

import org.jrm.data.PlaceRecord;
import org.jrm.data.StuffRecord;
import org.jrm.io.FileInput;

import java.util.ArrayList;
import java.util.HashMap;

public class Main {


    public static void main(String[] args)
    {
        PlaceRecord pr = new PlaceRecord();
        StuffRecord sr = new StuffRecord();

        ArrayList<PlaceRecord> places = pr.genListFromFileIO(new FileInput("places.csv"));
        ArrayList<StuffRecord> stuffs = sr.genListFromFileIO(new FileInput("stuff.csv"));

        // Generate a hash map that looks like this:
        // {country => {city => {thing => count}}}
        HashMap<String, HashMap<String, HashMap>> countryHash = new HashMap<>();
        HashMap<String, HashMap> idHash;
        HashMap<String, String> cityHash;
        HashMap<String, String> stuffHash;
        for(PlaceRecord place : places)
        {
            if (countryHash.containsKey(place.getCountry()))
            {
                idHash = countryHash.get(place.getCountry());
                cityHash = idHash.get("CITIES");
            }
            else
            {
                idHash = new HashMap<String, HashMap>();
                cityHash = new HashMap<String, String>();
            }
            cityHash.put(place.getCity(), "X");
            idHash.put("CITIES", cityHash);
            countryHash.put(place.getCountry(), idHash);
        }
        System.out.println("hi");
    }
}
