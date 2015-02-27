
package com.dop.cms.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "loginResponse", namespace = "http://cms.dop.com/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "loginResponse", namespace = "http://cms.dop.com/")
public class LoginResponse {

    @XmlElement(name = "return", namespace = "")
    private com.dop.cms.dataholder.LoginReturn _return;

    /**
     * 
     * @return
     *     returns LoginReturn
     */
    public com.dop.cms.dataholder.LoginReturn getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(com.dop.cms.dataholder.LoginReturn _return) {
        this._return = _return;
    }

}
