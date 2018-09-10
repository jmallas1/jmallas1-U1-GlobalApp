package org.jrm.data;

import org.jrm.io.FileInput;

import java.util.ArrayList;

/**
 * Class model for stuff record
 * @author Jared Mallas
 * @version 1.0
 */
public class StuffRecord
{
    private String city;
    private String thing;

    /**
     * Constructor for Stuff record
     * @param city City from stuff file
     * @param thing one thing of many stuffs
     */
    public StuffRecord(String city, String thing) {
        this.city = city;
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

    /* Getters and setters */

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getThing() {
        return thing;
    }

    public void setThing(String thing) {
        this.thing = thing;
    }
}
