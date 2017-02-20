
package com.gomeo2o.service.account.rb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for acceptBalanceTask complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="acceptBalanceTask">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="taskBean" type="{http://webservice.rb.gome.founder.com/}refundBalanceTask" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "acceptBalanceTask", propOrder = {
    "taskBean"
})
public class AcceptBalanceTask_Type {

    protected RefundBalanceTask taskBean;

    /**
     * Gets the value of the taskBean property.
     * 
     * @return
     *     possible object is
     *     {@link RefundBalanceTask }
     *     
     */
    public RefundBalanceTask getTaskBean() {
        return taskBean;
    }

    /**
     * Sets the value of the taskBean property.
     * 
     * @param value
     *     allowed object is
     *     {@link RefundBalanceTask }
     *     
     */
    public void setTaskBean(RefundBalanceTask value) {
        this.taskBean = value;
    }

}
