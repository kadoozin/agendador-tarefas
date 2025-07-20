package br.com.kadoozin.agendador_tarefas.bunisess.mapper;

import br.com.kadoozin.agendador_tarefas.bunisess.dto.TarefasDTO;
import br.com.kadoozin.agendador_tarefas.infrastructure.entities.TarefasEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TarefasMapper {
    TarefasEntity toEntity(TarefasDTO dto);
    TarefasDTO toDTO(TarefasEntity entity);

    List<TarefasEntity> toListEntity(List<TarefasDTO> dtos);
    List<TarefasDTO> toListDTO(List<TarefasEntity> entities);
}
