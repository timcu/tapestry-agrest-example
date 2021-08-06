package com.triptera.tagrest.rest;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.triptera.tagrest.MyDomainObject;

@Path("/mydomainobject")
public class MyDomainObjectResource {

  @GET
  @Produces({"application/json"})
  public List<MyDomainObject> getAllDomains() 
  {
    List<MyDomainObject> lstMdo = new ArrayList<MyDomainObject>();
    lstMdo.add(new MyDomainObject(1, "one"));
    lstMdo.add(new MyDomainObject(2, "two"));
    lstMdo.add(new MyDomainObject(3, "three"));
    return lstMdo;
  }
  
  
}
