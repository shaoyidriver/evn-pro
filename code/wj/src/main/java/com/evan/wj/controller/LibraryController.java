package com.evan.wj.controller;

import com.evan.wj.pojo.Book;
import com.evan.wj.service.BookService;
import com.evan.wj.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class LibraryController {
    @Autowired
    BookService bookService;

    @GetMapping("/books")
    public List<Book> list() throws Exception {
        return bookService.list();
    }

    @PostMapping("/books")
    public Book addOrUpdate(@RequestBody Book book) throws Exception {
        bookService.addOrUpdate(book);
        return book;
    }

    @PostMapping("/delete")
    public void delete(@RequestBody Book book) throws Exception {
        bookService.deleteById(book.getId());
    }

    @GetMapping("/categories/{cid}/books")
    public List<Book> listByCategory(@PathVariable("cid") int cid) throws Exception {
        if (0 != cid) {
            return bookService.listByCategory(cid);
        } else {
            return list();
        }
    }

    @GetMapping("/search")
    public List<Book> searchResult(@RequestParam("keyWords") String keyWords) {
        if (ObjectUtils.isEmpty(keyWords)) {
            return bookService.list();
        } else {
            return bookService.search(keyWords);
        }
    }

    @PostMapping("/coversUpload")
    public String coversUpload(MultipartFile file) throws Exception {
        String folder = "G:/work/img";
        File imgFolder = new File(folder);
        File imgFile = new File(imgFolder, StringUtils.getRandomString(12) + file.getOriginalFilename().substring(file.getOriginalFilename().length() - 4));
        if (!imgFile.getParentFile().exists()) {
            imgFile.getParentFile().mkdir();
        }
        try {
            file.transferTo(imgFile);
            return "file/" + imgFile.getName();
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }
}
