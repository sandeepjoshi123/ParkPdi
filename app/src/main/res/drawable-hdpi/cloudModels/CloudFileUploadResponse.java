package com.ds.riskassesor.cloudModels;

import org.json.JSONObject;

/**
 * Created by sandeepjoshi on 28/08/15.
 */
public class CloudFileUploadResponse {


    private int status;
    private String Message;
    private int company_id;
    private int userSignature_id;
    private int image_id;
    private int pdf_id;

    private JSONObject assessmentJsonObject;


    public JSONObject getAssessmentJsonObject() {
        return assessmentJsonObject;
    }

    public void setAssessmentJsonObject(JSONObject assessmentJsonObject) {
        this.assessmentJsonObject = assessmentJsonObject;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }

    public int getCompany_id() {
        return company_id;
    }

    public void setCompany_id(int company_id) {
        this.company_id = company_id;
    }

    public int getUserSignature_id() {
        return userSignature_id;
    }

    public void setUserSignature_id(int userSignature_id) {
        this.userSignature_id = userSignature_id;
    }

    public int getImage_id() {
        return image_id;
    }

    public void setImage_id(int image_id) {
        this.image_id = image_id;
    }

    public int getPdf_id() {
        return pdf_id;
    }

    public void setPdf_id(int pdf_id) {
        this.pdf_id = pdf_id;
    }
}
