package com.ds.riskassesor.cloudModels;

import com.ds.riskassesor.methodstatement.model.models.MethodAssessment;
import com.ds.riskassesor.model.AssessmentImageDTO;
import com.ds.riskassesor.model.KeyStaffDTO;
import com.ds.riskassesor.model.NotepadDTO;
import com.ds.riskassesor.model.RiskDTO;
import com.ds.riskassesor.model.User;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sandeepjoshi on 20/08/15.
 */
public class FolderAssessmentsList {


    private boolean isChild;

    private int assessmentID;
    private int contractors;
    private int membersOfPublic;
    private int folder_id;
    private int subfoldercount;
    private String parent_key;
    private boolean anotherAssessmentRequired;
    private int visitors;
    private int disabled;
    private int youngPersons1;
    private String projectDescription;
    private int displayHandling;
    private int fire;
    private String unique_key;
    private int employees;
    private int nursingAndExpectant;
    private int isBeingEdited;
    private String timeStamp;
    private int manualHandling;
    private int cossh;
    private String riskAssessor;
    private String projectName;
    private int others;
    private int serviceUsers;
    private int youngPerson2;
    private String assessmentDate;
    private String workStartDate;
    private String date;
    private String anotherAssessmentDate;
    private String workEndDate;
    private String workFinishDate;
    private String assImg;
    private String screenShotPath;
    private String pdfId;
    @SerializedName("isMatrixPDF")
    private boolean isMatrixActivated;


    @SerializedName("reminderDate")
    private String furtherAssessmentTime;

    private List<RiskDTO> Risk;
    private com.ds.riskassesor.cloudModels.WebCompany Company;
    private User User;

    private boolean isChecked;


    private String rootParentKey;
    private List<KeyStaffDTO> Fitters;
    private List<AssessmentImageDTO> AppAssessmentImage;
    private List<NotepadDTO> Notes;
    private com.ds.riskassesor.cloudModels.FolderAssessmentsList childAssessment;
    private String PdfPath;


    @SerializedName("MethodStatment")
    private MethodAssessment  methodAssessment;


//Sign OF VAriables
    private boolean needApproval;
    private boolean needSignOff;
    private User approveBy;


    private int methodAssessmentId;
    private String methodAssessmentCloudId;


    public MethodAssessment getMethodAssessment() {
        return methodAssessment;
    }

    public void setMethodAssessment(MethodAssessment methodAssessment) {
        this.methodAssessment = methodAssessment;
    }

    @SerializedName("SignOffDetail")
    private ArrayList<User> signOffUserList;

    @SerializedName("no_of_signee_required")
    private int noOfSigneesRequired;

    @SerializedName("sign_off_mode")
    private int signOffMode;

    @SerializedName("approval_mode")
    private int approvalMode;





    public String getMethodAssessmentCloudId() {
        return methodAssessmentCloudId;
    }

    public void setMethodAssessmentCloudId(String methodAssessmentCloudId) {
        this.methodAssessmentCloudId = methodAssessmentCloudId;
    }

    public int getMethodAssessmentId() {
        return methodAssessmentId;
    }

    public void setMethodAssessmentId(int methodAssessmentId) {
        this.methodAssessmentId = methodAssessmentId;
    }

    public int getSignOffMode() {
        return signOffMode;
    }

    public void setSignOffMode(int signOffMode) {
        this.signOffMode = signOffMode;
    }

    public void setIsChild(boolean isChild) {
        this.isChild = isChild;
    }

    public void setIsMatrixActivated(boolean isMatrixActivated) {
        this.isMatrixActivated = isMatrixActivated;
    }

    public void setIsChecked(boolean isChecked) {
        this.isChecked = isChecked;
    }

    public boolean isNeedApproval() {
        return needApproval;
    }

    public void setNeedApproval(boolean needApproval) {
        this.needApproval = needApproval;
    }

    public boolean isNeedSignOff() {
        return needSignOff;
    }

    public void setNeedSignOff(boolean needSignOff) {
        this.needSignOff = needSignOff;
    }

    public com.ds.riskassesor.model.User getApproveBy() {
        return approveBy;
    }

