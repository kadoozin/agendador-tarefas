package br.com.kadoozin.agendador_tarefas.infrastructure.repository;

import br.com.kadoozin.agendador_tarefas.infrastructure.entities.TarefasEntity;
import br.com.kadoozin.agendador_tarefas.infrastructure.enums.StatusNotificacaoEnum;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface TarefasRepository extends JpaRepository<TarefasEntity, String> {
    List<TarefasEntity> findByDataEventoBetweenAndStatusNotificacaoEnum(LocalDateTime dataInicial,
                                                                        LocalDateTime dataFinal,
                                                                        StatusNotificacaoEnum status);
    List<TarefasEntity> findByEmailUsuario(String email);
    boolean existsById(String id);
}
