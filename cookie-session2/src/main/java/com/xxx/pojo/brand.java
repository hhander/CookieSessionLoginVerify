package com.xxx.pojo;

public class brand {
    private int id;
    private String brandName;

    public brand(int id, String brandName, String companyName, int orderd, String description, int status) {
        this.id = id;
        this.brandName = brandName;
        this.companyName = companyName;
        this.orderd = orderd;
        this.description = description;
        this.status = status;
    }

    @Override
    public String toString() {
        return "brand{" +
                "id=" + id +
                ", brandName='" + brandName + '\'' +
                ", companyName='" + companyName + '\'' +
                ", orderd=" + orderd +
                ", description='" + description + '\'' +
                ", status=" + status +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public int getOrderd() {
        return orderd;
    }

    public void setOrderd(int orderd) {
        this.orderd = orderd;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public brand() {
    }

    private String companyName;
    private int orderd;
    private String description;
    private int status;

}
