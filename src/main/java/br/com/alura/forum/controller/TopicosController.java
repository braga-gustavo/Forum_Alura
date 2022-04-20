package br.com.alura.forum.controller;

import br.com.alura.forum.controller.dto.TopicoDTO;
import br.com.alura.forum.controller.form.TopicoForm;
import br.com.alura.forum.modelo.Topico;
import br.com.alura.forum.repostiory.CursoRepository;
import br.com.alura.forum.repostiory.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RequestMapping( "/topicos")
@RestController
public class TopicosController {

    @Autowired
    private TopicoRepository topicoRespository;

    @Autowired
    private CursoRepository cursoRepository;

    @GetMapping
        public List<TopicoDTO> lista(String nomeCruso) {

        if(nomeCruso == null){
            List<Topico> topicos = topicoRespository.findAll();
            return TopicoDTO.converter(topicos);
        }else{
            List<Topico> topicos = topicoRespository.findByCursoNome(nomeCruso);
            return TopicoDTO.converter(topicos);
        }
    }


    @PostMapping
    public ResponseEntity<TopicoDTO> cadastrar(@RequestBody TopicoForm form, UriComponentsBuilder uriBuilder){
        Topico topico = form.converter(cursoRepository);
        topicoRespository.save(topico);

        URI uri = uriBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();
        return ResponseEntity.created(uri).body(new TopicoDTO(topico));

    }
}