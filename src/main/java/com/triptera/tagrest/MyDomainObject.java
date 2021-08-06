package com.triptera.tagrest;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "mydomainobject")
public class MyDomainObject {
  
  public MyDomainObject(int id, String vc_domain) {
    this.id = id;
    this.vcDomain = vc_domain;
  }
  
  private int id;
  private String vcDomain;
  
  public int getId() {
    return id;
  }
  public void setId(int id) {
    this.id = id;
  }
  public String getVcDomain() {
    return vcDomain;
  }
  public void setVcDomain(String vc_domain) {
    this.vcDomain = vc_domain;
  }
  public boolean equals(Object o)
  {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    MyDomainObject that = (MyDomainObject) o;

    return getId() == that.getId();
  }

  public int hashCode()
  {
    return Integer.valueOf(getId()).hashCode();
  }

  public String toString()
  {
    return getVcDomain();
  }

}
