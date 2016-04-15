package ru.kurs.rest;


import org.apache.http.client.fluent.Executor;
import org.apache.http.client.fluent.Request;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Set;

/**
 * Created by yana on 4/15/2016.
 */
public class RestTests {

    @Test
    public void testCreateIssue() throws IOException {
        Set<Issue> oldIssues = getIssues();
        Issue newIssue = new Issue();
        int issueId = createIssue(newIssue);
        Set<Issue> newIssues = getIssues();
        oldIssues.add(newIssue.withId(issueId));
        Assert.assertEquals(newIssues, oldIssues);

    }

    private Set<Issue> getIssues() throws IOException {
        String json = getExecutor().execute(Request.Get("http://demo.bugify.com/api/issues.json"))
                .returnContent().asString();
        
        return null;
    }

    private Executor getExecutor() {
        return Executor.newInstance().auth(" LSGjeU4yP1X493ud1hNniA==", "");
    }

    private int createIssue(Issue newIssue) {
        return 0;
    }
}
