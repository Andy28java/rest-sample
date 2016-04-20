package ru.kurs.rest;

import org.testng.annotations.Test;

/**
 * Created by yana on 4/20/2016.
 */
public class TestForRestBugNumber2New extends TestBase {
    private final int IssueId = 2;

    @Override
    public int getIssueId() {
        return IssueId;
    }

    @Test
    public void doTest() {
        System.out.println("Done for bug: " + IssueId);
    }
}
