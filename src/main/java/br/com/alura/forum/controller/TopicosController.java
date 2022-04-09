package br.com.alura.forum.controller;

import br.com.alura.forum.controller.dto.TopicoDTO;
import br.com.alura.forum.modelo.Topico;
import br.com.alura.forum.repostiory.TopicoRepository;
import net.bytebuddy.implementation.bind.MethodDelegationBinder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;


@RestController
public class TopicosController {

    @Autowired
    private TopicoRepository topicoRespository;

    @RequestMapping("/topicos")
    public List<TopicoDTO> lista(String nomeCruso) {
        if(nomeCruso == null){
            List<Topico> topicos = topicoRespository.findAll();

        }else{
            List<Topico> topicos = topicoRespository.findByTitulo(nomeCruso);
        }

        return TopicoDTO.converter(topicos);


    }
}