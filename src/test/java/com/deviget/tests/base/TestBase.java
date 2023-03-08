package com.deviget.tests.base;

import com.deviget.config.TestConfig;
import com.deviget.steps.base.Perform;
import com.deviget.steps.base.Set;
import com.deviget.steps.base.Validate;
import net.thucydides.core.annotations.Steps;

public abstract class TestBase extends TestConfig {

    @Steps
    protected static Perform perform;
    @Steps
    protected static Set set;
    @Steps
    protected static Validate validate;
}
