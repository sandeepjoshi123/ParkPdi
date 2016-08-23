package com.ds.riskassesor.cloudModels;

import com.google.gson.annotations.SerializedName;

/**
 * Created by sandeepjoshi on 20/08/15.
 */
public class WebCompany {

    @SerializedName("emailAddress")
    private String emailAddress;

    @SerializedName("address3")
    private String address3;

    @SerializedName("telephonenumber")
    private String phoneNumber;

    private int company_id;
    private String zipCode;
    private String county;
    private String companyName;
    private boolean isMainCompany;
    private boolean isSelected;
    private String address1;
    private String unique_key;
    private String address2;
    private String company_logo;
    private int isCloud;



    private String sign_off_statement_app;
    private String sign_off_statement_report;
    private String approval_statement_app;
    private String approval_statement_report;
    private boolean sign_off_status;
    private boolean approval_status;

    private int cloud_company_id;


    public int getCloud_company_id() {
        return cloud_company_id;
    }

    public void setCloud_company_id(int cloud_company_id) {
        this.cloud_company_id = cloud_company_id;
    }

    public String getSign_off_statement_app() {
        return sign_off_statement_app;
    }

    public void setSign_off_statement_app(String sign_off_statement_app) {
        this.sign_off_statement_app = sign_off_statement_app;
    }

    public String getSign_off_statement_report() {
        return sign_off_statement_report;
    }

    public void setSign_off_statement_report(String sign_off_statement_report) {
        this.sign_off_statement_report = sign_off_statement_report;
    }

    public String getApproval_statement_app() {
        return approval_statement_app;
    }

    public void setApproval_statement_app(String approval_statement_app) {
        this.approval_statement_app = approval_statement_app;
    }

    public String getApproval_statement_report() {
        return approval_statement_report;
    }

    public void setApproval_statement_report(String approval_statement_report) {
        this.approval_statement_report = approval_statement_report;
    }

    public boolean isSign_off_status() {
        return sign_off_status;
    }

    public void setSign_off_status(boolean sign_off_status) {
        this.sign_off_status = sign_off_status;
    }

    public boolean isApproval_status() {
        return approval_status;
    }

    public void setApproval_status(boolean approval_status) {
        this.approval_status = approval_status;
    }

    public int getIsCloud() {
        return isCloud;
    }

    public void setIsCloud(int isCloud) {
        this.isCloud = isCloud;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getAddress3() {
        return address3;
    }

    public void setAddress3(String address3) {
        this.address3 = address3;
    }


    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getCompany_id() {
        return company_id;
    }

    public void setCompany_id(int company_id) {
        this.company_id = company_id;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName.replace("\\\\", "");
    }

    public boolean isMainCompany() {
        return isMainCompany;
    }

    public void setMainCompany(boolean isMainCompany) {
        this.isMainCompany = isMainCompany;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean isSelected) {
        this.isSelected = isSelected;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getUnique_key() {
        return unique_key;
    }

    public void setUnique_key(String unique_key) {
        this.unique_key = unique_key;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getCompany_logo() {
        return company_logo;
    }

    public void setCompany_logo(String company_logo) {
        this.company_logo = company_logo;
    }
}
