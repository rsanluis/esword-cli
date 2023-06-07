package com.codified.esword.dao;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.codified.esword.model.Details;

@SpringBootTest
public class DetailsDAOTest {
    @Autowired
    DetailsDAO detailsDAO;

    @Test
    public void testFindById() {
        String expectedInfo = "<p>This is the 1769 King James Version of the Holy Bible (also known as the Authorized Version) " +
        "with the words of Jesus Christ in red.  Includes Strong's numbers for looking up the original Hebrew or Greek word " +
        "in a lexicon.</p><p>Derivative Work, Copyright &copy; 2002-2019 by Rick Meyers. All rights reserved.</p>";
        
        String expectedTitle = "King James Version w/ Strong's Numbers";

        Optional<Details> detailsOpt = detailsDAO.findById("KJV+");
        assertTrue(detailsOpt.isPresent());
        Details details = detailsOpt.get();
        assertTrue(details.getTitle().equals(expectedTitle));
        assertTrue(details.getInformation().equals(expectedInfo));
        assertTrue(details.getVersion()==4);
        assertTrue(details.getOldTestament()==1);
        assertTrue(details.getNewTestament()==1);
        assertTrue(details.getApocrypha()==0);
        assertTrue(details.getStrongs()==1);
        assertTrue(details.getRightToLeft()==0);
    }
}
