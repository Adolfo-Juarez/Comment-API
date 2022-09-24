package com.escuelita.demo.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.escuelita.demo.entities.Comment;

@Repository
public interface ICommentRespository extends JpaRepository<Comment,Long>{}
