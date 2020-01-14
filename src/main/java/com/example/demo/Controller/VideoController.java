package com.example.demo.Controller;

import com.example.demo.Models.video;
import com.example.demo.repositories.VideoRepo;
import com.example.demo.services.VideoService;
import com.mongodb.client.gridfs.model.GridFSFile;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartResolver;

import javax.servlet.MultipartConfigElement;
import java.io.IOException;
import java.io.InputStream;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("")
public class VideoController {

    @Autowired
    private VideoService videoService ;
    @Autowired
    private VideoRepo videorepo ;

    //@RequestMapping(value ="/videos/add/{title}",method = RequestMethod.POST )
    @PostMapping(value ="/videos/add/{title}", consumes = { "multipart/form-data" })
    public Object addVideo(@PathVariable String title ,
                           @RequestParam("video") MultipartFile file, Model model) throws IOException {

        Object id = videoService.addVideo(title, file);
        return id;
    }

//    @GetMapping("/video/{id}")
//    public ResponseEntity downloadFromDB(@PathVariable String id) {
//        Document document = documentDao.findById(fileName);
//        return ResponseEntity.ok()
//                .contentType(MediaType.parseMediaType(contentType))
//                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileName + "\"")
//                .body(document.getFile());
//    }



    @GetMapping("/videos/{id}")
    public video getVideo(@PathVariable String id, Model model) throws Exception {
        video video = videoService.getVideo(id);

        //model.addAttribute("title", video.getTitle());
        model.addAttribute("url", "/videos/stream/" + id);
        return video  ;
    }
}
