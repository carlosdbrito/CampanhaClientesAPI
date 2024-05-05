package com.almeidatecnologia.CampanhaClientes.resource;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.almeidatecnologia.CampanhaClientes.exception.BeneficioNotFoundException;
import com.almeidatecnologia.CampanhaClientes.model.Beneficio;
import com.almeidatecnologia.CampanhaClientes.model.Cliente;
import com.almeidatecnologia.CampanhaClientes.repository.BeneficioRepository;
import com.almeidatecnologia.CampanhaClientes.service.ClienteService;
import com.almeidatecnologia.CampanhaClientes.service.BeneficioService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@Tag(name="Cliente")
@RequestMapping("/api/clientes") 
public class ClienteResource {

    private ClienteService clienteService;

    @Autowired
    public ClienteResource(ClienteService clienteService) {
        this.clienteService = clienteService;
    }
    
    @Autowired
    private BeneficioRepository beneficioRepository;

    @Operation(summary = "Cria um novo Cliente.")
	@PostMapping
	public ResponseEntity<Cliente> salvarCliente(@RequestBody Cliente cliente){
		Cliente objCliente = clienteService.salvarCliente(cliente);
		if(objCliente == null)
			return ResponseEntity.notFound().build();
		return ResponseEntity.ok(objCliente);
	}
	
    @Operation(summary = "Retorna os dados de um Cliente por ID.")
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Cliente>> obterClientePorId(@PathVariable Long id){
		Optional<Cliente> objCliente = clienteService.obterClientePorId(id);
		if(objCliente == null)
			return ResponseEntity.notFound().build();
		return ResponseEntity.ok(objCliente);
	}
     
    @Operation(summary = "Listar todos os Clientes.")
	@GetMapping
	public ResponseEntity<List<Cliente>> obterTodosClientes(){
		List<Cliente> objCliente = clienteService.obterTodosClientes();
		if(objCliente == null)
			return ResponseEntity.notFound().build();
		if(objCliente.size() == 0)
			return ResponseEntity.notFound().build();
		return ResponseEntity.ok(objCliente);
	}
		

    @Operation(summary = "Atualiza um Cliente existente.")
	@PutMapping
	public ResponseEntity<Cliente> atualizarCliente(@RequestBody Cliente cliente){
		Cliente objCliente = clienteService.atualizarCliente(cliente);
		if(objCliente == null)
			return ResponseEntity.notFound().build();
		return ResponseEntity.ok(objCliente);
	}
	
    @Operation(summary = "Remove um Cliente por ID.")
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletarCliente(@PathVariable Long id){
		clienteService.deletarCliente(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
    
    @Operation(summary = "Adiciona um novo Benefício a um Cliente.")
    @PostMapping("/{id}/beneficio")
    public ResponseEntity<Beneficio> adicionarBeneficioCliente(@RequestBody Beneficio beneficio) {
        	Beneficio objBeneficio = beneficioRepository.save(beneficio);
            if (objBeneficio == null) {
            	return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(objBeneficio);
    }
   
    
    @Operation(summary = "Retorna os dados do Beneficio de um Cliente.")
    @GetMapping("/{id}/beneficio")
    public ResponseEntity<Beneficio> getBeneficioCliente(@PathVariable(value = "id") Long clienteId) throws BeneficioNotFoundException {
        	Optional<Beneficio> objBeneficio = beneficioRepository.findByClienteId(clienteId);
            if (!objBeneficio.isPresent()) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok().body(objBeneficio.get());		
    }
}
