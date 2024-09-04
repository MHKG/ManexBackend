package com.manex.backend.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "tb_supplier_invoice")
public class TbSupplierInvoice implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "SUPP_PI_ID", nullable = false)
    private Integer suppPiId;

    @Column(name = "supp_inv_num")
    private String suppInvNum;

    @Column(name = "INV_MM")
    private Integer invMm;

    @Column(name = "UPDATED_BY")
    private Integer updatedBy;

    @Column(name = "TIMESTAMP")
    private Date timestamp;

    @Column(name = "TOTAL_GOODS_AMOUNT")
    private Float totalGoodsAmount;

    @Column(name = "INVOICE_CURRENCY")
    private Integer invoiceCurrency;

    @Column(name = "INVOICE_CURRENCY_RATE")
    private Float invoiceCurrencyRate;

    @Column(name = "SHIPPING_COST")
    private Float shippingCost;

    @Column(name = "PAYMENT_STATUS")
    private Integer paymentStatus;

    @Column(name = "STATUS")
    private Integer status;

    @Column(name = "remark")
    private String remark;
}
