package ru.kurs.rest;

import org.testng.annotations.Test;

/**
 * Created by yana on 4/18/2016.
 */
public class TestForRestBugNumber11 extends TestBase {
    private final int IssueId = 11;

    @Override
    public int getIssueId() {
        return IssueId;
    }

    @Test
    public void doTest() {
        System.out.println("Done for bug: " + IssueId);
    }
}
