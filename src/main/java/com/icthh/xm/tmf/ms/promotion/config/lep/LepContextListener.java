package com.icthh.xm.tmf.ms.promotion.config.lep;

import com.icthh.xm.commons.config.client.service.TenantConfigService;
import com.icthh.xm.commons.lep.api.BaseLepContext;
import com.icthh.xm.commons.lep.api.LepContextFactory;
import com.icthh.xm.commons.lep.commons.CommonsService;
import com.icthh.xm.commons.permission.service.PermissionCheckService;
import com.icthh.xm.lep.api.LepMethod;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class LepContextListener implements LepContextFactory {

    private final TenantConfigService tenantConfigService;
    private final RestTemplate restTemplate;
    private final CommonsService commonsService;
    private final PermissionCheckService permissionCheckService;

    public LepContextListener(TenantConfigService tenantConfigService,
                              @Qualifier("loadBalancedRestTemplate")
                              RestTemplate restTemplate,
                              CommonsService commonsService,
                              PermissionCheckService permissionCheckService) {
        this.tenantConfigService = tenantConfigService;
        this.restTemplate = restTemplate;
        this.commonsService = commonsService;
        this.permissionCheckService = permissionCheckService;
    }

    @Override
    public BaseLepContext buildLepContext(LepMethod lepMethod) {
        LepContext lepContext = new LepContext();

        lepContext.services = new LepContext.LepServices();
        lepContext.services.tenantConfigService = tenantConfigService;
        lepContext.services.permissionService = permissionCheckService;

        lepContext.templates = new LepContext.LepTemplates();
        lepContext.templates.rest = restTemplate;

        return lepContext;
    }
}
