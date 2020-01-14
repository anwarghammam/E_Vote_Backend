package com.example.demo.services;

import com.example.demo.Models.video;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.client.gridfs.model.GridFSFile;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsOperations;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class VideoService {

    @Autowired
    private GridFsTemplate gridFsTemplate;

    @Autowired
    private GridFsOperations operations;

    public  ObjectId addVideo(String title ,MultipartFile file) throws IOException {
        DBObject metaData = new BasicDBObject();
        metaData.put("type", "video");
        metaData.put("title", title);
        ObjectId id = gridFsTemplate.store(
                file.getInputStream(), file.getName(), file.getContentType(), metaData);
        return id ;
    }

    public video getVideo(String id) throws IllegalStateException, IOException {
        GridFSFile file = gridFsTemplate.findOne(new Query(Criteria.where("_id").is(id)));
        video video = new video();
        video.setTitle(file.getMetadata().get("title").toString());
        video.setStream(operations.getResource(file).getInputStream());
        return video ;
    }
}