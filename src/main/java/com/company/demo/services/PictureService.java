package com.company.demo.services;

import com.company.demo.models.Picture;

/**
 * service operations on pictures
 *
 */
public interface PictureService {
    /**
     * Adds picture in demo.pictures table and after returns URI
     *
     * @param name        Picture name
     * @param pictureFile Picture in byte array
     * @return Picture
     */
    Picture insertInTable(String name, byte[] pictureFile);
}
