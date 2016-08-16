/*
 *  Copyright (c) 2016, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 *  WSO2 Inc. licenses this file to you under the Apache License,
 *  Version 2.0 (the "License"); you may not use this file except
 *  in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an
 *  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied.  See the License for the
 *  specific language governing permissions and limitations
 *  under the License.
 *
 */
package org.wso2.carbon.dashboard.portal.core.internal;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.osgi.framework.BundleContext;
import org.osgi.service.component.ComponentContext;
import org.wso2.carbon.dashboard.portal.core.PortalDataSourceService;
import org.wso2.carbon.ndatasource.core.DataSourceService;

/**
 * Service component implementation for analytics data sources.
 * @scr.component name="name="dashboard.portal.core" immediate="true"
 * @scr.reference name="datasource.service" interface="org.wso2.carbon.ndatasource.core.DataSourceService"
 * cardinality="1..1" policy="dynamic"  bind="setDataSourceService" unbind="unsetDataSourceService"
 */
public class PortalDataSourceComponent {
    
    private static final Log log = LogFactory.getLog(PortalDataSourceComponent.class);
    
    protected void activate(ComponentContext ctx) {
        if (log.isDebugEnabled()) {
            log.debug("Starting PortalDataSourceComponent#activate");
        }
        log.error("************              Here");
        BundleContext bundleContext = ctx.getBundleContext();
        bundleContext.registerService(PortalDataSourceService.class, new PortalDataSourceService() { }, null);
        if (log.isDebugEnabled()) {
            log.debug("Finished PortalDataSourceComponent#activate");
        }
    }
    
    protected void setDataSourceService(DataSourceService service) {
        ServiceHolder.setDataSourceService(service);
    }
    
    protected void unsetDataSourceService(DataSourceService service) {
        ServiceHolder.setDataSourceService(null);
    }
    
}