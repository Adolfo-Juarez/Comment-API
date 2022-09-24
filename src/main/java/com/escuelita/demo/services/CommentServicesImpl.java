package com.escuelita.demo.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.escuelita.demo.controller.dtos.request.CreateCommentRequest;
import com.escuelita.demo.controller.dtos.request.UpdateCommentRequest;
import com.escuelita.demo.controller.dtos.responses.CreateCommentResponse;
import com.escuelita.demo.controller.dtos.responses.GetCommentResponse;
import com.escuelita.demo.entities.Comment;
import com.escuelita.demo.interfaces.ICommentRespository;
import com.escuelita.demo.services.interfaces.ICommentServices;

@Service
public class CommentServicesImpl implements ICommentServices {

    @Autowired
    ICommentRespository repository;

    @Override
    public CreateCommentResponse create(CreateCommentRequest request) {
        Comment comment = from(request);
        return toCreateCommentResponse(repository.save(comment));
    }

    @Override
    public GetCommentResponse get(Long id) {
        return repository
                .findById(id)
                .map(this::toGetCommentResponse)
                .orElseThrow(() -> new RuntimeException("Comment not found"));
    }

    @Override
    public List<GetCommentResponse> list() {
        return repository
                .findAll()
                .stream()
                .map(this::toGetCommentResponse)
                .collect(Collectors.toList());
    }

    @Override
    public GetCommentResponse update(Long id,UpdateCommentRequest request) {
        Comment comment = repository.findById(id).orElseThrow(()->new RuntimeException("User not found"));
        comment = fromUpdateRequest(request, comment);
        return toGetCommentResponse(repository.save(comment));
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    private Comment from(CreateCommentRequest request) {
        Comment comment = new Comment();
        comment.setAuthor(request.getAuthor());
        comment.setContent(request.getContent());
        return comment;
    }

    private CreateCommentResponse toCreateCommentResponse(Comment comment) {
        CreateCommentResponse response = new CreateCommentResponse();
        response.setContent(comment.getContent());
        response.setId(comment.getId());
        return response;
    }

    private GetCommentResponse toGetCommentResponse(Comment comment) {
        GetCommentResponse response = new GetCommentResponse();
        response.setAuthor(comment.getAuthor());
        response.setContent(comment.getContent());
        response.setId(comment.getId());
        return response;
    }

    private Comment fromUpdateRequest(UpdateCommentRequest request, Comment comment){
        comment.setContent(request.getContent());
        return comment;
    }
}
