package com.dev.challenge.core;

import com.dev.challenge.httpclient.HttpClientManager;
import com.dev.challenge.model.Album;
import com.dev.challenge.model.Photo;
import com.dev.challenge.model.UserInfo;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

public class CoreTest {

    @Test
    public void getPhotosByIdTest() throws IOException {
        int id = 5;
        Photo photo = HttpClientManager.getInstance().getPhotoById(id);

    }

    @Test
    public void getPhotosByAlbumIdTest() throws IOException {
        int id = 3;
        List<Photo> photos = HttpClientManager.getInstance().getPhotosByAlbum(id);

    }

    // Get Albums by user id

    @Test
    public void getAlbumsByUserId() throws IOException {
        int id = 3;
        List<Album> albums = HttpClientManager.getInstance().getAlbumByUserId(id);

    }

    // Get Albums by ID
    @Test
    public void getAlbumByIDTest() throws IOException {
        int id = 5;
        Album album = HttpClientManager.getInstance().getAlbumById(id);

    }

    // Get Photos by UserId
    @Test
    public void getPhotosByUserIdTest() throws IOException {
        int id = 4;
        List<Photo> photos = HttpClientManager.getInstance().getPhotosByUserId(id);

    }

    // Get Photos by UserId
    @Test
    public void getPhotosTest() throws IOException {
        List<Photo> photos = HttpClientManager.getInstance().getPhotos();

    }

    // Get Users
    @Test
    public void getAllUsers() throws IOException {
        List<UserInfo> users = HttpClientManager.getInstance().getUsers();

    }




}
