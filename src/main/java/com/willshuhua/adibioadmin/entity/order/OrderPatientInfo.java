package com.willshuhua.adibioadmin.entity.order;

import com.willshuhua.adibioadmin.entity.patient.PatientInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderPatientInfo {

    private String order_infoid;
    private String order_patient_infoid;
    private String name;
    private String gender;
    private float age;
    private String country;
    private String province;
    private String city;
    private String district;
    private String address;
    private String phone;
    private int has_diabetic;
    private int is_pregnant;
    private float height;
    private float weight;

    public OrderPatientInfo(PatientInfo patientInfo, String orderInfoid){
        this.order_infoid = orderInfoid;
        this.name = patientInfo.getName();
        this.gender = patientInfo.getGender();
        this.age = patientInfo.getAge();
        this.country = patientInfo.getCountry();
        this.province = patientInfo.getProvince();
        this.city = patientInfo.getCity();
        this.district = patientInfo.getDistrict();
        this.address = patientInfo.getAddress();
        this.phone = patientInfo.getPhone();
        this.has_diabetic = patientInfo.getHas_diabetic();
        this.is_pregnant = patientInfo.getIs_pregnant();
        this.height = patientInfo.getHeight();
        this.weight = patientInfo.getWeight();
        this.order_patient_infoid = UUID.randomUUID().toString();
    }
}
