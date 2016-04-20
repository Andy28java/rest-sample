package ru.kurs.rest;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.jayway.restassured.RestAssured;
import org.testng.SkipException;
import org.testng.annotations.BeforeTest;

import java.net.MalformedURLException;
import java.rmi.RemoteException;

/**
 * Created by yana on 4/18/2016.
 */
public abstract class TestBase {

    public abstract int getIssueId();

    @BeforeTest
    public void checkStatus() throws MalformedURLException, RemoteException {
        RestAssured.authentication = RestAssured.basic("LSGjeU4yP1X493ud1hNniA==", "");
        skipIfNotFixed(getIssueId());
    }

    protected boolean isIssueOpen(int issueId) throws RemoteException, MalformedURLException {
        String json = RestAssured.get(String.format("http://demo.bugify.com/api/issues/%s.json", issueId)).asString();
        JsonElement parsed = new JsonParser().parse(json);
        JsonArray issues = parsed.getAsJsonObject().getAsJsonArray("issues");
        String status = issues.get(0).getAsJsonObject().get("state_name").getAsString();
        if (status.equals("Closed")||status.equals("Resolved")){
            return false;
        }
        return true;

        //return isIssueOpen(issueId);
    }

    public void skipIfNotFixed(int issueId) throws RemoteException,  MalformedURLException {
        if (isIssueOpen(issueId)) {
            throw new SkipException("Ignored because of issue " + issueId);
        }
    }
}
