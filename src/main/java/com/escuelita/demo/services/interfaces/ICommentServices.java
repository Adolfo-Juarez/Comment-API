package com.escuelita.demo.services.interfaces;

import java.util.List;

import com.escuelita.demo.controller.dtos.request.CreateCommentRequest;
import com.escuelita.demo.controller.dtos.request.UpdateCommentRequest;
import com.escuelita.demo.controller.dtos.responses.CreateCommentResponse;
import com.escuelita.demo.controller.dtos.responses.GetCommentResponse;

public interface ICommentServices {
    public CreateCommentResponse create(CreateCommentRequest request);

    public GetCommentResponse get(Long id);

    public List<GetCommentResponse> list();

    public GetCommentResponse update(Long id,UpdateCommentRequest request);

    public void delete(Long id);
}
