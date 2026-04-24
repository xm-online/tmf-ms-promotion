package com.icthh.xm.tmf.ms.promotion.config.lep;

import com.icthh.xm.commons.config.client.service.TenantConfigService;
import com.icthh.xm.commons.lep.api.BaseLepContext;
import com.icthh.xm.commons.lep.commons.CommonsService;
import com.icthh.xm.commons.permission.service.PermissionCheckService;
import org.springframework.web.client.RestTemplate;

public class LepContext extends BaseLepContext {

    public TenantConfigService tenantConfigService;
    public RestTemplate restTemplate;
    public CommonsService commonsService;
    public PermissionCheckService permissionCheckService;

}

