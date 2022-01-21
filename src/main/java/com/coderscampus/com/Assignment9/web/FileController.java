package com.coderscampus.com.Assignment9.web;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coderscampus.com.Assignment9.Recipe;
import com.coderscampus.com.Assignment9.service.FileService;

@RestController
public class FileController {
	
	
	@Autowired
	private FileService fileService;
	
	@GetMapping("/all-recipes")
	public List<String> readLines () throws IOException{
		         return fileService.readFile("recipe.txt");
	}
	 @GetMapping("/gluten-free")
	 public List<Recipe>  glutenFree() throws IOException {
	              return fileService.readFiles().stream().filter(e -> e.getGlutenFree())
	            		                                .collect(Collectors.toList());
	 }
	 @GetMapping("/vegan")
		public List<Recipe> readVegan() throws IOException{
	                 return fileService.readFiles().stream()
						      .filter(x -> x.getVegan())
						      .collect(Collectors.toList());							  
	}
		
		@GetMapping("/vegan-and-gluten-free")
		public List<Recipe> readVeganGlutenFree() throws IOException{
	                 return fileService.readFiles().stream()
						      .filter(x -> x.getGlutenFree() && x.getVegan())
						      .collect(Collectors.toList());
	}
		@GetMapping("/vegetarian")
		public List<Recipe> readVegetarian() throws IOException{
			       return fileService.readFiles().stream()
						      .filter(x -> x.getVegetarian())
						      .collect(Collectors.toList());
	}
}
