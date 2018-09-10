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

        for(StuffRecord stuff : stuffs)
        {
            if (countryHash.containsKey(stuff.getCountry()))
            {
                idHash = countryHash.get(stuff.getCountry());
                if(idHash.containsKey("STUFFS"))
                {
                    stuffHash = idHash.get("STUFFS");
                }
                else
                {
                    stuffHash = new HashMap<String, String>();
                }

            }
            else
            {
                idHash = new HashMap<String, HashMap>();
                stuffHash = new HashMap<String, String>();
            }
            stuffHash.put(stuff.getThing(), "X");
            idHash.put("STUFFS", stuffHash);
            countryHash.put(stuff.getCountry(), idHash);
        }

        System.out.format("%22s  %5s  %7s\n","COUNTRY","CITY COUNT", "STUFF");
        System.out.format("%22s  %5s  %7s\n","=======","==========", "=====");

        for (String country : countryHash.keySet())
        {
            System.out.format("%22s  %5s  %10s\n",country, countryHash.get(country).get("CITIES").size(), countryHash.get(country).get("STUFFS").size());
            // System.out.println(country + "===>" + countryHash.get(country).get("CITIES").size() + "===>" + countryHash.get(country).get("STUFFS").size());
        }
    }
}
