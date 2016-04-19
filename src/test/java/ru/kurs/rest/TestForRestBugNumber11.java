package ru.kurs.rest;

import com.jayway.restassured.RestAssured;
import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.rmi.RemoteException;

/**
 * Created by yana on 4/18/2016.
 */
public class TestForRestBugNumber11 extends TestBase {
    public final int IssueId = 11;


    @BeforeTest
    public void checkStatus() throws MalformedURLException, RemoteException {
        RestAssured.authentication = RestAssured.basic("LSGjeU4yP1X493ud1hNniA==", "");
        skipIfNotFixed(IssueId);
    }

    @Test
    public void doTest() {
        System.out.println("Done for bug: " + IssueId);
    }
}
