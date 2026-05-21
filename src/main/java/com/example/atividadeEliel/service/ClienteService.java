package com.example.atividadeEliel.service;

import com.example.atividadeEliel.model.Cliente;
import com.example.atividadeEliel.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {
    private final ClienteRepository repository;

    public ClienteService(ClienteRepository repository) {
        this.repository = repository;
    }

    public Cliente save(Cliente cliente){
        return repository.save(cliente);
    }

    public List<Cliente> findAll(){
        return repository.findAll();
    }

    public Cliente findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
    }

    public Cliente update(Long id, Cliente cliente) {
        Cliente clienteExistente = findById(id);
        clienteExistente.setNome(cliente.getNome());

        return repository.save(clienteExistente);
    }

    public void delete(Long id) {
        Cliente cliente = findById(id);
        repository.delete(cliente);
    }
}