    public void setApproveBy(com.ds.riskassesor.model.User approveBy) {
        this.approveBy = approveBy;
    }

    public int getApprovalMode() {
        return approvalMode;
    }

    public void setApprovalMode(int approvalMode) {
        this.approvalMode = approvalMode;
    }

    public ArrayList<com.ds.riskassesor.model.User> getSignOffUserList() {
        return signOffUserList;
    }

    public void setSignOffUserList(ArrayList<com.ds.riskassesor.model.User> signOffUserList) {
        this.signOffUserList = signOffUserList;
    }

    public int getNoOfSigneesRequired() {
        return noOfSigneesRequired;
    }

    public void setNoOfSigneesRequired(int noOfSigneesRequired) {
        this.noOfSigneesRequired = noOfSigneesRequired;
    }

    public boolean isMatrixActivated() {
        return isMatrixActivated;
    }

    public void setMatrixActivated(boolean isMatrixActivated) {
        this.isMatrixActivated = isMatrixActivated;
    }

    public String getFurtherAssessmentTime() {
        return furtherAssessmentTime;
    }

    public void setFurtherAssessmentTime(String furtherAssessmentTime) {
        this.furtherAssessmentTime = furtherAssessmentTime;
    }

    public String getPdfId() {
        return pdfId;
    }

    public void setPdfId(String pdfId) {
        this.pdfId = pdfId;
    }

    public String getScreenShotPath() {
        return screenShotPath;
    }

    public void setScreenShotPath(String screenShotPath) {
        this.screenShotPath = screenShotPath;
    }

    public boolean isChild() {
        return isChild;
    }

    public void setChild(boolean isChild) {
        this.isChild = isChild;
    }

    public String getAssImg() {
        return assImg;
    }

    public void setAssImg(String assImg) {
        this.assImg = assImg;
    }

    public String getPdfPath() {
        return PdfPath;
    }

    public void setPdfPath(String pdfPath) {
        PdfPath = pdfPath;
    }

    public int getAssessmentID() {
        return assessmentID;
    }

    public void setAssessmentID(int assessmentID) {
        this.assessmentID = assessmentID;
    }

    public String getRootParentKey() {
        return rootParentKey;
    }

    public void setRootParentKey(String rootParentKey) {
        this.rootParentKey = rootParentKey;
    }

    public com.ds.riskassesor.cloudModels.FolderAssessmentsList getChildAssessment() {
        return childAssessment;
    }

