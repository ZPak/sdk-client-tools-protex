package com.blackducksoftware.sdk.protex.client.examples.test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import com.blackducksoftware.sdk.protex.client.examples.SampleCreateProjectWithAnalysisDatabaseOptions;
import com.blackducksoftware.sdk.protex.client.examples.test.type.AbstractSdkSampleTest;
import com.blackducksoftware.sdk.protex.client.examples.test.type.Tests;
import com.blackducksoftware.sdk.protex.project.Project;

public class SampleCreateProjectWithAnalysisDatabaseOptionsTest extends AbstractSdkSampleTest {

    private String projectName = "SampleCreateProjectWithAnalysisDatabaseOptions Project";

    @Test
    public void runSample() throws Exception {
        String[] args = new String[4];
        args[0] = Tests.getServerUrl();
        args[1] = Tests.getServerUsername();
        args[2] = Tests.getServerPassword();
        args[3] = projectName;

        SampleCreateProjectWithAnalysisDatabaseOptions.main(args);
    }

    @AfterClass(alwaysRun = true)
    protected void deleteProject() throws Exception {
        Project project = getProxy().getProjectApi().getProjectByName(projectName);
        getProxy().getProjectApi().deleteProject(project.getProjectId());
    }

}
