package com.deviget.steps.base;

import com.deviget.config.RequestSpecificationConfig;
import com.deviget.config.TestConfig;
import net.thucydides.core.annotations.Step;

public abstract class Set extends TestConfig {

    @Step("Set query param {0} - {1}")
    public void queryParam(String queryParamName, String queryParamValue) {
        RequestSpecificationConfig.withQueryParam(queryParamName, queryParamValue);
    }
}
