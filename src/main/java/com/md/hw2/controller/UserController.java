package com.md.hw2.controller;

import com.md.hw2.controller.contract.UserControllerContract;
import com.md.hw2.dto.UserDto;
import com.md.hw2.dto.requests.CreateUserRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping
    public ResponseEntity<RestResponse<List<UserDTO>>> findAll() {
        var userDTOList = userControllerContract.findAll();
        return ResponseEntity.ok(RestResponse.of(userDTOList));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<RestResponse<Object>> delete(@PathVariable Long id) {
        userControllerContract.delete(id);
        return ResponseEntity.ok(RestResponse.empty());
    }
}
