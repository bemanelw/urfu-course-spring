package org.example.mod4.controllers;

import jakarta.validation.Valid;
import org.example.mod4.DTO.CommentDTO;
import org.example.mod4.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comments")
public class CommentController {
    private final CommentService commentService;

    @Autowired
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping
    public ResponseEntity<CommentDTO> createComment(@Valid @RequestBody CommentDTO commentDTO) {
        CommentDTO createdComment = commentService.createComment(commentDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdComment);
    }

    @GetMapping("/news/{newsId}")
    public ResponseEntity<List<CommentDTO>> getCommentsByNewsId(@PathVariable Long newsId) {
        List<CommentDTO> comments = commentService.getCommentsByNewsId(newsId);
        return ResponseEntity.ok(comments);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CommentDTO> getCommentById(@PathVariable Long id) {
        CommentDTO commentDTO = commentService.getCommentById(id);
        return ResponseEntity.ok(commentDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CommentDTO> updateComment(@PathVariable Long id, @Valid @RequestBody CommentDTO commentDTO) {
        CommentDTO updatedComment = commentService.updateComment(id, commentDTO);
        return ResponseEntity.ok(updatedComment);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteComment(@PathVariable Long id) {
        commentService.deleteComment(id);
        return ResponseEntity.noContent().build();
    }
}