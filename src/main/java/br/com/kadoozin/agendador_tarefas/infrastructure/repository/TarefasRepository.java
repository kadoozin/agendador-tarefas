package br.com.kadoozin.agendador_tarefas.infrastructure.repository;

import br.com.kadoozin.agendador_tarefas.infrastructure.entities.TarefasEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TarefasRepository extends MongoRepository<TarefasEntity, String> {
}
