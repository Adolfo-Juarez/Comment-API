package com.escuelita.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.escuelita.demo.controller.dtos.request.CreateCommentRequest;
import com.escuelita.demo.controller.dtos.request.UpdateCommentRequest;
import com.escuelita.demo.controller.dtos.responses.CreateCommentResponse;
import com.escuelita.demo.controller.dtos.responses.GetCommentResponse;
import com.escuelita.demo.services.interfaces.ICommentServices;

@RestController
@RequestMapping("comment")
public class CommentController {
    
    @Autowired ICommentServices services;

    @PostMapping
    public CreateCommentResponse create(@RequestBody CreateCommentRequest request){
        return services.create(request);
    }

    @GetMapping
    public List<GetCommentResponse> list(){
        return services.list();
    }

    @GetMapping("{id}")
    public GetCommentResponse get(@PathVariable Long id){
        return services.get(id);
    }

    @PutMapping("{id}")
    public GetCommentResponse update(@PathVariable Long id, @RequestBody UpdateCommentRequest request){
        return services.update(id, request);
    }
    
    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id){
        services.delete(id);
    }

}
