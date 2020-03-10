package com.narabel.provider;

import javax.inject.Inject;
import javax.ws.rs.ApplicationPath;

import org.glassfish.hk2.api.DynamicConfiguration;
import org.glassfish.hk2.api.DynamicConfigurationService;
import org.glassfish.hk2.api.ServiceLocator;
import org.glassfish.hk2.utilities.BuilderHelper;
import org.glassfish.jersey.server.ResourceConfig;

import com.narabel.dao.IPersonDao;
import com.narabel.dao.PersonDaoImpl;

@ApplicationPath("/webapi")
public class ResourceConfigApp extends ResourceConfig{
	
	@Inject
	public ResourceConfigApp(ServiceLocator locator) {
		
		// Obtain the DynamicConfiguration object for binding a service to a contract.
		DynamicConfigurationService dcs = locator.getService(DynamicConfigurationService.class);
		DynamicConfiguration config = dcs.createDynamicConfiguration();
		
		config.bind(BuilderHelper.link(PersonDaoImpl.class).to(IPersonDao.class).build());
		
		config.commit();

 		packages(true, "com.narabel;com.narabel.service");
	}
}
