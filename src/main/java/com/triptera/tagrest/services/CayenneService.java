package com.triptera.tagrest.services;

import org.apache.cayenne.ObjectContext;
import org.apache.cayenne.configuration.server.ServerRuntime;

public interface CayenneService {
  
  ServerRuntime runtime();

  ObjectContext sharedContext();

  ObjectContext newContext();

}
