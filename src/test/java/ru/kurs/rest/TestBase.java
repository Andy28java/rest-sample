package ru.kurs.rest;

import org.testng.SkipException;

import java.net.MalformedURLException;
import java.rmi.RemoteException;

/**
 * Created by yana on 4/18/2016.
 */
public class TestBase {
    boolean isIssueOpen(int issueId) throws RemoteException, MalformedURLException {
        return isIssueOpen(issueId);
    }

    public void skipIfNotFixed(int issueId) throws RemoteException,  MalformedURLException {
        if (isIssueOpen(issueId)) {
            throw new SkipException("Ignored because of issue " + issueId);
        }
    }
}
