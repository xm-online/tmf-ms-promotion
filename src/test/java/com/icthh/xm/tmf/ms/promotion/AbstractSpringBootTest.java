package com.icthh.xm.tmf.ms.promotion;

import com.icthh.xm.tmf.ms.promotion.config.IntegrationTestConfiguration;
import com.icthh.xm.tmf.ms.promotion.config.TestLepConfiguration;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest(classes = {
        TestLepConfiguration.class,
        PromotionApp.class,
        IntegrationTestConfiguration.class
})
@Tag("com.icthh.xm.tmf.ms.promotion.AbstractSpringBootTest")
@ExtendWith(SpringExtension.class)
public abstract class AbstractSpringBootTest {

    // TODO: To speedup test:
    //      - find all cases which break Spring context like @MockBean and fix.
    //      - separate tests by categories: Unit, SpringBoot, WebMwc

}
