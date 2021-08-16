package com.triptera.tagrest.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Configuration;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

import com.triptera.tagrest.model.cayenne.Book;

import io.agrest.Ag;
import io.agrest.DataResponse;

@Path("/book")
@Produces(MediaType.APPLICATION_JSON)
public class BookResource {

  @Context
  private Configuration config;

  @GET
  public DataResponse<Book> getAll(@Context UriInfo uriInfo) {
    return Ag.select(Book.class, config).uri(uriInfo).get();
  }

}
