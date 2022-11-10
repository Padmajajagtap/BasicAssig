package com.neosoft.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue
    private int userId;

    @NotBlank
//    @Pattern(regexp = "[A-Za-z]*", message = "Contains Alphanumeric Characters (A – z, 0 – 9) and Special characters Except ( =, ? , < , >, % )")
    private String userName;

    @NotBlank
    private String country;

    @NotBlank
    private String state;

    @NotBlank
    private String city;

    @NotBlank
    private String district;

    @NotBlank
//    @Size(message = "Allows 6 Digit only")
    private long pincode;

    @NotBlank
    //@Size(min = 12)
    private long adharnumber;

    @NotBlank

//    @Size(min = 10)
    private String pancard;

//    @NotBlank
//    @Size(max = 10, message = "Only 10 digit Contact Number")
//    @Pattern(regexp = "(\\+91|0)[0-9]{10}")
    private long contactnumber;

    @NotBlank
//    @Email(message = "Valid Email ID Email ID must be unique")
    private String emailId;

    @NotBlank
//    @Size(min = 8, message = "Password must be 8 character having Atleast 1 Alphanumeric, 1 caps, 1 Small and 1 Special Character is required")
    private String password;

    @NotBlank
//    @Size(min = 8, message = "Password must be 8 character having Atleast 1 Alphanumeric, 1 caps, 1 Small and 1 Special Character is required")
    private String confirmpassword;

   /* @Size(min = 10,max = 10, message = "Please Enter 10 Characters only")
    private String panCard;*/

}
