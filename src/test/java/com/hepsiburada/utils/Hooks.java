package com.hepsiburada.utils;

import com.thoughtworks.gauge.AfterScenario;

public class Hooks {



    @AfterScenario
    public void tearDownScenarios() {
        Driver.closeDriver();

    }
}
