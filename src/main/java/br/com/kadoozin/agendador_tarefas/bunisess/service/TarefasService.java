package br.com.kadoozin.agendador_tarefas.bunisess.service;

import br.com.kadoozin.agendador_tarefas.bunisess.dto.TarefasDTO;
import br.com.kadoozin.agendador_tarefas.bunisess.mapper.TarefasMapper;
import br.com.kadoozin.agendador_tarefas.infrastructure.entities.TarefasEntity;
import br.com.kadoozin.agendador_tarefas.infrastructure.enums.StatusNotificacaoEnum;
import br.com.kadoozin.agendador_tarefas.infrastructure.repository.TarefasRepository;
import br.com.kadoozin.agendador_tarefas.infrastructure.security.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class TarefasService {
    private final TarefasRepository tarefasRepository;
    private final TarefasMapper tarefasMapper;
    private final JwtUtil jwtUtil;


    public TarefasDTO gravarTarefa(String token, TarefasDTO dto){
        String email = jwtUtil.extrairEmailToken(token.substring(7));
        dto.setDataCriacao(LocalDateTime.now());
        dto.setStatusNotificacaoEnum(StatusNotificacaoEnum.PENDENTE);
        dto.setEmailUsuario(email);
        TarefasEntity entity = tarefasMapper.toEntity(dto);
        return tarefasMapper.toDTO(tarefasRepository.save(entity));
    }
}
