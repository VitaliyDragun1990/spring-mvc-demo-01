package com.springdemo.mvc.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CourseCodeConstraintValidator implements ConstraintValidator<CourseCode, String> {

    private String[] coursePrefixes;

    public void initialize(CourseCode courseCode) {
        coursePrefixes = courseCode.value();
    }

    public boolean isValid(String code, ConstraintValidatorContext context) {

        boolean result = false;

        if (code != null) {
            for (String prefix: coursePrefixes) {
                result = code.startsWith(prefix);
                if (result) {
                    break;
                }
            }
        } else {
            result = true;
        }
        return result;
    }
}
