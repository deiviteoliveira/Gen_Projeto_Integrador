package org.generation.techdelas.controller;

import java.util.List;
import org.generation.techdelas.model.Tema;
import org.generation.techdelas.repository.TemaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



	
@RestController
@RequestMapping("/tema")																			//Mapeia todas URLs de solicitações HTTP
@CrossOrigin(origins = "*", allowedHeaders = "*")     						    					//"leitor de linguagem"

public class TemaController {	
	
	@Autowired
	private TemaRepository temaRepository;
	
	@GetMapping 
	public ResponseEntity<List<Tema>> getAll(){
		return ResponseEntity.ok(temaRepository.findAll());
		
	}
	
	
	@GetMapping("/{idTema}")																		//Pegar o Id
	
	public ResponseEntity<Tema> getAll(@PathVariable long idTema){				
		return temaRepository.findById(idTema)
				.map(resp -> ResponseEntity.ok(resp))												//Mapeia as informações
				.orElse(ResponseEntity.notFound().build());											//Retorna o erro 404
		
	}
	
	@GetMapping ("/nome/{nomeTema}")													             //Pegar o nomeTema
	public ResponseEntity<List<Tema>> getByNomeTema(@PathVariable String nomeTema){					 //List<Tema> = listará os registros da tabela
		return ResponseEntity.ok(temaRepository.findAllByNomeTemaContainingIgnoreCase(nomeTema));    //ResponseEntity = Usado para configurar toda a resposta HTTP
	}
	
	
	@GetMapping("/sobre/{sobre}")
	public ResponseEntity<List<Tema>> getBySobre(@PathVariable String sobre){
		return ResponseEntity.ok(temaRepository.findAllBySobreContainingIgnoreCase(sobre));
	}
	
	
	@GetMapping("/imgDevs/{imgDevs}")
	public ResponseEntity<List<Tema>> getByImgDevs(@PathVariable String imgDevs){
		return ResponseEntity.ok(temaRepository.findAllByImgDevsContainingIgnoreCase(imgDevs));
	}
	
	@PostMapping																					 //Atua como atalho para o request, lidando apenas com solicitações do tipo HTTP POST
	public ResponseEntity<Tema>postTema(@RequestBody Tema tema){
		return ResponseEntity.status(HttpStatus.CREATED).body(temaRepository.save(tema));
	}
	
	@PutMapping
	public ResponseEntity<Tema>putTema(@RequestBody Tema tema){
		return ResponseEntity.status(HttpStatus.CREATED).body(temaRepository.save(tema));
	}
	
	@DeleteMapping ("/idTema")
	public void delete(@PathVariable long idTema) {
		temaRepository.deleteById(idTema);
	} 
	
	@GetMapping("/nome/{nome}")																	    //Buscar por nome dentro do id_tema
	public ResponseEntity<List<Tema>> getByNome(@PathVariable String nomeTema){
		return ResponseEntity.ok(temaRepository.findByNomeTema(nomeTema));
	}	
	

}
