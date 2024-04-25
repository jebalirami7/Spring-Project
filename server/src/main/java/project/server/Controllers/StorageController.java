package project.server.Controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.RestController;

import project.server.Exceptions.StorageFileNotFoundException;
import project.server.Services.StorageService;
import project.server.Services.Implementations.StorageServiceImpl;

import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("/uploads")
public class StorageController {
    
    @Autowired
    private StorageServiceImpl storageService;



    @GetMapping("/{filename:.+}")
	@ResponseBody
	public ResponseEntity<Resource> serveFile(@PathVariable String filename) {

		Resource file = storageService.loadAsResource(filename);

		if (file == null)
			return ResponseEntity.notFound().build();

		return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
				"attachment; filename=\"" + file.getFilename() + "\"").body(file);
	}


    @PostMapping("/")
	public String handleFileUpload(@RequestParam("file") MultipartFile file) {

		storageService.store(file);
		
		return	"You successfully uploaded " + file.getOriginalFilename() + "!";
	}

	@ExceptionHandler(StorageFileNotFoundException.class)
	public ResponseEntity<?> handleStorageFileNotFound(StorageFileNotFoundException exc) {
		return ResponseEntity.notFound().build();
	}

}
