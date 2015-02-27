
package com.dop.cms.PatWs.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "requestBillResponse", namespace = "http://PatWs.cms.dop.com/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "requestBillResponse", namespace = "http://PatWs.cms.dop.com/")
public class RequestBillResponse {

    @XmlElement(name = "return", namespace = "")
    private com.dop.cms.PatWs.dataHolders.Bill _return;

    /**
     * 
     * @return
     *     returns Bill
     */
    public com.dop.cms.PatWs.dataHolders.Bill getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(com.dop.cms.PatWs.dataHolders.Bill _return) {
        this._return = _return;
    }

}
