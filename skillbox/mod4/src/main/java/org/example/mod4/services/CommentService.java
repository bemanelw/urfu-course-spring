package org.example.mod4.services;

import org.example.mod4.DTO.CommentDTO;
import org.example.mod4.entities.Comment;
import org.example.mod4.mappers.CommentMapper;
import org.example.mod4.repositories.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentService {
    private final CommentRepository commentRepository;
    private final CommentMapper commentMapper;

    @Autowired
    public CommentService(CommentRepository commentRepository, CommentMapper commentMapper) {
        this.commentRepository = commentRepository;
        this.commentMapper = commentMapper;
    }

    public CommentDTO createComment(CommentDTO commentDTO) {
        Comment comment = commentMapper.toEntity(commentDTO);
        Comment savedComment = commentRepository.save(comment);
        return commentMapper.toDto(savedComment);
    }

    public List<CommentDTO> getCommentsByNewsId(Long newsId) {
        List<Comment> comments = commentRepository.findByNewsId(newsId);
        return comments.stream().map(commentMapper::toDto).collect(Collectors.toList());
    }

    public CommentDTO getCommentById(Long id) {
        Comment comment = commentRepository.findById(id).orElseThrow(() -> new RuntimeException("Comment not found"));
        return commentMapper.toDto(comment);
    }

    public CommentDTO updateComment(Long id, CommentDTO commentDTO) {
        Comment comment = commentRepository.findById(id).orElseThrow(() -> new RuntimeException("Comment not found"));
        comment.setContent(commentDTO.getContent());
        Comment updatedComment = commentRepository.save(comment);
        return commentMapper.toDto(updatedComment);
    }

    public void deleteComment(Long id) {
        commentRepository.deleteById(id);
    }
}
