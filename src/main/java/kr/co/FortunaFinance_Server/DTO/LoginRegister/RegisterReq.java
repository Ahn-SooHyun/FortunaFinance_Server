package kr.co.FortunaFinance_Server.DTO.LoginRegister;

import jakarta.validation.constraints.*;
import lombok.Data;
import java.util.Date;

/**
 * The RegisterReq class is used to represent the registration request details for a new user.
 */
@Data
public class RegisterReq {

    /**
     * Represents the unique identifier for a user.
     * The ID must be between 8 and 30 characters long and cannot be empty.
     * This ID is used during the user registration process.
     */
    @NotBlank(message = "ID cannot be empty.")
    @Size(min = 8, max = 30, message = "ID must be between 8 and 30 characters.")
    private String id;

    /**
     * Represents the user's password during the registration process.
     * The password field has several constraints to ensure its security:
     * - It cannot be empty.
     * - Its length must be between 8 and 30 characters.
     * - It must contain at least one letter (lowercase or uppercase), one number, and one special character.
     */
    @NotBlank(message = "Password cannot be empty.")
    @Size(min = 8, max = 30, message = "Password must be between 8 and 30 characters.")
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-zA-Z])(?=.*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?]).{8,30}$",
            message = "Password must include at least one letter (lowercase or uppercase), one number, and one special character.")
    private String pw;
    /**
     * Represents the name of the user.
     *
     * The name field has the following constraints:
     * - It cannot be empty.
     * - It must contain only letters (either Korean characters or English alphabets).
     */
    @NotBlank(message = "Name cannot be empty.")
    @Pattern(regexp = "^[가-힣a-zA-Z]+$", message = "Name must contain only letters.")
    private String name;
    /**
     * Represents the birth date of a user.
     * This field is mandatory and must specify a date in the past.
     */
    @NotNull(message = "Birth date cannot be empty.")
    @Past(message = "Birth date must be a past date.")
    private Date birth;
    /**
     * Represents the gender of the user.
     *
     * The gender field has the following constraints:
     * - It cannot be empty.
     * - It must be one of the following values: 'male', 'female', 'other'.
     */
    @NotBlank(message = "Gender cannot be empty.")
    @Pattern(regexp = "^(male|female|other)$", message = "Gender must be 'male', 'female', or 'other'.")
    private String gender;
    /**
     * Represents the phone number of a user in the registration request.
     * This field cannot be empty and must adhere to the specific pattern for phone numbers.
     *
     * Constraints:
     * - Cannot be blank.
     * - Must follow the pattern 010-1234-5678.
     */
    @NotBlank(message = "Phone number cannot be empty.")
    @Pattern(regexp = "^(010|011|016|017|018|019)-\\d{3,4}-\\d{4}$", message = "Phone number must follow the pattern 010-1234-5678.")
    private String phone;
    /**
     * Represents the email address of a user in the registration request.
     * The email must not be blank and should follow a valid email format.
     * Used in the RegisterReq class.
     *
     * Validation constraints:
     *   - Must not be empty.
     *   - Must be in a valid email format.
     */
    @NotBlank(message = "Email cannot be empty.")
    @Email(message = "Invalid email format.")
    private String email;
    /**
     * Represents the postcode of a user in the registration request.
     *
     * The postcode must be exactly 5 digits long and cannot be empty.
     *
     * Constraints:
     * - The postcode must not be blank.
     **/
    @NotBlank(message = "Postcode cannot be empty.")
    @Size(min = 5, max = 5, message = "Postcode must be 5 digits.")
    private String postcode;

    /**
     * The address of the user registering.
     * This field cannot be blank and an appropriate error message is displayed if the address is not provided.
     */
    @NotBlank(message = "Address cannot be empty.")
    private String address;

    /**
     * A detailed residential or office address provided by the user during the registration process.
     * This field is optional and does not require validation.
     */
    // Assuming DetailAddress is optional and does not need validation
    private String detailAddress;
}
