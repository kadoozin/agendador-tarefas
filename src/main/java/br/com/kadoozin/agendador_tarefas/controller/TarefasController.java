package br.com.kadoozin.agendador_tarefas.controller;

import br.com.kadoozin.agendador_tarefas.bunisess.dto.in.TarefasRequestDTO;
import br.com.kadoozin.agendador_tarefas.bunisess.dto.out.TarefasResponseDTO;
import br.com.kadoozin.agendador_tarefas.bunisess.service.TarefasService;
import br.com.kadoozin.agendador_tarefas.infrastructure.enums.StatusNotificacaoEnum;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/tarefas")
@RequiredArgsConstructor
public class TarefasController {
    private final TarefasService tarefasService;

    @PostMapping
    public ResponseEntity<TarefasResponseDTO> gravarTarefas(@RequestBody TarefasRequestDTO dto,
                                                            @RequestHeader("Authorization") String token) {
        return ResponseEntity.ok(tarefasService.gravarTarefa(token, dto));
    }

    @GetMapping("/periodo")
    public ResponseEntity<List<TarefasResponseDTO>> buscaListaTarefasPorPeriodo(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
                                                                        LocalDateTime dataInicial,
                                                                        @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
                                                                        LocalDateTime dataFinal) {
        return ResponseEntity.ok(tarefasService.buscaListaTarefasAgendadasPorPeriodo(dataInicial, dataFinal));
    }

    @GetMapping
    public ResponseEntity<List<TarefasResponseDTO>> buscarTarefasPorEmail(@RequestHeader("Authorization") String token) {
        return ResponseEntity.ok(tarefasService.buscaTarefasPorEmail(token));
    }

    @DeleteMapping
    public ResponseEntity<Void> deletaTarefaPorId(@RequestParam("id") String id){
        tarefasService.deletarTarefaPorId(id);
        return ResponseEntity.ok().build();
    }

    @PatchMapping
    public ResponseEntity<TarefasResponseDTO> alteraStatusDeNotificacao(@RequestParam("status")StatusNotificacaoEnum status,
                                                                @RequestParam("id") String id){
        return ResponseEntity.ok(tarefasService.alteraStatus(status, id));
    }

    @PutMapping
    public ResponseEntity<TarefasResponseDTO> updateDeTarefas(@RequestBody TarefasRequestDTO dto,
                                                      @RequestParam("id") String id){
        return ResponseEntity.ok(tarefasService.updateDeTarefas(dto, id));
    }

}
