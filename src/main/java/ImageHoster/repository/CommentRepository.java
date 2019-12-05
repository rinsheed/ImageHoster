package ImageHoster.repository;

import ImageHoster.model.Comment;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.List;

//The annotation is a special type of @Component annotation which describes that the class defines a data repository
@Repository
public class CommentRepository {

    //Get an instance of EntityManagerFactory from persistence unit with name as 'imageHoster'
    @PersistenceUnit(unitName = "imageHoster")
    private EntityManagerFactory emf;


    public List<Comment> getComments(Integer imageId){
        EntityManager em = emf.createEntityManager();
        TypedQuery<Comment> query = em.createQuery("SELECT c FROM Comment c WHERE c.image.id = :imageId", Comment.class);
        query.setParameter("imageId", imageId);

        List<Comment> comments = query.getResultList();

        return comments;
    }

    public Comment postComment(Comment newComment){
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            em.persist(newComment);
            transaction.commit();
        }
        catch (Exception e){
            transaction.rollback();
        }
        return newComment;
    }
}
