package com.triptera.tagrest.pages;

import java.util.List;

import org.apache.cayenne.query.ObjectSelect;
import org.apache.tapestry5.annotations.PageActivationContext;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.triptera.tagrest.model.cayenne.Category;
import com.triptera.tagrest.services.CayenneService;

public class About
{
    private static final Logger logger = LoggerFactory.getLogger(About.class);
    @PageActivationContext
    private String learn;

    public String getLearn() {
        return learn;
    }

    public void setLearn(String learn) {
        this.learn = learn;
    }
    
    @Inject
    CayenneService svcCayenne;
    
    public List<Category> getListCategory() {
      logger.warn("Getting categories");
      return ObjectSelect.query(Category.class)
            .orderBy(Category.NAME.ascInsensitives())
            .select(svcCayenne.newContext());

    }
    @Property
    private Category category;
}
