
package com.dop.cms.PatWs.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "getDocBySpecResponse", namespace = "http://PatWs.cms.dop.com/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getDocBySpecResponse", namespace = "http://PatWs.cms.dop.com/")
public class GetDocBySpecResponse {

    @XmlElement(name = "return", namespace = "", nillable = true)
    private com.dop.cms.data.DocNamesBySpec[] _return;

    /**
     * 
     * @return
     *     returns DocNamesBySpec[]
     */
    public com.dop.cms.data.DocNamesBySpec[] getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(com.dop.cms.data.DocNamesBySpec[] _return) {
        this._return = _return;
    }

}
