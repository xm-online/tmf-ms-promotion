package com.icthh.xm.tmf.ms.promotion.web.rest;

import com.icthh.xm.commons.lep.LogicExtensionPoint;
import com.icthh.xm.commons.lep.spring.LepService;
import com.icthh.xm.commons.permission.annotation.PrivilegeDescription;
import com.icthh.xm.tmf.ms.promotion.lep.keyresolver.PromotionIdKeyResolver;
import com.icthh.xm.tmf.ms.promotion.lep.keyresolver.PromotionCreateKeyResolver;
import com.icthh.xm.tmf.ms.promotion.lep.keyresolver.PromotionListKeyResolver;
import com.icthh.xm.tmf.ms.promotion.web.api.PromotionApiDelegate;
import com.icthh.xm.tmf.ms.promotion.web.api.model.Promotion;
import com.icthh.xm.tmf.ms.promotion.web.api.model.PromotionCreate;
import com.icthh.xm.tmf.ms.promotion.web.api.model.PromotionUpdate;
import io.micrometer.core.annotation.Timed;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@LepService(group = "service", name = "default")
public class PromotionDelegate implements PromotionApiDelegate {

    @Timed
    @LogicExtensionPoint(value = "retrievePromotion", resolver = PromotionIdKeyResolver.class)
    @PreAuthorize("hasPermission({'id': #id}, 'PROMOTION.GET')")
    @Override
    @PrivilegeDescription("Privilege to get a promotions")
    public ResponseEntity<List<Promotion>> retrievePromotion(String id) {
        logNativeRequest();
        return ResponseEntity.ok(List.of(new Promotion()));
    }

    @Timed
    @LogicExtensionPoint(value = "createPromotion", resolver = PromotionCreateKeyResolver.class)
    @PreAuthorize("hasPermission({'promotion': #promotion}, 'PROMOTION.CREATE')")
    @Override
    @PrivilegeDescription("Privilege to create a promotion")
    public ResponseEntity<Promotion> createPromotion(PromotionCreate promotion) {
        logNativeRequest();
        return ResponseEntity.ok(new Promotion());
    }

    @Timed
    @LogicExtensionPoint(value = "deletePromotion", resolver = PromotionIdKeyResolver.class)
    @PreAuthorize("hasPermission({'id': #id}, 'PROMOTION.DELETE')")
    @Override
    @PrivilegeDescription("Privilege to delete a promotion")
    public ResponseEntity<Void> deletePromotion(String id) {
        logNativeRequest();
        return ResponseEntity.ok().build();
    }

    @Timed
    @LogicExtensionPoint(value = "listPromotion", resolver = PromotionListKeyResolver.class)
    @PreAuthorize("hasPermission({'fields': #fields, 'offset': #offset, 'limit': #limit}, 'PROMOTION.LIST')")
    @Override
    @PrivilegeDescription("Privilege to list promotions")
    public ResponseEntity<List<Promotion>> listPromotion(String fields, Integer offset, Integer limit) {
        logNativeRequest();
        return ResponseEntity.ok(List.of(new Promotion()));
    }

    @Timed
    @LogicExtensionPoint(value = "patchPromotion", resolver = PromotionCreateKeyResolver.class)
    @PreAuthorize("hasPermission({'id': #id, 'promotion': #promotion}, 'PROMOTION.PATCH')")
    @Override
    @PrivilegeDescription("Privilege to patch a promotion")
    public ResponseEntity<Promotion> patchPromotion(String id, PromotionUpdate promotion) {
        logNativeRequest();
        return ResponseEntity.ok(new Promotion());
    }

    private void logNativeRequest() {
        if (getRequest().isPresent()) {
            log.info("Native request {}", getRequest().get().getNativeRequest());
        }
    }
}
