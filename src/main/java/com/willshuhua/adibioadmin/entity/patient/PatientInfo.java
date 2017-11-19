package com.willshuhua.adibioadmin.entity.patient;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatientInfo {

    private String customer_id;
    private String patient_infoid;
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

    public void setHeight(float height){
        this.height = height;
    }

    public void setHeight(String height) {
        String regex = "\"^(-?\\\\d+)(\\\\.\\\\d+)?$\"";
        if (height != null){
            if (height.matches(regex)){
                this.height = Float.valueOf(height);
            }
        }
    }

    public void setWeight(float weight){
        this.weight = weight;
    }

    public void setWeight(String weight) {
        String regex = "\"^(-?\\\\d+)(\\\\.\\\\d+)?$\"";
        if (weight != null){
            if (weight.matches(regex)){
                this.weight = Float.valueOf(weight);
            }
        }
    }
}
