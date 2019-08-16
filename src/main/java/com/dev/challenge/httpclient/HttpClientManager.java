package com.dev.challenge.httpclient;

import com.dev.challenge.model.Album;
import com.dev.challenge.model.Photo;
import com.dev.challenge.model.UserInfo;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class HttpClientManager {

    private String server = "https://jsonplaceholder.typicode.com";
    private RestTemplate rest;
    private final String PHOTO_URI = "/photos";
    private final String ALBUM_URI = "/albums";
    private final String USER_URI = "/users";
    private final String USER_ID = "userId";
    private final String ALBUM_ID = "albumId";
    private static HttpClientManager INSTANCE = null;


    private HttpHeaders headers;

    public void setupClient() {

        this.rest = new RestTemplate();

        this.headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        headers.add("Accept", "*/*");
    }


    private HttpClientManager() {
    }


    public static HttpClientManager getInstance() {
        if(INSTANCE == null){
            INSTANCE = new HttpClientManager();
            INSTANCE.setupClient();
        }
        return INSTANCE;
    }

    public List<Photo> getPhotos() throws IOException {
        HttpEntity<String> requestEntity = new HttpEntity<String>("", headers);
        ResponseEntity<List<Photo>> responseEntity = rest.exchange(server + PHOTO_URI, HttpMethod.GET, requestEntity, new ParameterizedTypeReference<List<Photo>>() {
        });
        return responseEntity.getBody();
    }



    public List<Album> getAllAlbums() throws IOException {
        HttpEntity<String> requestEntity = new HttpEntity<String>("", headers);
        ResponseEntity<List<Album>> responseEntity = rest.exchange(server + ALBUM_URI, HttpMethod.GET, requestEntity, new ParameterizedTypeReference<List<Album>>() {
        });
        return responseEntity.getBody();
    }




    public List<UserInfo> getUsers() throws IOException {
        HttpEntity<String> requestEntity = new HttpEntity<String>("", headers);
        ResponseEntity<List<UserInfo>> responseEntity = rest.exchange(server + USER_URI, HttpMethod.GET, requestEntity, new ParameterizedTypeReference<List<UserInfo>>() {
        });
        return responseEntity.getBody();
    }

    public Photo getPhotoById(int id) throws IOException {
        HttpEntity<String> requestEntity = new HttpEntity<String>("", headers);
        ResponseEntity<Photo> responseEntity = rest.exchange(server + PHOTO_URI + "/" + id, HttpMethod.GET, requestEntity, Photo.class);
        return responseEntity.getBody();
    }

    public List<Photo> getPhotosByAlbum(int albumId) throws IOException {
        HttpEntity<String> requestEntity = new HttpEntity<String>("", headers);
        ResponseEntity<List<Photo>> responseEntity = rest.exchange(server + PHOTO_URI + "?" + ALBUM_ID + "=" + albumId, HttpMethod.GET, requestEntity, new ParameterizedTypeReference<List<Photo>>() {
        });
        return responseEntity.getBody();

    }

    public List<Photo> getPhotosByUserId(int userId) throws IOException {
        List<Photo> photos = new ArrayList<>();
        List<Album> albumsForUser = getAlbumByUserId(userId);
        for (Album album : albumsForUser) {
            photos.addAll(getPhotosByAlbum(album.getId()));
        }
        return photos;
    }

    // get Album by Id

    public Album getAlbumById(int albumId) throws IOException {
        HttpEntity<String> requestEntity = new HttpEntity<String>("", headers);
        ResponseEntity<Album> responseEntity = rest.exchange(server + ALBUM_URI + "/" + albumId, HttpMethod.GET, requestEntity, new ParameterizedTypeReference<Album>() {
        });
        return responseEntity.getBody();

    }


    // get album by userId

    public List<Album> getAlbumByUserId(int userId) throws IOException {
        HttpEntity<String> requestEntity = new HttpEntity<String>("", headers);
        ResponseEntity<List<Album>> responseEntity = rest.exchange(server + ALBUM_URI + "?" + USER_ID + "=" + userId, HttpMethod.GET, requestEntity, new ParameterizedTypeReference<List<Album>>() {
        });
        return responseEntity.getBody();

    }



    // get User by Id

    public UserInfo getUserById(int userId) throws IOException {
        HttpEntity<String> requestEntity = new HttpEntity<String>("", headers);
        ResponseEntity<UserInfo> responseEntity = rest.exchange(server + USER_URI + "/" + userId, HttpMethod.GET, requestEntity, new ParameterizedTypeReference<UserInfo>() {
        });
        return responseEntity.getBody();

    }

}
