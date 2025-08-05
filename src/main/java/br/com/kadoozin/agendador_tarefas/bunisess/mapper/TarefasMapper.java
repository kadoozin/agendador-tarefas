package br.com.kadoozin.agendador_tarefas.bunisess.mapper;

import br.com.kadoozin.agendador_tarefas.bunisess.dto.in.TarefasRequestDTO;
import br.com.kadoozin.agendador_tarefas.bunisess.dto.out.TarefasResponseDTO;
import br.com.kadoozin.agendador_tarefas.infrastructure.entities.TarefasEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TarefasMapper {
    TarefasEntity toEntity(TarefasRequestDTO dto);
    TarefasResponseDTO toDTO(TarefasEntity entity);

    List<TarefasEntity> toListEntity(List<TarefasResponseDTO> dtos);
    List<TarefasResponseDTO> toListDTO(List<TarefasEntity> entities);
}
