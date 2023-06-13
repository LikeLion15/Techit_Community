package likelion15.mutsa.service;

import jakarta.persistence.EntityManager;
import likelion15.mutsa.entity.Board;
import likelion15.mutsa.entity.Comment;
import likelion15.mutsa.entity.User;
import likelion15.mutsa.entity.embedded.Content;
import likelion15.mutsa.entity.enums.DeletedStatus;
import likelion15.mutsa.entity.enums.VisibleStatus;
import likelion15.mutsa.repository.BoardRepository;
import likelion15.mutsa.repository.CommentRepository;
import likelion15.mutsa.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;
    private final UserRepository userRepository;
    private final CommentRepository commentRepository;
    @Transactional
    public Long writeArticle(Long userId, String title, String content) {
        // 게시글 등록
        User user = userRepository.findOne(userId);

        Content content1 = Content.builder()
                .title(title)
                .content(content)
                .status(VisibleStatus.VISIBLE)
                .isDeleted(DeletedStatus.NONE)
                .build();

        Board board = Board.builder()
                .content(content1)
                .user(userRepository.findOne(userId))
                .build();

        boardRepository.save(board);
        return board.getId();
    }

    @Transactional
    public Long writeComment(Long userId, Long boardId, String content) {
        // 게시글 등록
        User user = userRepository.findOne(userId);

        Comment comment = Comment.builder()
                .comment(content)
                .board(boardRepository.findOne(boardId))
                .username(userRepository.findOne(userId).getName())
                .user(userRepository.findOne(userId))
                .isDeleted(DeletedStatus.NONE)
                .build();

        commentRepository.save(comment);
        return comment.getId();
    }


    // 한 유저가 쓴 모든 글 조회
    public List<Board> findOnesBoards(Long userId) {return boardRepository.findByUserId(userId);}

    // 한 유저가 쓴 모든 댓글 조회
    public List<Comment> findOnesComments(Long userId) {return commentRepository.findByUserId(userId);}
}
