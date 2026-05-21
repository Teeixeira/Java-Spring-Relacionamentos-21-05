package com.example.atividadeEliel.controler;

import com.example.atividadeEliel.model.Cliente;
import com.example.atividadeEliel.service.ClienteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClienteControler {
    private final ClienteService service;

    public ClienteControler(ClienteService service) {
        this.service = service;
    }

    @PostMapping
    public Cliente cadastrar(@RequestBody Cliente cliente){
        return service.save(cliente);
    }

    @GetMapping
    public List<Cliente> findAll(){
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Cliente findById(@PathVariable Long id){
        return service.findById(id);
    }

    @PutMapping("/{id}")
    public Cliente update(@PathVariable Long id, @RequestBody Cliente cliente){
        return service.update(id, cliente);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        service.delete(id);
    }
}
