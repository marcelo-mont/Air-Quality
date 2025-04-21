package br.com.fiap.airquality.controller.user;

import br.com.fiap.airquality.model.user.User;
import br.com.fiap.airquality.model.user.dto.ShowUserDTO;
import br.com.fiap.airquality.model.user.dto.SignUpUserDTO;
import br.com.fiap.airquality.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/air_quality")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/user")
    @ResponseStatus(HttpStatus.OK)
    public List<ShowUserDTO> findAll(){
        return userService.findAll();
    }

    @GetMapping("/user/{id}")
    public ShowUserDTO findById(@PathVariable Long id){
        return userService.findById(id);
    }

    @DeleteMapping("/user/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
        userService.delete(id);
    }

    @PutMapping("/user")
    @ResponseStatus(HttpStatus.OK)
    public ShowUserDTO update(@RequestBody User user){
        return userService.update(user);
    }

}