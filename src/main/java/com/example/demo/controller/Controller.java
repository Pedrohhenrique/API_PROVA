package com.example.demo.controller;

import com.example.demo.entity.Funcionario;
import com.example.demo.repository.Repository;
import com.example.demo.dto.clienteDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/Funcionarios/v1/")
public class Controller {

    @Autowired
    Repository repository;

    @PostMapping
    public Funcionario creat(@RequestBody @Valid Funcionario funcionario){
     for (Funcionario p : funcionario.getSalario()){
           p.set(p.getPrecoIndividual()* p.getQuantidade());
       }
        Funcionario funcionarioSaved = repository.save(funcionario);
        return funcionarioSaved;
    }

    @GetMapping("/{id}")
    @ResponseBody
    public Optional<Funcionario> getClineteById(@PathVariable Long id){
        Optional<Funcionario> clienteReturned = repository.findById(id);
        return clienteReturned;
    }
    @DeleteMapping("/{id}")
    public String deleteClienteById(@PathVariable Long id){
        try{
            Optional<Funcionario> cliente = Optional.of(repository.getById(id));
            if(cliente.isPresent()){
                repository.deleteById(id);
                return "Cliente de " + id + " deletado com sucesso";
            }else{
                throw new Exception("Cliente inexistente");
            }
        }catch(Exception e){
            e.printStackTrace();
            return "O cliente de " + id + " não existe para ser deletado!" +
                    " Por favor, entre em contato com o atendimento ...";
        }
    }

    @GetMapping
    public List<Funcionario> listCliente(){
        return repository.findAll();
    }

    @PutMapping("/atualize/{id}")
    public String updateClineteById(@RequestBody clienteDTO clienteDTO, @PathVariable Long id){
        Optional<Funcionario> velhoCliente = repository.findById(id);
        if(velhoCliente.isPresent()){
            Funcionario funcionario = velhoCliente.get();
            funcionario.setSalario(clienteDTO.getSalario());
            repository.save(funcionario);
            return "Cliente de ID" + funcionario.getId() + " atualizado com sucesso!";
        }else{
            return "Cliente de ID " + id + " não existe!";
        }
    }
}
