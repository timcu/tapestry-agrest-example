package com.triptera.tagrest;

import javax.xml.bind.annotation.XmlRootElement;

import com.triptera.tagrest.model.cayenne.Category;

@XmlRootElement
public class CategoryObject {
  
  private String title;
  public String getTitle() {
    return title;
  }

  public String getDescription() {
    return description;
  }

  private String description;
  
  public CategoryObject(Category category) {
    this.title = category.getName();
    this.description = category.getDescription();
  }

}
