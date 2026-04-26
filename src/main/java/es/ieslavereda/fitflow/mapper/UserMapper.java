package es.ieslavereda.fitflow.mapper;

import es.ieslavereda.fitflow.model.dto.CreateUserDTO;
import es.ieslavereda.fitflow.model.dto.UserDTO;
import es.ieslavereda.fitflow.model.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDTO toDTO(User user);

    @Mapping(target = "id", ignore = true)
    User toEntity(CreateUserDTO dto);

    @Mapping(target = "id", ignore = true)
    void updateEntityFromDto(CreateUserDTO dto, @MappingTarget User user);
}
