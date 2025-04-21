package br.com.fiap.airquality.service.user;

import br.com.fiap.airquality.exception.EntryNotFoundException;
import br.com.fiap.airquality.model.user.User;
import br.com.fiap.airquality.model.user.dto.ShowUserDTO;
import br.com.fiap.airquality.model.user.dto.SignUpUserDTO;
import br.com.fiap.airquality.repository.user.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public ShowUserDTO createUser(SignUpUserDTO signUpUserDTO) {

        String encryptedPassword = new BCryptPasswordEncoder().encode(signUpUserDTO.password());

        User user = new User();
        BeanUtils.copyProperties(signUpUserDTO, user);

        user.setPassword(encryptedPassword);

        User createdUser = userRepository.save(user);

        return new ShowUserDTO(createdUser);
    }

    public ShowUserDTO findById(Long id) {
        return new ShowUserDTO(
                userRepository.findById(id)
                .orElseThrow(EntryNotFoundException::new));
    }

    public List<ShowUserDTO> findAll() {
        return userRepository.findAll()
                .stream()
                .map(ShowUserDTO::new)
                .collect(Collectors.toList());
    }

    public void delete(Long id) {
        userRepository.delete(
                userRepository.findById(id)
                        .orElseThrow(EntryNotFoundException::new));
    }

    public ShowUserDTO update(User user) {

        Optional<User> optionalUser = userRepository.findById(user.getId());

        if (optionalUser.isPresent()) {
            return new ShowUserDTO(
                    userRepository.save(user));
        }

        else {
            throw new EntryNotFoundException();
        }

    }

}
