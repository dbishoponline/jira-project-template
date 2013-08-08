package com.example.plugins.tutorial;

import com.atlassian.jira.blueprint.spi.AddProjectHook;
import com.atlassian.jira.blueprint.spi.ConfigureData;
import com.atlassian.jira.blueprint.spi.ConfigureResponse;
import com.atlassian.jira.blueprint.spi.ValidateData;
import com.atlassian.jira.blueprint.spi.ValidateResponse;

public class MyAddProjectHook implements AddProjectHook
{
    @Override
    public ValidateResponse validate(final ValidateData validateData)
    {
        ValidateResponse validateResponse = ValidateResponse.create();
        if (validateData.projectKey().equals("TEST"))
        {
            validateResponse.addErrorMessage("Invalid Project Key");
        }

        return validateResponse;
    }

    @Override
    public ConfigureResponse configure(final ConfigureData configureData)
    {
        ConfigureResponse configureResponse = ConfigureResponse.create().setRedirect("/issues/");

        return configureResponse;
    }
}