    public void setChildAssessment(com.ds.riskassesor.cloudModels.FolderAssessmentsList childAssessment) {
        this.childAssessment = childAssessment;
    }

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean isChecked) {
        this.isChecked = isChecked;
    }

    public int getContractors() {
        return contractors;
    }

    public void setContractors(int contractors) {
        this.contractors = contractors;
    }

    public int getMembersOfPublic() {
        return membersOfPublic;
    }

    public void setMembersOfPublic(int membersOfPublic) {
        this.membersOfPublic = membersOfPublic;
    }

    public int getFolder_id() {
        return folder_id;
    }

    public void setFolder_id(int folder_id) {
        this.folder_id = folder_id;
    }

    public int getSubfoldercount() {
        return subfoldercount;
    }

    public void setSubfoldercount(int subfoldercount) {
        this.subfoldercount = subfoldercount;
    }

    public String getParent_key() {
        return parent_key;
    }

    public void setParent_key(String parent_key) {
        this.parent_key = parent_key;
    }

    public boolean isAnotherAssessmentRequired() {
        return anotherAssessmentRequired;
    }

    public void setAnotherAssessmentRequired(boolean anotherAssessmentRequired) {
        this.anotherAssessmentRequired = anotherAssessmentRequired;
    }


    public int getVisitors() {
        return visitors;
    }

    public void setVisitors(int visitors) {
        this.visitors = visitors;
    }

    public int getDisabled() {
        return disabled;
    }

    public void setDisabled(int disabled) {
        this.disabled = disabled;
    }

    public int getYoungPersons1() {
        return youngPersons1;
    }

    public void setYoungPersons1(int youngPersons1) {
        this.youngPersons1 = youngPersons1;
    }

    public String getProjectDescription() {
        return projectDescription;
    }

    public void setProjectDescription(String projectDescription) {
        this.projectDescription = projectDescription;
    }

    public int getDisplayHandling() {
        return displayHandling;
    }

    public void setDisplayHandling(int displayHandling) {
        this.displayHandling = displayHandling;
    }

    public int getFire() {
        return fire;
    }

    public void setFire(int fire) {
        this.fire = fire;
    }

    public String getUnique_key() {
        return unique_key;
    }

    public void setUnique_key(String unique_key) {
        this.unique_key = unique_key;
    }

    public int getEmployees() {
        return employees;
    }

    public void setEmployees(int employees) {
        this.employees = employees;
    }

    public int getNursingAndExpectant() {
        return nursingAndExpectant;
    }

    public void setNursingAndExpectant(int nursingAndExpectant) {
        this.nursingAndExpectant = nursingAndExpectant;
    }

    public int getIsBeingEdited() {
        return isBeingEdited;
    }

    public void setIsBeingEdited(int isBeingEdited) {
        this.isBeingEdited = isBeingEdited;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public int getManualHandling() {
        return manualHandling;
    }

    public void setManualHandling(int manualHandling) {
        this.manualHandling = manualHandling;
    }

    public int getCossh() {
        return cossh;
    }

    public void setCossh(int cossh) {
        this.cossh = cossh;
    }

    public String getRiskAssessor() {
        return riskAssessor;
    }

    public void setRiskAssessor(String riskAssessor) {
        this.riskAssessor = riskAssessor;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public int getOthers() {
        return others;
    }

    public void setOthers(int others) {
        this.others = others;
    }

    public int getServiceUsers() {
        return serviceUsers;
    }

    public void setServiceUsers(int serviceUsers) {
        this.serviceUsers = serviceUsers;
    }

    public int getYoungPerson2() {
        return youngPerson2;
    }

    public void setYoungPerson2(int youngPerson2) {
        this.youngPerson2 = youngPerson2;
    }

    public String getAssessmentDate() {
        return assessmentDate;
    }

    public void setAssessmentDate(String assessmentDate) {
        this.assessmentDate = assessmentDate;
    }

    public String getWorkStartDate() {
        return workStartDate;
    }

    public void setWorkStartDate(String workStartDate) {
        this.workStartDate = workStartDate;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAnotherAssessmentDate() {
        return anotherAssessmentDate;
    }

    public void setAnotherAssessmentDate(String anotherAssessmentDate) {
        this.anotherAssessmentDate = anotherAssessmentDate;
    }

    public String getWorkEndDate() {
        return workEndDate;
    }

    public void setWorkEndDate(String workEndDate) {
        this.workEndDate = workEndDate;
    }

    public String getWorkFinishDate() {
        return workFinishDate;
    }

    public void setWorkFinishDate(String workFinishDate) {
        this.workFinishDate = workFinishDate;
    }

    public List<RiskDTO> getRisk() {
        return Risk;
    }

    public void setRisk(List<RiskDTO> risk) {
        Risk = risk;
    }

    public com.ds.riskassesor.cloudModels.WebCompany getCompany() {
        return Company;
    }

    public void setCompany(com.ds.riskassesor.cloudModels.WebCompany company) {
        Company = company;
    }

    public User getUser() {
        return User;
    }

    public void setUser(User user) {
        User = user;
    }

    public List<KeyStaffDTO> getFitters() {
        return Fitters;
    }

    public void setFitters(List<KeyStaffDTO> fitters) {
        Fitters = fitters;
    }

    public List<AssessmentImageDTO> getAppAssessmentImage() {
        return AppAssessmentImage;
    }

    public void setAppAssessmentImage(List<AssessmentImageDTO> appAssessmentImage) {
        AppAssessmentImage = appAssessmentImage;
    }

    public List<NotepadDTO> getNotes() {
        return Notes;
    }

    public void setNotes(List<NotepadDTO> notes) {
        Notes = notes;
    }
}
