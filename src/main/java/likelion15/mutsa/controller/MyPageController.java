package likelion15.mutsa.controller;


import likelion15.mutsa.entity.User;
import likelion15.mutsa.entity.enums.UserAuth;
import likelion15.mutsa.entity.enums.UserStatus;
import likelion15.mutsa.repository.BoardPageRepository;
import likelion15.mutsa.service.BoardService;
import likelion15.mutsa.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequiredArgsConstructor

@Slf4j
@RequestMapping("/my-page")
public class MyPageController {
    public final BoardService boardService;
    public final UserService userService;
    public final BoardPageRepository boardPageRepository;

    @GetMapping("")
    public String myPage(
            Model model,
            @RequestParam(value = "page", defaultValue = "0") int pageNum,
            @RequestParam(value = "limit", defaultValue = "3") int pageLimit
    ) {

        Long logInId = 1L;
        User writer = userService.findOne(logInId);

//        model.addAttribute("myArticleList", boardService.findOnesBoards(logInId));
        model.addAttribute("myArticleList", boardService.readBoardPaged(pageNum, pageLimit, writer));
        model.addAttribute("myCommentList", boardService.findOnesComments(writer.getName()));
        model.addAttribute("myCommentLikesList", boardService.findOnesLikesComments(writer.getName()));
        model.addAttribute("myArticleLikesList", boardService.findOnesLikesBoards(writer.getId()));

        return "my-page";
    }

    @GetMapping("/profile")
    public String profile(
            Model model
    ) {
        Long logInId = 1L;
        User user = userService.findOne(logInId);
        model.addAttribute(user);


        return "profile";
    }
    @PostMapping("/profile/{id}/name")
    public String updateName(@PathVariable("id") Long id, @RequestParam("name") String name) {
        userService.updateName(id, name);
        return "redirect:/my-page/profile";
    }

    @PostMapping("/profile/{id}/email")
    public String updateEmail(@PathVariable("id") Long id, @RequestParam("email") String email) {
        userService.updateEmail(id, email);
        return "redirect:/my-page/profile";
    }

    @PostMapping("/profile/{id}/password")
    public String updatePassword(
            @PathVariable("id") Long id,
            @RequestParam("password") String password,
            @RequestParam("newPassword") String newPassword,
            @RequestParam("newPasswordCheck") String newPasswordCheck
    ) {

        userService.updatePassword(id, password, newPassword, newPasswordCheck);

        return "redirect:/my-page/profile";
    }

    @PostMapping("/profile/{id}/phonenumber")
    public String updatePhoneNumber(@PathVariable("id") Long id, @RequestParam("phoneNumber") String phoneNumber) {

        userService.updatePhoneNumber(id, phoneNumber);
        return "redirect:/my-page/profile";
    }

//    @PutMapping("/users/{id}/{fieldName}")
//    public String updateUser

}
