package com.triptera.tagrest.services;

import org.apache.cayenne.ObjectContext;
import org.apache.cayenne.configuration.Constants;
import org.apache.cayenne.configuration.server.ServerModule;
import org.apache.cayenne.configuration.server.ServerRuntime;
import org.apache.cayenne.di.Binder;
import org.apache.cayenne.di.Module;
import org.apache.tapestry5.ioc.services.RegistryShutdownHub;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CayenneServiceImpl implements CayenneService {

  private static Logger logger = LoggerFactory.getLogger(CayenneServiceImpl.class);

  private ServerRuntime runtime;
  private ObjectContext sharedContext;

  public CayenneServiceImpl(RegistryShutdownHub shutdownHub) {
    Module module = new Module() {

      @Override
      public void configure(Binder binder) {
        //binder.bind(QueryCache.class).toInstance(new JCacheQueryCache());
        // Turns off Cross Context Synchronization ( see Cayenne4.mp4 at 52:25 or
        // https://cayenne.apache.org/docs/4.1/cayenne-guide/#caching)
        // binder.bindMap(String.class,
        // Constants.PROPERTIES_MAP).put(Constants.SERVER_CONTEXTS_SYNC_PROPERTY,
        // "false");
        ServerModule.contributeProperties(binder).put(Constants.SERVER_CONTEXTS_SYNC_PROPERTY, "false");
      }
    };

    runtime = ServerRuntime.builder().addConfig("cayenne-project.xml").addModule(module).build();

    sharedContext = runtime.newContext();
    
    logger.warn("Created two categories");

    shutdownHub.addRegistryShutdownListener(new Runnable() {
      public void run() {
        runtime.shutdown();
      }
    });


  }

  @Override
  public ServerRuntime runtime() {
    return runtime;
  }

  @Override
  public ObjectContext sharedContext() {
    return sharedContext;
  }

  @Override
  public ObjectContext newContext() {
    return runtime.newContext();
  }

}
