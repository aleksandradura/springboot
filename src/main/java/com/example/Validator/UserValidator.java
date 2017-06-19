//package com.example.Validator;
//
//
//import com.example.model.StudentEntity;
//import com.example.service.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.autoconfigure.security.SecurityProperties;
//import org.springframework.stereotype.Component;
//import org.springframework.validation.Errors;
//import org.springframework.validation.ValidationUtils;
//import org.springframework.validation.Validator;
//
///**
// * Created by test on 19.06.2017.
// */
//@Component
//public class UserValidator implements Validator{
//
//        @Autowired
//        private UserService studentService;
//
//        @Override
//        public boolean supports(Class<?> aClass) {
//            return SecurityProperties.User.class.equals(aClass);
//        }
//
//        @Override
//        public void validate(Object o, Errors errors) {
//            StudentEntity user = (StudentEntity) o;
//
//            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "NotEmpty");
//            if (user.getIndeks().length() < 6 || user.getIndeks().length() > 6) {
//                errors.rejectValue("username", "indeks.size");
//
////            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty");
////            if (user.getPassword().length() < 8 || user.getPassword().length() > 32) {
////                errors.rejectValue("password", "Size.userForm.password");
////            }
////
////            if (!user.getPasswordConfirm().equals(user.getPassword())) {
////                errors.rejectValue("passwordConfirm", "Diff.userForm.passwordConfirm");
////            }
//        }
//    }
//}
