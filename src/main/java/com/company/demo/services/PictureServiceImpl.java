package com.company.demo.services;

import com.company.demo.models.Picture;
import com.company.demo.models.PictureDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PictureServiceImpl implements PictureService {
    @Autowired
    private PictureDao pictureDao;

    @Override
    public Picture insertInTable(String name, byte[] pictureFile) {

        Picture picture = new Picture(name, pictureFile);
        pictureDao.save(picture);
        return picture;

    }
}
