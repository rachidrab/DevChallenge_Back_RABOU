package com.dev.challenge.controller;

import com.dev.challenge.httpclient.HttpClientManager;
import com.dev.challenge.model.Album;
import com.dev.challenge.model.Photo;
import com.dev.challenge.model.UserInfo;

import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/core")
public class CoreController {


	// get all users
	@GetMapping("/users")
	public List<UserInfo> getUsers() throws IOException {
		return HttpClientManager.getInstance().getUsers();
	}

	// get User by Id

	@GetMapping("/users/{id}")
	public UserInfo getUserById(@PathVariable("id") int idUser) throws IOException {
		return HttpClientManager.getInstance().getUserById(idUser);
	}



	// get album by id

	@GetMapping("/albums/{id}")
	public Album getAlbumById(@PathVariable("id") int albumId) throws IOException {
		return HttpClientManager.getInstance().getAlbumById(albumId);
	}


	// get albums by user

	@GetMapping("/albums/user/{id}")
	public List<Album> getAlbumsByUserId(@PathVariable("id") int userId) throws IOException {
		return HttpClientManager.getInstance().getAlbumByUserId(userId);
	}

	// get photos by user

	@GetMapping("/photos/user/{id}")
	public List<Photo> getPhotosByUserId(@PathVariable("id") int userId) throws IOException {
		return HttpClientManager.getInstance().getPhotosByUserId(userId);
	}



	// get photos by album



	@GetMapping("/photos/album/{id}")
	public List<Photo> getPhotosByAlbumId(@PathVariable("id") int albumId) throws IOException {
		return HttpClientManager.getInstance().getPhotosByAlbum(albumId);
	}

	// get all albums
	@GetMapping("/albums")
	public List<Album> getAlbums() throws IOException {
		return HttpClientManager.getInstance().getAllAlbums();
	}

	// get all phtos
	@GetMapping("/photos")
	public List<Photo> getPhotos() throws IOException {
		return HttpClientManager.getInstance().getPhotos();
	}




}