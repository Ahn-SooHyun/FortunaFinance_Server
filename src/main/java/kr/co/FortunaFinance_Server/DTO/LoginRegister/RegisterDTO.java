package kr.co.FortunaFinance_Server.DTO.LoginRegister;

import lombok.Data;

import java.util.Date;

/**
 * The RegisterDTO class is a Data Transfer Object used for transferring user registration details.
 */
@Data
public class RegisterDTO {

     /**
      * A unique index assigned to each RegisterDTO instance.
      */
     private int idx;

     /**
      * The gender of the user, which may be 'male', 'female', or 'other'.
      */
     private String gender;

     /**
      * The email address of the user.
      * This field must follow a valid email format.
      */
     private String email;

     /**
      * The phone number of the user.
      * This field must follow*/
     private String phone;

     /**
      * The postal code of the user's address.
      * This field must be exactly 5 digits in length.
      */
     private String postcode;

     /**
      * The address of the user.
      * This field represents the primary street address component of the user's location.
      */
     private String address;

     /**
      * The additional detailed component of the user's address.
      */
     private String detailAddress;

     /**
      * The birth date of the user.
      * This field represents the date on which the user was born.
      */
     private Date birth;

     /**
      * Constructs a new RegisterDTO instance with the given registration request and index.
      *
      * @param req the request object containing user registration details
      * @param idx the unique index assigned to the new RegisterDTO instance
      */
     public RegisterDTO(RegisterReq req, int idx) {
          this.idx = idx;
          this.gender = req.getGender();
          this.email = req.getEmail();
          this.phone = req.getPhone();
          this.postcode = req.getPostcode();
          this.address = req.getAddress();
          this.detailAddress = req.getDetailAddress();
          this.birth = req.getBirth();
     }
}
