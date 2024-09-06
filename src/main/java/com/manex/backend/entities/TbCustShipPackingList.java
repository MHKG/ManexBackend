package com.manex.backend.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_cust_ship_packing_list")
public class TbCustShipPackingList {

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "SHIPMENT_ID", nullable = false)
    private Integer shipmentId;

    @Column(name = "CUST_INV_ID", nullable = false)
    private Integer custInvId;

    @Column(name = "PRODUCT_ID", nullable = false)
    private Integer productId;

    @Column(name = "CTN_ID", nullable = false)
    private Integer ctnId;

    @Column(name = "CTN_QR_NUMBER")
    private Integer ctnQrNumber;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getShipmentId() {
        return shipmentId;
    }

    public void setShipmentId(Integer shipmentId) {
        this.shipmentId = shipmentId;
    }

    public Integer getCustInvId() {
        return custInvId;
    }

    public void setCustInvId(Integer custInvId) {
        this.custInvId = custInvId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getCtnId() {
        return ctnId;
    }

    public void setCtnId(Integer ctnId) {
        this.ctnId = ctnId;
    }

    public Integer getCtnQrNumber() {
        return ctnQrNumber;
    }

    public void setCtnQrNumber(Integer ctnQrNumber) {
        this.ctnQrNumber = ctnQrNumber;
    }
}
