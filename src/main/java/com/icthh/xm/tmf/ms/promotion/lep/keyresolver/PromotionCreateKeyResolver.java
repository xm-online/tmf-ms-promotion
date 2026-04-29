package com.icthh.xm.tmf.ms.promotion.lep.keyresolver;

import com.icthh.xm.lep.api.LepKeyResolver;
import com.icthh.xm.lep.api.LepMethod;
import com.icthh.xm.tmf.ms.promotion.web.api.model.PromotionCreate;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class PromotionCreateKeyResolver implements LepKeyResolver {

    @Override
    public List<String> segments(LepMethod method) {
        return List.of(method.getParameter("promotion", PromotionCreate.class).getType());
    }
}
