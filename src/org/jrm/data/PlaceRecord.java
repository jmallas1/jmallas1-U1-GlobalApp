package org.jrm.data;

import org.jrm.io.FileInput;

import java.util.ArrayList;

/**
 * Class model for a place record from input file
 * @author Jared Mallas
 * @version 1.0
 */
public class PlaceRecord implements Comparable<PlaceRecord>
{
    private String country;
    private String city;
    private String lat;
    private String lng;


    /**
     * Constructor for place object
     * @param country Country
     * @param city City
     * @param lat Latitude
     * @param lng Longitude
     */
    public PlaceRecord(String country, String city, String lat, String lng) {
        this.country = country;
        this.city = city;
        this.lat = lat;
        this.lng = lng;
    }

    /**
     * Overloaded constructor (or... underloaded) for utility use
     */
    public PlaceRecord()
    {

    }

    /**
     * Generate a list of PlaceRecord objects from a FileInput object pointed at given csv
     * @return ArrayList of PlaceRecords
     */
    public ArrayList<PlaceRecord> genListFromFileIO(FileInput in)
    {
        String line;
        String[] fields;
        ArrayList<PlaceRecord> rList= new ArrayList<PlaceRecord>();

        while((line = in.readLine()) != null)
        {
            fields = line.split(",");
            rList.add(new PlaceRecord(fields[0], fields[1], fields[2], fields[3]));
        }
        in.fileClose();
        return rList;
    }

    /**
     * Override of compareTo. When comparing these objects, only compare the countries
     * @param o the PlaceRecord to compare
     * @return results of comparison
     */
    @Override
    public int compareTo(PlaceRecord o) {
        return this.getCountry().compareTo(o.getCountry());
    }

    /* Getters and setters*/

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }
}
