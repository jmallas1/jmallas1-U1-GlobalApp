package org.jrm.test;

import org.jrm.data.PlaceRecord;
import org.jrm.data.StuffRecord;
import org.jrm.io.FileInput;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class StuffRecordTest {

    StuffRecord srt;
    FileInput fi;

    @BeforeEach
    void setUp()
    {
        srt = new StuffRecord();
        fi = new FileInput("stuff.csv");
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
        ArrayList testList = srt.genListFromFileIO(fi);
        assertEquals(1000, testList.size(), "Array list should have 1000 items.");
    }
}