package com.icthh.xm.tmf.ms.promotion.cucumber.stepdefs;

import com.icthh.xm.tmf.ms.promotion.PromotionApp;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.ResultActions;

import org.springframework.boot.test.context.SpringBootTest;

@WebAppConfiguration
@SpringBootTest
@ContextConfiguration(classes = PromotionApp.class)
public abstract class StepDefs {

    protected ResultActions actions;

}
