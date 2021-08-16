package com.triptera.tagrest.model.cayenne;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.triptera.tagrest.model.cayenne.auto._Category;

@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class Category extends _Category {

    private static final long serialVersionUID = 1L;

    @XmlElement
    @Override
    public String getDescription() {
      return super.getDescription();
    }

    @XmlElement
    @Override
    public String getName() {
      return super.getName();
    }

}
