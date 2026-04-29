package com.icthh.xm.tmf.ms.promotion.web.rest;

import com.icthh.xm.commons.gen.api.TenantsApiDelegate;
import com.icthh.xm.commons.gen.model.Tenant;
import com.icthh.xm.commons.permission.annotation.PrivilegeDescription;
import com.icthh.xm.commons.tenantendpoint.TenantManager;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Component
public class TenantResource implements TenantsApiDelegate {

    private final TenantManager tenantManager;

    @Override
    @Transactional
    @PreAuthorize("hasPermission({'tenant':#tenant}, 'PROMOTION.TENANT.CREATE')")
    @PrivilegeDescription("Privilege to add a new promotion tenant")
    public ResponseEntity<Void> addTenant(Tenant tenant) {
        tenantManager.createTenant(tenant);
        return ResponseEntity.ok().build();
    }

    @Override
    @PreAuthorize("hasPermission({'tenantKey':#tenantKey}, 'PROMOTION.TENANT.DELETE')")
    @PrivilegeDescription("Privilege to delete promotion tenant by tenantKey")
    public ResponseEntity<Void> deleteTenant(String tenantKey) {
        tenantManager.deleteTenant(tenantKey);
        return ResponseEntity.ok().build();
    }

    @Override
    @PostAuthorize("hasPermission(null, 'PROMOTION.TENANT.GET_LIST')")
    @PrivilegeDescription("Privilege to get all promotion tenants")
    public ResponseEntity<List<Tenant>> getAllTenantInfo() {
        return ResponseEntity.ok().build();
    }

    @Override
    @PostAuthorize("hasPermission({'returnObject': returnObject.body}, 'PROMOTION.TENANT.GET_LIST.ITEM')")
    @PrivilegeDescription("Privilege to get promotion tenant")
    public ResponseEntity<Tenant> getTenant(String s) {
        return ResponseEntity.ok().build();
    }

    @Override
    @PreAuthorize("hasPermission({'tenant':#tenant, 'status':#status}, 'PROMOTION.TENANT.UPDATE')")
    @PrivilegeDescription("Privilege to update promotion tenant")
    public ResponseEntity<Void> manageTenant(String tenant, String status) {
        tenantManager.manageTenant(tenant, status);
        return ResponseEntity.ok().build();
    }
}
