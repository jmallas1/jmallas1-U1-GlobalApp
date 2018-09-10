package org.jrm.data;

import org.jrm.io.FileInput;

import java.util.ArrayList;

/**
 * Class model for stuff record
 * @author Jared Mallas
 * @version 1.0
 */
public class StuffRecord implements Comparable<StuffRecord>
{
    private String country;
    private String thing;

    /**
     * Constructor for Stuff record
     * @param country City from stuff file
     * @param thing one thing of many stuffs
     */
    public StuffRecord(String country, String thing) {
        this.country = country;
        this.thing = thing;
    }

    /**
     * Overloaded (or underloaded) constructor for utility use
     */
    public StuffRecord()
    {
    }


    public ArrayList<StuffRecord> genListFromFileIO(FileInput in)
    {
        String line;
        String[] fields;
        ArrayList<StuffRecord> rList= new ArrayList<StuffRecord>();

        while((line = in.readLine()) != null)
        {
            fields = line.split(",");
            rList.add(new StuffRecord(fields[0], fields[1]));
        }
        in.fileClose();
        return rList;
    }

    /**
     * Override of compareTo method. When comparing StuffRecords, only compare countries
     * @param o The StuffRecord to compare
     * @return results of comparison
     */
    @Override
    public int compareTo(StuffRecord o) {
        return this.getCountry().compareTo(o.getCountry());
    }
    /* Getters and setters */

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getThing() {
        return thing;
    }

    public void setThing(String thing) {
        this.thing = thing;
    }
}
