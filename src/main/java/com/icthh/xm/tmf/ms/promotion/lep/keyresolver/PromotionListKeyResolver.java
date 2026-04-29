package com.icthh.xm.tmf.ms.promotion.lep.keyresolver;

import com.icthh.xm.lep.api.LepKeyResolver;
import com.icthh.xm.lep.api.LepMethod;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class PromotionListKeyResolver implements LepKeyResolver {

    @Override
    public List<String> segments(LepMethod method) {
        String fields = method.getParameter("fields", String.class);
        
        return List.of(fields != null ? fields : "");
    }
}
