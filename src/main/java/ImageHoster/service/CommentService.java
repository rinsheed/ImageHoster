package ImageHoster.service;

import ImageHoster.model.Comment;
import ImageHoster.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;

    public List<Comment> getComments(Integer imageId){ return commentRepository.getComments(imageId); }

    public Comment postComment(Comment newComment){ return commentRepository.postComment(newComment); }

}
