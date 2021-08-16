package com.triptera.tagrest.services;

import org.apache.cayenne.configuration.server.ServerRuntime;

import io.agrest.cayenne.AgCayenneBuilder;
import io.agrest.cayenne.AgCayenneModule;
import io.agrest.runtime.AgBuilder;
import io.agrest.runtime.AgRuntime;

public class AgrestServiceImpl implements AgrestService {
  
//  @Inject
//  private CayenneService svcCayenne;
  
  public AgrestServiceImpl() {
    ServerRuntime runtime = ServerRuntime.builder().addConfig("cayenne-project.xml").build();
    AgCayenneModule cayenneExt = AgCayenneBuilder.build(runtime);
    agRuntime = new AgBuilder().module(cayenneExt).build();
  }
  
  private AgRuntime agRuntime;
  

  public AgRuntime agRuntime() {
    return agRuntime;
  }

}
