package com.education.lendmeyourbook.controllers;

import com.education.lendmeyourbook.entities.State;
import com.education.lendmeyourbook.repositories.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/states")
@CrossOrigin("http://localhost:4200")
public class StateController {

    @Autowired
    StateRepository stateRepository;

    @GetMapping
    public List<State> list(){
        return stateRepository.findAll();
    }

    @GetMapping
    @RequestMapping("{id}")
    public ResponseEntity<State> getState(@PathVariable Long id){
        Optional<State> state = stateRepository.findById(id);
        return ResponseEntity.ok(state.get());
    }

    @PostMapping(value="/create", consumes = {"application/json"})
    public ResponseEntity<State> registerState(@RequestBody State state){
        state = stateRepository.save(state);
        return ResponseEntity.ok(state);
    }

    @PostMapping("/createList")
    public List<State> registerStates(@RequestBody List<State> states){
        List<State> savedStates=new ArrayList<>();
        for(State state:states){
            try {
                state = stateRepository.save(state);
                savedStates.add(state);
            } catch (Exception e){}
            }
        return savedStates;
    }

    @RequestMapping(value = "{id}",method = RequestMethod.DELETE)
    public void deleteState(@PathVariable Long id){
        stateRepository.deleteById(id);
    }

}
