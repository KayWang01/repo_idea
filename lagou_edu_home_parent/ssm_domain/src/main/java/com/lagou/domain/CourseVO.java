package com.lagou.domain;

public class CourseVO {


    private Integer id;
    private String courseName;
    private String brief;
    private double price;
    private String priceTag;
    private double discounts;
    private double discountsTag;
    private String courseDescriptionMarkDown;
    private String courseDescription;
    private String courseImgUrl;
    private int isNew;
    private int lastOperatorid;
    private int isDel;
    private int totalDuration;
    private String courseListImg;
    private int status;
    private int sortNum;
    private String previewFirstFiled;
    private String previewSecondFiles;
    private int sales;
    private String teacherName;
    private String position;
    private String description;

    @Override
    public String toString() {
        return "CourseVO{" +
                "id=" + id +
                ", courseName='" + courseName + '\'' +
                ", brief='" + brief + '\'' +
                ", price=" + price +
                ", priceTag='" + priceTag + '\'' +
                ", discounts=" + discounts +
                ", discountsTag=" + discountsTag +
                ", courseDescriptionMarkDown='" + courseDescriptionMarkDown + '\'' +
                ", courseDescription='" + courseDescription + '\'' +
                ", courseImgUrl='" + courseImgUrl + '\'' +
                ", isNew=" + isNew +
                ", lastOperatorid=" + lastOperatorid +
                ", isDel=" + isDel +
                ", totalDuration=" + totalDuration +
                ", courseListImg='" + courseListImg + '\'' +
                ", status=" + status +
                ", sortNum=" + sortNum +
                ", previewFirstFiled='" + previewFirstFiled + '\'' +
                ", previewSecondFiles='" + previewSecondFiles + '\'' +
                ", sales=" + sales +
                ", teacherName='" + teacherName + '\'' +
                ", position='" + position + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getPriceTag() {
        return priceTag;
    }

    public void setPriceTag(String priceTag) {
        this.priceTag = priceTag;
    }

    public double getDiscounts() {
        return discounts;
    }

    public void setDiscounts(double discounts) {
        this.discounts = discounts;
    }

    public double getDiscountsTag() {
        return discountsTag;
    }

    public void setDiscountsTag(double discountsTag) {
        this.discountsTag = discountsTag;
    }

    public String getCourseDescriptionMarkDown() {
        return courseDescriptionMarkDown;
    }

    public void setCourseDescriptionMarkDown(String courseDescriptionMarkDown) {
        this.courseDescriptionMarkDown = courseDescriptionMarkDown;
    }

    public String getCourseDescription() {
        return courseDescription;
    }

    public void setCourseDescription(String courseDescription) {
        this.courseDescription = courseDescription;
    }

    public String getCourseImgUrl() {
        return courseImgUrl;
    }

    public void setCourseImgUrl(String courseImgUrl) {
        this.courseImgUrl = courseImgUrl;
    }

    public int getIsNew() {
        return isNew;
    }

    public void setIsNew(int isNew) {
        this.isNew = isNew;
    }

    public int getLastOperatorid() {
        return lastOperatorid;
    }

    public void setLastOperatorid(int lastOperatorid) {
        this.lastOperatorid = lastOperatorid;
    }

    public int getIsDel() {
        return isDel;
    }

    public void setIsDel(int isDel) {
        this.isDel = isDel;
    }

    public int getTotalDuration() {
        return totalDuration;
    }

    public void setTotalDuration(int totalDuration) {
        this.totalDuration = totalDuration;
    }

    public String getCourseListImg() {
        return courseListImg;
    }

    public void setCourseListImg(String courseListImg) {
        this.courseListImg = courseListImg;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getSortNum() {
        return sortNum;
    }

    public void setSortNum(int sortNum) {
        this.sortNum = sortNum;
    }

    public String getPreviewFirstFiled() {
        return previewFirstFiled;
    }

    public void setPreviewFirstFiled(String previewFirstFiled) {
        this.previewFirstFiled = previewFirstFiled;
    }

    public String getPreviewSecondFiles() {
        return previewSecondFiles;
    }

    public void setPreviewSecondFiles(String previewSecondFiles) {
        this.previewSecondFiles = previewSecondFiles;
    }

    public int getSales() {
        return sales;
    }

    public void setSales(int sales) {
        this.sales = sales;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
