package com.triptera.tagrest.rest;

import java.util.List;
import java.util.stream.Collectors;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Configuration;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import org.apache.cayenne.query.ObjectSelect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.triptera.tagrest.CategoryObject;
import com.triptera.tagrest.model.cayenne.Category;
import com.triptera.tagrest.services.CayenneService;

@Path("/category")
@Produces(MediaType.APPLICATION_JSON)
public class CategoryResource {
  
  private static final Logger logger = LoggerFactory.getLogger(CategoryResource.class);
  
  @Context
  private Configuration config;
  
  private CayenneService svcCayenne;
  
  public CategoryResource(CayenneService svcCayenne) {
    this.svcCayenne = svcCayenne;
  }

  @GET
  public List<Category> getAllCategories() {
    List<Category> list = ObjectSelect.query(Category.class)
          .orderBy(Category.NAME.ascInsensitives())
          .select(svcCayenne.newContext());
    logger.warn("Found " + list.size() + " categories");
    List<CategoryObject> lco = list.stream().map(x -> new CategoryObject(x)).collect(Collectors.toList());
    for (CategoryObject co : lco) {
      logger.warn("CategoryObject " + co.getTitle() + " " + co.getDescription());
    }
    return list;
  }

}
