package com.example.demo.Controller;

import com.example.demo.Models.video;
import com.example.demo.repositories.VideoRepo;
import com.example.demo.services.VideoService;
import com.mongodb.client.gridfs.model.GridFSFile;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
@CrossOrigin(origins = "*")
@Controller
@RequestMapping("")
public class VideoController {

    @Autowired
    private VideoService videoService ;
    @Autowired
    private VideoRepo videorepo ;

    @RequestMapping(value ="/videos/add", method = RequestMethod.POST)
    public String addVideo(
                           @RequestParam("file") MultipartFile file, Model model) throws IOException {

        System.out.println("jjkkjkjjk");
       // ObjectId id = videoService.addVideo(title, file);
        return "redirect:/videos/" ;
    }


    @GetMapping("/videos/{id}")
    public video getVideo(@PathVariable String id, Model model) throws Exception {
        video video = videoService.getVideo(id);
        model.addAttribute("title", video.getTitle());
        model.addAttribute("url", "/videos/stream/" + id);
        return video  ;
    }
}
