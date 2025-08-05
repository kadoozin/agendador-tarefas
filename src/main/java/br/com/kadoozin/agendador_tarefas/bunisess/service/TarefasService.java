package br.com.kadoozin.agendador_tarefas.bunisess.service;

import br.com.kadoozin.agendador_tarefas.bunisess.dto.in.TarefasRequestDTO;
import br.com.kadoozin.agendador_tarefas.bunisess.dto.out.TarefasResponseDTO;
import br.com.kadoozin.agendador_tarefas.bunisess.mapper.TarefasMapper;
import br.com.kadoozin.agendador_tarefas.bunisess.mapper.TarefasUpdateMapper;
import br.com.kadoozin.agendador_tarefas.infrastructure.entities.TarefasEntity;
import br.com.kadoozin.agendador_tarefas.infrastructure.enums.StatusNotificacaoEnum;
import br.com.kadoozin.agendador_tarefas.infrastructure.exceptions.InvalidTokenException;
import br.com.kadoozin.agendador_tarefas.infrastructure.exceptions.ResourceNotFoundException;
import br.com.kadoozin.agendador_tarefas.infrastructure.repository.TarefasRepository;
import br.com.kadoozin.agendador_tarefas.infrastructure.security.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TarefasService {
    private final TarefasRepository tarefasRepository;
    private final TarefasMapper tarefasMapper;
    private final TarefasUpdateMapper tarefasUpdateMapper;
    private final JwtUtil jwtUtil;


    public TarefasResponseDTO gravarTarefa(String token, TarefasRequestDTO dto) {
        if (token == null || !token.startsWith("Bearer ")) {
            throw new InvalidTokenException("Token inválido ou ausente");
        }
            String email = jwtUtil.extrairEmailToken(token.substring(7));
            dto.setDataCriacao(LocalDateTime.now());
            dto.setStatusNotificacaoEnum(StatusNotificacaoEnum.PENDENTE);
            dto.setEmailUsuario(email);
            TarefasEntity entity = tarefasMapper.toEntity(dto);
            return tarefasMapper.toDTO(tarefasRepository.save(entity));
    }

    public List<TarefasResponseDTO> buscaListaTarefasAgendadasPorPeriodo(LocalDateTime dataInicial, LocalDateTime dataFinal) {
        return tarefasMapper.toListDTO(tarefasRepository.findByDataEventoBetweenAndStatusNotificacaoEnum(dataInicial,
                dataFinal, StatusNotificacaoEnum.PENDENTE));
    }

    public List<TarefasResponseDTO> buscaTarefasPorEmail(String token) {
        String email = jwtUtil.extrairEmailToken(token.substring(7));
        return tarefasMapper.toListDTO(tarefasRepository.findByEmailUsuario(email));
    }

    public void deletarTarefaPorId(String id) {
        if (!tarefasRepository.existsById(id)){
            throw new ResourceNotFoundException("Tarefa com ID: " + id + " não encontrada.");
        }
        tarefasRepository.deleteById(id);
    }

    public TarefasResponseDTO alteraStatus(StatusNotificacaoEnum status, String id) {
            TarefasEntity entity = tarefasRepository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Tarefa não encontrada!"));
            entity.setStatusNotificacaoEnum(status);
            return tarefasMapper.toDTO(tarefasRepository.save(entity));
    }

    public TarefasResponseDTO updateDeTarefas(TarefasRequestDTO dto, String id){
            TarefasEntity entity = tarefasRepository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Tarefa não encontrada!"));
            tarefasUpdateMapper.updateTarefas(dto, entity);
            return tarefasMapper.toDTO(tarefasRepository.save(entity));
    }
}
