
package com.dop.cms.DocWs.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "getLabAssistDetResponse", namespace = "http://DocWs.cms.dop.com/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getLabAssistDetResponse", namespace = "http://DocWs.cms.dop.com/")
public class GetLabAssistDetResponse {

    @XmlElement(name = "return", namespace = "", nillable = true)
    private com.dop.cms.data.LabAssistantDetails[] _return;

    /**
     * 
     * @return
     *     returns LabAssistantDetails[]
     */
    public com.dop.cms.data.LabAssistantDetails[] getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(com.dop.cms.data.LabAssistantDetails[] _return) {
        this._return = _return;
    }

}
