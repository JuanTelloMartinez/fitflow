package es.ieslavereda.fitflow.service.impl;

import es.ieslavereda.fitflow.exception.BadRequestException;
import es.ieslavereda.fitflow.exception.ResourceNotFoundException;
import es.ieslavereda.fitflow.mapper.UserMapper;
import es.ieslavereda.fitflow.model.dto.CreateUserDTO;
import es.ieslavereda.fitflow.model.dto.UserDTO;
import es.ieslavereda.fitflow.model.entity.User;
import es.ieslavereda.fitflow.repository.UserRepository;
import es.ieslavereda.fitflow.service.UserService;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    @Transactional(readOnly = true)
    public List<UserDTO> findAll() {
        return userRepository.findAll()
                .stream()
                .map(userMapper::toDTO)
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public UserDTO findById(Long id) {
        return userMapper.toDTO(getUserOrThrow(id));
    }

    @Override
    public UserDTO create(CreateUserDTO createUserDTO) {
        validateEmailAvailability(createUserDTO.getEmail(), null);

        User user = userMapper.toEntity(createUserDTO);
        if (user.getNivelGamificacion() == null) {
            user.setNivelGamificacion(0);
        }

        return userMapper.toDTO(userRepository.save(user));
    }

    @Override
    public UserDTO update(Long id, CreateUserDTO updateUserDTO) {
        User existingUser = getUserOrThrow(id);
        validateEmailAvailability(updateUserDTO.getEmail(), id);

        userMapper.updateEntityFromDto(updateUserDTO, existingUser);
        if (existingUser.getNivelGamificacion() == null) {
            existingUser.setNivelGamificacion(0);
        }

        return userMapper.toDTO(userRepository.save(existingUser));
    }

    @Override
    public void delete(Long id) {
        User user = getUserOrThrow(id);
        userRepository.delete(user);
    }

    private User getUserOrThrow(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado con id " + id));
    }

    private void validateEmailAvailability(String email, Long currentUserId) {
        boolean exists = userRepository.existsByEmail(email);
        if (!exists) {
            return;
        }

        if (currentUserId != null) {
            User currentUser = getUserOrThrow(currentUserId);
            if (email.equalsIgnoreCase(currentUser.getEmail())) {
                return;
            }
        }

        throw new BadRequestException("Ya existe un usuario con ese email");
    }
}
