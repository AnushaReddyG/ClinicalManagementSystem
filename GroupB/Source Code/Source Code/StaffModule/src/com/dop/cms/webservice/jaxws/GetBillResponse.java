
package com.dop.cms.webservice.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "getBillResponse", namespace = "http://webservice.cms.dop.com/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getBillResponse", namespace = "http://webservice.cms.dop.com/")
public class GetBillResponse {

    @XmlElement(name = "return", namespace = "")
    private com.dop.cms.data.Patient _return;

    /**
     * 
     * @return
     *     returns Patient
     */
    public com.dop.cms.data.Patient getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(com.dop.cms.data.Patient _return) {
        this._return = _return;
    }

}
