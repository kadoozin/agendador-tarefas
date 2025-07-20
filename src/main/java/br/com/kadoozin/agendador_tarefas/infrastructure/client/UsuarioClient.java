package br.com.kadoozin.agendador_tarefas.infrastructure.client;

import br.com.kadoozin.agendador_tarefas.bunisess.dto.UsuarioDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "usuario", url = "http://localhost:8080")
public interface UsuarioClient {

    @GetMapping("/usuario/buscar")
    UsuarioDTO buscarUsuarioPorEmail(@RequestParam("email") String email,
                                     @RequestHeader("Authorization") String token);
}
