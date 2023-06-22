package likelion15.mutsa.repository;

import jakarta.persistence.EntityManager;
import likelion15.mutsa.entity.Board;
import likelion15.mutsa.entity.Likes;
import likelion15.mutsa.entity.User;
import likelion15.mutsa.entity.enums.DeletedStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class BoardRepository {

    private final EntityManager em;

    public void save(Board board) {em.persist(board);}

    public Board findOne(Long id) {return em.find(Board.class, id);}


    public List<Board> findByUserId(Long userId) {
        return em.createQuery("select b from Board b where b.user.id =:user_id and b.content.isDeleted =:isDeleted", Board.class)
                .setParameter("user_id", userId)
                .setParameter("isDeleted", DeletedStatus.NONE)
                .getResultList();
    }

    public List<Board> findAllByLikesAndUserId(User user) {
        return em.createQuery("select b from Board b, Likes l where b.user.id =:userId and l.board.id = b.id")
                .setParameter("userId", user.getId())
                .getResultList();
    }

    public void deleteBoard(Long id) {
        em.createQuery("delete from Board b where b.id =:boardId", Board.class)
                .setParameter("boardId", id);
    }
}
