package com.company.demo.controllers;

import com.company.demo.models.Picture;
import com.company.demo.services.PictureService;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Fileupload controller handles request for:
 * 1. return upload page;
 * 2. upload file in demo.pictures table and return URI of uploaded picture
 */
@Controller
public class FileUploadController {
    @Autowired
    private PictureService pictureService;

    /**
     * Returns picture-upload.html
     *
     * @return upload page
     */
    @RequestMapping(value = "/upload", method = RequestMethod.GET)
    public String returnUploadPage() {
        return "picture-upload";
    }

    /**
     * Handles picture uploading:
     * gets String "name" parameter and MultipartFile picture "file"
     * and returns picture URI
     *
     * @param name Picture name
     * @param file Picture file (max size = 5Mb)
     * @return Picture URI
     */
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public
    @ResponseBody
    JSONPObject handleFileUpload(@RequestParam("name") String name,
                                 @RequestParam("file") MultipartFile file) throws IOException {

        byte[] bytes = file.getBytes();
        BufferedOutputStream stream =
                new BufferedOutputStream(new FileOutputStream(new File(name)));
        stream.write(bytes);
        stream.close();
        Picture picture = pictureService.insertInTable(name, bytes);
        return new JSONPObject("picture_id", picture.getId());

    }

}
