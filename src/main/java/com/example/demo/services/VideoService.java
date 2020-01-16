package com.example.demo.services;

import com.example.demo.Models.video;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.client.gridfs.GridFSFindIterable;
import com.mongodb.client.gridfs.model.GridFSFile;
import com.mongodb.util.JSON;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsOperations;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Service
public class VideoService {

    @Autowired
    private GridFsTemplate gridFsTemplate;

    @Autowired
    private GridFsOperations operations;

    public Object addVideo(String title ,MultipartFile file) throws IOException {
        DBObject metaData = new BasicDBObject();
        metaData.put("type", "video");
        metaData.put("title", title);

        ObjectId id =gridFsTemplate.store(
                file.getInputStream(),title, file.getContentType(), metaData) ;


        return id ;
    }

    public video getVideo(String title) throws IllegalStateException, IOException {
        GridFSFile file = gridFsTemplate.findOne(new Query(Criteria.where("filename").is(title)));
        System.out.println("*");

        video video = new video();
        System.out.println("**");
        //video.setTitle(file.getMetadata().get("title").toString());
        System.out.println("***");
        video.setStream(operations.getResource(file).getInputStream());
        System.out.println("****");




        return video ;
    }
    public List getallvideos() throws IllegalStateException, IOException{
         List videos = new ArrayList();
        GridFSFindIterable files = gridFsTemplate.find(null);
        System.out.println("*");
        for (GridFSFile file:files
             ) {
            video video = new video();
            video.setTitle(file.getMetadata().get("filename").toString());

        System.out.println("***");
        video.setStream(operations.getResource(file).getInputStream());
        System.out.println("****");
        videos.add(video);
          }
        return videos ;
    }
}