package org.jrm.test;

import org.jrm.data.PlaceRecord;
import org.jrm.io.FileInput;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class PlaceRecordTest {

    PlaceRecord prt;
    FileInput fi;

    @BeforeEach
    void setUp()
    {
        // prt = new PlaceRecord("test", "test", "test", "test");
        prt = new PlaceRecord();
        fi = new FileInput("places.csv");
    }

    @AfterEach
    void tearDown()
    {
        fi.fileClose();
    }

    @DisplayName("Generate a list of objects from a file")
    @Test
    void genListFromFileIO()
    {
        ArrayList testList = prt.genListFromFileIO(fi);
        assertEquals(500, testList.size(), "Array list should have 500 items.");
    }
}