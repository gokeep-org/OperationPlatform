package com.op.customer.bean.entity;

import java.util.List;

import com.google.gson.annotations.SerializedName;

/****************************************
 * Copyright (c) xuning.
 * 尊重版权，禁止抄袭!
 * 如有违反，必将追究其法律责任.
 * @Auther is xuning on 2017/4/19.
 ****************************************/
public class Contract {
    @SerializedName("_id")
    private String id;
    @SerializedName("create_date")
    private long createDate;
    private boolean status;
    @SerializedName("user_id")
    private String userId;
    @SerializedName("customer_id")
    private String customerId;
    @SerializedName("customer_name")
    private String customerName;
    @SerializedName("payment_ids")
    private List<String> paymentIds;
    @SerializedName("repayment_ids")
    private List<String> rePaymentIds;
    @SerializedName("product_ids")
    private List<String> productIds;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public long getCreateDate() {
        return createDate;
    }

    public void setCreateDate(long createDate) {
        this.createDate = createDate;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public List<String> getPaymentIds() {
        return paymentIds;
    }

    public void setPaymentIds(List<String> paymentIds) {
        this.paymentIds = paymentIds;
    }

    public List<String> getRePaymentIds() {
        return rePaymentIds;
    }

    public void setRePaymentIds(List<String> rePaymentIds) {
        this.rePaymentIds = rePaymentIds;
    }

    public List<String> getProductIds() {
        return productIds;
    }

    public void setProductIds(List<String> productIds) {
        this.productIds = productIds;
    }
}
