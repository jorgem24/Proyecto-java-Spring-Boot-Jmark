package com.example.demo.restController;
import com.example.demo.model.ActivityLog;
import com.example.demo.model.User;
import com.example.demo.service.ActivityLogService;
import com.example.demo.service.UserService;
import com.example.demo.utilities.Utilities;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;

@RestController
@RequestMapping("api/v1/user/")
public class UserRestController {

    @Autowired
    UserService userService;

    @Autowired
    ActivityLogService activityLogService;

    //CRUD: get all
    @GetMapping("/getAllUser")
    public ResponseEntity<Iterable<User>> getAllBooks(HttpServletRequest request){

        // query to service to get all Users
        ArrayList<User> usersFromService = userService.getAllUsers();
        // call Utilities to create a log
        ActivityLog activityLog = Utilities.createLog(request,"getAllUsers",
                "users", "processing", "/api/v1/book/getAllUsers", "GET");
        HttpHeaders headers = Utilities.createHeader(activityLog);
        //Timestamp timestamp2 = new Timestamp(System.currentTimeMillis());
        //System.out.println("Lapsed time: " + ( timestamp2.getNanos() - timestamp.getNanos()));

        if (usersFromService != null) {
            activityLog.setStatus("success");
            activityLogService.addActivityLog(activityLog);
            headers.add("status", "success");
            return ResponseEntity.accepted().headers(headers).body(usersFromService);
        } else {
            activityLog.setStatus("fail");
            activityLogService.addActivityLog(activityLog);
            headers.add("status", "fail");
            return ResponseEntity.internalServerError().headers(headers).body(usersFromService);
        }
    }

    //CRUD: get by id
    @GetMapping("/getBookById/{id}")
    public ResponseEntity<User> getBookById(HttpServletRequest request, @PathVariable  String  id){

        // call to service for find by id
       User user = userService.findUserById(id);

        ActivityLog activityLog = Utilities.createLog(request,"getUserById",
                "users", "processing", "api/v1/user/getUserById", "GET");

        HttpHeaders headers = Utilities.createHeader(activityLog);

        if (user != null) {
            activityLog.setStatus("success");
            activityLogService.addActivityLog(activityLog);
            headers.add("status", "success");
            return ResponseEntity.accepted().headers(headers).body(user);
        } else {
            activityLog.setStatus("fail");
            activityLogService.addActivityLog(activityLog);
            headers.add("status", "fail");
            return ResponseEntity.internalServerError().headers(headers).body(user);
        }
    }

    //CRUD: delete all
    @DeleteMapping("/deleteAllUsers")
    public ResponseEntity deleteAllBooks (HttpServletRequest request){

       // query to delete all users
        int qty = userService.qtyUsers();
        boolean deleted = userService.deleteAllUsers();


        ActivityLog activityLog = Utilities.createLog(request,"deleteAllBooks",
                "users", "processing", "api/v1/user/deleteAllUsers", "DELETE");

        HttpHeaders headers = Utilities.createHeader(activityLog);

        if (deleted) {
            activityLog.setStatus("success");
            activityLogService.addActivityLog(activityLog);
            headers.add("status", "success");
            headers.add("qtyObjectsDeleted", String.valueOf(qty));
            return ResponseEntity.accepted().headers(headers).body(null);
        } else {
            activityLog.setStatus("fail");
            activityLogService.addActivityLog(activityLog);
            headers.add("status", "fail");
            return ResponseEntity.internalServerError().headers(headers).body(null);
        }
    }

    //CRUD: delete by id
    @DeleteMapping("/deleteBookById/{id}")
    public ResponseEntity<User> deleteBookById (HttpServletRequest request, @PathVariable String id){

       User user = userService.deleteById(id);
        ActivityLog activityLog = Utilities.createLog(request,"deleteBookById",
                "users", "processing", "api/v1/user/deleteUserById", "DELETE");

        HttpHeaders headers = Utilities.createHeader(activityLog);

        if (user != null) {
            activityLog.setStatus("success");
            activityLogService.addActivityLog(activityLog);
            headers.add("status", "success");
            return ResponseEntity.accepted().headers(headers).body(user);
        } else {
            activityLog.setStatus("fail");
            activityLogService.addActivityLog(activityLog);
            headers.add("status", "fail");
            return ResponseEntity.internalServerError().headers(headers).body(user);
        }


    }

    //CRUD: create
    @PostMapping(path = "/createBook", consumes = "application/JSON")
    public ResponseEntity<User> addBook(HttpServletRequest request, @RequestBody User user) {
        //
        ActivityLog activityLog = Utilities.createLog(request,"createBook",
                "users", "fail", "api/v1/user/createUser", "POST");


        HttpHeaders headers = Utilities.createHeader(activityLog);

        User userCreated = userService.createUser(user);


        if (userCreated != null) {
            activityLog.setStatus("success");
            activityLogService.addActivityLog(activityLog);
            headers.add("status", "success");
            return ResponseEntity.accepted().headers(headers).body(user);
        } else {
            activityLog.setStatus("fail");
            activityLogService.addActivityLog(activityLog);
            headers.add("status", "fail");
            return ResponseEntity.internalServerError().headers(headers).body(user);
        }
    }

    //CRUD: update
    @PutMapping("/updateUser/{id}")
    public ResponseEntity<User> updateBook (HttpServletRequest request, @PathVariable String id,
                                            @RequestBody User user){

        User userToUpdate = userService.updateUser(id, user);

        ActivityLog activityLog = Utilities.createLog(request,"updateUser",
                "users", "processing", "api/v1/user/updateUser", "PUT");

        HttpHeaders headers = Utilities.createHeader(activityLog);

        if (userToUpdate != null) {
            activityLog.setStatus("success");
            activityLogService.addActivityLog(activityLog);
            headers.add("status", "success");
            return ResponseEntity.accepted().headers(headers).body(user);
        } else {
            activityLog.setStatus("fail");
            activityLogService.addActivityLog(activityLog);
            headers.add("status", "fail");
            return ResponseEntity.internalServerError().headers(headers).body(user);
        }
    }



}
