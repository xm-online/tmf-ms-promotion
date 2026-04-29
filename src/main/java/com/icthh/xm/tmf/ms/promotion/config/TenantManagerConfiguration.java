package com.icthh.xm.tmf.ms.promotion.config;

import com.icthh.xm.commons.config.client.repository.TenantConfigRepository;
import com.icthh.xm.commons.tenantendpoint.TenantManager;
import com.icthh.xm.commons.tenantendpoint.provisioner.TenantConfigProvisioner;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class TenantManagerConfiguration {

    @Bean
    public TenantManager tenantManager(TenantConfigProvisioner configProvisioner) {
        TenantManager manager = TenantManager.builder()
            .service(configProvisioner)
            .build();

        log.info("Configured tenant manager: {}", manager);
        return manager;
    }

    @Bean
    public TenantConfigProvisioner tenantConfigProvisioner(TenantConfigRepository tenantConfigRepository) {
        TenantConfigProvisioner provisioner = TenantConfigProvisioner
            .builder()
            .tenantConfigRepository(tenantConfigRepository)
            .build();

        log.info("Configured tenant config provisioner: {}", provisioner);
        return provisioner;
    }
}
