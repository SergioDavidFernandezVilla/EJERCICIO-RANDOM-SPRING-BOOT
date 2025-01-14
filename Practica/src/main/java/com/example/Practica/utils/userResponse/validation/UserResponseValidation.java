package com.example.Practica.utils.userResponse.validation;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

import com.example.Practica.utils.userResponse.regex.UserResponseRegex;

@Component  // Marca esta clase como un bean gestionado por Spring
public class UserResponseValidation {

    public boolean validateEmail(String email) {
        return email.matches(UserResponseRegex.EMAIL_REGEX);
    }

    public boolean validatePassword(String password) {
        return password.matches(UserResponseRegex.PASSWORD_REGEX);
    }

    public boolean validatePasswordConfirmation(String password, String confirmPassword) {
        return password.equals(confirmPassword);
    }

    public boolean validateUsername(String username) {
        return username.matches(UserResponseRegex.USERNAME_REGEX);
    }

    public boolean validateLastName(String lastName) {
        return lastName.matches(UserResponseRegex.LASTNAME_REGEX);
    }

    public boolean validateBirthDate(LocalDate birthDate) {
        return birthDate.toString().matches(UserResponseRegex.BIRTHDATE_REGEX);
    }

    public String getEmailValidation() {
        return UserResponseRegex.EMAIL_VALIDATION;
    }

    public String getPasswordValidation() {
        return UserResponseRegex.PASSWORD_VALIDATION;
    }

    public String getPasswordConfirmationValidation() {
        return UserResponseRegex.PASSWORD_CONFIRMATION_VALIDATION;
    }

    public String getUsernameValidation() {
        return UserResponseRegex.USERNAME_VALIDATION;
    }

    public String getLastNameValidation() {
        return UserResponseRegex.LASTNAME_VALIDATION;
    }

    public String getBirthDateValidation() {
        return UserResponseRegex.BIRTHDATE_VALIDATION;
    }

    public String getRegexEmail() {
        return UserResponseRegex.EMAIL_REGEX;
    }

    public String getRegexPassword() {
        return UserResponseRegex.PASSWORD_REGEX;
    }

    public String getRegexUsername() {
        return UserResponseRegex.USERNAME_REGEX;
    }

    public String getRegexLastName() {
        return UserResponseRegex.LASTNAME_REGEX;
    }

    public String getRegexBirthDate() {
        return UserResponseRegex.BIRTHDATE_REGEX;
    }

    public String getValidationEmail() {
        return UserResponseRegex.EMAIL_VALIDATION;
    }

    public String getValidationPassword() {
        return UserResponseRegex.PASSWORD_VALIDATION;
    }

    public String getValidationPasswordConfirmation() {
        return UserResponseRegex.PASSWORD_CONFIRMATION_VALIDATION;
    }

    public String getValidationUsername() {
        return UserResponseRegex.USERNAME_VALIDATION;
    }

    public String getValidationLastName() {
        return UserResponseRegex.LASTNAME_VALIDATION;
    }

    public String getValidationBirthDate() {
        return UserResponseRegex.BIRTHDATE_VALIDATION;
    }


}
