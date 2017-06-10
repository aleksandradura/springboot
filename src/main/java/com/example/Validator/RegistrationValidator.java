//package com.example.Validator;
//
//import com.example.model.StudentEntity;
//import com.example.service.StudentService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//import org.springframework.validation.Errors;
//
//import javax.validation.Validator;
//
//import static com.sun.javafx.css.StyleManager.errors;
//import static org.springframework.validation.ValidationUtils.rejectIfEmptyOrWhitespace;
//
///**
// * Created by test on 30.05.2017.
// */
//@Component
//public class RegistrationValidator implements Validator {
//    @Autowired
//    StudentService studentService;
//
//    @Override
//    public boolean supports(Class<?> paramClass) {
//        return StudentEntity.class.equals(paramClass);
//    }
//
//    public void validate(Object obj, Errors errors) {
//
//        StudentEntity student = (StudentEntity) obj;
//
//        rejectIfEmptyOrWhitespace(errors, "indeks", "form.not.empty");
//        rejectIfEmptyOrWhitespace(errors, "password", "form.not.empty");
//    }
//
//    int indeksLength = student.getIndeks.length();
//        if (indeksLength < 5 || indeksLength > 15) {
//        errors.rejectValue("username", "form.username.size");
//    }
//
//}
