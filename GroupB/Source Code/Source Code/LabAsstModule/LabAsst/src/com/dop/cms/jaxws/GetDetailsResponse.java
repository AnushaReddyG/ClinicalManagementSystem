
package com.dop.cms.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "getDetailsResponse", namespace = "http://cms.dop.com/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getDetailsResponse", namespace = "http://cms.dop.com/")
public class GetDetailsResponse {

    @XmlElement(name = "return", namespace = "", nillable = true)
    private com.dop.dataHolder.ListPatients[] _return;

    /**
     * 
     * @return
     *     returns ListPatients[]
     */
    public com.dop.dataHolder.ListPatients[] getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(com.dop.dataHolder.ListPatients[] _return) {
        this._return = _return;
    }

}
