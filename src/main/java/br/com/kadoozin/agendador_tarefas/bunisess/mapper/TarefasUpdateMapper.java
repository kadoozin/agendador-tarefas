package br.com.kadoozin.agendador_tarefas.bunisess.mapper;

import br.com.kadoozin.agendador_tarefas.bunisess.dto.TarefasDTO;
import br.com.kadoozin.agendador_tarefas.infrastructure.entities.TarefasEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface TarefasUpdateMapper {
    void updateTarefas(TarefasDTO dto, @MappingTarget TarefasEntity entity);
}
