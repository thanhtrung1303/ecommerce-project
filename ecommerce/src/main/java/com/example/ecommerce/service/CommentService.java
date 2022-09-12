package com.example.ecommerce.service;

import com.example.ecommerce.entity.*;
import com.example.ecommerce.repository.CommentRepository;
import com.example.ecommerce.repository.ProductRepository;
import com.example.ecommerce.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service
public class CommentService {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private UserRepository userRepository;


    public Comment createComment(Comment comment, long productId, Long userId) {

        Product product = productRepository.findById(productId).get();

        User user = userRepository.getReferenceById(userId);

        comment.setProduct(product);

        comment.setUser(user);

        comment.setCreatedAt(new Timestamp(System.currentTimeMillis()));

        commentRepository.save(comment);

        return comment;
    };
}
