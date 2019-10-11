package com.candidjava.spring.bean;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;

@Entity
@Table(name = "foodtimetype")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class FoodTimeType {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer fdTypeId;
    private String fdTypeName;
    private Time fdTypeTimeFrom;
    private Time fdTypeTimeTo;
    private Date date;

    public Integer getFdTypeId() {
        return fdTypeId;
    }

    public void setFdTypeId(Integer fdTypeId) {
        this.fdTypeId = fdTypeId;
    }

    public String getFdTypeName() {
        return fdTypeName;
    }

    public void setFdTypeName(String fdTypeName) {
        this.fdTypeName = fdTypeName;
    }

    public Time getFdTypeTimeFrom() {
        return fdTypeTimeFrom;
    }

    public void setFdTypeTimeFrom(Time fdTypeTimeFrom) {
        this.fdTypeTimeFrom = fdTypeTimeFrom;
    }

    public Time getFdTypeTimeTo() {
        return fdTypeTimeTo;
    }

    public void setFdTypeTimeTo(Time fdTypeTimeTo) {
        this.fdTypeTimeTo = fdTypeTimeTo;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
