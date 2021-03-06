package jjfactory.boardthymeleaf.business.controller.board;

import jjfactory.boardthymeleaf.business.dto.board.BoardDto;
import jjfactory.boardthymeleaf.business.dto.board.BoardResponse;
import jjfactory.boardthymeleaf.business.service.board.BoardService;
import jjfactory.boardthymeleaf.global.dto.QueryModel;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/boards")
@Controller
public class BoardController {
    private final BoardService boardService;

    @GetMapping({"", "/list"})
    public String getBoards(@RequestParam(required = false, defaultValue = "1") int page,
                            @RequestParam(required = false, defaultValue = "10") int limit,
                            @RequestParam(required = false) String query,
                            @RequestParam(required = false) String startDate,
                            @RequestParam(required = false) String endDate,
                            Model model) {
        Page<BoardResponse> boards = boardService.findBoards(PageRequest.of(page, limit),
                new QueryModel(query, startDate, endDate));

        model.addAttribute("boardList", boards);

        return "board/list";
    }

    @GetMapping("/new")
    public String writeForm() {
        return "board/write";
    }
    @PostMapping("")
    public String write(@RequestBody BoardDto boardDto) {
        boardService.create(boardDto);
        return "redirect:/board/list";
    }

    @GetMapping("/{id}")
    public String detail(@PathVariable Long id, Model model) {
        BoardDto boardDTO = boardService.findBoard(id);

        model.addAttribute("boardDto", boardDTO);
        return "board/detail";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable Long id, Model model) {
        BoardDto boardDTO = boardService.findBoard(id);

        model.addAttribute("boardDto", boardDTO);
        return "board/update";
    }

    // ?????? GET ???????????????, PUT ???????????? ????????? ????????? ????????? ????????? ?????? ??????

//    @PutMapping("/post/edit/{no}")
//    public String update(BoardDto boardDTO) {
//        boardService.(boardDTO);
//
//        return "redirect:/board/list";
//    }

    // ????????? ????????? deletePost ???????????? ???????????? ???????????? ????????? ??? ??????.

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        boardService.delete(id);

        return "redirect:/board/list";
    }
}
