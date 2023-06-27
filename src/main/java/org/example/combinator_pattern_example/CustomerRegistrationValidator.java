package org.example.combinator_pattern_example;

import java.time.LocalDate;
import java.time.Period;
import java.util.function.Function;
import org.example.combinator_pattern_example.CustomerRegistrationValidator.ValidationResult;

public interface CustomerRegistrationValidator extends Function<Customer, ValidationResult> {


    static CustomerRegistrationValidator isEmailValid(){
        return customer ->
            customer.getEmail().contains("@")
                ? ValidationResult.SUCCESS
                :ValidationResult.EMAIL_NUMBER_NOT_VALID;
    }


    static CustomerRegistrationValidator isEmailPhoneNumber(){
        return customer ->
            customer.getPhoneNumber().contains("+0")
                ? ValidationResult.SUCCESS
                :ValidationResult.PHONE_NUMBER_NOT_VALID;
    }

    static CustomerRegistrationValidator isAnAdult(){
        return customer ->
            Period.between(customer.getDob(), LocalDate.now()).getYears() > 16 ?ValidationResult.SUCCESS
                :ValidationResult.IS_NOT_AN_ADULT;
    }

    default  CustomerRegistrationValidator and (CustomerRegistrationValidator other){
        return customer -> {
            ValidationResult result = this.apply(customer);
            return  result.equals(ValidationResult.SUCCESS) ? other.apply(customer) : result;
        };
    }

    enum ValidationResult {
      SUCCESS,  IS_NOT_AN_ADULT,
      PHONE_NUMBER_NOT_VALID, EMAIL_NUMBER_NOT_VALID, IS_NOT_VALID
    }

}
