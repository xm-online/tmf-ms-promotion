package com.icthh.xm.tmf.ms.promotion.config.lep;

import com.icthh.xm.commons.config.client.service.TenantConfigService;
import com.icthh.xm.commons.lep.api.BaseLepContext;
import com.icthh.xm.commons.lep.commons.CommonsService;
import com.icthh.xm.commons.permission.service.PermissionCheckService;
import org.springframework.web.client.RestTemplate;

public class LepContext extends BaseLepContext {

    public LepCommons commons;
    public LepServices services;
    public LepTemplates templates;

    public static class LepCommons {
        public CommonsService commonsService;
    }

    public static class LepServices {
        public TenantConfigService tenantConfigService;
        public PermissionCheckService permissionService;
    }

    public static class LepTemplates {
        public RestTemplate rest;
    }

}
