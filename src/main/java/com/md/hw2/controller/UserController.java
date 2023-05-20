package com.md.hw2.controller;

import com.md.hw2.base.RestResponse;
import com.md.hw2.controller.contract.UserControllerContract;
import com.md.hw2.dto.UserDto;
import com.md.hw2.dto.requests.CreateUserRequest;
import com.md.hw2.dto.requests.DeleteUserRequest;
import com.md.hw2.dto.requests.UpdateUserRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserControllerContract userControllerContract;

    @PostMapping
    public ResponseEntity<RestResponse<UserDto>> save(@RequestBody CreateUserRequest createUserRequest) {
        var userDTO = userControllerContract.save(createUserRequest);
        return ResponseEntity.ok(RestResponse.of(userDTO));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<RestResponse<UserDto>> update(@PathVariable Long id, @RequestBody UpdateUserRequest updateUserRequest) {
        var userDTO = userControllerContract.update(id, updateUserRequest);
        return ResponseEntity.ok(RestResponse.of(userDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<RestResponse<UserDto>> findById(@PathVariable Long id) {
        var userDto = userControllerContract.findById(id);
        return ResponseEntity.ok(RestResponse.of(userDto));
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<RestResponse<UserDto>> findByName(@PathVariable String name) {
        var userDto = userControllerContract.findByName(name);
        return ResponseEntity.ok(RestResponse.of(userDto));
    }

    @GetMapping
    public ResponseEntity<RestResponse<List<UserDto>>> findAll() {
        var userDTOList = userControllerContract.findAll();
        return ResponseEntity.ok(RestResponse.of(userDTOList));
    }

    @DeleteMapping
    public ResponseEntity<RestResponse<String>> delete(@RequestBody DeleteUserRequest deleteUserRequest) {

        if (userControllerContract.delete(deleteUserRequest)) {
            return ResponseEntity.ok(RestResponse.of("Deleted by " + deleteUserRequest.name()));
        } else {
            return ResponseEntity.ok(RestResponse.errorMessage(
                  String.format("%s kullanıcı adı ile %s telefonu bilgileri uyuşmamaktadır",
                          deleteUserRequest.name(), deleteUserRequest.phoneNumber())));
        }

    }

}
