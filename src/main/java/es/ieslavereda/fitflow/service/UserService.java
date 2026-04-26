package es.ieslavereda.fitflow.service;

import es.ieslavereda.fitflow.model.dto.CreateUserDTO;
import es.ieslavereda.fitflow.model.dto.UserDTO;
import java.util.List;

public interface UserService {
    List<UserDTO> findAll();

    UserDTO findById(Long id);

    UserDTO create(CreateUserDTO createUserDTO);

    UserDTO update(Long id, CreateUserDTO updateUserDTO);

    void delete(Long id);
}
