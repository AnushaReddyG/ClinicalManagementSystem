
package com.dop.cms.PatWs.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "getPatDetailsResponse", namespace = "http://PatWs.cms.dop.com/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getPatDetailsResponse", namespace = "http://PatWs.cms.dop.com/")
public class GetPatDetailsResponse {

    @XmlElement(name = "return", namespace = "")
    private com.dop.cms.data.PatientDetails _return;

    /**
     * 
     * @return
     *     returns PatientDetails
     */
    public com.dop.cms.data.PatientDetails getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(com.dop.cms.data.PatientDetails _return) {
        this._return = _return;
    }

}
